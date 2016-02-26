
package com.iyihua.remote.base;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.iyihua.model.base.UserDTO;


public interface UserRemote {

	public UserDTO findUserById(Long id);
	
	public UserDTO createUser(UserDTO user) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	public void deleteUser(Long id); 
	
	public UserDTO findUserByName(String username);
}
