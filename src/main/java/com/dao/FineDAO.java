package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Fine_enti;
import com.entity.Stock_transection_student_enti;

public class FineDAO {

	private Connection conn;

	public FineDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	
	
	
	public boolean fine_register(Fine_enti f_enti) {
		
		boolean f = false;
		
		try {
			
			String sql = "insert into fine (f_tran_id, f_stud_name, f_book_name, f_stud_id, f_book_id, f_curr_date, f_late_days, f_amout, f_stud_dept) "
					+ "values(?,?,?,?,?, DATE_ADD(NOW(), INTERVAL 0 DAY) ,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, f_enti.getFine_tran_id());
			ps.setString(2, f_enti.getFine_stud_name());
			ps.setString(3, f_enti.getFine_book_name());
			ps.setString(4, f_enti.getFine_stud_id());
			ps.setString(5, f_enti.getFine_book_id());
			ps.setString(6, f_enti.getFine_late_days());
			ps.setDouble(7, f_enti.getFine_amount());
			ps.setString(8, f_enti.getStud_dept());
			
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				int j =0;
				
				
				if(f_enti.getProfile().equals("book")) {
					
					String sql_book = "update original_book set or_b_issue_status=? where or_b_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "available");
					pps2.setString(2, f_enti.getFine_book_id());

					j = pps2.executeUpdate();
					
					
				}else if(f_enti.getProfile().equals("journal")) {
					
					String sql_book = "update original_journal set or_jr_issue_status=? where or_jr_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "available");
					pps2.setString(2, f_enti.getFine_book_id());

					j = pps2.executeUpdate();
				
				
				
				
				}else if(f_enti.getProfile().equals("magazine")) {
					
					String sql_book = "update original_magazin set or_mag_issu_status=? where or_mag_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "available");
					pps2.setString(2, f_enti.getFine_book_id());

					j = pps2.executeUpdate();
				}
				
			
				
				
				
				if(j==1) {
					

					 String sql2 = "update stock_transc_stud set tr_actual_return_date=DATE_ADD(NOW(), INTERVAL 0 DAY), tr_late_day=?, tr_status=? where transc_id=? ";
					  
					  PreparedStatement pps = conn.prepareStatement(sql2); 
					  
					
					  pps.setString(1, f_enti.getFine_late_days());
					  pps.setString(2,"returned");
					  pps.setString(3, f_enti.getFine_tran_id());
					  
					  int p = pps.executeUpdate();
					  
					  if(p==1) {
					  
						  f = true;
					  
					  }
					
					
					
				}
				
				

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	
	
	
	
	
	
	
	
	
	public List<Fine_enti> getall_fine_details(){
		
		List<Fine_enti> list = new ArrayList<Fine_enti>();
		Fine_enti f_enti = null;
	
		try {
		
			
			String sql = "select * from fine order by f_id asc";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				f_enti = new Fine_enti();
				
				f_enti.setFine_stud_name(rs.getString(3));
				f_enti.setFine_book_name(rs.getString(4));
				f_enti.setFine_issue_date(rs.getString(7));	
				f_enti.setFine_amount(rs.getDouble(9));
				f_enti.setStud_dept(rs.getString(10));
				
				
					String sql2 = "select sum(f_amout) from fine";
					PreparedStatement pps = conn.prepareStatement(sql2);
					ResultSet rrs = pps.executeQuery();
					while(rrs.next()) {
						f_enti.setTotal_fine(rrs.getDouble(1));
					}
					
				list.add(f_enti);
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	public List<Fine_enti> get_search_fine_details( String profile, String content, String from_date, String to_date){
		
		List<Fine_enti> list = new ArrayList<Fine_enti>();
		Fine_enti f_enti = null;
	
		try {
			
			
			if(from_date=="" && to_date=="") {
				
				if(profile.equals("f_stud_name") || profile.equals("f_book_name")) {
					
					String sql = "select * from fine where "+profile+" LIKE '%"+content+"%' ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+" LIKE '%"+content+"%' ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
					
				}else {
					String sql = "select * from fine where "+profile+"=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, content);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+"=?";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, content);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
				}
				
				
			}else if(content=="") {
				
				if(from_date!="" && to_date!="") {
					String sql = "select * from fine where f_curr_date BETWEEN ? and ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, from_date);
					ps.setString(2, to_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where f_curr_date BETWEEN ? and ?";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, from_date);
							pps.setString(2, to_date);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
					
				}else if(to_date!="") {
					
					String sql = "select * from fine where f_curr_date <= ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, to_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where f_curr_date <= ?";
							PreparedStatement pps = conn.prepareStatement(sql2);
							
							pps.setString(1, to_date);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
					
				}else if(from_date!="") {
					
					String sql = "select * from fine where f_curr_date >= ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, from_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where f_curr_date >= ?";
							PreparedStatement pps = conn.prepareStatement(sql2);
							
							pps.setString(1, from_date);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}		
				}
			
				
			}else if(content!="" && to_date!="" && from_date!="") {
				
				if(profile.equals("f_stud_name") || profile.equals("f_book_name")) {
					
					String sql = "select * from fine where "+profile+" LIKE '%"+content+"%' and f_curr_date BETWEEN ? and ? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, from_date);
					ps.setString(2, to_date);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+" LIKE '%"+content+"%' and f_curr_date BETWEEN ? and ? ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, from_date);
							pps.setString(2, to_date);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
					
					
				}else {
					
					
					String sql = "select * from fine where "+profile+"=? and f_curr_date BETWEEN ? and ? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, content);
					ps.setString(2, from_date);
					ps.setString(3, to_date);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+"=? and f_curr_date BETWEEN ? and ? ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, content);
							pps.setString(2, from_date);
							pps.setString(3, to_date);
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}	
				}
					
				
			}else if(content!="" && from_date!="") {
				
				
				
				if(profile.equals("f_stud_name") || profile.equals("f_book_name")) {
					
					String sql = "select * from fine where "+profile+" LIKE '%"+content+"%' and f_curr_date >=? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, from_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+" LIKE '%"+content+"%' and f_curr_date >= ? ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, from_date);
							
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
					
					
				}else {
					
					
					String sql = "select * from fine where "+profile+"=? and f_curr_date >= ? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, content);
					ps.setString(2, from_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+"=? and f_curr_date >= ? ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, content);
							pps.setString(2, from_date);
							
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}	
				}
					
				
			}else if(content!="" && to_date!="") {
				
				
				
				if(profile.equals("f_stud_name") || profile.equals("f_book_name")) {
					
					String sql = "select * from fine where "+profile+" LIKE '%"+content+"%' and f_curr_date <=? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, to_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+" LIKE '%"+content+"%' and f_curr_date <= ? ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, to_date);
							
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}
					
					
				}else {
					
					
					String sql = "select * from fine where "+profile+"=? and f_curr_date <= ? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, content);
					ps.setString(2, to_date);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						f_enti = new Fine_enti();
						
						f_enti.setFine_stud_name(rs.getString(3));
						f_enti.setFine_book_name(rs.getString(4));
						f_enti.setFine_issue_date(rs.getString(7));	
						f_enti.setFine_amount(rs.getDouble(9));
						f_enti.setStud_dept(rs.getString(10));
						
						
							String sql2 = "select sum(f_amout) from fine where "+profile+"=? and f_curr_date <= ? ";
							PreparedStatement pps = conn.prepareStatement(sql2);
							pps.setString(1, content);
							pps.setString(2, to_date);
							
							ResultSet rrs = pps.executeQuery();
							while(rrs.next()) {
								f_enti.setTotal_fine(rrs.getDouble(1));
							}
							
						list.add(f_enti);	
					}	
				}
			}

				
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
}
