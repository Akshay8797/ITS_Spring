package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_USER_CREDENTIALS_ENTITY;
import com.spring.json.ITS_TBL_USER_CREDENTIALS;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public String resetpassword(ITS_TBL_USER_CREDENTIALS user, String newpassword) {

		if (userRepository.findByuserid(user.getUserid()) == null) {
			return "{\"Failed\"}";
		} else {
			ITS_TBL_USER_CREDENTIALS newUser = UserUtils
					.convertITS_TBL_USER_CREDENTIALS_ENTITYToITS_TBL_USER_CREDENTIALS(
							userRepository.findByuserid(user.getUserid()));
			if (newUser.getUserid().equals(user.getUserid())) {
				if (newUser.getPassword().equals(user.getPassword())) {
					ITS_TBL_USER_CREDENTIALS_ENTITY userEntity = userRepository.findByuserid((newUser.getUserid()));
					userEntity.setPassword(newpassword);
					userRepository.save(userEntity);
					return "{\"Password Updated\"}";
				} else {
					return "{\"Invalid Password\"}";
				}
			} else
				return "{\"Invalid User\"}";

		}

	}

}
