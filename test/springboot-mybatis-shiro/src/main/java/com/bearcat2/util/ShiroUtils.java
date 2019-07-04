package com.bearcat2.util;

import com.bearcat2.shiro.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    /**
     *
     * @Title: clearAuth
     * @Description: TODO 清空所有资源权限
     * @return void    返回类型
     */

    public static void clearAuth(){
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm realm = (ShiroRealm)rsm.getRealms().iterator().next();
        realm.clearCachedAuth();
    }


    /**
     * 重新赋值权限(在比如:给一个角色临时添加一个权限,需要调用此方法刷新权限,否则还是没有刚赋值的权限)
     * @param myRealm 自定义的realm
     * @param username 用户名
     */
    public static void reloadAuthorizing(ShiroRealm myRealm,String username){
        Subject subject = SecurityUtils.getSubject();
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        //第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户
        SimplePrincipalCollection principals = new SimplePrincipalCollection(username,realmName);
        subject.runAs(principals);
        myRealm.getAuthorizationCache().remove(subject.getPrincipals());
        subject.releaseRunAs();
    }


}
