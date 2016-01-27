package com.iyihua.bootdemo;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.itimes.App;
import com.iyihua.itimes.mapper.user.UserRoleMapper;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class AppTest {
	
//	@Autowired
//	DefaultSecurityManager securityManager;
//	
//	@Test
//	public void TestShiro() {
//		SecurityUtils.setSecurityManager(securityManager);
//		Subject subject = SecurityUtils.getSubject();  
//	    UsernamePasswordToken token = new UsernamePasswordToken("iyihua", "123456");  
//	  
//	    try {  
//	        //4、登录，即身份验证  
//	        subject.login(token);  
//	    } catch (AuthenticationException e) {  
//	        //5、身份验证失败  
//	    }  
//	  
//	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
//	  
//	    //6、退出  
//	    subject.logout();  
//	}
	
	@Autowired
	UserRoleMapper userRoleMapper;
	
	@Test
	public void TestRole() {
		
		List<String> roles = userRoleMapper.findByUserId(1L);
		if (roles != null && roles.size() > 0) {
			for (String role : roles) {
				System.err.println("role= " + role);
			}
		} else {
			System.err.println("null--------------------");
		}
	}
}
