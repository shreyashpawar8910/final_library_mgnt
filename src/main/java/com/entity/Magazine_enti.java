package com.entity;

public class Magazine_enti {

	
	private String mag_id;
	private String mag_dept;
	private String mag_catrgory;
	private String mag_classif_no;
	private String mag_title;
	private String mag_sub_title;
	private String mag_subject;
	private String mag_edition;
	private int mag_no_copies;
	private String mag_author;
	private String mag_publisher;
	private String mag_publi_year;
	private String mag_vend_nm;
	private String mag_pages;
	private double mag_price;
	private String mag_rack_no;
	private String mag_language;
	
	private String search_mag_table;
	private String search_mag_content;
	
	private String search_publisher;
	
	private String Mag_status;
	
	public Magazine_enti() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Magazine_enti(String mag_id, String mag_dept, String mag_catrgory, String mag_classif_no, String mag_title,
			String mag_sub_title, String mag_subject, String mag_edition, int mag_no_copies, String mag_author,
			String mag_publisher, String mag_publi_year, String mag_vend_nm, String mag_pages, double mag_price,
			String mag_rack_no, String mag_language, String search_mag_table, String search_mag_content, 
			String search_publisher, String Mag_status) {
		super();
		this.mag_id = mag_id;
		this.mag_dept = mag_dept;
		this.mag_catrgory = mag_catrgory;
		this.mag_classif_no = mag_classif_no;
		this.mag_title = mag_title;
		this.mag_sub_title = mag_sub_title;
		this.mag_subject = mag_subject;
		this.mag_edition = mag_edition;
		this.mag_no_copies = mag_no_copies;
		this.mag_author = mag_author;
		this.mag_publisher = mag_publisher;
		this.mag_publi_year = mag_publi_year;
		this.mag_vend_nm = mag_vend_nm;
		this.mag_pages = mag_pages;
		this.mag_price = mag_price;
		this.mag_rack_no = mag_rack_no;
		this.mag_language = mag_language;
		
		
		this.search_mag_table = search_mag_table;
		this.search_mag_content = search_mag_content;
		
		this.search_publisher = search_publisher;
		
		this.Mag_status = Mag_status;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	public String getMag_status() {
		return Mag_status;
	}



	public void setMag_status(String mag_status) {
		Mag_status = mag_status;
	}



	public String getSearch_publisher() {
		return search_publisher;
	}



	public void setSearch_publisher(String search_publisher) {
		this.search_publisher = search_publisher;
	}



	public String getMag_id() {
		return mag_id;
	}



	public void setMag_id(String mag_id) {
		this.mag_id = mag_id;
	}



	public String getMag_dept() {
		return mag_dept;
	}



	public void setMag_dept(String mag_dept) {
		this.mag_dept = mag_dept;
	}



	public String getMag_catrgory() {
		return mag_catrgory;
	}



	public void setMag_catrgory(String mag_catrgory) {
		this.mag_catrgory = mag_catrgory;
	}



	public String getMag_classif_no() {
		return mag_classif_no;
	}



	public void setMag_classif_no(String mag_classif_no) {
		this.mag_classif_no = mag_classif_no;
	}



	public String getMag_title() {
		return mag_title;
	}



	public void setMag_title(String mag_title) {
		this.mag_title = mag_title;
	}



	public String getMag_sub_title() {
		return mag_sub_title;
	}



	public void setMag_sub_title(String mag_sub_title) {
		this.mag_sub_title = mag_sub_title;
	}



	public String getMag_subject() {
		return mag_subject;
	}



	public void setMag_subject(String mag_subject) {
		this.mag_subject = mag_subject;
	}



	public String getMag_edition() {
		return mag_edition;
	}



	public void setMag_edition(String mag_edition) {
		this.mag_edition = mag_edition;
	}



	public int getMag_no_copies() {
		return mag_no_copies;
	}



	public void setMag_no_copies(int mag_no_copies) {
		this.mag_no_copies = mag_no_copies;
	}



	public String getMag_author() {
		return mag_author;
	}



	public void setMag_author(String mag_author) {
		this.mag_author = mag_author;
	}



	public String getMag_publisher() {
		return mag_publisher;
	}



	public void setMag_publisher(String mag_publisher) {
		this.mag_publisher = mag_publisher;
	}



	public String getMag_publi_year() {
		return mag_publi_year;
	}



	public void setMag_publi_year(String mag_publi_year) {
		this.mag_publi_year = mag_publi_year;
	}



	public String getMag_vend_nm() {
		return mag_vend_nm;
	}



	public void setMag_vend_nm(String mag_vend_nm) {
		this.mag_vend_nm = mag_vend_nm;
	}



	public String getMag_pages() {
		return mag_pages;
	}



	public void setMag_pages(String mag_pages) {
		this.mag_pages = mag_pages;
	}



	public double getMag_price() {
		return mag_price;
	}



	public void setMag_price(double mag_price) {
		this.mag_price = mag_price;
	}



	public String getMag_rack_no() {
		return mag_rack_no;
	}



	public void setMag_rack_no(String mag_rack_no) {
		this.mag_rack_no = mag_rack_no;
	}



	public String getMag_language() {
		return mag_language;
	}



	public void setMag_language(String mag_language) {
		this.mag_language = mag_language;
	}



	public String getSearch_mag_table() {
		return search_mag_table;
	}



	public void setSearch_mag_table(String search_mag_table) {
		this.search_mag_table = search_mag_table;
	}



	public String getSearch_mag_content() {
		return search_mag_content;
	}



	public void setSearch_mag_content(String search_mag_content) {
		this.search_mag_content = search_mag_content;
	}
	
	

}
