package com.iyihua.itimes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyihua.itimes.model.User;
import com.iyihua.itimes.service.MyService;

@Controller
public class SampleController {

	@Autowired
	MyService myService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
//		List<Map<String, Object>> r = myService.getDemo();
//		for (Map<String, Object> map : r) {
//			map.get("name");
//			System.out.println(map.get("name"));
//		}
		
		User user = myService.getUser("iyihua", 0);
		if (user != null) {
			System.err.println("user:" + user.getName());
		} else {
			System.err.println("null...........");
		}
		return "Hello World!";
	}

	
}
