package com.iyihua.itimes.component.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iyihua.model.base.user.UserConfigJson;
import com.iyihua.remote.base.UserRemote;

@Component
public class UserConfigManager {

	@Autowired private UserRemote userService;
	
	public UserConfigJson getUserConfig(long id) {
		return userService.getUserConfigById(id);
	}
}
