package com.iyihua.itimes.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.iyihua.itimes.model.User;
import com.iyihua.itimes.repository.UserRepository;
import com.iyihua.model.base.UserDTO;
import com.iyihua.remote.base.UserRemote;

public class UserService implements UserRemote {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO findUserById(Long id) {
		UserDTO result = null;
		User user = userRepository.findOne(id);
		if (user != null) {
			result = new UserDTO();
			BeanUtils.copyProperties(user, result);
		}
		return result;
	}

	@Override
	public UserDTO createUser(UserDTO user) {
		Assert.isNull(user, "User can not be null!");
		User save = new User();
		BeanUtils.copyProperties(user, save);
		save = userRepository.save(save);
		BeanUtils.copyProperties(save, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	

}
