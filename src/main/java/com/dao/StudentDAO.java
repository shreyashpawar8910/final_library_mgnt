package com.dao;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.Part;

import com.entity.Department_enti;
import com.entity.Original_book_enti;
import com.entity.Stock_transection_student_enti;
import com.entity.Student_enti;
import com.entity.Vender_enti;
import com.mysql.cj.jdbc.Blob;

public class StudentDAO {

	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;
	
	}
	
	
	
	public boolean add_student(Student_enti stud, InputStream stream) {
		
			boolean f= false;
			
			try {
				
				String sql = "insert into students (Stud_id, stud_name, stud_dept, stud_class, stud_date_of_birth, stud_city, stud_taluka, "
						+ "stud_dist, stud_phone, stud_email, stud_photo) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				
			    
				
				ps.setString(1, stud.getStud_id());
				ps.setString(2, stud.getStud_name());
				ps.setString(3, stud.getStud_dept());
				ps.setString(4, stud.getStud_class());
				ps.setString(5, stud.getStud_dob());
				ps.setString(6, stud.getStud_city());
				ps.setString(7, stud.getStud_taluka());
				ps.setString(8, stud.getStud_dist());
				ps.setString(9, stud.getStud_phone());
				ps.setString(10, stud.getStud_email());
				ps.setBlob(11, stream);
			//	ps.setBinaryStream(11, file, file.available());
				
				int r= ps.executeUpdate();
				
				if(r==1) {
					System.out.print("\nPhoto Upload Succesful");
					f= true;
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
	}	
	
	
	
	
	
	public boolean student_update(Student_enti std_update, InputStream stream) {
		boolean f=false;
		
		try {
			
		
			if(stream.available()==0) {
				
				String sql = "update students set stud_name=?, stud_dept=?, stud_class=?, stud_date_of_birth=?, stud_city=?, stud_taluka=?,"
						+ " stud_dist=?, stud_phone=?, stud_email=? where Stud_id=?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				ps.setString(1, std_update.getStud_name());
				ps.setString(2, std_update.getStud_dept());
				ps.setString(3, std_update.getStud_class());
				ps.setString(4, std_update.getStud_dob());
				ps.setString(5, std_update.getStud_city());
				ps.setString(6, std_update.getStud_taluka());
				ps.setString(7, std_update.getStud_dist());
				ps.setString(8, std_update.getStud_phone());
				ps.setString(9, std_update.getStud_email());
				
				ps.setString(10, std_update.getStud_id());
				
				
				int i = ps.executeUpdate();
				
				if(i==1) {
					f=true;
				}
				
				
				
			}else {
				
				String sql = "update students set stud_name=?, stud_dept=?, stud_class=?, stud_date_of_birth=?, stud_city=?, stud_taluka=?,"
						+ " stud_dist=?, stud_phone=?, stud_email=?, stud_photo=? where Stud_id=?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				ps.setString(1, std_update.getStud_name());
				ps.setString(2, std_update.getStud_dept());
				ps.setString(3, std_update.getStud_class());
				ps.setString(4, std_update.getStud_dob());
				ps.setString(5, std_update.getStud_city());
				ps.setString(6, std_update.getStud_taluka());
				ps.setString(7, std_update.getStud_dist());
				ps.setString(8, std_update.getStud_phone());
				ps.setString(9, std_update.getStud_email());
				ps.setBlob(10, stream);
				ps.setString(11, std_update.getStud_id());
				
				
				int i = ps.executeUpdate();
				
				if(i==1) {
					f=true;
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
	
	
	
public List<Student_enti> getall_students(){
	
	List<Student_enti> list = new ArrayList<Student_enti>();
	Student_enti stud = null;
	
	try {
		
		String sql = "select * from students order by Stud_id asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			stud = new Student_enti();
			stud.setStud_id(rs.getString(1));
			stud.setStud_name(rs.getString(2));
			stud.setOriginal_dept(rs.getString(3));
			
			stud.setStud_class(rs.getString(4));
			stud.setStud_dob(rs.getString(5));
			stud.setStud_city(rs.getString(6));
			stud.setStud_taluka(rs.getString(7));
			stud.setStud_dist(rs.getString(8));
			stud.setStud_phone(rs.getString(9));
			stud.setStud_email(rs.getString(10));
			stud.setImage((Blob) rs.getBlob(11));
			stud.setBarr(stud.getImage().getBytes(1, (int)stud.getImage().length()));
			String enco = Base64.getEncoder().encodeToString(stud.getBarr());
			//stud.setEncodeimage(enco);
			stud.setEncodeimg("data:image/jpg;base64,"+enco);
			

			
				// ******** 
			String store_dept = rs.getString(3);
			
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
			
			stud.setStud_dept(dept);

				
			list.add(stud);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
}
	



	public List<Student_enti> get_search_student(String search_table, String search_content){
	
		List<Student_enti> list = new ArrayList<Student_enti>();
		Student_enti stud = null;
	
		
		try {
			
			
			
			
			String convert_dept = null;
			//System.out.print("\n Dept  : " search_content.getClass().getSimpleName());
			
			Student_enti stud_enti = new Student_enti();
			stud_enti.setSetSearch_student_table(search_table);
			stud_enti.setSetSearch_student_content(search_content);
		
			
			String qwe = "stud_dept";
			String asd = "stud_name";
			
			  if(stud_enti.getSetSearch_student_table().equals(qwe))
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
			  
			  
			  if(stud_enti.getSetSearch_student_table().equals(asd))
			  {
				  
				  String sql = "select * from students where stud_name LIKE '%"+search_content+ " %'";
					PreparedStatement ps = conn.prepareStatement(sql);	
				//	ps.setString(1, search_content);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						
						
						stud = new Student_enti();
						stud.setStud_id(rs.getString(1));
						stud.setStud_name(rs.getString(2));
						stud.setOriginal_dept(rs.getString(3));
					
						stud.setStud_class(rs.getString(4));
						stud.setStud_dob(rs.getString(5));
						stud.setStud_city(rs.getString(6));
						stud.setStud_taluka(rs.getString(7));
						stud.setStud_dist(rs.getString(8));
						stud.setStud_phone(rs.getString(9));
						stud.setStud_email(rs.getString(10));
						
						
						stud.setImage((Blob) rs.getBlob(11));
						stud.setBarr(stud.getImage().getBytes(1, (int)stud.getImage().length()));
						String enco = Base64.getEncoder().encodeToString(stud.getBarr());
						//stud.setEncodeimage(enco);
						stud.setEncodeimg("data:image/jpg;base64,"+enco);
						
						// ******** 
						String store_dept = rs.getString(3);
						
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
						
						stud.setStud_dept(dept);

							
						list.add(stud);
					}
						
				  
			  }else {
				  
				  String sql = "select * from students where "+search_table+"=? ";
					PreparedStatement ps = conn.prepareStatement(sql);	
					ps.setString(1, search_content);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						
						
						stud = new Student_enti();
						stud.setStud_id(rs.getString(1));
						stud.setStud_name(rs.getString(2));
						stud.setOriginal_dept(rs.getString(3));
					
						stud.setStud_class(rs.getString(4));
						stud.setStud_dob(rs.getString(5));
						stud.setStud_city(rs.getString(6));
						stud.setStud_taluka(rs.getString(7));
						stud.setStud_dist(rs.getString(8));
						stud.setStud_phone(rs.getString(9));
						stud.setStud_email(rs.getString(10));
						
						stud.setImage((Blob) rs.getBlob(11));
						stud.setBarr(stud.getImage().getBytes(1, (int)stud.getImage().length()));
						String enco = Base64.getEncoder().encodeToString(stud.getBarr());
						//stud.setEncodeimage(enco);
						stud.setEncodeimg("data:image/jpg;base64,"+enco);
						
						
						// ******** 
						String store_dept = rs.getString(3);
						
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
						
						stud.setStud_dept(dept);						
						list.add(stud);
						
				  
					}	
				}			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return list;
	}

	
	
	public boolean pramot_student_class(ArrayList<String> finala_arr, String pramot_class) {
		
		boolean f = false;
		
		try {
			
			String sql = "update students set stud_class=? where Stud_id=?";
			
			int leng = finala_arr.size();
			
			
			for(int j = 0; j<leng; j++) {
				
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, pramot_class);
				ps.setString(2, finala_arr.get(j));
				
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

	
	
	
	public boolean one_student_delete(String book_id) {
		boolean f = false;
		try {
			String sql = "delete from students where Stud_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book_id);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
	public boolean array_student_delete(ArrayList<String> finala_arr) {
		
		boolean f = false;
		
		try {
	
			String sql = "delete from students where Stud_id = ?";
			
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
	
	
	

	
	
	public List<Department_enti> classCalculate(String cls) {
		List<Department_enti> list = new ArrayList<Department_enti>();
		Department_enti dept = null;
		try {
			
			String sql = "select * from department where dept_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cls);
			
			ResultSet rs = ps.executeQuery();
			dept = new Department_enti();
			while(rs.next()){
				
				dept.setDept_id(rs.getString(1));
				dept.setDept_name(rs.getString(2));
				dept.setDept_dur(rs.getInt(3));		
			}
			
			String clsss = dept.getDept_name();
			int duration = dept.getDept_dur();
					
			System.out.print("duration "+duration);
			
			for(int i = 1;i <= duration; i++) {
				dept = new Department_enti();		
				dept.setFinal_class(clsss+ i);
				list.add(dept);
			}
			
			System.out.print(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	
	
	
	
}
