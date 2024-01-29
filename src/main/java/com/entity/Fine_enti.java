package com.entity;

public class Fine_enti {

	public Fine_enti() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private String fine_tran_id;
	private String fine_stud_id;
	private String fine_book_id;
	private String fine_stud_name;
	private String fine_book_name;
	private String fine_issue_date;
	private String fine_last_date;
	private String fine_late_days;
	private Double fine_amount;
	private String profile;
	
	private Double total_fine;
	
	private String stud_dept; 
	
	
	
	public Fine_enti(String fine_tran_id, String fine_stud_id, String fine_book_id, String fine_stud_name,
			String fine_book_name, String fine_issue_date, String fine_last_date, String fine_late_days,
			Double fine_amount, String profile, Double total_fine, String stud_dept) {
		super();
		this.fine_tran_id = fine_tran_id;
		this.fine_stud_id = fine_stud_id;
		this.fine_book_id = fine_book_id;
		this.fine_stud_name = fine_stud_name;
		this.fine_book_name = fine_book_name;
		this.fine_issue_date = fine_issue_date;
		this.fine_last_date = fine_last_date;
		this.fine_late_days = fine_late_days;
		this.fine_amount = fine_amount;
		this.profile = profile;
		
		this.total_fine = total_fine;
		
		this.stud_dept = stud_dept;
	}



	
	
	
	
	
	
	
	
	
	public String getStud_dept() {
		return stud_dept;
	}












	public void setStud_dept(String stud_dept) {
		this.stud_dept = stud_dept;
	}












	public Double getTotal_fine() {
		return total_fine;
	}








	public void setTotal_fine(Double total_fine) {
		this.total_fine = total_fine;
	}








	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}








	public String getFine_tran_id() {
		return fine_tran_id;
	}



	public void setFine_tran_id(String fine_tran_id) {
		this.fine_tran_id = fine_tran_id;
	}



	public String getFine_stud_id() {
		return fine_stud_id;
	}



	public void setFine_stud_id(String fine_stud_id) {
		this.fine_stud_id = fine_stud_id;
	}



	public String getFine_book_id() {
		return fine_book_id;
	}



	public void setFine_book_id(String fine_book_id) {
		this.fine_book_id = fine_book_id;
	}



	public String getFine_stud_name() {
		return fine_stud_name;
	}



	public void setFine_stud_name(String fine_stud_name) {
		this.fine_stud_name = fine_stud_name;
	}



	public String getFine_book_name() {
		return fine_book_name;
	}



	public void setFine_book_name(String fine_book_name) {
		this.fine_book_name = fine_book_name;
	}



	public String getFine_issue_date() {
		return fine_issue_date;
	}



	public void setFine_issue_date(String fine_issue_date) {
		this.fine_issue_date = fine_issue_date;
	}



	public String getFine_last_date() {
		return fine_last_date;
	}



	public void setFine_last_date(String fine_last_date) {
		this.fine_last_date = fine_last_date;
	}



	public String getFine_late_days() {
		return fine_late_days;
	}



	public void setFine_late_days(String fine_late_days) {
		this.fine_late_days = fine_late_days;
	}



	public Double getFine_amount() {
		return fine_amount;
	}



	public void setFine_amount(Double fine_amount) {
		this.fine_amount = fine_amount;
	}

	
	
	
	
	
	
}
