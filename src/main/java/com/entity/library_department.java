package com.entity;

public class library_department {
	private String dept_id;
	private String dept_name;
	private String dept_dur;
	
	public library_department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public library_department(String dept_id, String dept_name, String dept_dur) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_dur = dept_dur;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_dur() {
		return dept_dur;
	}

	public void setDept_dur(String dept_dur) {
		this.dept_dur = dept_dur;
	}
	
	
	
	
}
