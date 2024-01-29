package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.library_department;
import com.entity.library_users;

public class userDAO {
	private Connection conn;

	public userDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean adduser(library_users us) {
		
		boolean f = false;
		
		try {
			
			if(us.getUser_role().equals("Admin") || us.getUser_role().equals("Principle")) {
				String check_sql = "select * from users where user_role=?";
				PreparedStatement ps = conn.prepareStatement(check_sql);
				ps.setString(1, us.getUser_role());
				ResultSet rs = ps.executeQuery();
				
				int i = 0;
				while(rs.next()) {
					i++;
				}
				
				if(i==0) {
					String sql = "insert into users(user_name, user_role, user_email, user_phone,user_password) values(?,?,?,?,?)";
					
					PreparedStatement pps = conn.prepareStatement(sql);
					ps.setString(1, us.getUser_name());
					ps.setString(2, us.getUser_role());
					ps.setString(3, us.getUser_email());
					ps.setString(4, us.getUser_phone());
					ps.setString(5, us.getUser_password());
					
					int rrs = pps.executeUpdate();
					
					if(rrs==1) {
						
						f=true;
					}
				}else{
					
					f=false;
					
				}
				
				
			}else {
				String sql = "insert into users(user_name, user_role, user_email, user_phone,user_password) values(?,?,?,?,?)";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, us.getUser_name());
				ps.setString(2, us.getUser_role());
				ps.setString(3, us.getUser_email());
				ps.setString(4, us.getUser_phone());
				ps.setString(5, us.getUser_password());
				
				int rs = ps.executeUpdate();
				
				if(rs==1) {
					
					f=true;
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
	public List<library_users> getAll_users(){								// Show List of department data list
		
		List<library_users> list = new ArrayList<library_users>();
		library_users us = null;
		
		try {
			
			String sql = "select * from users order by user_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				us = new library_users();
				
				us.setUser_id(rs.getInt(1));
				us.setUser_name(rs.getString(2));
				us.setUser_role(rs.getString(3));
				us.setUser_email(rs.getString(4));
				us.setUser_phone(rs.getString(5));
				us.setUser_password(rs.getString(6));
				
				list.add(us);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	
	public boolean edit_user(library_users us) {
		
		boolean f = false;
		
		try {
	
			
			
				String sql = "update users set user_name=?, user_email=?, user_phone=?,user_password=? where user_id=?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, us.getUser_name());
					
					ps.setString(2, us.getUser_email());
					ps.setString(3, us.getUser_phone());
					ps.setString(4, us.getUser_password());
					
					ps.setInt(5, us.getUser_id());
					
					int rrs = ps.executeUpdate();
					
					if(rrs==1) {
						
						f=true;
					}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return f;
	}
	
	
	
public boolean delete_user(int user_id) {
		
		boolean f = false;
		
		try {

			String sql = "delete from users where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
}
	
	
	
	
	
}
