package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Vender_enti;


public class VenderDAO {

	private Connection conn;

	public VenderDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	
public boolean add_vender(Vender_enti vend) {
		
		boolean f= false;
		
		try {
			
			String sql = "insert into vender(vend_name, vend_address, vend_city, vend_taluka, vend_dist, vend_email, vend_phone) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vend.getVend_name());
			ps.setString(2, vend.getVend_address());
			ps.setString(3, vend.getVend_city());
			ps.setString(4, vend.getVend_taluka());
			ps.setString(5, vend.getVend_dist());
			ps.setString(6, vend.getVend_email());
			ps.setString(7, vend.getVend_phone());
			
			int rs = ps.executeUpdate();
			
			if(rs==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
	
	public List<Vender_enti> getallvenders(){
		
		List<Vender_enti> list = new ArrayList<Vender_enti>();
		Vender_enti vend = null;
		
		try {
			
			String sql = "select * from vender order by vend_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				vend = new Vender_enti();
				vend.setVend_id(rs.getInt(1));
				vend.setVend_name(rs.getString(2));
				vend.setVend_address(rs.getString(3));
				vend.setVend_city(rs.getString(4));
				vend.setVend_taluka(rs.getString(5));
				vend.setVend_dist(rs.getString(6));
				vend.setVend_email(rs.getString(7));
				vend.setVend_phone(rs.getString(8));
				list.add(vend);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
public boolean edit_vender(Vender_enti vend) {
		
		boolean f = false;
		
		try {
			
			String sql = "update vender set vend_name=?, vend_address=?, vend_city=?, vend_taluka=?, vend_dist=?, vend_email=?, vend_phone=? where vend_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, vend.getVend_name());
			ps.setString(2, vend.getVend_address());
			ps.setString(3, vend.getVend_city());
			ps.setString(4, vend.getVend_taluka());
			ps.setString(5, vend.getVend_dist());
			ps.setString(6, vend.getVend_email());
			ps.setString(7, vend.getVend_phone());
			ps.setInt(8, vend.getVend_id());
			
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
public boolean delete_vender(int delt_vend_id) {
	boolean f = false;

	try {

		String sql = "delete from vender where vend_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, delt_vend_id);
	
		int i = ps.executeUpdate();
	
		if(i==1) {
			f=true;
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	return f;
}	


	
	
}
