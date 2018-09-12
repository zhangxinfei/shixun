package com.software.domain;

public class Users {
	private String userId;
	private String password;
	private String userName;
	private String phone;
	private String mail;
	private String flag;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Users(String userId, String password, String userName, String phone,
			String mail, String flag) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.phone = phone;
		this.mail = mail;
		this.flag = flag;
	}
	public Users() {
		super();
	}
	
	

}
