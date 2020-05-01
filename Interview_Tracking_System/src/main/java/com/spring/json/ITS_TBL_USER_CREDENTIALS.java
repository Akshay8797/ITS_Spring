package com.spring.json;

public class ITS_TBL_USER_CREDENTIALS {
	private String userid;
	private String password;
	private String usertype;
	private String loginstatus;
	public ITS_TBL_USER_CREDENTIALS() {
		super();
		
	}
	public ITS_TBL_USER_CREDENTIALS(String userid, String password, String usertype, String loginstatus) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
	}
	public ITS_TBL_USER_CREDENTIALS(String userid, String password, String usertype) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getLoginstatus() {
		return loginstatus;
	}
	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}
	
}
