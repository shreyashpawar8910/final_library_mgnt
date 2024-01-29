package com.entity;

public class book_category_enti {

	private String bcat_id;
	private String bcat_name;
	private String bcat_type;
	
	
	
	public book_category_enti() {
		super();

	}


	public book_category_enti(String bcat_id, String bcat_name, String bcat_type) {
		super();
		this.bcat_id = bcat_id;
		this.bcat_name = bcat_name;
		this.bcat_type = bcat_type;
		
	}


	public String getBcat_id() {
		return bcat_id;
	}


	public void setBcat_id(String bcat_id) {
		this.bcat_id = bcat_id;
	}


	public String getBcat_name() {
		return bcat_name;
	}


	public void setBcat_name(String bcat_name) {
		this.bcat_name = bcat_name;
	}
	
	public String getBcat_type() {
		return bcat_type;
	}


	public void setBcat_type(String bcat_type) {
		this.bcat_type = bcat_type;
	}
	
}
