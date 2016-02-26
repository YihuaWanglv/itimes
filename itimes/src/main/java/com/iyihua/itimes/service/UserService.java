package com.iyihua.itimes.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import util.PasswordSecureHash;

import com.iyihua.itimes.model.User;
import com.iyihua.itimes.repository.UserRepository;
import com.iyihua.model.base.UserDTO;
import com.iyihua.remote.base.UserRemote;

@Service
public class UserService implements UserRemote {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO findUserById(Long id) {
		Assert.notNull(id, "userId can not be null!");
		UserDTO result = null;
		User user = userRepository.findOne(id);
		if (user != null) {
			result = new UserDTO();
			BeanUtils.copyProperties(user, result);
		}
		return result;
	}

	@Override
	public UserDTO createUser(UserDTO user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Assert.notNull(user, "User can not be null!");
		User save = new User();
		BeanUtils.copyProperties(user, save);
		String salt = PasswordSecureHash.createRandom();
		save.setPassword(PasswordSecureHash.hashEncrypt(user.getPassword(), salt));
		save.setSalt(salt);
		save = userRepository.save(save);
		BeanUtils.copyProperties(save, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public UserDTO findUserByName(String username) {
		UserDTO result = null;
		User user = userRepository.findByName(username);
		if (user != null) {
			result = new UserDTO();
			BeanUtils.copyProperties(user, result);
		}
		return result;
	}

	

}
