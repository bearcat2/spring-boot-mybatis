package com.bearcat2.web.controller.system;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.result.ResponseResult;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.entity.system.SysUserExample;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.service.system.SysRoleService;
import com.bearcat2.service.system.SysUserService;
import com.bearcat2.util.IStatusMessage;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: 系统用户控制器</p>
 * <p>Title: SysUserController </p>
 * <p>Create Time: 2018/8/16 15:12 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    private static final Logger logger = LoggerFactory
            .getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private EhCacheManager ecm;

    @GetMapping("/doLogin")
    public String doLogin() {
        return "login";
    }


    /**
     * 登录【使用shiro中自带的HashedCredentialsMatcher结合ehcache（记录输错次数）配置进行密码输错次数限制】
     * @param user 用户登录信息
     * @param rememberMe 是否选择了记住我
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public LayuiResult login(SysUser user,
                             @RequestParam(value = "rememberMe",
                                           required = false) boolean rememberMe) {
        logger.debug("用户登录，请求参数=user:" + user + "，是否记住我：" + rememberMe);

        LayuiResult responseResult = new LayuiResult();
        responseResult.setCode(IStatusMessage.SystemStatus.ERROR.getCode());

        if (null == user) {
            responseResult.setCode(IStatusMessage.SystemStatus.PARAM_ERROR
                    .getCode());
            responseResult.setMsg("请求参数有误，请您稍后再试");
            logger.debug("用户登录，结果=responseResult:" + responseResult);
            return responseResult;
        }
        // 用户是否存在
        SysUserExample userExample = new SysUserExample();

        SysUserExample.Criteria criteria = userExample.createCriteria();

        criteria.andSuLoginNameEqualTo(user.getSuLoginName());

        List<SysUser> sysUsers = sysUserService.selectByExample(userExample);


        if (sysUsers.size() == 0) {
            responseResult.setMsg("该用户不存在，请您联系管理员");
            logger.debug("用户登录，结果=responseResult:" + responseResult);
            return responseResult;
        }


        SysUser existUser = sysUsers.get(0);

        //用户登录
        try{
        // 1、 封装用户名、密码、是否记住我到token令牌对象 [支持记住我]
        AuthenticationToken token = new UsernamePasswordToken(
                user.getSuLoginName(), DigestUtils.md5Hex(user.getSuPassword()),
                rememberMe);

        // 2、 Subject调用login
        Subject subject = SecurityUtils.getSubject();
        // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
        // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
        // 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
        logger.debug("用户登录，用户验证开始！user=" + user.getSuLoginName());
        subject.login(token);
        responseResult.setCode(IStatusMessage.SystemStatus.SUCCESS_LOGIN.getCode());
        responseResult.setMsg(IStatusMessage.SystemStatus.SUCCESS_LOGIN.getMessage());

        logger.info("用户登录，用户验证通过！user=" + user.getSuLoginName());
    }
    catch (UnknownAccountException uae)
    {
        logger.error("用户登录，用户验证未通过：未知用户！user=" + user.getSuLoginName(), uae);
        responseResult.setMsg("该用户不存在，请您联系管理员");
    } catch (
    IncorrectCredentialsException ice) {
        // 获取输错次数
        logger.error("用户登录，用户验证未通过：错误的凭证，密码输入错误！user=" + user.getSuLoginName(),
                ice);
        responseResult.setMsg("用户名或密码不正确");
    } catch (
    LockedAccountException lae) {
        logger.error("用户登录，用户验证未通过：账户已锁定！user=" + user.getSuLoginName(), lae);
        responseResult.setMsg("账户已锁定");
    } catch (ExcessiveAttemptsException eae) {
        logger.error(
                "用户登录，用户验证未通过：错误次数大于5次,账户已锁定！user=.getMobile()" + user, eae);
        responseResult
                .setMsg("用户名或密码错误次数大于5次,账户已锁定!</br><span style='color:red;font-weight:bold; '>2分钟后可再次登录，或联系管理员解锁</span>");
        // 这里结合了，另一种密码输错限制的实现，基于redis或mysql的实现；也可以直接使用RetryLimitHashedCredentialsMatcher限制5次
    } /*catch (DisabledAccountException sae){
		 logger.error("用户登录，用户验证未通过：帐号已经禁止登录！user=" +
		 user.getMobile(),sae);
		 responseResult.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
		 responseResult.setMessage("帐号已经禁止登录");
		}*/catch (AuthenticationException ae) {
        // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
        logger.error("用户登录，用户验证未通过：认证异常，异常信息如下！user=" + user.getSuLoginName(),
                ae);
        responseResult.setMsg("用户名或密码不正确");
    } catch (Exception e) {
        logger.error("用户登录，用户验证未通过：操作异常，异常信息如下！user=" + user.getSuLoginName(), e);
        responseResult.setMsg("用户登录失败，请您稍后再试");
    }
    Cache<String, AtomicInteger> passwordRetryCache = ecm.getCache("passwordRetryCache");
		if (null != passwordRetryCache) {
        int retryNum = (passwordRetryCache.get(existUser.getSuLoginName()) == null ? 0
                : passwordRetryCache.get(existUser.getSuLoginName())).intValue();
        logger.debug("输错次数：" + retryNum);
        if (retryNum > 0 && retryNum < 6) {
            responseResult.setMsg("用户名或密码错误" + retryNum + "次,再输错"
                    + (6 - retryNum) + "次账号将锁定");
        }
    }
		logger.debug("用户登录，user=" + user.getSuLoginName() + ",登录结果=responseResult:"
                + responseResult);
		return responseResult;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session标记
        SecurityUtils.getSubject().logout();
        logger.debug("用户退出");
        return "redirect:/sysUser/doLogin";
    }

    @GetMapping("/manager")
    public String listUi() {
        return "system/user/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public LayuiResult list(SysUser sysUser) {
        return this.sysUserService.list(sysUser);
    }

    @GetMapping(value = "/edit_ui")
    public String editUi(SysUser sysUser, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(sysUser.getSuId()));
        model.addAttribute("roles", this.sysRoleService.findAll());
        model.addAttribute("sysUserRoles", this.sysUserService.findByUserId(sysUser.getSuId()));
        return "system/user/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysUser sysUser, Integer roleId) {
        sysUser.setSuUpdateTime(new Date());
        this.sysUserService.updateByPrimaryKeySelective(sysUser);

        // 修改对应的用户角色关系表
        this.sysUserService.updateUserRoleRelationByUserId(sysUser.getSuId(), roleId);
        return LayuiResult.success();
    }

    @GetMapping(value = "/detail")
    public String detailUi(SysUser sysUser, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(sysUser.getSuId()));
        return "system/user/detail";
    }

    @GetMapping("/add_ui")
    public String addUi(Model model) {
        model.addAttribute("roles", this.sysRoleService.findAll());
        return "system/user/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysUser sysUser, Integer roleId) {
        sysUser.setSuCreateTime(new Date());
        sysUser.setSuUpdateTime(new Date());
        sysUser.setSuPassword(SecureUtil.md5(sysUser.getSuPassword()));
        // 注意这里已在mybatis里设置,插入用户数据后会将自增生成的主键插入到SysUser对象的suId属性中
        this.sysUserService.insertSelective(sysUser);

        // 添加用户角色表
        this.sysUserService.insertUserRoleRelation(sysUser.getSuId(), roleId);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(SysUser sysUser) {
        this.sysUserService.deleteByPrimaryKey(sysUser.getSuId());
        return LayuiResult.success();
    }
}
