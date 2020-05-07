package com.spring.json;

public class ITS_TBL_User_Credentials {

	private String userid;
	private String password;
	private String loginstatus;
	private String userType;
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public ITS_TBL_User_Credentials() {
	};

	public ITS_TBL_User_Credentials(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}

	public ITS_TBL_User_Credentials(String userid, String password, String loginstatus, String userType,
			String sessionId) {
		super();
		this.userid = userid;
		this.password = password;
		this.loginstatus = loginstatus;
		this.userType = userType;
		this.sessionId = sessionId;
	}

	public String getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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

	@Override
	public boolean equals(Object obj) {
		ITS_TBL_User_Credentials user = (ITS_TBL_User_Credentials) obj;
		if (this.userid.equals(user.userid))
			return true;
		return false;
	}

}
