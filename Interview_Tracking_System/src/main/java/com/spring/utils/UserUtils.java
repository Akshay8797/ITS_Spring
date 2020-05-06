package com.spring.utils;

import com.spring.entity.ITS_TBL_USER_CREDENTIALS_ENTITY;
import com.spring.json.ITS_TBL_USER_CREDENTIALS;

public class UserUtils {
	
	public static ITS_TBL_USER_CREDENTIALS convertITS_TBL_USER_CREDENTIALS_ENTITYToITS_TBL_USER_CREDENTIALS(
			ITS_TBL_USER_CREDENTIALS_ENTITY userEntity) {
		return new ITS_TBL_USER_CREDENTIALS(userEntity.getUserid(), userEntity.getPassword(), userEntity.getUsertype(),
				userEntity.getLoginstatus(), userEntity.getSessionid());
	}

	public static ITS_TBL_USER_CREDENTIALS_ENTITY convertITS_TBL_USER_CREDENTIALSToITS_TBL_USER_CREDENTIALS_ENTITY(
			ITS_TBL_USER_CREDENTIALS user) {
		return new ITS_TBL_USER_CREDENTIALS_ENTITY(user.getUserid(), user.getPassword(), user.getUsertype(),
				user.getLoginstatus(), user.getSessionid());
	}

}
