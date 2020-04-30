package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ITS_TBL_User_Credentials_Entity {
	@GeneratedValue
	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "USERID")
	private String userId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERTYPE")
	private String userType;

	@Column(name = "LOGINSTATUS")
	private String loginStatus;

	public ITS_TBL_User_Credentials_Entity() {
		super();
	}

	public ITS_TBL_User_Credentials_Entity(String userId, String password, String userType, String loginStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
	}

	public ITS_TBL_User_Credentials_Entity(String userId, String password, String userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
