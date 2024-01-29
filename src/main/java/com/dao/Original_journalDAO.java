package com.dao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.entity.Original_book_enti;
import com.entity.Original_journal_enti;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class Original_journalDAO {
	private Connection conn;

	public Original_journalDAO(Connection conn) {
		super();
		this.conn=conn;
	}
	
	
	public boolean one_id_Original_journal(Original_journal_enti or_jour) {
		
		boolean f=false;
		String soop = null;
		
		try {
			
			String new_sql = "select or_jr_id from original_journal where or_jr_dept=? and or_jr_cat=?";
			PreparedStatement nps = conn.prepareStatement(new_sql);
			nps.setString(1, or_jour.getJournal_dept());
			nps.setString(2, or_jour.getJournal_catrgory());
			
			ResultSet nrs = nps.executeQuery();
			
			while(nrs.next()) {
				soop=nrs.getString(1);
				f=true;
			}
			
			if(soop==null) {
				or_jour.setJournal_id(or_jour.getJournal_dept()+or_jour.getJournal_catrgory()+1);
			}else {
				String asd = soop.substring(6);
				int inc = Integer.parseInt(asd);
				int increment_id = inc+1;
				String new_form_id = or_jour.getJournal_dept()+or_jour.getJournal_catrgory()+increment_id;
				or_jour.setJournal_id(new_form_id);
				
				System.out.println(new_form_id);
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
public boolean add_Original_journal(Original_journal_enti or_jour) {
		
		boolean f = false;
		
		try {
			
			String sql = "insert into original_journal(or_jr_id, or_jr_dept, or_jr_cat, or_jr_classif_no, or_jr_title, or_jr_sub_title,"
					+ "or_jr_subject, or_jr_edition, or_jr_auther_name, or_jr_publi_nm, or_jr_publi_yy, or_jr_vender_nm, or_jr_pages, or_jr_price, "
					+ "or_jr_rack, or_jr_language, or_jr_stock_status, or_jr_issue_status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, or_jour.getJournal_id());
			
			ps.setString(2, or_jour.getJournal_dept());
			ps.setString(3, or_jour.getJournal_catrgory());
			ps.setString(4, or_jour.getJournal_classif_no());
			ps.setString(5, or_jour.getJournal_title());
			ps.setString(6, or_jour.getJournal_sub_title());
			ps.setString(7, or_jour.getJournal_subject());
			ps.setString(8, or_jour.getJournal_edition());
			ps.setString(9, or_jour.getJournal_author());
			ps.setString(10, or_jour.getJournal_publisher());
			ps.setString(11, or_jour.getJournal_publi_year());
			ps.setString(12, or_jour.getJournal_vend_nm());
			ps.setString(13, or_jour.getJournal_pages());
			ps.setDouble(14, or_jour.getJournal_price());
			ps.setString(15, or_jour.getJournal_rack_no());
			ps.setString(16, or_jour.getJournal_language());
			ps.setString(17, "In Stock");
			ps.setString(18, "available");
			
			int rs = ps.executeUpdate();
			
			if(rs==1) {
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
}


	public boolean generate_journal_QR(Original_journal_enti or_jour) {
	
			boolean f = false;
			
			try {
				
				String content = or_jour.getJournal_id();
				String path = "G:\\Library Mgnt System\\final_library_mgnt\\QR Code\\Journals\\"+content+".jpg";
				
				File file = new File(path);
				
			BitMatrix bitmatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300);
			int maxwidth = bitmatrix.getWidth();
			
			BufferedImage buff = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
			buff.createGraphics();
			
			Graphics2D g2d = (Graphics2D) buff.getGraphics();
			
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, maxwidth, maxwidth);
			g2d.setColor(Color.BLACK);
			
			for(int i = 0; i< maxwidth; i++) {
				for(int j = 0; j<maxwidth; j++) {
					if(bitmatrix.get(i, j)) {
						g2d.fillRect(i, j, 1, 1);
					}
				}
			}
				
			String slicing_dept = content.substring(0,4);
			
			String sql = "select dept_name from department where dept_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, slicing_dept);
			
			ResultSet rs = ps.executeQuery();
			String var = null;
			
			while(rs.next()) {
				var = rs.getString(1);
			}
			
			g2d.setFont(g2d.getFont().deriveFont(30f));
			g2d.drawString(var, 115, 30);
			
			g2d.setFont(g2d.getFont().deriveFont(30f));
			g2d.drawString(or_jour.getJournal_rack_no(), 122, 285);
			
			ImageIO.write(buff, "jpg", file);
			f=true;
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
	}
	
	
	
	
	
	
	
	


public List<Original_journal_enti> getall_or_journal(){
	
	List<Original_journal_enti> list = new ArrayList<Original_journal_enti>();
	Original_journal_enti or_jr = null;
	
	try {
		
		String sql = "select * from original_journal where or_jr_stock_status=? order by or_jr_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			or_jr = new Original_journal_enti();
			or_jr.setJournal_id(rs.getString(1));
			
			or_jr.setJournal_classif_no(rs.getString(5));
			or_jr.setJournal_title(rs.getString(6));
			or_jr.setJournal_sub_title(rs.getString(7));
			or_jr.setJournal_subject(rs.getString(8));
			or_jr.setJournal_edition(rs.getString(9));
			or_jr.setJournal_author(rs.getString(10));
			
			or_jr.setJournal_publisher(rs.getString(11));
			or_jr.setJournal_publi_year(rs.getString(12));
			or_jr.setJournal_vend_nm(rs.getString(13));
			or_jr.setJournal_pages(rs.getString(14));
			or_jr.setJournal_price(rs.getDouble(15));
			or_jr.setJournal_rack_no(rs.getString(16));
			or_jr.setJournal_language(rs.getString(17));
			
			
			
			String store_dept = rs.getString(3);
			String store_publ = rs.getString(11);
			
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
			
			or_jr.setJournal_dept(dept);
			
			
			
			
			
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
			
			or_jr.setSearch_publisher(publ);
			
			
			
			
			
				// *******
			
			String store_cat = rs.getString(4);
			
			String sql_cat = "select cat_name from category where cat_id=?";
			PreparedStatement cps = conn.prepareStatement(sql_cat);						// 	Line No 238 to 253 code for 
			cps.setString(1, store_cat);												// 	conversion category id to 
																						//	category Name
			ResultSet nrs_cat = cps.executeQuery();
			String cat =null;
			
			while(nrs_cat.next()) {
				
				cat = nrs_cat.getString(1);
			}
					
			
			or_jr.setJournal_catrgory(cat);
				
		
			list.add(or_jr);
			
		}
				
			
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}







public List<Original_journal_enti> get_available_or_journal(){
	
	List<Original_journal_enti> list = new ArrayList<Original_journal_enti>();
	Original_journal_enti or_jr = null;
	
	try {
		
		String sql = "select * from original_journal where or_jr_stock_status=? and or_jr_issue_status=? order by or_jr_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		ps.setString(2, "available");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			or_jr = new Original_journal_enti();
			or_jr.setJournal_id(rs.getString(1));
			
			or_jr.setJournal_classif_no(rs.getString(5));
			or_jr.setJournal_title(rs.getString(6));
			or_jr.setJournal_sub_title(rs.getString(7));
			or_jr.setJournal_subject(rs.getString(8));
			or_jr.setJournal_edition(rs.getString(9));
			or_jr.setJournal_author(rs.getString(10));
			
			or_jr.setJournal_publisher(rs.getString(11));
			or_jr.setJournal_publi_year(rs.getString(12));
			or_jr.setJournal_vend_nm(rs.getString(13));
			or_jr.setJournal_pages(rs.getString(14));
			or_jr.setJournal_price(rs.getDouble(15));
			or_jr.setJournal_rack_no(rs.getString(16));
			or_jr.setJournal_language(rs.getString(17));
			
			
			
			String store_dept = rs.getString(3);
			String store_publ = rs.getString(11);
			
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
			
			or_jr.setJournal_dept(dept);
			
			
			
			
			
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
			
			or_jr.setSearch_publisher(publ);
			
			
			
			
			
				// *******
			
			String store_cat = rs.getString(4);
			
			String sql_cat = "select cat_name from category where cat_id=?";
			PreparedStatement cps = conn.prepareStatement(sql_cat);						// 	Line No 238 to 253 code for 
			cps.setString(1, store_cat);												// 	conversion category id to 
																						//	category Name
			ResultSet nrs_cat = cps.executeQuery();
			String cat =null;
			
			while(nrs_cat.next()) {
				
				cat = nrs_cat.getString(1);
			}
					
			
			or_jr.setJournal_catrgory(cat);
				
		
			list.add(or_jr);
			
		}
				
			
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}










	public List<Original_journal_enti> get_search_or_journal(String search_table, String search_content){
	
		List<Original_journal_enti> list = new ArrayList<Original_journal_enti>();
		Original_journal_enti or_jr = null;
	
	
		try {
			
			String convert_dept = null;
			
			Original_journal_enti jr_enti = new Original_journal_enti();
			
			jr_enti.setSearch_journal_table(search_table);
			jr_enti.setSearch_journal_content(search_content);
			
			String qwe = "or_jr_dept";
			
			
			
			if(jr_enti.getSearch_journal_table().equals(qwe)) {
				
				
				String sql1 = "select * from department where dept_name=?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);	
				ps1.setString(1, search_content);
				
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
					convert_dept = rs1.getString(1);
				}
				search_content = convert_dept;
				
				
			}
			
			
			if(jr_enti.getSearch_journal_table().equals("or_jr_title") || jr_enti.getSearch_journal_table().equals("or_jr_auther_name")) {
				
				String sql = "select * from original_journal where "+search_table+" LIKE '%"+search_content +"%' and or_jr_stock_status=?";
				PreparedStatement ps = conn.prepareStatement(sql);	
				
				ps.setString(1, "In stock");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {

					or_jr = new Original_journal_enti();
					or_jr.setJournal_id(rs.getString(1));
					
					or_jr.setJournal_classif_no(rs.getString(5));
					or_jr.setJournal_title(rs.getString(6));
					or_jr.setJournal_sub_title(rs.getString(7));
					or_jr.setJournal_subject(rs.getString(8));
					or_jr.setJournal_edition(rs.getString(9));
					or_jr.setJournal_author(rs.getString(10));
					
					or_jr.setJournal_publisher(rs.getString(11));
					or_jr.setJournal_publi_year(rs.getString(12));
					or_jr.setJournal_vend_nm(rs.getString(13));
					or_jr.setJournal_pages(rs.getString(14));
					or_jr.setJournal_price(rs.getDouble(15));
					or_jr.setJournal_rack_no(rs.getString(16));
					or_jr.setJournal_language(rs.getString(17));
					
					
					
					String store_dept = rs.getString(3);
					String store_publ = rs.getString(11);
					
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
					
					or_jr.setJournal_dept(dept);
					
					
					
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
					
					or_jr.setJournal_publisher(publ);
							
					
					
						// *******
					
					String store_cat = rs.getString(4);
					
					String sql_cat = "select cat_name from category where cat_id=?";
					PreparedStatement cps = conn.prepareStatement(sql_cat);						// 	Line No 238 to 253 code for 
					cps.setString(1, store_cat);												// 	conversion category id to 
																								//	category Name
					ResultSet nrs_cat = cps.executeQuery();
					String cat =null;
					
					while(nrs_cat.next()) {
						
						cat = nrs_cat.getString(1);
					}
							
					
					or_jr.setJournal_catrgory(cat);
						
				
					list.add(or_jr);		
					
				}				
			}else {
				String sql = "select * from original_journal where "+search_table+"=? and or_jr_stock_status=?";
				PreparedStatement ps = conn.prepareStatement(sql);	
				ps.setString(1, search_content);
				ps.setString(2, "In stock");
				
		ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {

					or_jr = new Original_journal_enti();
					or_jr.setJournal_id(rs.getString(1));
					
					or_jr.setJournal_classif_no(rs.getString(5));
					or_jr.setJournal_title(rs.getString(6));
					or_jr.setJournal_sub_title(rs.getString(7));
					or_jr.setJournal_subject(rs.getString(8));
					or_jr.setJournal_edition(rs.getString(9));
					or_jr.setJournal_author(rs.getString(10));
					
					or_jr.setJournal_publisher(rs.getString(11));
					or_jr.setJournal_publi_year(rs.getString(12));
					or_jr.setJournal_vend_nm(rs.getString(13));
					or_jr.setJournal_pages(rs.getString(14));
					or_jr.setJournal_price(rs.getDouble(15));
					or_jr.setJournal_rack_no(rs.getString(16));
					or_jr.setJournal_language(rs.getString(17));
					
					
					
					String store_dept = rs.getString(3);
					String store_publ = rs.getString(11);
					
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
					
					or_jr.setJournal_dept(dept);
					
					
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
					
					or_jr.setSearch_publisher(publ);
					
					
					
					
						// *******
					
					String store_cat = rs.getString(4);
					
					String sql_cat = "select cat_name from category where cat_id=?";
					PreparedStatement cps = conn.prepareStatement(sql_cat);						// 	Line No 238 to 253 code for 
					cps.setString(1, store_cat);												// 	conversion category id to 
																								//	category Name
					ResultSet nrs_cat = cps.executeQuery();
					String cat =null;
					
					while(nrs_cat.next()) {
						
						cat = nrs_cat.getString(1);
					}
					or_jr.setJournal_catrgory(cat);
					list.add(or_jr);
				}				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
				


	public boolean Original_journal_edit(Original_journal_enti or_jour) {
		
		boolean f=false;
		
		
		try {
			
			String sql = "update original_journal set or_jr_entry_date=CURRENT_TIMESTAMP, or_jr_classif_no=?, or_jr_title=?, or_jr_sub_title=?, "
					+ "or_jr_subject=?, or_jr_edition=?, or_jr_auther_name=?, or_jr_publi_nm=?, or_jr_publi_yy=?, or_jr_vender_nm=?, or_jr_pages=?,"
					+ " or_jr_price=?, or_jr_rack=?, or_jr_language=? where or_jr_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
		
			ps.setString(1, or_jour.getJournal_classif_no());
			ps.setString(2, or_jour.getJournal_title());
			ps.setString(3, or_jour.getJournal_sub_title());
			ps.setString(4, or_jour.getJournal_subject());
			ps.setString(5, or_jour.getJournal_edition());
			ps.setString(6, or_jour.getJournal_author());
			ps.setString(7, or_jour.getJournal_publisher());
			ps.setString(8, or_jour.getJournal_publi_year());
			ps.setString(9, or_jour.getJournal_vend_nm());
			ps.setString(10, or_jour.getJournal_pages());
			ps.setDouble(11, or_jour.getJournal_price());
			ps.setString(12, or_jour.getJournal_rack_no());
			ps.setString(13, or_jour.getJournal_language());
			
			
			ps.setString(14, or_jour.getJournal_id());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	
	

	public boolean delete_original_journal(String or_jr) {
		
			boolean f = false;
		
			try {
			
				String sql = "delete from original_journal where or_jr_id=?";
			
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, or_jr);
			
				int i = ps.executeUpdate();
			
				if(i==1) {
					f = true;
				}
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
			return f;
	}
	
	
	
	public boolean delete_original_journal_array(ArrayList<String> finala_arr) {
		
		boolean f = false;
	
		try {
				
			String sql = "delete from original_journal where or_jr_id=?";
			
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

	
	
public boolean shift_dead_stock_journal(ArrayList<String> finala_arr, String reason) {
		
		boolean f = false;
		Original_journal_enti or_jr = new Original_journal_enti();
		try {
			
			String sql = "update original_journal set or_jr_stock_status=? where or_jr_id=?";
	
			int leng = finala_arr.size();
			 
			
			for(int j = 0; j<leng; j++) {
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, "dead stock");
				ps.setString(2, finala_arr.get(j));
				
				int i = ps.executeUpdate();
				
				
			
				
				// ******** Shift Books from book table to dead Stock ***********
				
				
				String sql3 = "select * from original_journal where or_jr_id=?";
				PreparedStatement ps2 = conn.prepareStatement(sql3);
				ps2.setString(1, finala_arr.get(j));
				ResultSet rs = ps2.executeQuery();
				while(rs.next()) {
					
					or_jr.setJournal_id(rs.getString(1));
					or_jr.setJournal_dept(rs.getString(3));;
					or_jr.setJournal_catrgory(rs.getString(4));
					
					or_jr.setJournal_classif_no(rs.getString(5));
					or_jr.setJournal_title(rs.getString(6));
					or_jr.setJournal_sub_title(rs.getString(7));
					or_jr.setJournal_subject(rs.getString(8));
					or_jr.setJournal_edition(rs.getString(9));
					or_jr.setJournal_author(rs.getString(10));
					or_jr.setJournal_publisher(rs.getString(11));
					or_jr.setJournal_publi_year(rs.getString(12));
					or_jr.setJournal_vend_nm(rs.getString(13));
					or_jr.setJournal_pages(rs.getString(14));
					or_jr.setJournal_price(rs.getDouble(15));
					or_jr.setJournal_rack_no(rs.getString(16));
					or_jr.setJournal_language(rs.getString(17));
					
				}
				
				
				String sql2 = "insert into stock_dead_stock(b_dead_id, b_dead_dept, b_dead_cat, b_dead_classino, b_dead_title,"
						+ " b_dead_sub_title, b_dead_subject, b_dead_edition, b_dead_author, b_dead_publi_nm, b_dead_publi_yy, b_dead_vend_nm, "
						+ "b_dead_book_pages, b_dead_book_price, b_dead_rackno, b_dead_lang, b_dead_reason, b_dead_stock_cat) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				
				PreparedStatement ps3 = conn.prepareStatement(sql2);
				ps3.setString(1, or_jr.getJournal_id());
				
				
				
				
				ps3.setString(2, or_jr.getJournal_dept());
				ps3.setString(3, or_jr.getJournal_catrgory());
				ps3.setString(4, or_jr.getJournal_classif_no());
				ps3.setString(5, or_jr.getJournal_title());
				ps3.setString(6, or_jr.getJournal_sub_title());
				ps3.setString(7, or_jr.getJournal_subject());
				ps3.setString(8, or_jr.getJournal_edition());
				ps3.setString(9, or_jr.getJournal_author());
				ps3.setString(10, or_jr.getJournal_publisher());
				ps3.setString(11, or_jr.getJournal_publi_year());
				ps3.setString(12, or_jr.getJournal_vend_nm());
				ps3.setString(13, or_jr.getJournal_pages());
				ps3.setDouble(14, or_jr.getJournal_price());
				ps3.setString(15, or_jr.getJournal_rack_no());
				ps3.setString(16, or_jr.getJournal_language());
				ps3.setString(17, reason);
				ps3.setString(18, "journal");
				
				
				int ii = ps3.executeUpdate();
				
				if(ii==1) {
					f=true;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	
	
	
	
	
	
}
