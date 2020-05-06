package com.spring.service;

import com.spring.json.ITS_TBL_USER_CREDENTIALS;

public interface UserService {

	public String resetpassword(ITS_TBL_USER_CREDENTIALS user, String newpassword);

}
