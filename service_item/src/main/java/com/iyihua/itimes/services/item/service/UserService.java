package com.iyihua.itimes.services.item.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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

	@Override
	public UserDTO findUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO user, Boolean isUpdateSelected)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		return null;
	}

}
