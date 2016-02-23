package com.iyihua.itimes.config.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha384Hash;
import org.springframework.stereotype.Component;

//@Component
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));
		Object accountCredentials = getCredentials(info);
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return equals(tokenCredentials, accountCredentials);
	}

	// 将传进来密码加密方法
	private String encrypt(String data) {
		String sha384Hex = new Sha384Hash(data).toBase64();
		System.out.println(data + ":" + sha384Hex);
		return sha384Hex;
	}
	
	public static void main(String[] args) {
//		CustomCredentialsMatcher m = new CustomCredentialsMatcher();
//		
//		String r = m.encrypt("123456");
		
		String r = new Md5Hash("123456").toString();
		
		
		System.out.println(r);
	}
}