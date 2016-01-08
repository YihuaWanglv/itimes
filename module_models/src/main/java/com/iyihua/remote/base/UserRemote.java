
package com.iyihua.remote.base;

import com.iyihua.model.base.UserDTO;


public interface UserRemote {

	public UserDTO findUserById(Long id);
	
	public UserDTO createUser(UserDTO user);
	
	public boolean updateUser(UserDTO user); 
}
