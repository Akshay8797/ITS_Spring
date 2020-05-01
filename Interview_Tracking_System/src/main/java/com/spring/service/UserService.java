package com.spring.service;

import com.spring.json.ITS_TBL_User_Credentials;

public interface UserService {
	
	public String login(ITS_TBL_User_Credentials user);
	public String logout(String authToken);
	public String resetpassword(ITS_TBL_User_Credentials user,String newpassword);
}
