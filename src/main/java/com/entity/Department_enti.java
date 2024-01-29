package com.entity;

public class Department_enti {
	
	private String dept_id;
	private String dept_name;
	private int dept_dur;
	private String final_class;
	
	
	public Department_enti() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department_enti(String dept_id, String dept_name, int dept_dur, String final_class) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_dur = dept_dur;
		this.final_class = final_class;
	}

	
	
	

	public String getFinal_class() {
		return final_class;
	}


	public void setFinal_class(String final_class) {
		this.final_class = final_class;
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


	public int getDept_dur() {
		return dept_dur;
	}


	public void setDept_dur(int dept_dur) {
		this.dept_dur = dept_dur;
	}
	
	
	

}
