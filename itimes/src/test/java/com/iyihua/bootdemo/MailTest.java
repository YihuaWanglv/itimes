package com.iyihua.bootdemo;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.itimes.App;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class MailTest {

	
	@Autowired private JavaMailSender javaMailSender;

	@Test
	public void send() {
		SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setFrom("619361578@qq.com");
	    msg.setTo("wanglvyh@cf-ec.com");
	    msg.setSubject("testemail");
	    msg.setText("test");
		javaMailSender.send(msg);
    }

}
