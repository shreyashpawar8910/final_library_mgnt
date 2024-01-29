package com.entity;

public class publisher_enti {
	
	private int publ_id;
	private String publ_name;
	private String publ_address;
	private String publ_city;
	private String publ_taluka;
	private String publ_dist;
	private String publ_email;
	private String publ_phone;
	
	
	public publisher_enti() {
		super();
		// TODO Auto-generated constructor stub
	}


	public publisher_enti(String publ_name, String publ_address, String publ_city, String publ_taluka, String publ_dist,
			String publ_email, String publ_phone) {
		super();
		this.publ_name = publ_name;
		this.publ_address = publ_address;
		this.publ_city = publ_city;
		this.publ_taluka = publ_taluka;
		this.publ_dist = publ_dist;
		this.publ_email = publ_email;
		this.publ_phone = publ_phone;
	}


	public int getPubl_id() {
		return publ_id;
	}


	public void setPubl_id(int publ_id) {
		this.publ_id = publ_id;
	}


	public String getPubl_name() {
		return publ_name;
	}


	public void setPubl_name(String publ_name) {
		this.publ_name = publ_name;
	}


	public String getPubl_address() {
		return publ_address;
	}


	public void setPubl_address(String publ_address) {
		this.publ_address = publ_address;
	}


	public String getPubl_city() {
		return publ_city;
	}


	public void setPubl_city(String publ_city) {
		this.publ_city = publ_city;
	}


	public String getPubl_taluka() {
		return publ_taluka;
	}


	public void setPubl_taluka(String publ_taluka) {
		this.publ_taluka = publ_taluka;
	}


	public String getPubl_dist() {
		return publ_dist;
	}


	public void setPubl_dist(String publ_dist) {
		this.publ_dist = publ_dist;
	}


	public String getPubl_email() {
		return publ_email;
	}


	public void setPubl_email(String publ_email) {
		this.publ_email = publ_email;
	}


	public String getPubl_phone() {
		return publ_phone;
	}


	public void setPubl_phone(String publ_phone) {
		this.publ_phone = publ_phone;
	}
	
	
}
