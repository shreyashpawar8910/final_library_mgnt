package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Vender_enti;
import com.entity.publisher_enti;

public class PublisherDAO {

	private Connection conn;

	public PublisherDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
public boolean add_publisher(publisher_enti publ) {
		
		boolean f= false;
		
		try {
			
			String sql = "insert into publisher(publ_name, publ_address, publ_city, publ_taluka, publ_dist, publ_email, publ_phone) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, publ.getPubl_name());
			ps.setString(2, publ.getPubl_address());
			ps.setString(3, publ.getPubl_city());
			ps.setString(4, publ.getPubl_taluka());
			ps.setString(5, publ.getPubl_dist());
			ps.setString(6, publ.getPubl_email());
			ps.setString(7, publ.getPubl_phone());
			
			int rs = ps.executeUpdate();
			
			if(rs==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}


public List<publisher_enti> getallpublishers(){
	
	List<publisher_enti> list = new ArrayList<publisher_enti>();
	publisher_enti publ = null;
	
	try {
		
		String sql = "select * from publisher order by publ_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			publ = new publisher_enti();
			publ.setPubl_id(rs.getInt(1));
			publ.setPubl_name(rs.getString(2));
			publ.setPubl_address(rs.getString(3));
			publ.setPubl_city(rs.getString(4));
			publ.setPubl_taluka(rs.getString(5));
			publ.setPubl_dist(rs.getString(6));
			publ.setPubl_email(rs.getString(7));
			publ.setPubl_phone(rs.getString(8));
			list.add(publ);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}


public boolean delete_publisher(int delt_publ_id) {
boolean f = false;

try {

	String sql = "delete from publisher where publ_id=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, delt_publ_id);

	int i = ps.executeUpdate();

	if(i==1) {
		f=true;
	}

} catch (Exception e) {
	e.printStackTrace();
}

return f;
}



public boolean edit_publi(publisher_enti publ) {
	
	boolean f = false;
	
	try {
		
		String sql = "update publisher set publ_name=?, publ_address=?, publ_city=?, publ_taluka=?, publ_dist=?, publ_email=?, publ_phone=? where publ_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, publ.getPubl_name());
		ps.setString(2, publ.getPubl_address());
		ps.setString(3, publ.getPubl_city());
		ps.setString(4, publ.getPubl_taluka());
		ps.setString(5, publ.getPubl_dist());
		ps.setString(6, publ.getPubl_email());
		ps.setString(7, publ.getPubl_phone());
		ps.setInt(8, publ.getPubl_id());
		
		
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


	

