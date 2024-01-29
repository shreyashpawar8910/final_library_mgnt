package com.entity;

public class Stock_transection_student_enti {
	
	
	private String tran_stud_id;
	private String tran_stud_name;
	private String tran_stud_dept;
	private String tran_book_id;
	private String tran_book_name;
	private String tran_virt_retur_date;
	private String tran_return_date;
	private int tran_let_day;
	private String tran_status;
	
	private String issue_date;
	private String return_date;
	
	private String candi_type;
	
	private String stock_category;
	
	private double stock_price;
	
	
	public Stock_transection_student_enti() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Stock_transection_student_enti(String tran_stud_id, String tran_stud_name, String tran_stud_dept,
			String tran_book_id, String tran_book_name, String tran_virt_retur_date, String tran_return_date,
			int tran_let_day, String tran_status, String issue_date, String return_date, String stock_category , String candi_type, double stock_price) {
		super();
		this.tran_stud_id = tran_stud_id;
		this.tran_stud_name = tran_stud_name;
		this.tran_stud_dept = tran_stud_dept;
		this.tran_book_id = tran_book_id;
		this.tran_book_name = tran_book_name;
		this.tran_virt_retur_date = tran_virt_retur_date;
		this.tran_return_date = tran_return_date;
		this.tran_let_day = tran_let_day;
		this.tran_status = tran_status;
		
		this.issue_date = issue_date;
		this.return_date = return_date;
		
		this.stock_category = stock_category;
		
		this.candi_type = candi_type;
		
		this.stock_price = stock_price;
	}


	
	
	
	
	
	
	public double getStock_price() {
		return stock_price;
	}


	public void setStock_price(double stock_price) {
		this.stock_price = stock_price;
	}


	public String getCandi_type() {
		return candi_type;
	}


	public void setCandi_type(String candi_type) {
		this.candi_type = candi_type;
	}


	public String getStock_category() {
		return stock_category;
	}


	public void setStock_category(String stock_category) {
		this.stock_category = stock_category;
	}


	public String getIssue_date() {
		return issue_date;
	}


	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}


	public String getReturn_date() {
		return return_date;
	}


	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}


	public String getTran_stud_id() {
		return tran_stud_id;
	}


	public void setTran_stud_id(String tran_stud_id) {
		this.tran_stud_id = tran_stud_id;
	}


	public String getTran_stud_name() {
		return tran_stud_name;
	}


	public void setTran_stud_name(String tran_stud_name) {
		this.tran_stud_name = tran_stud_name;
	}


	public String getTran_stud_dept() {
		return tran_stud_dept;
	}


	public void setTran_stud_dept(String tran_stud_dept) {
		this.tran_stud_dept = tran_stud_dept;
	}


	public String getTran_book_id() {
		return tran_book_id;
	}


	public void setTran_book_id(String tran_book_id) {
		this.tran_book_id = tran_book_id;
	}


	public String getTran_book_name() {
		return tran_book_name;
	}


	public void setTran_book_name(String tran_book_name) {
		this.tran_book_name = tran_book_name;
	}


	public String getTran_virt_retur_date() {
		return tran_virt_retur_date;
	}


	public void setTran_virt_retur_date(String tran_virt_retur_date) {
		this.tran_virt_retur_date = tran_virt_retur_date;
	}


	public String getTran_return_date() {
		return tran_return_date;
	}


	public void setTran_return_date(String tran_return_date) {
		this.tran_return_date = tran_return_date;
	}


	public int getTran_let_day() {
		return tran_let_day;
	}


	public void setTran_let_day(int tran_let_day) {
		this.tran_let_day = tran_let_day;
	}


	public String getTran_status() {
		return tran_status;
	}


	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}
	
	
	
	

}
