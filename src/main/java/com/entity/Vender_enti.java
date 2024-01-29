package com.entity;

public class Vender_enti {
	private int vend_id;
	private String vend_name;
	private String vend_address;
	private String vend_city;
	private String vend_taluka;
	private String vend_dist;
	private String vend_email;
	private String vend_phone;
	
	public Vender_enti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vender_enti(String vend_name, String vend_address, String vend_city, String vend_taluka, String vend_dist,
			String vend_email, String vend_phone) {
		super();
		this.vend_name = vend_name;
		this.vend_address = vend_address;
		this.vend_city = vend_city;
		this.vend_taluka = vend_taluka;
		this.vend_dist = vend_dist;
		this.vend_email = vend_email;
		this.vend_phone = vend_phone;
	}

	public int getVend_id() {
		return vend_id;
	}

	public void setVend_id(int vend_id) {
		this.vend_id = vend_id;
	}

	public String getVend_name() {
		return vend_name;
	}

	public void setVend_name(String vend_name) {
		this.vend_name = vend_name;
	}

	public String getVend_address() {
		return vend_address;
	}

	public void setVend_address(String vend_address) {
		this.vend_address = vend_address;
	}

	public String getVend_city() {
		return vend_city;
	}

	public void setVend_city(String vend_city) {
		this.vend_city = vend_city;
	}

	public String getVend_taluka() {
		return vend_taluka;
	}

	public void setVend_taluka(String vend_taluka) {
		this.vend_taluka = vend_taluka;
	}

	public String getVend_dist() {
		return vend_dist;
	}

	public void setVend_dist(String vend_dist) {
		this.vend_dist = vend_dist;
	}

	public String getVend_email() {
		return vend_email;
	}

	public void setVend_email(String vend_email) {
		this.vend_email = vend_email;
	}

	public String getVend_phone() {
		return vend_phone;
	}

	public void setVend_phone(String vend_phone) {
		this.vend_phone = vend_phone;
	}
	
	
}
