package com.entity;

import java.io.InputStream;

import com.mysql.cj.jdbc.Blob;

public class Staff_enti {
	
	
	private String staff_id;
	private String staff_name;
	private String staff_dept;
	private String staff_dob;
	private String staff_city;
	private String staff_taluka;
	private String staff_dist;
	private String staff_phone;
	private String staff_email;
	private InputStream inputStream;
	
	private Blob image;
	private String encodeimg;
	private byte barr[];
	
	private String setSearch_student_table;
	private String setSearch_student_content;
	
	private String original_dept;
	
	
	public Staff_enti() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Staff_enti(String staff_id, String staff_name, String staff_dept, String staff_dob, String staff_city,
			String staff_taluka, String staff_dist, String staff_phone, String staff_email, InputStream inputStream,
			String setSearch_student_table, String setSearch_student_content, String original_dept) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_dept = staff_dept;
		this.staff_dob = staff_dob;
		this.staff_city = staff_city;
		this.staff_taluka = staff_taluka;
		this.staff_dist = staff_dist;
		this.staff_phone = staff_phone;
		this.staff_email = staff_email;
		this.inputStream = inputStream;
		this.setSearch_student_table = setSearch_student_table;
		this.setSearch_student_content = setSearch_student_content;
		
		this.original_dept = original_dept;
	}

	
	
	
	
	
	

	public String getOriginal_dept() {
		return original_dept;
	}


	public void setOriginal_dept(String original_dept) {
		this.original_dept = original_dept;
	}


	public byte[] getBarr() {
		return barr;
	}


	public void setBarr(byte[] barr) {
		this.barr = barr;
	}


	public Blob getImage() {
		return image;
	}


	public void setImage(Blob image) {
		this.image = image;
	}


	public String getEncodeimg() {
		return encodeimg;
	}


	public void setEncodeimg(String encodeimg) {
		this.encodeimg = encodeimg;
	}


	public String getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}


	public String getStaff_name() {
		return staff_name;
	}


	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}


	public String getStaff_dept() {
		return staff_dept;
	}


	public void setStaff_dept(String staff_dept) {
		this.staff_dept = staff_dept;
	}


	public String getStaff_dob() {
		return staff_dob;
	}


	public void setStaff_dob(String staff_dob) {
		this.staff_dob = staff_dob;
	}


	public String getStaff_city() {
		return staff_city;
	}


	public void setStaff_city(String staff_city) {
		this.staff_city = staff_city;
	}


	public String getStaff_taluka() {
		return staff_taluka;
	}


	public void setStaff_taluka(String staff_taluka) {
		this.staff_taluka = staff_taluka;
	}


	public String getStaff_dist() {
		return staff_dist;
	}


	public void setStaff_dist(String staff_dist) {
		this.staff_dist = staff_dist;
	}


	public String getStaff_phone() {
		return staff_phone;
	}


	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}


	public String getStaff_email() {
		return staff_email;
	}


	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public String getSetSearch_student_table() {
		return setSearch_student_table;
	}


	public void setSetSearch_student_table(String setSearch_student_table) {
		this.setSearch_student_table = setSearch_student_table;
	}


	public String getSetSearch_student_content() {
		return setSearch_student_content;
	}


	public void setSetSearch_student_content(String setSearch_student_content) {
		this.setSearch_student_content = setSearch_student_content;
	}
	
	
	

}
