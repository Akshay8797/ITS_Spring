package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITS_TBL_User_Credentials")
public class ITS_TBL_User_Credentials_Entity {

	@Id
	@Column(name = "UserId")
	private String userid;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Loginstatus")
	private String loginstatus;
	
	@Column(name ="UserType")
	private String userType;


	@Column(name = "sessionId")
	private String sessionId;

	@Column(name ="userType")
	public String getUserType() {
		return userType;
	}


	ITS_TBL_User_Credentials_Entity(){};
	
	public ITS_TBL_User_Credentials_Entity(String userid, String password, String loginstatus, String userType,
			String sessionId) {
		super();
		this.userid = userid;
		this.password = password;
		this.loginstatus = loginstatus;
		this.userType = userType;
		this.sessionId = sessionId;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}

		public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginstatus() {
		return loginstatus;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}
	
}