package com.entity;

public class library_users {
	
	private int user_id;
	private String user_name;
	private String user_role;
	private String user_email;
	private String user_phone;
	private String user_password;
	
	
	
	
	public library_users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public library_users(String user_name, String user_role, String user_email, String user_phone,
			String user_password) {
		super();
		this.user_name = user_name;
		this.user_role = user_role;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_password = user_password;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
	
}
