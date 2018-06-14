//package com.xhhxd.retail.shiro;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.DisabledAccountException;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.SimplePrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.javatuples.Triplet;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.xhhxd.retail.bean.bs.BsUser;
//import com.xhhxd.retail.bean.request.LoginRequest;
//import com.xhhxd.retail.service.bs.UserService;
//
//
//@Service
//public class ShiroDbRealm extends AuthorizingRealm {
//
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private ModuleService moduleService;
//
//	public ShiroDbRealm() {
//		super();
//	}
//
//	/**
//	 * 授权(验证权限时调�
//	 */
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		Subject subject = SecurityUtils.getSubject();
//		if (!subject.isAuthenticated()) {
//			doClearCache(principals);
//			subject.logout();
//			return info;
//		}
//		BsUser user = principals.oneByType(BsUser.class);
//		Set<String> permsList = moduleService.queryAllPerms(user.getId());
//		Set<String> permsSet = new HashSet<>();
//		for (String perms : permsList) {
//			if (StringUtils.isNotBlank(perms)) {
//				permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//			}
//		}
//		info.setStringPermissions(permsSet);
//		return info;
//	}
//
//	/**
//	 * 认证(登录时调�
//	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		String inputPassword = String.valueOf(token.getPassword());
//		LoginRequest request = new LoginRequest(token.getUsername(), inputPassword, true, 2, 3);
//		Triplet<Boolean, String, BsUser> result = userService.login(request);
//		if (result.getValue0() == false) {
//			if (result.getValue1().equals("用户不存在")) {
//				throw new UnknownAccountException("用户不存在");
//			} else {
//				throw new DisabledAccountException(result.getValue1());
//			}
//		}
//		BsUser user = new BsUser();
//		BeanUtils.copyProperties(result.getValue2(), user);
//		return new SimpleAuthenticationInfo(user, inputPassword, this.getName());
//	}
//
//	protected void clearCachedAuthorizationInfo() {
//		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
//		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
//		super.clearCachedAuthorizationInfo(principals);
//	}
//
//	protected void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
//		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
//		super.clearCachedAuthorizationInfo(principals);
//	}
//
//	public UserService getSysUserService() {
//		return userService;
//	}
//
//	public void setSysUserService(UserService userService) {
//		this.userService = userService;
//	}
//}
