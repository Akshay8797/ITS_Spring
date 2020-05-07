package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.json.ITS_TBL_User_Credentials;

public class UserUtils {
	public static List<ITS_TBL_User_Credentials> convertUserEntityListToUserList(List<ITS_TBL_User_Credentials_Entity> userEntityList) {
		List<ITS_TBL_User_Credentials> userList = new ArrayList<ITS_TBL_User_Credentials>();
		Consumer<ITS_TBL_User_Credentials_Entity> consumer = (ITS_TBL_User_Credentials_Entity userEntity)->userList.add(convertUserEntityToUser(userEntity));
		userEntityList.stream().forEach(consumer);
		return userList;
	}
	
	public static ITS_TBL_User_Credentials convertUserEntityToUser(ITS_TBL_User_Credentials_Entity userEntity) {
		return new ITS_TBL_User_Credentials(userEntity.getUserid(),userEntity.getPassword(),userEntity.getLoginstatus(),userEntity.getUserType(),userEntity.getSessionId());
	}

	public static ITS_TBL_User_Credentials_Entity convertUserToUserEntity(ITS_TBL_User_Credentials user) {
		return new ITS_TBL_User_Credentials_Entity(user.getUserid(),user.getPassword(),user.getLoginstatus(),user.getUserType(),user.getSessionId());
	}

}
