package com.dao;


import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Stock_transection_student_enti;
import com.entity.Student_enti;

//import com.google.protobuf.Duration;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stock_transection_studentDAO {

	private Connection conn;

	Stock_transection_student_enti tr_enti = new Stock_transection_student_enti();

	public String Tran_stud_id;
	public String Tran_stud_name;
	public String Tran_stud_dept;
	public String Tran_book_id;
	public String Tran_book_name;
	public Double Tran_book_price;

	public Stock_transection_studentDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	// ************ This function for Check Scanned Student Id are present in
	// database or not ***********

	public boolean check_stud_present_ornot(String content, String profile) {

		boolean f = false;

		try {
			if (profile.equals("student")) {

				String Sql1 = "select * from students where Stud_id=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, content);

				// Stock_transection_student_enti tr_enti = new
				// Stock_transection_student_enti();

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					f = true;
				}

			}

			if (profile.equals("teacher")) {
				String Sql1 = "select * from staff where stf_id=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, content);

				// Stock_transection_student_enti tr_enti = new
				// Stock_transection_student_enti();

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					f = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public boolean check_stock_present_ornot(String content, String profile, String candi_id, String candi_prof) {

		boolean f = false;
		boolean ff = false;

		try {

			if (profile.equals("book")) {

				String Sql1 = "select * from original_book where or_b_id=? and or_b_issue_status=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, content);
				ps.setString(2, "available");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					Tran_book_id = rs.getString(1);
					Tran_book_name = rs.getString(6);
					Tran_book_price = rs.getDouble(15);

				}

			} else if (profile.equals("journal")) {

				String Sql1 = "select * from original_journal where or_jr_id=? and or_jr_issue_status=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, content);
				ps.setString(2, "available");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					Tran_book_id = rs.getString(1);
					Tran_book_name = rs.getString(6);
					Tran_book_price = rs.getDouble(15);

				}
			} else if (profile.equals("magazine")) {
				

				String Sql1 = "select * from original_magazin where or_mag_id=? and or_mag_issu_status=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, content);
				ps.setString(2, "available");

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					Tran_book_id = rs.getString(1);
					Tran_book_name = rs.getString(6);
					Tran_book_price = rs.getDouble(14);

				}
			
			}

			
			
			
			
			// ********* This code for fatch required data from student or Staff
			// table*******

			if (candi_prof.equals("student")) {

				String Sql1 = "select * from students where Stud_id=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, candi_id);

				

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					Tran_stud_id = rs.getString(1);
					Tran_stud_name = rs.getString(2);
					Tran_stud_dept = rs.getString(3);

					boolean k = insert_student_trans(profile);

					if (k) {
						f = true;
					}

				}

			}else if(candi_prof.equals("teacher")){
				
				
				String Sql1 = "select * from staff where stf_id=?";
				PreparedStatement ps = conn.prepareStatement(Sql1);
				ps.setString(1, candi_id);

				

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					Tran_stud_id = rs.getString(1);
					Tran_stud_name = rs.getString(2);
					Tran_stud_dept = rs.getString(3);

					boolean k = insert_staff_trans(profile);
					
					if (k) {
						f = true;
					}

				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	
	
	
	
	
	

	public boolean insert_student_trans(String profile) {

		boolean f = false;
		String issue_status = "returned";

		try {

			String sql1 = "select tr_status from stock_transc_stud where tr_book_id=? order by transc_id asc";
			PreparedStatement pps = conn.prepareStatement(sql1);
			pps.setString(1, Tran_book_id);

			ResultSet rrs = pps.executeQuery();
			
			while (rrs.next()) {
				issue_status = rrs.getString(1);
			}

			

			if (issue_status.equals("issued")) {

		

			} else {

				String sql = "insert into stock_transc_stud (tr_stud_stud_id, tr_stud_name, tr_stud_dept, tr_book_id, tr_book_name, tr_issue_date, "
						+ "tr_virtual_return_date, tr_book_price, tr_status, tr_candi_type, tr_stock_type)"
						+ " values(?,?,?,?,?,DATE_ADD(NOW(), INTERVAL 0 DAY), DATE_ADD(NOW(), INTERVAL 7 DAY),?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, Tran_stud_id);
				ps.setString(2, Tran_stud_name);
				ps.setString(3, Tran_stud_dept);
				ps.setString(4, Tran_book_id);
				ps.setString(5, Tran_book_name);

				ps.setDouble(6, Tran_book_price);
				ps.setString(7, "issued");
				ps.setString(8, "student");
				ps.setString(9, profile);

				int i = ps.executeUpdate();

				if (i == 1) {
					
					f = true;

				} 

				
				if(profile.equals("book")) {
					
					String sql_book = "update original_book set or_b_issue_status=? where or_b_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "unavailable");
					pps2.setString(2, Tran_book_id);

					int j = pps2.executeUpdate();
					
					
				}else if(profile.equals("journal")) {
					
					String sql_book = "update original_journal set or_jr_issue_status=? where or_jr_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "unavailable");
					pps2.setString(2, Tran_book_id);

					int j = pps2.executeUpdate();
				
				
				
				
				}else if(profile.equals("magazine")) {
					
					String sql_book = "update original_magazin set or_mag_issu_status=? where or_mag_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "unavailable");
					pps2.setString(2, Tran_book_id);

					int j = pps2.executeUpdate();
				}
				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}
	
	
	
	
	public boolean insert_staff_trans(String profile) {

		boolean f = false;
		String issue_status = null;

		try {

			String sql1 = "select tr_status from stock_transc_stud where tr_book_id=? order by transc_id asc";
			PreparedStatement pps = conn.prepareStatement(sql1);
			pps.setString(1, Tran_book_id);

			ResultSet rrs = pps.executeQuery();
			while (rrs.next()) {
				issue_status = rrs.getString(1);
			}

			

			if (issue_status.equals("issued")) {



			} else {

				String sql = "insert into stock_transc_stud (tr_stud_stud_id, tr_stud_name, tr_stud_dept, tr_book_id, tr_book_name,tr_issue_date, "
						+ "tr_virtual_return_date, tr_book_price, tr_status, tr_candi_type, tr_stock_type) "
						+ "values(?,?,?,?,?,DATE_ADD(NOW(), INTERVAL 0 DAY)  ,DATE_ADD(NOW(), INTERVAL 15 DAY),?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, Tran_stud_id);
				ps.setString(2, Tran_stud_name);
				ps.setString(3, Tran_stud_dept);
				ps.setString(4, Tran_book_id);
				ps.setString(5, Tran_book_name);

				ps.setDouble(6, Tran_book_price);
				ps.setString(7, "issued");
				ps.setString(8, "teacher");
				ps.setString(9, profile);

				int i = ps.executeUpdate();

				if (i == 1) {
					

					f = true;

				} else {
				
				}

				
				if(profile.equals("book")) {
					
					String sql_book = "update original_book set or_b_issue_status=? where or_b_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "unavailable");
					pps2.setString(2, Tran_book_id);

					int j = pps2.executeUpdate();
					
					
				}else if(profile.equals("journal")) {
					
					String sql_book = "update original_journal set or_jr_issue_status=? where or_jr_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "unavailable");
					pps2.setString(2, Tran_book_id);

					int j = pps2.executeUpdate();
				
				
				
				
				}else if(profile.equals("magazine")) {
					
					String sql_book = "update original_magazin set or_mag_issu_status=? where or_mag_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "unavailable");
					pps2.setString(2, Tran_book_id);

					int j = pps2.executeUpdate();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}
	
	
	
	
	
	
	

	// ************* Return Of Stock *******************
	// **************************************************

	public boolean return_stock(String content, String profile, HttpServletRequest request, HttpServletResponse response) {

		boolean f = false;
		String tran_id = null, tr_student_id= null, tr_stock_id= null, tr_stock_name =null, tr_student_name=null, tr_stock_status, tr_candi_type=null;
		String tran_stud_dept = null;
		try {

			
			
			String sql = "select * from stock_transc_stud where tr_book_id=? order by transc_id asc";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, content);

			ResultSet rs = ps.executeQuery();
			Date dbDate = null;
			Date dbDate2 = null;

			while (rs.next()) {

				tran_id = rs.getString(1);
				tr_student_id = rs.getString(2);
				tr_student_name = rs.getString(3);
				
				tr_stock_id = rs.getString(5);
				tr_stock_name = rs.getString(6);
				dbDate = rs.getDate(7);
				dbDate2 = rs.getDate(8);

				// tr_issue_date = rs.getString(7);
				// tr_virtual_return_date = rs.getString(8);
				tr_stock_status = rs.getString(12);
				tr_candi_type = rs.getString(13);
			
			
				tran_stud_dept = rs.getString(4);
				
				// ******** 
			
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
				nps.setString(1, tran_stud_dept);												// 	conversion department id to 
																							// 	department Name
				
				ResultSet nrs = nps.executeQuery();
				String dept =null;
				
				while(nrs.next()) {
					//or_book.setBook_dept(nrs.getString(0));
				    dept = nrs.getString(1);
					
				}
				
				tran_stud_dept = dept;
			
			
			}

			
			
			Date curr_date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyy-MM-DD");
			String datestring = dateformat.format(curr_date);
			curr_date = dateformat.parse(datestring);			
			
			int result = curr_date.compareTo(dbDate2);

			
			

			 

			if (result < 0) {										//***** For Under the due Date ******
			
				int j = 0;
			
					if(profile.equals("book")) {
					
						String sql_book = "update original_book set or_b_issue_status=? where or_b_id=?";

						PreparedStatement pps2 = conn.prepareStatement(sql_book);

						pps2.setString(1, "available");
						pps2.setString(2, content);

						j = pps2.executeUpdate();
					
					
					}else if(profile.equals("journal")) {
					
						String sql_book = "update original_journal set or_jr_issue_status=? where or_jr_id=?";

						PreparedStatement pps2 = conn.prepareStatement(sql_book);

						pps2.setString(1, "available");
						pps2.setString(2, content);

						j = pps2.executeUpdate();
				
				
				
				
						}else if(profile.equals("magazine")) {
					
							String sql_book = "update original_magazin set or_mag_issu_status=? where or_mag_id=?";

							PreparedStatement pps2 = conn.prepareStatement(sql_book);
							
							pps2.setString(1, "available");
							pps2.setString(2, content);

							j = pps2.executeUpdate();
						}
				
					if(j==1) {
					
					 String sql2 = "update stock_transc_stud set tr_actual_return_date=DATE_ADD(NOW(), INTERVAL 0 DAY), tr_status=? where transc_id=? ";
					  
					  PreparedStatement pps = conn.prepareStatement(sql2); 
					  
					
					  pps.setString(1,"returned");
					  pps.setString(2, tran_id);
					  
					  int i = pps.executeUpdate();
					  
					  if(i==1) {
					  
					  f = true;
					  
					  }
					 
				}
				
				
				 
				
			} else if (result == 0) {								//***** For Equal the due Date ******								
				
				int j = 0;
				
				if(profile.equals("book")) {
					
					String sql_book = "update original_book set or_b_issue_status=? where or_b_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "available");
					pps2.setString(2, content);

					j = pps2.executeUpdate();
					
					
				}else if(profile.equals("journal")) {
					
					String sql_book = "update original_journal set or_jr_issue_status=? where or_jr_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "available");
					pps2.setString(2, content);

					j = pps2.executeUpdate();
				
				
				
				
				}else if(profile.equals("magazine")) {
					
					String sql_book = "update original_magazin set or_mag_issu_status=? where or_mag_id=?";

					PreparedStatement pps2 = conn.prepareStatement(sql_book);

					pps2.setString(1, "available");
					pps2.setString(2, content);

					j = pps2.executeUpdate();
				}
				
				
				if(j ==1) {
					
					 String sql2 = "update stock_transc_stud set tr_actual_return_date=DATE_ADD(NOW(), INTERVAL 0 DAY), tr_status=? where transc_id=? ";
					  
					  PreparedStatement pps = conn.prepareStatement(sql2); 
					  
					
					  pps.setString(1,"returned");
					  pps.setString(2, tran_id);
					  
					  int i = pps.executeUpdate();
					  
					  if(i==1) {
					  
						  f = true;
					  
					  }
					
					
				}
				
				
				
				
				
			} else {												//***** For Cross the due Date ******							
				

				
				  long diffInMillies = Math.abs(curr_date.getTime() - dbDate2.getTime()); long
				  dur = Duration.ofMillis(diffInMillies).toDays();
				 
				  f = false;
				
				 
				 double fine_amount = dur*2;
				 
				 HttpSession session=request.getSession();
				 session.setAttribute("succMsg", "fine");	
					
				 response.sendRedirect("Student_fine_collect.jsp?tran_id="+tran_id+"&book_name="+tr_stock_name+"&issu_date="+dbDate+"&stud_name="
				 		+ tr_student_name+"&last_date="+dbDate2+"&late_day="+dur+"&fine_amount="+fine_amount+"&error=error &book_id="+tr_stock_id+
				 		"&student_id="+tr_student_id+"&profile="+profile+"&student_dept="+tran_stud_dept);

			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}
	
	
	
	
	
	
	//*********************************
	//*********************************
	//******* Reports  ***************
	//*********************************
	
	
	
	public List<Stock_transection_student_enti> getall_students_transaction(String candi_type){
		
		List<Stock_transection_student_enti> list = new ArrayList<Stock_transection_student_enti>();
		Stock_transection_student_enti stk_enti = null;
	
		try {
			
			String convert_dept = null;
			
			String sql = "select * from stock_transc_stud where tr_candi_type=? and tr_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, candi_type);
			ps.setString(2, "returned");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				stk_enti = new Stock_transection_student_enti();
				
				stk_enti.setTran_stud_id(rs.getString(2));
				stk_enti.setTran_stud_name(rs.getString(3));
				
				
				
				stk_enti.setTran_book_id(rs.getString(5));
				stk_enti.setTran_book_name(rs.getString(6));
				stk_enti.setIssue_date(rs.getString(7));
				stk_enti.setReturn_date(rs.getString(9));
				stk_enti.setTran_let_day(rs.getInt(10));
				stk_enti.setStock_category(rs.getString(14));
				
				convert_dept = rs.getString(4);
				
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
				nps.setString(1, convert_dept);												// 	conversion department id to 
																							// 	department Name
				ResultSet nrs = nps.executeQuery();
				String dept =null;
				
				while(nrs.next()) {
				    dept = nrs.getString(1);
				}
				
				stk_enti.setTran_stud_dept(dept);				
				
				list.add(stk_enti);
			
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public List<Stock_transection_student_enti> getsearch_students_transaction(String candi_type, String profile, String content, String from_date, String to_date){
		
		List<Stock_transection_student_enti> list = new ArrayList<Stock_transection_student_enti>();
		Stock_transection_student_enti stk_enti = null;
	
	
		
		try {
			
			
			
			
			
			
			String convert_dept = null;
			
			if(profile.equals("tr_stud_dept")) {
				
				 String sql1 = "select * from department where dept_name=?";
					PreparedStatement ps1 = conn.prepareStatement(sql1);	
					ps1.setString(1, content);
					
					ResultSet rs1 = ps1.executeQuery();
					
					while(rs1.next()) {
						convert_dept = rs1.getString(1);
					}
					content = convert_dept;
			}
			
			
			
			if(from_date=="" && to_date=="") {

				
				
				
				if(profile.equals("tr_stud_name")|| profile.equals("tr_book_name")) {
					
					String sql = "select * from stock_transc_stud where "+profile+" LIKE '%"+content+"%' and tr_candi_type=? and tr_status=? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, candi_type);
					String temp = "returned";
					ps.setString(2, temp);
					
				
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
						
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				
				}else {
					String sql = "select * from stock_transc_stud where "+profile+" ="+content+" and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, candi_type);
					ps.setString(2, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
					
				}
				
				
				
				
			}else if(content=="") {
				
				if(from_date!="" && to_date!="") {

					
					
					String sql = "select * from stock_transc_stud where tr_actual_return_date BETWEEN ? and ? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, from_date);
					ps.setString(2, to_date);
					
					ps.setString(3, candi_type);
					ps.setString(4, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						System.out.print("\nQuery Student: "+sql);
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
					
				}else if(to_date!="") {
					
					
					
					String sql = "select * from stock_transc_stud where tr_actual_return_date <= ? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, to_date);
					ps.setString(2, candi_type);
					ps.setString(3, "returned");
				
					ResultSet rs = ps.executeQuery();
				
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
					
				}else if(from_date!="") {
					
					String sql = "select * from stock_transc_stud where tr_actual_return_date >= ? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, from_date);
					ps.setString(2, candi_type);
					ps.setString(3, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
		
				}
				
				
				
				
				
			}else if(content!="" && to_date!="" && from_date!="") {
				

				if(profile.equals("tr_stud_name")|| profile.equals("tr_book_name")) {
					
					String sql = "select * from stock_transc_stud where "+profile+" LIKE '%"+ content+ " %' and tr_actual_return_date BETWEEN ? and ? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, from_date);
					ps.setString(2, to_date);
					
					ps.setString(3, candi_type);
					ps.setString(4, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				
				}else {
					String sql = "select * from stock_transc_stud where "+profile+" ="+content+" and tr_actual_return_date BETWEEN ? and ? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, from_date);
					ps.setString(2, to_date);
					
					ps.setString(3, candi_type);
					ps.setString(4, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				}
				
			}else if(content!="" && from_date!="") {
				

				if(profile.equals("tr_stud_name")|| profile.equals("tr_book_name")) {
					
					String sql = "select * from stock_transc_stud where "+profile+" LIKE '%"+ content+ " %' and tr_actual_return_date >=? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, from_date);
					ps.setString(2, candi_type);
					ps.setString(3, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				
				}else {
					String sql = "select * from stock_transc_stud where "+profile+" ="+content+" and tr_actual_return_date >=? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, from_date);
					ps.setString(2, candi_type);
					ps.setString(3, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				}
			
				
			}else if(content!="" && to_date!="") {
				

				if(profile.equals("tr_stud_name")|| profile.equals("tr_book_name")) {
					
					String sql = "select * from stock_transc_stud where "+profile+" LIKE '%"+ content+ " %' and tr_actual_return_date <=? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1, to_date);
					ps.setString(2, candi_type);
					ps.setString(3, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				
				}else {
					String sql = "select * from stock_transc_stud where "+profile+" ="+content+" and tr_actual_return_date <=? and tr_candi_type=? and tr_status=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, to_date);
					ps.setString(2, candi_type);
					ps.setString(3, "returned");
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						stk_enti = new Stock_transection_student_enti();
						
						stk_enti.setTran_stud_id(rs.getString(2));
						stk_enti.setTran_stud_name(rs.getString(3));
						
						
						
						stk_enti.setTran_book_id(rs.getString(5));
						stk_enti.setTran_book_name(rs.getString(6));
						stk_enti.setIssue_date(rs.getString(7));
						stk_enti.setReturn_date(rs.getString(9));
						stk_enti.setTran_let_day(rs.getInt(10));
						stk_enti.setStock_category(rs.getString(14));
					
						convert_dept = rs.getString(4);
						
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, convert_dept);												// 	conversion department id to 
																									// 	department Name
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
						}
						
						stk_enti.setTran_stud_dept(dept);				
						
						list.add(stk_enti);
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return list;
	}
	
	
	
	
	
public List<Stock_transection_student_enti> getall_issued_book_transaction(){
		
		List<Stock_transection_student_enti> list = new ArrayList<Stock_transection_student_enti>();
		Stock_transection_student_enti stk_enti = null;
	
		try {
			
			String convert_dept = null;
			
			String sql = "select * from stock_transc_stud where tr_status=? and tr_stock_type=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "issued");
			ps.setString(2, "book");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				stk_enti = new Stock_transection_student_enti();
				
				stk_enti.setTran_stud_id(rs.getString(2));
				stk_enti.setTran_stud_name(rs.getString(3));
				
				
				
				stk_enti.setTran_book_id(rs.getString(5));
				stk_enti.setTran_book_name(rs.getString(6));
				stk_enti.setIssue_date(rs.getString(7));
				stk_enti.setTran_virt_retur_date(rs.getString(8));
				stk_enti.setReturn_date(rs.getString(9));
				stk_enti.setTran_let_day(rs.getInt(10));
				stk_enti.setStock_price(rs.getDouble(11));
				stk_enti.setCandi_type(rs.getString(13));
				stk_enti.setStock_category(rs.getString(14));
				
				convert_dept = rs.getString(4);
				
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
				nps.setString(1, convert_dept);												// 	conversion department id to 
																							// 	department Name
				ResultSet nrs = nps.executeQuery();
				String dept =null;
				
				while(nrs.next()) {
				    dept = nrs.getString(1);
				}
				
				stk_enti.setTran_stud_dept(dept);				
				
				list.add(stk_enti);
			
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	


public List<Stock_transection_student_enti> getall_issued_journal_transaction(){
		
		List<Stock_transection_student_enti> list = new ArrayList<Stock_transection_student_enti>();
		Stock_transection_student_enti stk_enti = null;
	
		try {
			
			String convert_dept = null;
			
			String sql = "select * from stock_transc_stud where tr_status=? and tr_stock_type=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "issued");
			ps.setString(2, "journal");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				stk_enti = new Stock_transection_student_enti();
				
				stk_enti.setTran_stud_id(rs.getString(2));
				stk_enti.setTran_stud_name(rs.getString(3));
				
				
				
				stk_enti.setTran_book_id(rs.getString(5));
				stk_enti.setTran_book_name(rs.getString(6));
				stk_enti.setIssue_date(rs.getString(7));
				stk_enti.setTran_virt_retur_date(rs.getString(8));
				stk_enti.setReturn_date(rs.getString(9));
				stk_enti.setTran_let_day(rs.getInt(10));
				stk_enti.setStock_price(rs.getDouble(11));
				stk_enti.setCandi_type(rs.getString(13));
				stk_enti.setStock_category(rs.getString(14));
				
				convert_dept = rs.getString(4);
				
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
				nps.setString(1, convert_dept);												// 	conversion department id to 
																							// 	department Name
				ResultSet nrs = nps.executeQuery();
				String dept =null;
				
				while(nrs.next()) {
				    dept = nrs.getString(1);
				}
				
				stk_enti.setTran_stud_dept(dept);				
				
				list.add(stk_enti);
			
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	





public List<Stock_transection_student_enti> getall_issued_magazine_transaction(){
		
		List<Stock_transection_student_enti> list = new ArrayList<Stock_transection_student_enti>();
		Stock_transection_student_enti stk_enti = null;
	
		try {
			
			String convert_dept = null;
			
			String sql = "select * from stock_transc_stud where tr_status=? and tr_stock_type=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "issued");
			ps.setString(2, "magazine");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				stk_enti = new Stock_transection_student_enti();
				
				stk_enti.setTran_stud_id(rs.getString(2));
				stk_enti.setTran_stud_name(rs.getString(3));
				
				
				
				stk_enti.setTran_book_id(rs.getString(5));
				stk_enti.setTran_book_name(rs.getString(6));
				stk_enti.setIssue_date(rs.getString(7));
				stk_enti.setTran_virt_retur_date(rs.getString(8));
				stk_enti.setReturn_date(rs.getString(9));
				stk_enti.setTran_let_day(rs.getInt(10));
				stk_enti.setStock_price(rs.getDouble(11));
				stk_enti.setCandi_type(rs.getString(13));
				stk_enti.setStock_category(rs.getString(14));
				
				convert_dept = rs.getString(4);
				
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
				nps.setString(1, convert_dept);												// 	conversion department id to 
																							// 	department Name
				ResultSet nrs = nps.executeQuery();
				String dept =null;
				
				while(nrs.next()) {
				    dept = nrs.getString(1);
				}
				
				stk_enti.setTran_stud_dept(dept);				
				
				list.add(stk_enti);
			
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	













	
	

}
