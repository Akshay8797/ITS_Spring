package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.json.ITS_TBL_User_Credentials;
import com.spring.rest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public String login(ITS_TBL_User_Credentials user) {
		String userId = user.getUserid();
		String password = user.getPassword();
		List<ITS_TBL_User_Credentials_Entity> userList = userRepository.findByuserid(userId);
		if (userList == null || userList.size() == 0 || userList.get(0).getPassword().equals(password) != true) {
			return "failed";

		} else {
			ITS_TBL_User_Credentials_Entity userEntity = userList.get(0);
			String sessionId = new java.rmi.server.UID().toString().substring(0, 20);
			String loginstatus = "online";
			userEntity.setSessionId(sessionId);
			userEntity.setLoginstatus(loginstatus);
			userRepository.save(userEntity);
			return userEntity.getSessionId();

		}
	}

	@Override
	public String logout(String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList = userRepository.findBysessionId(authToken);
		if (userList == null || userList.size() == 0) {
			return "failed";
		} else {
			ITS_TBL_User_Credentials_Entity userEntity = userList.get(0);
			String sessionId = null;
			String loginstatus = "offline";
			userEntity.setSessionId(sessionId);
			userEntity.setLoginstatus(loginstatus);
			userRepository.save(userEntity);
			return "Logged out successfully";
		}

	}

	@Override
	public String resetpassword(ITS_TBL_User_Credentials user, String newpassword) {
		String userid = user.getUserid();
		String password = user.getPassword();
		List<ITS_TBL_User_Credentials_Entity> userList = userRepository.findByuserid(userid);
		if (userList == null || userList.size() == 0 || (userList.get(0).getPassword().equals(password) != true)) {
			return "{\"result\": \"Failed\"}";

		} else {
			ITS_TBL_User_Credentials_Entity userEntity = userList.get(0);
			userEntity.setPassword(user.getPassword());
			userRepository.save(userEntity);
			return "{\"result\": \"Password Updated\"}";
		}

	}

	public String getSessionId(String userid) {
		List<ITS_TBL_User_Credentials_Entity> userList = userRepository.findByuserid(userid);
		if (userList == null || userList.size() == 0) {
			return "";

		} else {
			ITS_TBL_User_Credentials_Entity userEntity = userList.get(0);
			return userEntity.getSessionId();
		}

	};

}
