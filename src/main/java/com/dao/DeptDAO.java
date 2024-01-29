package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.entity.library_department;

public class DeptDAO {
	
	private Connection conn;

	public DeptDAO(Connection conn) {
		super();
		this.conn = conn;
	}	
	
	public boolean add_department(library_department dept) {		// Insert Data into department Table
		
		boolean f= false;
		
		try {
			
			String sql = "insert into department(dept_id, dept_name, dept_dur) values(?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDept_id());
			ps.setString(2, dept.getDept_name());
			ps.setString(3, dept.getDept_dur());
			
			int rs = ps.executeUpdate();
			if(rs==1) {
				f=true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;		
	}

	public List<library_department> getAlldept(){								// Show List of department data list
		
		List<library_department> list = new ArrayList<library_department>();
		library_department dept = null;
		
		try {		
			String sql = "select * from department order by dept_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				dept= new library_department();
				dept.setDept_id(rs.getString(1));
				dept.setDept_name(rs.getString(2));
				dept.setDept_dur(rs.getString(3));
				list.add(dept);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}
	
	
public library_department getdeptById(String dept_id) {
		
		library_department lib_dept = null;
		
		try {
			
			String sql = "select * from department where dept_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				lib_dept = new library_department();
				lib_dept.setDept_id(rs.getString(1));
				lib_dept.setDept_name(rs.getString(2));
				lib_dept.setDept_dur(rs.getString(3));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lib_dept;
	}
	
	
	
	
	public boolean edit_department(library_department dept) {
		
		boolean f = false;
		
		try {
			
			String sql = "update department set dept_name=?,dept_dur=? where dept_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, dept.getDept_name());
			ps.setString(2, dept.getDept_dur());
			ps.setString(3, dept.getDept_id());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	public boolean delete_department(String delt_dept_id) {
		boolean f = false;
		
		try {
		
			String sql = "delete from department where dept_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, delt_dept_id);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean last_id_department(library_department dept) {
		
		boolean f = false;
		try {
			
			String sql = "select dept_id from department order by dept_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			String soop = null;
			
			while(rs.next()) {
				soop = rs.getString(1);
			}
			
			if(soop==null) {
				dept.setDept_id("1001");
				f=true;
			}else {
				
				int temp_dept = Integer.parseInt(soop);
				temp_dept++;
				String final_id = String.valueOf(temp_dept);
				dept.setDept_id(final_id);
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	


}
