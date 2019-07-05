package com.bearcat2.web.interceptor;

import com.bearcat2.dao.redis.RedisDao;
import com.bearcat2.dao.redis.RedisNameSpace;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.service.system.SysPrivilegeService;
import com.bearcat2.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p> Description: 权限刷新拦截,用于超管在线改变权限实现在线用户权限动态刷新 </p>
 * <p> Title: PrivilegeRefreshInterceptor </p>
 * <p> Create Time: 2019/7/5 21:48 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Component
public class PrivilegeRefreshInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Value("${bearcat2.superUser.username}")
    private String superAdmin;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 注意该拦截器要放在登录拦截器之后，权限校验拦截器之前，需要取出当前用户id进行判断，刷新权限后要立即进行权限校验

        // 1.取出session中登录用户信息
        LoginUser loginUser = CommonUtil.getLoginUser(request);
        if (superAdmin.equals(loginUser.getLoginName())) {
            // 超管直接放行
            return true;
        }
        // 2.判断redis中当前用户权限改变标记是否存在
        boolean exists = this.redisDao.exists(
                String.format(
                        RedisNameSpace.PRIVILEGE_REFRESH_FLAG
                        , loginUser.getUserId()
                )
        );
        // 3.不存在权限改变标记直接放行
        if (!exists) {
            return true;
        }
        // 4.走到这说明当前用户权限已改变,根据当前用户id去数据库查询最新菜单和权限
        List<SysPrivilege> newMenu = this.sysPrivilegeService.findMenuByUserId(loginUser.getUserId());
        List<SysPrivilege> newPrivilege = this.sysPrivilegeService.findPrivilegeByUserId(loginUser.getUserId());
        // 5.替换原有旧权限，并移除权限改变标记,避免重复替换权限
        loginUser.setMenus(CommonUtil.listToSet(newMenu));
        loginUser.setUserPrivileges(CommonUtil.listToSet(newPrivilege));
        this.redisDao.del(
                String.format(
                        RedisNameSpace.PRIVILEGE_REFRESH_FLAG
                        , loginUser.getUserId()
                )
        );
        return true;
    }
}
