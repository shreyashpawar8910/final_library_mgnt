package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.book_category_enti;
import com.entity.library_department;


public class categoryDAO {

	private Connection conn;
	
	public categoryDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean add_category(book_category_enti bcat) {
		
		boolean f= false;
		
		try {
			
			String sql = "insert into category(cat_id, cat_name, cat_type) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bcat.getBcat_id());
			ps.setString(2, bcat.getBcat_name());
			ps.setString(3, bcat.getBcat_type());
			int rs = ps.executeUpdate();
			
			if(rs==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
		
	
public List<book_category_enti> getAllcategory(){								// Show List of category data list
		
		List<book_category_enti> list = new ArrayList<book_category_enti>();
		book_category_enti bcat = null;
		
		try {		
			String sql = "select * from category order by cat_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				bcat= new book_category_enti();
				bcat.setBcat_id(rs.getString(1));
				bcat.setBcat_name(rs.getString(2));	
				bcat.setBcat_type(rs.getString(3));
				list.add(bcat);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}
	
	
public book_category_enti getcategorytById(String bcat_id) {
	
	book_category_enti bcat = null;
	
	try {
		
		String sql = "select * from category where cat_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bcat_id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			bcat = new book_category_enti();
			bcat.setBcat_id(rs.getString(1));
			bcat.setBcat_name(rs.getString(2));
			bcat.setBcat_type(rs.getString(3));
			
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return bcat;
}

public boolean edit_category(book_category_enti category) {
	
	boolean f = false;
	
	try {
		
		String sql = "update category set cat_name=?,cat_type=? where cat_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, category.getBcat_name());
		ps.setString(2, category.getBcat_type());
		ps.setString(3, category.getBcat_id());
		
		int p = ps.executeUpdate();
		
		if(p==1) {
			f=true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return f;
}


	public boolean delete_category(String delt_cat_id) {
		boolean f = false;
	
		try {
	
			String sql = "delete from category where cat_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, delt_cat_id);
		
			int i = ps.executeUpdate();
		
			if(i==1) {
				f=true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return f;
	}	
	
	
	public boolean last_id_category(book_category_enti b_cat) {
		
		boolean f = false;
		try {
			
			String sql = "select cat_id from category order by cat_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			String soop = null;
			
			while(rs.next()) {
				soop = rs.getString(1);
			}
			
			if(soop==null) {
				b_cat.setBcat_id("11");
				f=true;
			}else {
				
				int temp_dept = Integer.parseInt(soop);
				temp_dept++;
				String final_id = String.valueOf(temp_dept);
				b_cat.setBcat_id(final_id);
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}



}
