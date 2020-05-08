package com.spring.service;

import com.spring.json.ITS_TBL_User_Credentials;

public interface UserService {
	
	public String login(String userId, String password, String userType);
	public String logout(String authToken);
	public String resetpassword(ITS_TBL_User_Credentials user, String newpassword);
	public String getSessionId(String userid);
}
