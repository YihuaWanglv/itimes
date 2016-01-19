package com.iyihua.itimes.config.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyihua.model.base.UserDTO;
import com.iyihua.remote.base.UserRemote;

public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	UserRemote userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		         String username = usernamePasswordToken.getUsername();
		 
		         UserDTO user = userService.findUserByName(username);
		 
		         if (null != user) {
		             //此处传入的第一个参数为user对象，那么我们在页面可以通过这样的方式来获取用户名：<shiro:principal property="username"/>
		        	 return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
//		             return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
		         }
		 
		         return null;
	}

}
