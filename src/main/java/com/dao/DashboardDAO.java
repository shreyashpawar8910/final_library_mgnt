package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardDAO {
	private Connection conn;

	public DashboardDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	public long total_books() {
		
		long total_book=0;
		
		try {
			
			String sql = "select count(*) from original_book where or_b_stock_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return total_book;
	}
	
	
	public long issued_books() {
		
		long issued_book=0;
		
		try {
			
			String sql = "select count(*) from original_book where or_b_stock_status=? and or_b_issue_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			ps.setString(2, "unavailable");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issued_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return issued_book;
	}
	
	
	public long availabel_books() {
		
		long availabel_book=0;
		
		try {
			
			String sql = "select count(*) from original_book where or_b_stock_status=? and or_b_issue_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			ps.setString(2, "available");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				availabel_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return availabel_book;
	}
	
	
	//***********************
	//**** Journal *********
	//***********************
	//***********************
	
	
	
	
	
	public long total_journal() {
		
		long total_book=0;
		
		try {
			
			String sql = "select count(*) from original_journal where or_jr_stock_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return total_book;
	}
	
	
	public long issued_journal() {
		
		long issued_book=0;
		
		try {
			
			String sql = "select count(*) from original_journal where or_jr_stock_status=? and or_jr_issue_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			ps.setString(2, "unavailable");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issued_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return issued_book;
	}
	
	
	public long availabel_journal() {
		
		long availabel_book=0;
		
		try {
			
			String sql = "select count(*) from original_journal where or_jr_stock_status=? and or_jr_issue_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			ps.setString(2, "available");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				availabel_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return availabel_book;
	}
	
	
	
	
	

	//***********************
	//**** Magazine *********
	//***********************
	//***********************
	
	
	
	
	
	public long total_magazine() {
		
		long total_book=0;
		
		try {
			
			String sql = "select count(*) from original_magazin where or_mag_stock_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return total_book;
	}
	
	
	public long issued_magazine() {
		
		long issued_book=0;
		
		try {
			
			String sql = "select count(*) from original_magazin where or_mag_stock_status=? and or_mag_issu_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			ps.setString(2, "unavailable");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issued_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return issued_book;
	}
	
	
	public long availabel_magazine() {
		
		long availabel_book=0;
		
		try {
			
			String sql = "select count(*) from original_magazin where or_mag_stock_status=? and or_mag_issu_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "In Stock");
			ps.setString(2, "available");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				availabel_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return availabel_book;
	}
	
	
	
	

	//***********************
	//**** Magazine *********
	//***********************
	//***********************
	
	
	
	
	
	public long total_book_dead_stock() {
		
		long total_book=0;
		
		try {
			
			String sql = "select count(*) from stock_dead_stock where b_dead_stock_cat=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "book");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return total_book;
	}
	
	
	public long total_journal_dead_stock() {
		
		long issued_book=0;
		
		try {
			
			String sql = "select count(*) from stock_dead_stock where b_dead_stock_cat=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "journal");
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issued_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return issued_book;
	}
	
	
	public long total_magazine_dead_stock() {
		
		long availabel_book=0;
		
		try {
			
			String sql = "select count(*) from stock_dead_stock where b_dead_stock_cat=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Magazine");
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				availabel_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return availabel_book;
	}
	
	
	
	
	
	
	

	//***********************
	//**** Department *********
	//***********************
	//***********************
	
	
	
	
	
	public long total_department() {
		
		long total_book=0;
		
		try {
			
			String sql = "select count(*) from department";
			PreparedStatement ps = conn.prepareStatement(sql);
	
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return total_book;
	}
	
	
	//***********************
	//**** Students *********
	//***********************
	//***********************

	
	
	public long total_students() {
		
		long issued_book=0;
		
		try {
			
			String sql = "select count(*) from students";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issued_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return issued_book;
	}
	
	
	
	//***********************
	//**** Staff *********
	//***********************
	//***********************

	
	
	public long total_staff() {
		
		long availabel_book=0;
		
		try {
			
			String sql = "select count(*) from staff";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				availabel_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return availabel_book;
	}
	
	

	//***********************
	//**** Staff *********
	//***********************
	//***********************

	
	
	public long total_users() {
		
		long availabel_book=0;
		
		try {
			
			String sql = "select count(*) from users";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				availabel_book = rs.getLong(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return availabel_book;
	}
	
	
	
	
	
	
	
}
