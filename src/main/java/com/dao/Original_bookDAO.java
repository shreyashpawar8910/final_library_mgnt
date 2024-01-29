package com.dao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import com.entity.Magazine_enti;
import com.entity.Original_book_enti;
import com.entity.Original_journal_enti;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.BarcodeMatrix;

	public class Original_bookDAO {
	
	private Connection conn;

	public Original_bookDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	

	public boolean one_id_Original_book(Original_book_enti or_book) {
		
			boolean f= false;
			 String soop = null;
			try {
				
				
				String new_sql = "select or_b_id from original_book where or_b_department=? and or_b_category=? order by or_b_id asc";
				PreparedStatement nps = conn.prepareStatement(new_sql);
				nps.setString(1, or_book.getBook_dept());
				nps.setString(2, or_book.getBook_catrgory());
				
				ResultSet nrs = nps.executeQuery();
				
				while(nrs.next()) {
					soop=nrs.getString(1);
					
				}
				
				if(soop == null) {
					or_book.setBook_id(or_book.getBook_dept()+or_book.getBook_catrgory()+1);
					f=true;
				}else {
					
					String asd = soop.substring(6);
					int inc = Integer.parseInt(asd);
					int increment_id = inc+1;
					String new_form_id = or_book.getBook_dept()+or_book.getBook_catrgory()+increment_id;
					or_book.setBook_id(new_form_id);
					
					System.out.println(new_form_id);
					f=true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
	}
	
	
	public boolean add_Original_book(Original_book_enti or_book) {
		
		boolean f = false;
		
		try {
			
			
			String sql = "insert into original_book(or_b_id, or_b_department, or_b_category, or_b_classi_no,"
					+ " or_b_title, or_b_sub_title, or_b_subject, or_b_edition, or_b_author_nm, or_b_publi_nm, or_b_publi_year,"
					+ " or_b_vender_nm, or_b_book_pages, or_b_price, or_b_rack_no, or_b_language, or_b_stock_status, or_b_issue_status) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
					
			ps.setString(1, or_book.getBook_id());
			
			ps.setString(2, or_book.getBook_dept());
			ps.setString(3, or_book.getBook_catrgory());
			ps.setString(4, or_book.getBook_classif_no());
			ps.setString(5, or_book.getBook_title());
			ps.setString(6, or_book.getBook_sub_title());
			ps.setString(7, or_book.getBook_subject());
			ps.setString(8, or_book.getBook_edition());
			ps.setString(9, or_book.getBook_author());
			ps.setString(10, or_book.getBook_publisher());
			ps.setString(11, or_book.getBook_publi_year());
			ps.setString(12, or_book.getBook_vend_nm());
			ps.setString(13, or_book.getBook_pages());
			ps.setDouble(14, or_book.getBook_price());
			ps.setString(15, or_book.getBook_rack_no());
			ps.setString(16, or_book.getBook_language());
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
	
	
	
	public boolean generate_book_QR(Original_book_enti or_book) {
		
			boolean f = false;
		
			try {
				
				String content = null;
				
				content = or_book.getBook_id();
				String path_of_qr = "G:\\Library Mgnt System\\final_library_mgnt\\QR Code\\Books\\"+content+".jpg";
				
				File file = new File(path_of_qr);
				
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300);
				int maxwidth = bitMatrix.getWidth();
				
				//MatrixToImageWriter.writeToPath(bitMatrix,"jpg", Paths.get("G:\\Library Mgnt System\\QR Code\\"+content+".jpg"));
							
				BufferedImage buff = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
				buff.createGraphics();
				
				
				Graphics2D g2d = (Graphics2D) buff.getGraphics();
				
				g2d.setColor(Color.WHITE);
				g2d.fillRect(0, 0, maxwidth, maxwidth);
				g2d.setColor(Color.BLACK);
				
				for(int i = 0; i< maxwidth; i++) {
					for(int j = 0; j<maxwidth; j++) {
						if(bitMatrix.get(i, j)) {
							g2d.fillRect(i, j, 1, 1);
						}
					}
				}
				
				String slicing_dept = content.substring(0,4);
				System.out.println(slicing_dept);
				
				
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);
				nps.setString(1, slicing_dept);
				String soop2 = null;
				ResultSet nrs = nps.executeQuery();
				
				while(nrs.next()) {
					soop2=nrs.getString(1);
					
				}
				
				
				g2d.setFont(g2d.getFont().deriveFont(30f));
				g2d.drawString(soop2, 115, 30);
				
				g2d.setFont(g2d.getFont().deriveFont(30f));
				g2d.drawString(or_book.getBook_rack_no(), 122, 285);
				g2d.setColor(Color.GREEN);
				ImageIO.write(buff, "jpg", file);
				
				System.out.println("Qr code Generate Succesful");
				f=true;
						
			} catch (Exception e) {
				e.printStackTrace();
			}		
			
			return f;
	}
	
	
	

public List<Original_book_enti> getall_or_books(){
	
	List<Original_book_enti> list = new ArrayList<Original_book_enti>();
	Original_book_enti or_book = null;
	
	try {
		
		String sql = "select * from original_book where or_b_stock_status=? order by or_b_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_book = new Original_book_enti();
			or_book.setBook_id(rs.getString(1));
			or_book.setBook_classif_no(rs.getString(5));
			or_book.setBook_title(rs.getString(6));
			or_book.setBook_sub_title(rs.getString(7));
			or_book.setBook_subject(rs.getString(8));
			or_book.setBook_edition(rs.getString(9));
			or_book.setBook_author(rs.getString(10));
			
			or_book.setBook_publisher(rs.getString(11));
			or_book.setBook_publi_year(rs.getString(12));
			or_book.setBook_vend_nm(rs.getString(13));
			or_book.setBook_pages(rs.getString(14));
			or_book.setBook_price(rs.getDouble(15));
			or_book.setBook_rack_no(rs.getString(16));
			or_book.setBook_language(rs.getString(17));
			
			or_book.setBook_status(rs.getString(19));
			
			
				// ******** 
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
			
			or_book.setBook_dept(dept);
			
			
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
			
			or_book.setSearch_publisher(publ);
			
			
			
			
			
			
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
					
			
			or_book.setBook_catrgory(cat);
				
			list.add(or_book);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}












public List<Original_book_enti> getall_or_only_books(String content){
	
	List<Original_book_enti> list = new ArrayList<Original_book_enti>();
	Original_book_enti or_book = null;
	
	try {
		
		String sql = "select * from original_book where or_b_title LIKE '%"+content+"%' and or_b_stock_status=? order by or_b_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_book = new Original_book_enti();
			or_book.setBook_id(rs.getString(1));
			or_book.setBook_classif_no(rs.getString(5));
			or_book.setBook_title(rs.getString(6));
			or_book.setBook_sub_title(rs.getString(7));
			or_book.setBook_subject(rs.getString(8));
			or_book.setBook_edition(rs.getString(9));
			or_book.setBook_author(rs.getString(10));
			
			or_book.setBook_publisher(rs.getString(11));
			or_book.setBook_publi_year(rs.getString(12));
			or_book.setBook_vend_nm(rs.getString(13));
			or_book.setBook_pages(rs.getString(14));
			or_book.setBook_price(rs.getDouble(15));
			or_book.setBook_rack_no(rs.getString(16));
			or_book.setBook_language(rs.getString(17));
			
			or_book.setBook_status(rs.getString(19));
			
			
				// ******** 
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
			
			or_book.setBook_dept(dept);
			
			
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
			
			or_book.setSearch_publisher(publ);
			
			list.add(or_book);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}



//************* Display Search journal data to Index page **********************
//*****************************************************************************


public List<Original_journal_enti> getall_or_journal(String content){
	
	List<Original_journal_enti> list = new ArrayList<Original_journal_enti>();
	Original_journal_enti or_jr = null;
	
	try {
		
		String sql = "select * from original_journal where or_jr_title LIKE '%"+content+"%'  and or_jr_stock_status=? order by or_jr_id asc";
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
			
			or_jr.setJournal_status(rs.getString(19));
			
			
			
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
				
			list.add(or_jr);
			
		}
				
			
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}






//************* Display Search Magazine data to Index page **********************
//*****************************************************************************






public List<Magazine_enti> getall_or_magzine(String content){
	
	List<Magazine_enti> list = new ArrayList<Magazine_enti>();
	Magazine_enti or_mag = null;
	
	try {
		
		String sql = "select * from original_magazin where or_mag_title LIKE '%"+content+"%'  and or_mag_stock_status=? order by or_mag_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_mag = new Magazine_enti();
			
			or_mag.setMag_id(rs.getString(1));
						
			or_mag.setMag_classif_no(rs.getString(5));
			or_mag.setMag_title(rs.getString(6));
			or_mag.setMag_sub_title(rs.getString(7));
			or_mag.setMag_edition(rs.getString(8));
			or_mag.setMag_author(rs.getString(9));

			or_mag.setMag_publisher(rs.getString(10));
			or_mag.setMag_publi_year(rs.getString(11));
			or_mag.setMag_vend_nm(rs.getString(12));
			or_mag.setMag_pages(rs.getString(13));
			or_mag.setMag_price(rs.getDouble(14));
			or_mag.setMag_rack_no(rs.getString(15));
			or_mag.setMag_language(rs.getString(16));
			
			or_mag.setMag_status(rs.getString(18));
			
				// ******** 
			String store_dept = rs.getString(3);
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
			
			or_mag.setMag_dept(dept);	
			
	

			//***************
			
			String sql_publ = "select publ_name from publisher where publ_id=?";
			PreparedStatement np = conn.prepareStatement(sql_publ);					// 	Line No 216 to 233 code for 
			np.setString(1, store_publ);												// 	conversion Publisher id to 
																						// 	publisher Name
			
			ResultSet nr = np.executeQuery();
			String publ =null;
			
			while(nr.next()) {
				
			    publ = nr.getString(1);
				
			}
			
			or_mag.setSearch_publisher(publ);		
			
			
			
			
			
			list.add(or_mag);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}
















// ***********  Display Available Books *********************


public List<Original_book_enti> get_available_or_books(){
	
	List<Original_book_enti> list = new ArrayList<Original_book_enti>();
	Original_book_enti or_book = null;
	
	try {
		
		String sql = "select * from original_book where or_b_stock_status=? and or_b_issue_status=? order by or_b_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		ps.setString(2, "available");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			or_book = new Original_book_enti();
			or_book.setBook_id(rs.getString(1));
			or_book.setBook_classif_no(rs.getString(5));
			or_book.setBook_title(rs.getString(6));
			or_book.setBook_sub_title(rs.getString(7));
			or_book.setBook_subject(rs.getString(8));
			or_book.setBook_edition(rs.getString(9));
			or_book.setBook_author(rs.getString(10));
			
			or_book.setBook_publisher(rs.getString(11));
			or_book.setBook_publi_year(rs.getString(12));
			or_book.setBook_vend_nm(rs.getString(13));
			or_book.setBook_pages(rs.getString(14));
			or_book.setBook_price(rs.getDouble(15));
			or_book.setBook_rack_no(rs.getString(16));
			or_book.setBook_language(rs.getString(17));
			
			
				// ******** 
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
			
			or_book.setBook_dept(dept);
			
			
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
			
			or_book.setSearch_publisher(publ);
			
			
			
			
			
			
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
					
			
			or_book.setBook_catrgory(cat);
				
			list.add(or_book);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}









public List<Original_book_enti> get_search_or_books(String search_table, String search_content){
	
	List<Original_book_enti> list = new ArrayList<Original_book_enti>();
	Original_book_enti or_book = null;
	
	
	try { 
				
		String convert_dept = null;
		//System.out.print("\n Dept  : " search_content.getClass().getSimpleName());
		
		Original_book_enti enti = new Original_book_enti();
		enti.setSearch_book_table(search_table);
		enti.setSearch_book_content(search_content);
		
		
		String qwe = "or_b_department";
		
		  if(enti.getSearch_book_table().equals(qwe))
		  {
			 
			  
			  String sql1 = "select * from department where dept_name=?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);	
				ps1.setString(1, search_content);
				
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
					convert_dept = rs1.getString(1);
				}
				search_content = convert_dept;
				
		  }
		  
		  
		  
		  if(enti.getSearch_book_table().equals("or_b_title") || enti.getSearch_book_table().equals("or_b_author_nm")) {
			  
			  
			  

				String sql = "select * from original_book where "+search_table+" LIKE '%"+search_content +"%' and or_b_stock_status=? ";
				PreparedStatement ps = conn.prepareStatement(sql);	
				//ps.setString(1, search_content);
				ps.setString(1, "In stock");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					or_book = new Original_book_enti();
					or_book.setBook_id(rs.getString(1));
					or_book.setBook_classif_no(rs.getString(5));
					or_book.setBook_title(rs.getString(6));
					or_book.setBook_sub_title(rs.getString(7));
					or_book.setBook_subject(rs.getString(8));
					or_book.setBook_edition(rs.getString(9));
					or_book.setBook_author(rs.getString(10));
					
					or_book.setBook_publisher(rs.getString(11));
					or_book.setBook_publi_year(rs.getString(12));
					or_book.setBook_vend_nm(rs.getString(13));
					or_book.setBook_pages(rs.getString(14));
					or_book.setBook_price(rs.getDouble(15));
					or_book.setBook_rack_no(rs.getString(16));
					or_book.setBook_language(rs.getString(17));
					
						// ******** 
					String store_dept = rs.getString(3);
					String store_publ = rs.getString(11); 
					
					String sql_dept = "select dept_name from department where dept_id=?";
					PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
					nps.setString(1, store_dept);												// 	convertion department id to 
																								// 	department Name
					
					ResultSet nrs = nps.executeQuery();
					String dept =null;
					
					while(nrs.next()) {
						//or_book.setBook_dept(nrs.getString(0));
					    dept = nrs.getString(1);
						
					}
					
					or_book.setBook_dept(dept);
					
					
					
					//************
					
					
					
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
					
					or_book.setSearch_publisher(publ);
					
					
					
					
					
					
						// *******
					
					String store_cat = rs.getString(4);
					
					String sql_cat = "select cat_name from category where cat_id=?";
					PreparedStatement cps = conn.prepareStatement(sql_cat);					// 	Line No 238 to 253 code for 
					cps.setString(1, store_cat);												// 	convertion category id to 
																								//	category Name
					ResultSet nrs_cat = cps.executeQuery();
					String cat =null;
					
					while(nrs_cat.next()) {
						
						cat = nrs_cat.getString(1);
					}
							
					
					or_book.setBook_catrgory(cat);
					
					
					list.add(or_book);
				}
				
			  
			  
		  }else {

				String sql = "select * from original_book where "+search_table+"=? and or_b_stock_status=? ";
				PreparedStatement ps = conn.prepareStatement(sql);	
				ps.setString(1, search_content);
				ps.setString(2, "in stock");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					or_book = new Original_book_enti();
					or_book.setBook_id(rs.getString(1));
					or_book.setBook_classif_no(rs.getString(5));
					or_book.setBook_title(rs.getString(6));
					or_book.setBook_sub_title(rs.getString(7));
					or_book.setBook_subject(rs.getString(8));
					or_book.setBook_edition(rs.getString(9));
					or_book.setBook_author(rs.getString(10));
					
					or_book.setBook_publisher(rs.getString(11));
					or_book.setBook_publi_year(rs.getString(12));
					or_book.setBook_vend_nm(rs.getString(13));
					or_book.setBook_pages(rs.getString(14));
					or_book.setBook_price(rs.getDouble(15));
					or_book.setBook_rack_no(rs.getString(16));
					or_book.setBook_language(rs.getString(17));
					
						// ******** 
					String store_dept = rs.getString(3);
					String store_publ = rs.getString(11); 
					
					String sql_dept = "select dept_name from department where dept_id=?";
					PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
					nps.setString(1, store_dept);												// 	convertion department id to 
																								// 	department Name
					
					ResultSet nrs = nps.executeQuery();
					String dept =null;
					
					while(nrs.next()) {
						//or_book.setBook_dept(nrs.getString(0));
					    dept = nrs.getString(1);
						
					}
					
					or_book.setBook_dept(dept);
					
					
						// *******
					
					String store_cat = rs.getString(4);
					
					String sql_cat = "select cat_name from category where cat_id=?";
					PreparedStatement cps = conn.prepareStatement(sql_cat);					// 	Line No 238 to 253 code for 
					cps.setString(1, store_cat);												// 	convertion category id to 
																								//	category Name
					ResultSet nrs_cat = cps.executeQuery();
					String cat =null;
					
					while(nrs_cat.next()) {
						
						cat = nrs_cat.getString(1);
					}
					or_book.setBook_catrgory(cat);
					
					
					
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
					
					or_book.setSearch_publisher(publ);
					
					
					
					list.add(or_book);
				}
				
			  
		  }
		  
		  
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return list;
}






	
	public boolean edit_original_book(Original_book_enti or_book) {
		
		boolean f = false;
		
		try {
			
			String sql = "update original_book set or_b_classi_no=?, or_b_title=?, or_b_sub_title=?, or_b_subject=?, or_b_edition=?,"
					+ " or_b_author_nm=?, or_b_publi_nm=?, or_b_publi_year=?, or_b_vender_nm=?, or_b_book_pages=?, or_b_price=?,"
					+ " or_b_rack_no=?, or_b_language=?, or_b_stock_status=? where or_b_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, or_book.getBook_classif_no());
			ps.setString(2, or_book.getBook_title());
			ps.setString(3, or_book.getBook_sub_title());
			ps.setString(4, or_book.getBook_subject());
			ps.setString(5, or_book.getBook_edition());
			ps.setString(6, or_book.getBook_author());
			ps.setString(7, or_book.getBook_publisher());
			ps.setString(8, or_book.getBook_publi_year());
			ps.setString(9, or_book.getBook_vend_nm());
			ps.setString(10, or_book.getBook_pages());
			ps.setDouble(11, or_book.getBook_price());
			ps.setString(12, or_book.getBook_rack_no());
			ps.setString(13, or_book.getBook_language());
			ps.setString(14, "in stock");
			ps.setString(15, or_book.getBook_id());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	
	
public boolean delete_original_book(String or_book) {
		
		boolean f = false;
		
		try {
			
			String sql = "delete from original_book where or_b_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, or_book);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
}
	
	



	public boolean delete_original_book_array(ArrayList<String> finala_arr) {
	
		boolean f = false;
	
		try {
				
			String sql = "delete from original_book where or_b_id=?";
			
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

	
	
	
	
	public boolean shift_deadstock_book(ArrayList<String> finala_arr, String reason) {
		
		boolean f = false;
		Original_book_enti or_book = new Original_book_enti();
		try {
			
			String sql = "update original_book set or_b_stock_status=?, or_b_issue_status=? where or_b_id=?";
	
			int leng = finala_arr.size();
			 
			
			for(int j = 0; j<leng; j++) {
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, "dead stock");
				ps.setString(2, null);
				ps.setString(3, finala_arr.get(j));
				
				int i = ps.executeUpdate();
				
				
			
				
				// ******** Shift Books from book table to dead Stock ***********
				
				
				String sql3 = "select * from original_book where or_b_id=?";
				PreparedStatement ps2 = conn.prepareStatement(sql3);
				ps2.setString(1, finala_arr.get(j));
				ResultSet rs = ps2.executeQuery();
				while(rs.next()) {
					
				    
					or_book.setBook_id(rs.getString(1));
					or_book.setBook_dept(rs.getString(3));
					or_book.setBook_catrgory(rs.getString(4));
					or_book.setBook_classif_no(rs.getString(5));
					or_book.setBook_title(rs.getString(6));
					or_book.setBook_sub_title(rs.getString(7));
					or_book.setBook_subject(rs.getString(8));
					or_book.setBook_edition(rs.getString(9));
					or_book.setBook_author(rs.getString(10));
					or_book.setBook_publisher(rs.getString(11));
					or_book.setBook_publi_year(rs.getString(12));
					or_book.setBook_vend_nm(rs.getString(13));
					or_book.setBook_pages(rs.getString(14));
					or_book.setBook_price(rs.getDouble(15));
					or_book.setBook_rack_no(rs.getString(16));
					or_book.setBook_language(rs.getString(17));	
				}
				
				
				String sql2 = "insert into stock_dead_stock(b_dead_id, b_dead_dept, b_dead_cat, b_dead_classino, b_dead_title,"
						+ " b_dead_sub_title, b_dead_subject, b_dead_edition, b_dead_author, b_dead_publi_nm, b_dead_publi_yy, b_dead_vend_nm, "
						+ "b_dead_book_pages, b_dead_book_price, b_dead_rackno, b_dead_lang, b_dead_reason, b_dead_stock_cat) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				
				PreparedStatement ps3 = conn.prepareStatement(sql2);
				ps3.setString(1, or_book.getBook_id());
				
				
				System.out.print("\n\n Book Id : "+or_book.getBook_id());
				
				ps3.setString(2, or_book.getBook_dept());
				ps3.setString(3, or_book.getBook_catrgory());
				ps3.setString(4, or_book.getBook_classif_no());
				ps3.setString(5, or_book.getBook_title());
				ps3.setString(6, or_book.getBook_sub_title());
				ps3.setString(7, or_book.getBook_subject());
				ps3.setString(8, or_book.getBook_edition());
				ps3.setString(9, or_book.getBook_author());
				ps3.setString(10, or_book.getBook_publisher());
				ps3.setString(11, or_book.getBook_publi_year());
				ps3.setString(12, or_book.getBook_vend_nm());
				ps3.setString(13, or_book.getBook_pages());
				ps3.setDouble(14, or_book.getBook_price());
				ps3.setString(15, or_book.getBook_rack_no());
				ps3.setString(16, or_book.getBook_language());
				ps3.setString(17, reason);
				ps3.setString(18, "book");
				
				
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
