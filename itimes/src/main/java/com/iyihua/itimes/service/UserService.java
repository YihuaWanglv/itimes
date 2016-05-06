package com.iyihua.itimes.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iyihua.itimes.mapper.user.UserXmlMapper;
import com.iyihua.itimes.model.User;
import com.iyihua.itimes.repository.UserRepository;
import com.iyihua.itimes.repository.user.UserConfigRepository;
import com.iyihua.model.base.UserDTO;
import com.iyihua.model.base.report.ReportConfig;
import com.iyihua.model.base.user.UserConfigJson;
import com.iyihua.remote.base.UserRemote;

import util.PasswordSecureHash;

@Service
public class UserService implements UserRemote {

	@Autowired private UserRepository userRepository;
	@Autowired private UserXmlMapper userXmlMapper;
//	@Autowired private UserConfigRepository userConfigRepository;
	
	@Override
	public UserDTO findUserById(Long id) {
		Assert.notNull(id, "userId can not be null!");
		UserDTO result = null;
		User user = userRepository.findOne(id);
		if (user != null) {
			result = new UserDTO();
			BeanUtils.copyProperties(user, result);
//			UserConfig uc = userConfigRepository.findOne(user.getUserConfigId());
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
		save.setCode(DigestUtils.sha1DigestAsHex(user.getCode()+salt));
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


	@Override
	public UserDTO updateUser(UserDTO user, Boolean isUpdateSelected) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Assert.notNull(user, "User can not be null!");
		User save = new User();
		BeanUtils.copyProperties(user, save);
		if (isUpdateSelected != null && isUpdateSelected) {
			int r = userXmlMapper.updateUserSelective(save);
			if (r <= 0) {
				return null;
			}
		} else {
			save = userRepository.save(save);
		}
		return user;
	}

	@Override
	public UserConfigJson getUserConfigById(long id) {
		
		UserConfigJson config = new UserConfigJson();
		
		List<ReportConfig> reportConfigs = new ArrayList<ReportConfig>();
		reportConfigs.add(new ReportConfig.Builder("category").enabled(1).type("bar").title("ÿ����������ʱ��").build());
		reportConfigs.add(new ReportConfig.Builder("categoryTime").enabled(1).type("line").muti(1).title("����������ÿ�·ݵ�ʱ��").build());
		reportConfigs.add(new ReportConfig.Builder("project").enabled(1).type("bar").title("������Ŀ����ʱ��").build());
		reportConfigs.add(new ReportConfig.Builder("projectTime").enabled(1).type("line").muti(1).title("������Ŀ��ÿ���·�����ʱ��").build());
		reportConfigs.add(new ReportConfig.Builder("location").enabled(1).type("bar").title("�����ص�����ʱ��").build());
		reportConfigs.add(new ReportConfig.Builder("locationTime").enabled(0).build());
		config.setReportConfigs(reportConfigs);
		
		return config;
	}

	

}
