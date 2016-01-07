package com.iyihua.itimes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyihua.itimes.model.Category;
import com.iyihua.itimes.model.User;
import com.iyihua.itimes.service.MyService;

@Controller
public class SampleController {

	@Autowired
	MyService myService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		String data = "";
		
		User user = myService.getUser("iyihua", 0);
		if (user != null) {
			System.err.println("user:" + user.getName());
		} else {
			System.err.println("null...........");
		}
		List<Category> categories = myService.listCategory();
		if (categories != null) {
			for (Category category : categories) {
				data += categories.toString();
			}
		}
		return "Hello World!" + data;
	}

	
}
