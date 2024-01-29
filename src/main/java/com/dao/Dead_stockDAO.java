package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Dead_stock_enti;
import com.entity.Magazine_enti;

public class Dead_stockDAO {
	
	private Connection conn;

	public Dead_stockDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	

public List<Dead_stock_enti> getall_or_dead_stock(){
	
	List<Dead_stock_enti> list = new ArrayList<Dead_stock_enti>();
	Dead_stock_enti or_dead = null;
	
	try {
		
		String sql = "select * from stock_dead_stock order by b_dead_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_dead = new Dead_stock_enti();
			
			or_dead.setDead_id(rs.getString(1));
			
			or_dead.setDead_cat(rs.getString(3));
			or_dead.setDead_classi_no(rs.getString(4));
			or_dead.setDead_title(rs.getString(5));
			or_dead.setDead_sub_title(rs.getString(6));
			or_dead.setDead_subject(rs.getString(7));
			or_dead.setDead_edition(rs.getString(8));
			or_dead.setDead_author(rs.getString(9));
		
			
			or_dead.setDead_publi_yy(rs.getString(11));
			or_dead.setDead_vend_name(rs.getString(12));
			or_dead.setDead_pages(rs.getString(13));
			or_dead.setDead_price(rs.getDouble(14));
			or_dead.setDead_rack(rs.getString(15));
			or_dead.setDead_lang(rs.getString(16));
			or_dead.setDead_reason(rs.getString(17));
			or_dead.setDead_stock_category(rs.getString(18));
			or_dead.setDead_date(rs.getString(19));
			
			
		
			
			
				// ******** 
			String store_dept = rs.getString(2);
			String store_publ = rs.getString(10); 
			
			
			String sql_dept = "select dept_name from department where dept_id=?";
			PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
			nps.setString(1, store_dept);												// 	conversion department id to 
																						// 	department Name
			
			ResultSet nrs = nps.executeQuery();
			String dept =null;
			
			while(nrs.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    dept = nrs.getString(1);
				
			}
			
			or_dead.setDead_dept(dept);
			
			
			//***************
			
			String sql_publ = "select publ_name from publisher where publ_id=?";
			PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
			np.setString(1, store_publ);												// 	conversion Publisher id to 
																						// 	publisher Name
			
			ResultSet nr = np.executeQuery();
			String publ =null;
			
			while(nr.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    publ = nr.getString(1);
				
			}
			
			or_dead.setDead_publisher_name(publ);
			
			
			
			
			
			
			
				
			list.add(or_dead);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}




public List<Dead_stock_enti> get_book_dead_stock(){
	
	List<Dead_stock_enti> list = new ArrayList<Dead_stock_enti>();
	Dead_stock_enti or_dead = null;
	
	try {
		
		String sql = "select * from stock_dead_stock where b_dead_stock_cat=? order by b_dead_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "book");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_dead = new Dead_stock_enti();
			
			or_dead.setDead_id(rs.getString(1));
			
			or_dead.setDead_cat(rs.getString(3));
			or_dead.setDead_classi_no(rs.getString(4));
			or_dead.setDead_title(rs.getString(5));
			or_dead.setDead_sub_title(rs.getString(6));
			or_dead.setDead_subject(rs.getString(7));
			or_dead.setDead_edition(rs.getString(8));
			or_dead.setDead_author(rs.getString(9));
		
			
			or_dead.setDead_publi_yy(rs.getString(11));
			or_dead.setDead_vend_name(rs.getString(12));
			or_dead.setDead_pages(rs.getString(13));
			or_dead.setDead_price(rs.getDouble(14));
			or_dead.setDead_rack(rs.getString(15));
			or_dead.setDead_lang(rs.getString(16));
			or_dead.setDead_reason(rs.getString(17));
			or_dead.setDead_stock_category(rs.getString(18));
			or_dead.setDead_date(rs.getString(19));
			
			
		
			
			
				// ******** 
			String store_dept = rs.getString(2);
			String store_publ = rs.getString(10); 
			
			
			String sql_dept = "select dept_name from department where dept_id=?";
			PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
			nps.setString(1, store_dept);												// 	conversion department id to 
																						// 	department Name
			
			ResultSet nrs = nps.executeQuery();
			String dept =null;
			
			while(nrs.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    dept = nrs.getString(1);
				
			}
			
			or_dead.setDead_dept(dept);
			
			
			//***************
			
			String sql_publ = "select publ_name from publisher where publ_id=?";
			PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
			np.setString(1, store_publ);												// 	conversion Publisher id to 
																						// 	publisher Name
			
			ResultSet nr = np.executeQuery();
			String publ =null;
			
			while(nr.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    publ = nr.getString(1);
				
			}
			
			or_dead.setDead_publisher_name(publ);
			
			
			
			
			
			
			
				
			list.add(or_dead);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}






public List<Dead_stock_enti> get_journal_dead_stock(){
	
	List<Dead_stock_enti> list = new ArrayList<Dead_stock_enti>();
	Dead_stock_enti or_dead = null;
	
	try {
		
		String sql = "select * from stock_dead_stock where b_dead_stock_cat=? order by b_dead_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "journal");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_dead = new Dead_stock_enti();
			
			or_dead.setDead_id(rs.getString(1));
			
			or_dead.setDead_cat(rs.getString(3));
			or_dead.setDead_classi_no(rs.getString(4));
			or_dead.setDead_title(rs.getString(5));
			or_dead.setDead_sub_title(rs.getString(6));
			or_dead.setDead_subject(rs.getString(7));
			or_dead.setDead_edition(rs.getString(8));
			or_dead.setDead_author(rs.getString(9));
		
			
			or_dead.setDead_publi_yy(rs.getString(11));
			or_dead.setDead_vend_name(rs.getString(12));
			or_dead.setDead_pages(rs.getString(13));
			or_dead.setDead_price(rs.getDouble(14));
			or_dead.setDead_rack(rs.getString(15));
			or_dead.setDead_lang(rs.getString(16));
			or_dead.setDead_reason(rs.getString(17));
			or_dead.setDead_stock_category(rs.getString(18));
			or_dead.setDead_date(rs.getString(19));
			
			
		
			
			
				// ******** 
			String store_dept = rs.getString(2);
			String store_publ = rs.getString(10); 
			
			
			String sql_dept = "select dept_name from department where dept_id=?";
			PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
			nps.setString(1, store_dept);												// 	conversion department id to 
																						// 	department Name
			
			ResultSet nrs = nps.executeQuery();
			String dept =null;
			
			while(nrs.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    dept = nrs.getString(1);
				
			}
			
			or_dead.setDead_dept(dept);
			
			
			//***************
			
			String sql_publ = "select publ_name from publisher where publ_id=?";
			PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
			np.setString(1, store_publ);												// 	conversion Publisher id to 
																						// 	publisher Name
			
			ResultSet nr = np.executeQuery();
			String publ =null;
			
			while(nr.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    publ = nr.getString(1);
				
			}
			
			or_dead.setDead_publisher_name(publ);
			
			
			
			
			
			
			
				
			list.add(or_dead);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}







public List<Dead_stock_enti> get_magazine_dead_stock(){
	
	List<Dead_stock_enti> list = new ArrayList<Dead_stock_enti>();
	Dead_stock_enti or_dead = null;
	
	try {
		
		String sql = "select * from stock_dead_stock where b_dead_stock_cat=? order by b_dead_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "Magazine");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_dead = new Dead_stock_enti();
			
			or_dead.setDead_id(rs.getString(1));
			
			or_dead.setDead_cat(rs.getString(3));
			or_dead.setDead_classi_no(rs.getString(4));
			or_dead.setDead_title(rs.getString(5));
			or_dead.setDead_sub_title(rs.getString(6));
			or_dead.setDead_subject(rs.getString(7));
			or_dead.setDead_edition(rs.getString(8));
			or_dead.setDead_author(rs.getString(9));
		
			
			or_dead.setDead_publi_yy(rs.getString(11));
			or_dead.setDead_vend_name(rs.getString(12));
			or_dead.setDead_pages(rs.getString(13));
			or_dead.setDead_price(rs.getDouble(14));
			or_dead.setDead_rack(rs.getString(15));
			or_dead.setDead_lang(rs.getString(16));
			or_dead.setDead_reason(rs.getString(17));
			or_dead.setDead_stock_category(rs.getString(18));
			or_dead.setDead_date(rs.getString(19));
			
			
		
			
			
				// ******** 
			String store_dept = rs.getString(2);
			String store_publ = rs.getString(10); 
			
			
			String sql_dept = "select dept_name from department where dept_id=?";
			PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
			nps.setString(1, store_dept);												// 	conversion department id to 
																						// 	department Name
			
			ResultSet nrs = nps.executeQuery();
			String dept =null;
			
			while(nrs.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    dept = nrs.getString(1);
				
			}
			
			or_dead.setDead_dept(dept);
			
			
			//***************
			
			String sql_publ = "select publ_name from publisher where publ_id=?";
			PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
			np.setString(1, store_publ);												// 	conversion Publisher id to 
																						// 	publisher Name
			
			ResultSet nr = np.executeQuery();
			String publ =null;
			
			while(nr.next()) {
				//or_book.setBook_dept(nrs.getString(0));
			    publ = nr.getString(1);
				
			}
			
			or_dead.setDead_publisher_name(publ);
			
			
			
			
			
			
			
				
			list.add(or_dead);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}














public List<Dead_stock_enti> get_search_dead_stock(String profile, String content){
	
	List<Dead_stock_enti> list = new ArrayList<Dead_stock_enti>();
	Dead_stock_enti or_dead = null;

	or_dead = new Dead_stock_enti();
	
	String dept_temp = "b_dead_dept";
	String author_temp = "b_dead_author";
	String title_temp = "b_dead_title";
	
	String convert_dept = null;
	
	if(profile.equals(dept_temp)) {
		
		 
			try {
			
				String sql1 = "select * from department where dept_name=?";
					PreparedStatement ps1 = conn.prepareStatement(sql1);	
					ps1.setString(1, content);
				
					ResultSet rs1 = ps1.executeQuery();
				
					while(rs1.next()) {
						convert_dept = rs1.getString(1);
					}
					content = convert_dept;
			 
			 
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 		}	
	}
	
	
	
	if(profile.equals(title_temp) || profile.equals(author_temp)) {
		
			try {
			
				String sql = "select * from stock_dead_stock where "+profile+" LIKE '%"+content +"%'";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					

					or_dead.setDead_id(rs.getString(1));
					
					or_dead.setDead_cat(rs.getString(3));
					or_dead.setDead_classi_no(rs.getString(4));
					or_dead.setDead_title(rs.getString(5));
					or_dead.setDead_sub_title(rs.getString(6));
					or_dead.setDead_subject(rs.getString(7));
					or_dead.setDead_edition(rs.getString(8));
					or_dead.setDead_author(rs.getString(9));
				
					
					or_dead.setDead_publi_yy(rs.getString(11));
					or_dead.setDead_vend_name(rs.getString(12));
					or_dead.setDead_pages(rs.getString(13));
					or_dead.setDead_price(rs.getDouble(14));
					or_dead.setDead_rack(rs.getString(15));
					or_dead.setDead_lang(rs.getString(16));
					or_dead.setDead_reason(rs.getString(17));
					or_dead.setDead_stock_category(rs.getString(18));
					or_dead.setDead_date(rs.getString(19));
					
					
				
					
					
						// ******** 
					String store_dept = rs.getString(2);
					String store_publ = rs.getString(10); 
				
					
					
					
					
					
					
					
					String sql_dept = "select dept_name from department where dept_id=?";
					PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
					nps.setString(1, store_dept);												// 	conversion department id to 
																								// 	department Name
					
					ResultSet nrs = nps.executeQuery();
					String dept =null;
					
					while(nrs.next()) {
						//or_book.setBook_dept(nrs.getString(0));
					    dept = nrs.getString(1);
						
					}
					
					or_dead.setDead_dept(dept);	
						

					//***************
					
					String sql_publ = "select publ_name from publisher where publ_id=?";
					PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
					np.setString(1, store_publ);												// 	conversion Publisher id to 
																								// 	publisher Name
					
					ResultSet nr = np.executeQuery();
					String publ =null;
					
					while(nr.next()) {
						//or_book.setBook_dept(nrs.getString(0));
					    publ = nr.getString(1);
						
					}
					
					or_dead.setDead_publisher_name(publ);		
					
					list.add(or_dead);
			
					
				}				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		}else {
			
			try {
				
				String sql = "select * from stock_dead_stock where "+profile+"=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, content);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					


					or_dead.setDead_id(rs.getString(1));
					
					or_dead.setDead_cat(rs.getString(3));
					or_dead.setDead_classi_no(rs.getString(4));
					or_dead.setDead_title(rs.getString(5));
					or_dead.setDead_sub_title(rs.getString(6));
					or_dead.setDead_subject(rs.getString(7));
					or_dead.setDead_edition(rs.getString(8));
					or_dead.setDead_author(rs.getString(9));
				
					
					or_dead.setDead_publi_yy(rs.getString(11));
					or_dead.setDead_vend_name(rs.getString(12));
					or_dead.setDead_pages(rs.getString(13));
					or_dead.setDead_price(rs.getDouble(14));
					or_dead.setDead_rack(rs.getString(15));
					or_dead.setDead_lang(rs.getString(16));
					or_dead.setDead_reason(rs.getString(17));
					or_dead.setDead_stock_category(rs.getString(18));
					or_dead.setDead_date(rs.getString(19));
					
					
				
					
					
						// ******** 
					String store_dept = rs.getString(2);
					String store_publ = rs.getString(10); 
				
					String sql_dept = "select dept_name from department where dept_id=?";
					PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
					nps.setString(1, store_dept);												// 	conversion department id to 
																								// 	department Name
					
					ResultSet nrs = nps.executeQuery();
					String dept =null;
					
					while(nrs.next()) {
						//or_book.setBook_dept(nrs.getString(0));
					    dept = nrs.getString(1);
						
					}
					
					or_dead.setDead_dept(dept);	
						

					//***************
					
					String sql_publ = "select publ_name from publisher where publ_id=?";
					PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
					np.setString(1, store_publ);												// 	conversion Publisher id to 
																								// 	publisher Name
					
					ResultSet nr = np.executeQuery();
					String publ =null;
					
					while(nr.next()) {
						//or_book.setBook_dept(nrs.getString(0));
					    publ = nr.getString(1);
						
					}
					
					or_dead.setDead_publisher_name(publ);		
					
					list.add(or_dead);
					
				}				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			
		}
	
	
	
	return list;
	
}






	public boolean delete_dead_stock_array(ArrayList<String> finala_arr) {
		
		boolean f = false;
	
		try {
				
			String sql = "delete from stock_dead_stock where b_dead_id=?";
			
			int leng = finala_arr.size();
			 
			
			for(int j = 0; j<leng; j++) {
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				ps.setString(1, finala_arr.get(j));
				
				int i = ps.executeUpdate();
				
				if(i==1) {
					f=true;
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	
	}
	










	

}
