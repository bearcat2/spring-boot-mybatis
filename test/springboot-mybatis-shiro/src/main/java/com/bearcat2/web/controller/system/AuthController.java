package com.bearcat2.web.controller.system;

import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.service.system.shiro.AuthService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 权限获取控制器
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthController.class);


    @Autowired
    private AuthService authService;



    /**
     * 根据用户id查询权限树数据
     * @return PermTreeDTO
     */
    @RequestMapping(value = "/getUserPerms", method = RequestMethod.GET)
    @ResponseBody
    public List<SysPrivilege> getUserPerms() {
        logger.debug("根据用户id查询限树列表！");
        List<SysPrivilege> pvo = null;
        SysUser existUser= (SysUser) SecurityUtils.getSubject().getPrincipal();
        if(null==existUser){
            logger.debug("根据用户id查询限树列表！用户未登录");
            return pvo;
        }
        try {
            pvo = authService.getUserPerms(existUser.getSuId());
            //生成页面需要的json格式
            logger.debug("根据用户id查询限树列表查询=pvo:" + pvo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据用户id查询权限树列表查询异常！", e);
        }
        return pvo;
    }


}
