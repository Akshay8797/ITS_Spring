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

	
	public String login(ITS_TBL_USER_CREDENTIALS user) {
		//String sessionId=null;
		//Random random =new Random();
		if(userRepository.findByuserid(user.getUserid())==null)
		{
			return "{\"result\": \"Invalid User\"}";
		}
		else
		{
		ITS_TBL_USER_CREDENTIALS newUser =UserUtils.convertITS_TBL_USER_CREDENTIALS_ENTITYToITS_TBL_USER_CREDENTIALS(userRepository.findByuserid(user.getUserid()));
			if (newUser.getUserid().equals(user.getUserid()))
			{
				if(newUser.getPassword().equals(user.getPassword()))
				{
					String sessionId = new java.rmi.server.UID().toString().substring(0,10);
					ITS_TBL_USER_CREDENTIALS_ENTITY userEntity = userRepository.findByuserid((newUser.getUserid()));
					userEntity.setLoginstatus(0);
					userEntity.setSessionid(sessionId);
					userEntity = userRepository.save(userEntity);
					
					// System.out.println(newUser.getLoginstatus());
					return "{\"result\": \"success\",\"UserType\":\""+newUser.getUsertype()+"\"}";
				}
				else 
				{
					return "{\"result\": \"invalid Password\"}";
				}
			}	
		else 
			return "{\"result\": \"Invalid User\"}";
	}
	}

	public String logout(String authToken) {
		if(userRepository.findBysessionid(authToken)==null )
		{
			return "failed";
		}
		else
		{
		ITS_TBL_USER_CREDENTIALS_ENTITY newUser=userRepository.findBysessionid(authToken);
		ITS_TBL_USER_CREDENTIALS_ENTITY userEntity = userRepository.findByuserid((newUser.getUserid()));
			String sessionId=null;
			int loginstatus=1;
			userEntity.setSessionid(sessionId);
			userEntity.setLoginstatus(loginstatus);
			userRepository.save(userEntity);
			return "Logged out successfully";
	}}
	/*public String logout(String sessionId) {
		//LoginResponse response = new LoginResponse();
		if (sessionId == null) {
			//response.setMessage("INVALID SESSIONID");
			return "{\"message\": \"INVALID SESSIONID\"}";
		} else {
			ITS_TBL_USER_CREDENTIALS_ENTITY userEntity = userRepository.findBysessionid(sessionId);
			//System.out.println(
			//		"===========================================================================>" + sessionId);
			userEntity.setSessionid(null);
			userEntity.setLoginstatus(1);

			userRepository.save(userEntity);
			//response.setMessage("LOGGED OUT SUCCESFULLY");
			return "{\"message\": \"LOGGED OUT SUCCESFULLY\"}";
		}
		
	}*/
	

	public String resetpassword(ITS_TBL_USER_CREDENTIALS user, String newpassword) {

		if (userRepository.findByuserid(user.getUserid()) == null) {
			return "{\"result\": \"Invalid\"}";
		} else {
			ITS_TBL_USER_CREDENTIALS newUser = UserUtils
					.convertITS_TBL_USER_CREDENTIALS_ENTITYToITS_TBL_USER_CREDENTIALS(
							userRepository.findByuserid(user.getUserid()));
			if (newUser.getUserid().equals(user.getUserid())) {
				if (newUser.getPassword().equals(user.getPassword())) {
					ITS_TBL_USER_CREDENTIALS_ENTITY userEntity = userRepository.findByuserid((newUser.getUserid()));
					userEntity.setPassword(newpassword);
					userRepository.save(userEntity);
					return "{\"result\": \"Password Updated\"}";
				} else {
					return "{\"result\": \"Invalid Password\"}";
				}
			} else
				return "{\"result\": \"Invalid User\"}";
		}

	}

}

