package com.iyihua.itimes.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyihua.itimes.component.security.LoginSessionManager;
import com.iyihua.itimes.component.tools.UserConfigManager;
import com.iyihua.model.base.user.UserConfigJson;

@RestController
@RequestMapping("/data/user")
public class UserDataController {
	
	@Autowired private LoginSessionManager loginSessionManager;
	@Autowired private UserConfigManager userConfigManager;

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public UserConfigJson config() {
		Long userId = loginSessionManager.getSessionUserId();
		return userConfigManager.getUserConfig(userId);
	}
}
