package com.bearcat2.entity.common;

import com.bearcat2.entity.system.SysPrivilege;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p> Description: 当前登录的用户 </p>
 * <p> Title: LoginUser </p>
 * <p> Create Time: 2019/5/11 23:15 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Data
public class LoginUser {

    /** 用户id */
    private Integer userId;

    /** 登录名 */
    private String loginName;

    /** 真实姓名 */
    private String realName;

    /** 当前用户所拥有的菜单集合(包含模块,菜单) */
    private Set<SysPrivilege> menus = new HashSet<>();

    /** 当前用户所拥有的权限集合(用户所用的按钮权限) */
    private Set<SysPrivilege> userPrivileges = new HashSet<>();

    /** 系统配置的所有权限. key为权限url value为权限id */
    private Map<String, Integer> privilegeMap = new HashMap<>();
}
