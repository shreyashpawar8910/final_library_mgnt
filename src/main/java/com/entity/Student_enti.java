package com.entity;

import java.io.InputStream;

import com.mysql.cj.jdbc.Blob;

public class Student_enti {

	private String stud_id;
	private String stud_name;
	private String stud_dept;
	private String stud_class;
	private String stud_dob;
	private String stud_city;
	private String stud_taluka;
	private String stud_dist;
	private String stud_phone;
	private String stud_email;
	private String stud_photo;
	private InputStream inputStream;
	
	private Blob image;
	private String encodeimg;
	
	
	private String pramote_class;
	
	private String setSearch_student_table;
	private String setSearch_student_content;
	
	private String message_var;
	private String content_set;
	private String profile_set;
	
	private String original_dept;
	
	private byte barr[];
	
	public Student_enti() {
		super();

	}

	public Student_enti(String stud_name, String stud_dept, String stud_class, String stud_dob, String stud_city,
			String stud_taluka, String stud_dist, String stud_phone, String stud_email, String stud_photo, String setSearch_student_table,
			String setSearch_student_content, String original_dept) {
		super();
		this.stud_name = stud_name;
		this.stud_dept = stud_dept;
		this.stud_class = stud_class;
		this.stud_dob = stud_dob;
		this.stud_city = stud_city;
		this.stud_taluka = stud_taluka;
		this.stud_dist = stud_dist;
		this.stud_phone = stud_phone;
		this.stud_email = stud_email;
		this.stud_photo = stud_photo;
		
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

	public String getPramote_class() {
		return pramote_class;
	}

	public void setPramote_class(String pramote_class) {
		this.pramote_class = pramote_class;
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

	public String getEncodeimg() {
		return encodeimg;
	}

	public void setEncodeimg(String encodeimg) {
		this.encodeimg = encodeimg;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
	

	public String getProfile_set() {
		return profile_set;
	}

	public void setProfile_set(String profile_set) {
		this.profile_set = profile_set;
	}

	
	public String getContent_set() {
		return content_set;
	}

	public void setContent_set(String content_set) {
		this.content_set = content_set;
	}

	public String getMessage_var() {
		return message_var;
	}

	public void setMessage_var(String message_var) {
		this.message_var = message_var;
	}

	public byte[] getBarr() {
		return barr;
	}

	public void setBarr(byte[] barr) {
		this.barr = barr;
	}
	
	

	public InputStream getInputStream() { return inputStream; }
	  
	  
	  
	  
	  public void setInputStream(InputStream inputStream)
	  { 
		  this.inputStream = inputStream; 
       }
	  
	 

	public String getStud_id() {
		return stud_id;
	}

	public void setStud_id(String stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getStud_dept() {
		return stud_dept;
	}

	public void setStud_dept(String stud_dept) {
		this.stud_dept = stud_dept;
	}

	public String getStud_class() {
		return stud_class;
	}

	public void setStud_class(String stud_class) {
		this.stud_class = stud_class;
	}

	public String getStud_dob() {
		return stud_dob;
	}

	public void setStud_dob(String stud_dob) {
		this.stud_dob = stud_dob;
	}

	public String getStud_city() {
		return stud_city;
	}

	public void setStud_city(String stud_city) {
		this.stud_city = stud_city;
	}

	public String getStud_taluka() {
		return stud_taluka;
	}

	public void setStud_taluka(String stud_taluka) {
		this.stud_taluka = stud_taluka;
	}

	public String getStud_dist() {
		return stud_dist;
	}

	public void setStud_dist(String stud_dist) {
		this.stud_dist = stud_dist;
	}

	public String getStud_phone() {
		return stud_phone;
	}

	public void setStud_phone(String stud_phone) {
		this.stud_phone = stud_phone;
	}

	public String getStud_email() {
		return stud_email;
	}

	public void setStud_email(String stud_email) {
		this.stud_email = stud_email;
	}

	public String getStud_photo() {
		return stud_photo;
	}

	public void setStud_photo(String stud_photo) {
		this.stud_photo = stud_photo;
	}

}
