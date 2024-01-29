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

import com.entity.Magazine_enti;
import com.entity.Original_book_enti;
import com.entity.Original_journal_enti;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class Original_magDAO {

	
	
	private Connection conn;

	public Original_magDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	
	public boolean one_id_Original_magazine(Magazine_enti or_mag) {
		
		boolean f= false;
		 String soop = null;
		try {
			
			
			String new_sql = "select or_mag_id from original_magazin where or_mag_dept=? and or_mag_cat=? order by or_mag_id asc";
			PreparedStatement nps = conn.prepareStatement(new_sql);
			nps.setString(1, or_mag.getMag_dept());
			nps.setString(2, or_mag.getMag_catrgory());
			
			ResultSet nrs = nps.executeQuery();
			
			while(nrs.next()) {
				soop=nrs.getString(1);
				
			}
			
			if(soop == null) {
				
				or_mag.setMag_id(or_mag.getMag_dept()+ or_mag.getMag_catrgory()+1);
				
				f=true;
			}else {
				
				String asd = soop.substring(6);
				int inc = Integer.parseInt(asd);
				int increment_id = inc+1;
				String new_form_id = or_mag.getMag_dept()+ or_mag.getMag_catrgory()+increment_id;
				or_mag.setMag_id(new_form_id);
				
				System.out.println(new_form_id);
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
	public boolean add_Original_magazine(Magazine_enti or_mag) {
		
		boolean f = false;
		
		try {
	
			String sql = "insert into original_magazin(or_mag_id, or_mag_dept, or_mag_cat, or_mag_classi_no, or_mag_title, or_mag_sub_title,"
					+ " or_mag_edition, or_mag_author, or_mag_publi_nm, or_mag_publi_yy, or_mag_vend_nm, or_mag_pages, "
					+ "or_mag_price, or_mag_rack_no, or_mag_language, or_mag_stock_status, or_mag_issu_status) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, or_mag.getMag_id());
			ps.setString(2, or_mag.getMag_dept());
			ps.setString(3, or_mag.getMag_catrgory());
			ps.setString(4, or_mag.getMag_classif_no());
			ps.setString(5, or_mag.getMag_title());
			ps.setString(6, or_mag.getMag_sub_title());
		
			ps.setString(7, or_mag.getMag_edition());
			ps.setString(8, or_mag.getMag_author());
			ps.setString(9, or_mag.getMag_publisher());
			ps.setString(10, or_mag.getMag_publi_year());
			ps.setString(11, or_mag.getMag_vend_nm());
			ps.setString(12, or_mag.getMag_pages());
			ps.setDouble(13, or_mag.getMag_price());
			ps.setString(14, or_mag.getMag_rack_no());
			ps.setString(15, or_mag.getMag_language());
			ps.setString(16, "In Stock");
			ps.setString(17, "available");
			
			
			int rs = ps.executeUpdate();
			
			if(rs==1) {
				f=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	public boolean generate_magazine_QR(Magazine_enti or_mag) {
		
		boolean f = false;
	
		try {
			
			String content = null;
			
			content = or_mag.getMag_id();
			String path_of_qr = "G:\\Library Mgnt System\\final_library_mgnt\\QR Code\\Magazine\\"+content+".jpg";
			
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
			g2d.drawString(or_mag.getMag_rack_no(), 122, 285);
			g2d.setColor(Color.GREEN);
			ImageIO.write(buff, "jpg", file);
			
			System.out.println("Qr code Generate Succesful");
			f=true;
					
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return f;
}

	
	
	
	

public List<Magazine_enti> getall_or_magzine(){
	
	List<Magazine_enti> list = new ArrayList<Magazine_enti>();
	Magazine_enti or_mag = null;
	
	try {
		
		String sql = "select * from original_magazin where or_mag_stock_status=? order by or_mag_id asc";
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
			or_mag.setMag_catrgory(cat);
			
			
			

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







public List<Magazine_enti> get_available_or_magzine(){
	
	List<Magazine_enti> list = new ArrayList<Magazine_enti>();
	Magazine_enti or_mag = null;
	
	try {
		
		String sql = "select * from original_magazin where or_mag_stock_status=? and or_mag_issu_status=? order by or_mag_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "In stock");
		ps.setString(2, "available");
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
			or_mag.setMag_catrgory(cat);
			
			
			

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


















public List<Magazine_enti> get_search_or_magzine(String profile, String content){
	
	List<Magazine_enti> list = new ArrayList<Magazine_enti>();
	Magazine_enti or_mag = null;

	or_mag = new Magazine_enti();
	
	String dept_temp = "or_mag_dept";
	String author_temp = "or_mag_author";
	String title_temp = "or_mag_title";
	
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
			
				String sql = "select * from original_magazin where "+profile+" LIKE '%"+content +"%' and or_mag_stock_status=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, "In stock");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					

					
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
							
					
					or_mag.setMag_catrgory(cat);
						
					

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
					
					or_mag.setSearch_publisher(publ);		
					
					list.add(or_mag);
			
					
				}				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		}else {
			
			try {
				
				String sql = "select * from original_magazin where "+profile+"=? and or_mag_stock_status=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, content);
				ps.setString(2, "In stock");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					

					
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
							
					
					or_mag.setMag_catrgory(cat);
						
					

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
					
					or_mag.setSearch_publisher(publ);
					
					list.add(or_mag);
			
					
				}				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			
		}
	
	
	
	return list;
	
}









	public boolean edit_original_magzine(Magazine_enti or_mag) {
		
		boolean f = false;
		
		try {
			String sql = "update original_magazin set or_mag_classi_no=?, or_mag_title=?, or_mag_sub_title=?, or_mag_edition=?, or_mag_author=?,"
					+ " or_mag_publi_nm=?, or_mag_publi_yy=?, or_mag_vend_nm=?, or_mag_pages=?, or_mag_price=?, or_mag_rack_no=?, or_mag_language=?"
					+ " where or_mag_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, or_mag.getMag_classif_no());
			ps.setString(2, or_mag.getMag_title());
			ps.setString(3, or_mag.getMag_sub_title());
		
			ps.setString(4, or_mag.getMag_edition());
			ps.setString(5, or_mag.getMag_author());
			ps.setString(6, or_mag.getMag_publisher());
			ps.setString(7, or_mag.getMag_publi_year());
			ps.setString(8, or_mag.getMag_vend_nm());
			ps.setString(9, or_mag.getMag_pages());
			ps.setDouble(10, or_mag.getMag_price());
			ps.setString(11, or_mag.getMag_rack_no());
			ps.setString(12, or_mag.getMag_language());
			
			ps.setString(13, or_mag.getMag_id());
			
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;	
	}
	
	
	
	
	public boolean one_magzine_delete(Magazine_enti mag_enti) {
		
		boolean f = false;
		
		
		try {
			String sql = "delete from original_magazin where or_mag_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mag_enti.getMag_id());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	
	
	
	
public boolean delete_original_magazine_array(ArrayList<String> finala_arr) {
		
		boolean f = false;
	
		try {
				
			String sql = "delete from original_magazin where or_mag_id=?";
			
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
	


		

public boolean shift_dead_stock_magazine(ArrayList<String> finala_arr, String reason) {
	
	boolean f = false;
	Magazine_enti or_mag = new Magazine_enti();
	try {
		
		String sql = "update original_magazin set or_mag_stock_status=? where or_mag_id=?";

		int leng = finala_arr.size();
		 
																						//******* Update Stock Status in Original
		for(int j = 0; j<leng; j++) {													//******* magazine tabel	
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "dead stock");
			ps.setString(2, finala_arr.get(j));
			
			int i = ps.executeUpdate();
	
		
		
		
		
		String sql2 = "select * from original_magazin where or_mag_id =?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setString(1, finala_arr.get(j));
		
		ResultSet rs = ps2.executeQuery();
		while(rs.next()) {
	
			or_mag.setMag_id(rs.getString(1));
			or_mag.setMag_dept(rs.getString(3));
			or_mag.setMag_catrgory(rs.getString(4));
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
		
		}
		
		
		String sql3 = "insert into stock_dead_stock(b_dead_id, b_dead_dept, b_dead_cat, b_dead_classino, b_dead_title,"
				+ " b_dead_sub_title, b_dead_subject, b_dead_edition, b_dead_author, b_dead_publi_nm, b_dead_publi_yy, b_dead_vend_nm, "
				+ "b_dead_book_pages, b_dead_book_price, b_dead_rackno, b_dead_lang, b_dead_reason, b_dead_stock_cat) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		
		ps3.setString(1, or_mag.getMag_id());
		
		ps3.setString(2, or_mag.getMag_dept());
		ps3.setString(3, or_mag.getMag_catrgory());
		ps3.setString(4, or_mag.getMag_classif_no());
		ps3.setString(5, or_mag.getMag_title());
		ps3.setString(6, or_mag.getMag_sub_title());
		ps3.setString(7, "");
		ps3.setString(8, or_mag.getMag_edition());
		ps3.setString(9, or_mag.getMag_author());
		ps3.setString(10, or_mag.getMag_publisher());
		ps3.setString(11, or_mag.getMag_publi_year());
		ps3.setString(12, or_mag.getMag_vend_nm());
		ps3.setString(13, or_mag.getMag_pages());
		ps3.setDouble(14, or_mag.getMag_price());
		ps3.setString(15, or_mag.getMag_rack_no());
		ps3.setString(16, or_mag.getMag_language());
		ps3.setString(17, reason);
		ps3.setString(18, "Magazine");
		
		
		int ii = ps3.executeUpdate();
		
		if(ii==1) {
			f=true;
		}
	
		
		}
		
		
		

	}catch (Exception e) {
		e.printStackTrace();
	}

	
	
	return f;
}



	
	
	
}
