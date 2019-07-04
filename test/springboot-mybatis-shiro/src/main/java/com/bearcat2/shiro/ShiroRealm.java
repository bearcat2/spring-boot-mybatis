package com.bearcat2.shiro;

import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysRole;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.entity.system.SysUserExample;
import com.bearcat2.mapper.system.SysPrivilegeMapper;
import com.bearcat2.mapper.system.SysRoleMapper;
import com.bearcat2.mapper.system.SysUserMapper;
import com.bearcat2.service.impl.system.SysUserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @项目名称：wyait-manage
 * @包名：com.wyait.manage.shiro
 * @类描述：
 * @创建人：wyait
 * @创建时间：2017-12-13 13:53
 * @version：V1.0
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory
			.getLogger(SysUserServiceImpl.class);
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private SysPrivilegeMapper privilegeMapper;

	/**
	 * 授予角色和权限
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		//授权
		logger.debug("授予角色和权限");
		//permissonSet集合获取当前用户下所有按钮权限
		Set<String> permissonSet = new HashSet<String>();
		// 添加权限 和 角色信息
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 获取当前登陆用户
		Subject subject = SecurityUtils.getSubject();
		SysUser user = (SysUser) subject.getPrincipal();
		if (user.getSuLoginName().equals("zhangsan")) {
			// 超级管理员，添加所有角色、添加所有权限
			authorizationInfo.addRole("*");
			authorizationInfo.addStringPermission("*");
		} else {
			try {
				// 普通用户，查询用户的角色，根据角色查询权限
				Integer userId = user.getSuId();
				List<SysRole> roles = this.roleMapper.getRoleByUser(userId);
				if (null != roles && roles.size() > 0) {
					for (SysRole role : roles) {
						//此处添加权限code（key)变为rolename
						authorizationInfo.addRole(role.getSrName());
						// 角色对应的权限数据
						List<SysPrivilege> perms = this.privilegeMapper.findPermsByRoleId(role
								.getSrId());
						if (null != perms && perms.size() > 0) {
							// 授权角色下所有权限
							for (SysPrivilege perm : perms) {
								//通过权限name代替code
								authorizationInfo.addStringPermission(perm
										.getSpName());
								permissonSet.add(perm.getSpUri());
								for (String s:permissonSet) {

									if(s.equals("")){
										permissonSet.remove(s);
									}
								}
							}
							//AuthorizationInfo添加按钮权限列表
							authorizationInfo.setStringPermissions(permissonSet);
						}
					}
				}

			}catch (Exception e){
				logger.error("数据库异常");
				e.printStackTrace();
			}

		}
		logger.debug(authorizationInfo.getStringPermissions().toString());
		return authorizationInfo;
	}

	/**
	 * 登录认证
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		//TODO
		//UsernamePasswordToken用于存放提交的登录信息
		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
		logger.info("用户登录认证：验证当前Subject时获取到token为：" + ReflectionToStringBuilder
				.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		String username = token.getUsername();
		// 调用数据层
		SysUserExample userExample = new SysUserExample();

		SysUserExample.Criteria criteria = userExample.createCriteria();

		criteria.andSuLoginNameEqualTo(username);

		SysUser user;

		try {

			user = userMapper.selectByExample(userExample).get(0);
			logger.debug("用户登录认证！用户信息user：" + user);
			if (user == null) {
				// 用户不存在
				return null;
			} else {
				// 密码存在
				// 第一个参数 ，登陆后，需要在session保存数据
				// 第二个参数，查询到密码(加密规则要和自定义的HashedCredentialsMatcher中的HashAlgorithmName散列算法一致)
				// 第三个参数 ，realm名字
				return new SimpleAuthenticationInfo(user, DigestUtils.md5Hex(user.getSuPassword()),
						getName());
			}

		}catch (Exception e){

			//用户不存在
			return null;
		}

	}


	/**
	 * 清除所有缓存【实测无效】
	 */
	public void clearCachedAuth(){
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}
}
