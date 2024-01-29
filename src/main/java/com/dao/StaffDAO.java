package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.entity.Staff_enti;
import com.entity.Student_enti;
import com.google.protobuf.Timestamp;
import com.mysql.cj.jdbc.Blob;

public class StaffDAO {
	private Connection conn;

	public StaffDAO(Connection conn) {
		super();
		this.conn = conn;
	
	}

	
	
	
	public boolean add_stff(Staff_enti stff, InputStream stream) {
		
		boolean f= false;
		
		try {
			
			
			String sql = "insert into staff (stf_id, stf_name, stf_dept, stf_dob, stf_city, stf_taluka, stf_dist, stf_phone,"
					+ " stf_email, stf_photo) values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stff.getStaff_id());
			ps.setString(2, stff.getStaff_name());
			ps.setString(3, stff.getStaff_dept());
			ps.setString(4, stff.getStaff_dob());
			ps.setString(5, stff.getStaff_city());
			ps.setString(6, stff.getStaff_taluka());
			ps.setString(7, stff.getStaff_dist());
			ps.setString(8, stff.getStaff_phone());
			ps.setString(9, stff.getStaff_email());
			ps.setBlob(10, stream);
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return f;
	}
	
	
	
	
	
	
	public List<Staff_enti> getall_staff(){
	
		List<Staff_enti> list = new ArrayList<Staff_enti>();
		Staff_enti staff = null;
	
		try {
		
			String sql = "select * from staff order by stf_id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				staff = new Staff_enti();
				staff.setStaff_id(rs.getString(1));
				staff.setStaff_name(rs.getString(2));
				staff.setOriginal_dept(rs.getString(3));
				
				staff.setStaff_dob(rs.getString(4));
				staff.setStaff_city(rs.getString(5));
				staff.setStaff_taluka(rs.getString(6));
				staff.setStaff_dist(rs.getString(7));
				staff.setStaff_phone(rs.getString(8));
				staff.setStaff_email(rs.getString(9));
				staff.setImage((Blob) rs.getBlob(10));
				
				staff.setBarr(staff.getImage().getBytes(1, (int)staff.getImage().length()));
				String enco = Base64.getEncoder().encodeToString(staff.getBarr());
				//stud.setEncodeimage(enco);
				staff.setEncodeimg("data:image/jpg;base64,"+enco);
				
				
				
				String store_dept = rs.getString(3);
								
				String sql_dept = "select dept_name from department where dept_id=?";
				PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
				nps.setString(1, store_dept);												// 	conversion department id to 																						// 	department Name
				
				ResultSet nrs = nps.executeQuery();
				String dept =null;
				
				while(nrs.next()) {
				    dept = nrs.getString(1);
					
				}
				staff.setStaff_dept(dept);
				
				
				
				
				
				list.add(staff);
			}
			
			
			
		}catch (Exception e) {
		e.printStackTrace();
		}
	
		return list;
	
	}
	
	
	
	public boolean update_stff(Staff_enti stff, InputStream stream) {
		
		boolean f= false;
		
		try {
			
			if(stream.available()==0) {
				
				String sql = "update staff set stf_name=?, stf_dept=?, stf_dob=?, stf_city=?, stf_taluka=?, stf_dist=?, stf_phone=?,"
						+ " stf_email=?, stf_entry_date=CURRENT_TIMESTAMP where stf_id=?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				
				ps.setString(1, stff.getStaff_name());
				ps.setString(2, stff.getStaff_dept());
				ps.setString(3, stff.getStaff_dob());
				ps.setString(4, stff.getStaff_city());
				ps.setString(5, stff.getStaff_taluka());
				ps.setString(6, stff.getStaff_dist());
				ps.setString(7, stff.getStaff_phone());
				ps.setString(8, stff.getStaff_email());
				
				ps.setString(9, stff.getStaff_id());
				
				int i = ps.executeUpdate();
				
				if(i==1) {
					f = true;
				}
				
			}else {
				
				String sql = "update staff set stf_name=?, stf_dept=?, stf_dob=?, stf_city=?, stf_taluka=?, stf_dist=?, stf_phone=?,"
						+ " stf_email=?,stf_photo=?, stf_entry_date=CURRENT_TIMESTAMP where stf_id=?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				
				ps.setString(1, stff.getStaff_name());
				ps.setString(2, stff.getStaff_dept());
				ps.setString(3, stff.getStaff_dob());
				ps.setString(4, stff.getStaff_city());
				ps.setString(5, stff.getStaff_taluka());
				ps.setString(6, stff.getStaff_dist());
				ps.setString(7, stff.getStaff_phone());
				ps.setString(8, stff.getStaff_email());
				ps.setBlob(9, stream);
				ps.setString(10, stff.getStaff_id());
				
				int i = ps.executeUpdate();
				
				if(i==1) {
					f = true;
				}				
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	return f;	
	}
	
	
	
	
	

	public List<Staff_enti> get_search_staff(String search_table, String search_content){
	
		List<Staff_enti> list = new ArrayList<Staff_enti>();
		Staff_enti staff = null;
	
		
		try {
			
			
			
			
			String convert_dept = null;
			//System.out.print("\n Dept  : " search_content.getClass().getSimpleName());
			
		
			
			String qwe = "stf_dept";
			String asd = "stf_name";
			
			  if(search_table.equals(qwe))
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
			  
			  
			  if(search_table.equals(asd))
			  {
				  
				  String sql = "select * from staff where stf_name LIKE '%"+search_content+ " %'";
					PreparedStatement ps = conn.prepareStatement(sql);	
				//	ps.setString(1, search_content);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						
						
						staff = new Staff_enti();
						staff.setStaff_id(rs.getString(1));
						staff.setStaff_name(rs.getString(2));
						staff.setOriginal_dept(rs.getString(3));
						
						staff.setStaff_dob(rs.getString(4));
						staff.setStaff_city(rs.getString(5));
						staff.setStaff_taluka(rs.getString(6));
						staff.setStaff_dist(rs.getString(7));
						staff.setStaff_phone(rs.getString(8));
						staff.setStaff_email(rs.getString(9));
						staff.setImage((Blob) rs.getBlob(10));
						
						staff.setBarr(staff.getImage().getBytes(1, (int)staff.getImage().length()));
						String enco = Base64.getEncoder().encodeToString(staff.getBarr());
						//stud.setEncodeimage(enco);
						staff.setEncodeimg("data:image/jpg;base64,"+enco);
						
						
						
						String store_dept = rs.getString(3);
										
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, store_dept);												// 	conversion department id to 																						// 	department Name
						
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
							
						}
						staff.setStaff_dept(dept);
						
						
						

							
						list.add(staff);
					}
						
				  
			  }else {
				  
				  String sql = "select * from staff where "+search_table+"=? ";
					PreparedStatement ps = conn.prepareStatement(sql);	
					ps.setString(1, search_content);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						
						staff = new Staff_enti();
						staff.setStaff_id(rs.getString(1));
						staff.setStaff_name(rs.getString(2));
						staff.setOriginal_dept(rs.getString(3));
						
						staff.setStaff_dob(rs.getString(4));
						staff.setStaff_city(rs.getString(5));
						staff.setStaff_taluka(rs.getString(6));
						staff.setStaff_dist(rs.getString(7));
						staff.setStaff_phone(rs.getString(8));
						staff.setStaff_email(rs.getString(9));
						staff.setImage((Blob) rs.getBlob(10));
						
						staff.setBarr(staff.getImage().getBytes(1, (int)staff.getImage().length()));
						String enco = Base64.getEncoder().encodeToString(staff.getBarr());
						//stud.setEncodeimage(enco);
						staff.setEncodeimg("data:image/jpg;base64,"+enco);
						
						
						
						String store_dept = rs.getString(3);
										
						String sql_dept = "select dept_name from department where dept_id=?";
						PreparedStatement nps = conn.prepareStatement(sql_dept);					// 	Line No 216 to 233 code for 
						nps.setString(1, store_dept);												// 	conversion department id to 																						// 	department Name
						
						ResultSet nrs = nps.executeQuery();
						String dept =null;
						
						while(nrs.next()) {
						    dept = nrs.getString(1);
							
						}
						staff.setStaff_dept(dept);

							
						list.add(staff);
						
				  
					}	
				}			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return list;
	}

	
	
	
	
}
