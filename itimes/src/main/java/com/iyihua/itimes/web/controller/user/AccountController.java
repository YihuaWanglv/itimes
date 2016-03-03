package com.iyihua.itimes.web.controller.user;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@RequestMapping(value = "/active")
	public String active(Map<String, Object> model, String code) {
		model.put("message", "hello world!");
		model.put("name", "wanglvyh");
		return "welcom";
	}
}
