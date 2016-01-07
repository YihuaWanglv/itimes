package com.iyihua.itimes.services.item.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyihua.itimes.services.item.model.Item;
import com.iyihua.itimes.services.item.service.MyService;

@Controller
public class SampleController {

	@Autowired
	MyService myService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		String data = "";
		List<Item> items = myService.getDemo();
		
		if (items != null && items.size() > 0) {
			for (Item item : items) {
				data += item.getItem_id()+","+item.getYear();
			}
		}
		
		return "Hello World!"+data;
	}

	
}
