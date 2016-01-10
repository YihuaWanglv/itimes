package com.iyihua.itimes.services.item.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.iyihua.itimes.services.item.mapper.UserMapper;
import com.iyihua.model.base.UserDTO;
import com.iyihua.remote.base.UserRemote;

public class UserService implements UserRemote {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDTO findUserById(Long id) {
		return userMapper.findById(id);
	}

	@Override
	public UserDTO createUser(UserDTO user) {
		return null;
	}
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
