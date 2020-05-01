package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="its_tbl_user_credentials")
public class ITS_TBL_USER_CREDENTIALS_ENTITY {
	@Id
	@Column(name = "UserId")
	private String userid;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Usertype")
	private String usertype;
	
	@Column(name = "Loginstatus")
	private String loginstatus;

	public ITS_TBL_USER_CREDENTIALS_ENTITY() {
		super();
	}

	public ITS_TBL_USER_CREDENTIALS_ENTITY(String userid, String password, String usertype, String loginstatus) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
	}

	public ITS_TBL_USER_CREDENTIALS_ENTITY(String userid, String password, String usertype) {
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
