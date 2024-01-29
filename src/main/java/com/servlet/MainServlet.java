package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DB.DBConnect;
import com.dao.Dead_stockDAO;
import com.dao.DeptDAO;
import com.dao.FineDAO;
import com.dao.Original_bookDAO;
import com.dao.Original_journalDAO;
import com.dao.Original_magDAO;
import com.dao.PublisherDAO;
import com.dao.StaffDAO;
import com.dao.Stock_transection_studentDAO;
import com.dao.StudentDAO;
import com.dao.VenderDAO;
import com.dao.categoryDAO;
import com.dao.for_demo;
import com.dao.userDAO;
import com.entity.Fine_enti;
import com.entity.Magazine_enti;
import com.entity.Original_book_enti;
import com.entity.Original_journal_enti;
import com.entity.Staff_enti;
import com.entity.Student_enti;
import com.entity.Vender_enti;
import com.entity.book_category_enti;
import com.entity.library_department;
import com.entity.library_users;
import com.entity.publisher_enti;

/**
 * Servlet implementation class DepartmentServlet
 */

@WebServlet("/")
@MultipartConfig(maxFileSize = 16177216) // 1.5 mb
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPrcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doPrcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String url = request.getServletPath();

		switch (url) {

		
		
		
		
		//********************* Webmapping for new user Creation *******************
		//**************************************************************************
		
		
		case "/user_creation":
			new_user_creation(request, response);
			break;
		
			
		case "/user_updation":
			user_updation(request, response);
			break;
			
		case "/single_user_delet":
			user_delete(request, response);
			break;
	
			
			
			
			//********************* Webmapping for new Login *******************
			//**************************************************************************
			
			
		case "/login_user":
			login_users(request, response);
			break;
			
		case "/logout":
			logout_user(request, response);
			break;
			
		
		
		
		// ******* Webmapping using switch case for department master ******

		case "/department":
			dept_register(request, response);
			break;

		case "/dept_edit":
			dept_edit(request, response);
			break;

		case "/dept_delete":
			dept_delete(request, response);
			break;

			
			
		// ******* Webmapping using switch case for category master ******

		case "/save_category":
			category_register(request, response);
			break;

		case "/category_edit":
			category_edit(request, response);
			break;

		case "/cat_delete":
			category_delete(request, response);
			break;

			
			
		// ******* Webmapping using switch case for Vender master ******

		case "/vender_register":
			vender_register(request, response);
			break;

		case "/vender_edit":
			vender_edit(request, response);
			break;

		case "/vend_delete":
			vender_delete(request, response);
			break;

			
			
			
		// ******* Webmapping using switch case for Publisher master ******

		case "/publisher_register":
			publisher_register(request, response);
			break;

		case "/publisher_edit":
			publisher_edit(request, response);
			break;

		case "/publisher_delete":
			publisher_delete(request, response);
			break;

			
			
			
		// ******* Webmapping using switch case for Original Books master ******

		case "/original_book_register":
			original_book_register(request, response);
			break;

		case "/original_book_edit":
			original_book_edit(request, response);
			break;
			
		case "/single_book_delet":
			original_book_delete(request, response);
			break;

		case "/array_pass":
			original_book_array(request, response);
			break;
			
		case "/book_array_delete":
			original_book_array_delete(request, response);
			break;

			
			
			
		// ******* Webmapping using switch case for Original Journal master ******

		case "/original_journal_register":
			original_journal_register(request, response);
			break;
			
		case "/original_journal_edit":
			original_journal_edit(request, response);
			break;
			
		case "/single_journal_delet":
			original_one_journal_delete(request, response);
			break;
			
		case "/journal_array_delete":
			original_journal_array_delete(request, response);
			break;
			
		case "/journal_dead_stock":
			original_journal_dead_stock(request, response);
			break;

			
			
			
			// ******* Webmapping using switch case for Original Magazine master ******
			
		case "/original_magazine_register":
			Original_magazine_register(request, response);
			break;
			
		case "/original_magazine_update":
			Original_magazine_update(request, response);
			break;
			
		case "/single_mag_delet":
			Original_one_mag_delete(request, response);
			break;
			
		case "/magazine_array_delete":
			original_magazine_array_delete(request, response);
			break;
			
		case "/array_dead_stock_mag":
			original_magazine_dead_stock(request, response);
			break;
			
			
			
			
			
			
		// ******* Webmapping using switch case for Original Journal master ******

		case "/student_register":
			student_register(request, response);
			break;
			
		case "/stud_pramote":
			student_parmote(request, response);
			break;
			
		case "/student_update_one":
			student_update(request, response);
			break;
			
		case "/delete_one_stud":
			one_student_delete(request, response);
			break;
		
		case "/student_array_delete":
			array_student_delete(request,response);
			break;
			
			

			
			
			// ******* Webmapping using switch case for Staff Operation ******
			
			
			
		case "/staff_register":
			staff_register(request, response);
			break;
			
		case "/staff_update":
			staff_update(request, response);
			break;
			
			
			
			
			
			// ******* Webmapping using switch case for Transection of Stock with Students and Staff ******
			
			
		case "/check_studid":
			transection_scann_stud_staf(request, response);
			break;
		
		case "/check_stock_id":
			transection_scann_stock(request, response);
			break;
			
		case "/return_stock_id":
			return_scann_stock(request, response);
			break;
			
			
			
			
			// ******* Webmapping using switch case for Fine Calculation of Students and Staff ******
			
		case "/student_fine":
			fine_calculation(request, response);
			break;
			
			
			
			// ******* Webmapping using switch case for Dead Stock Tables Operations ******
		
		case "/dead_stock_array_delete":
			dead_stock_array_delete(request, response);
			break;
			
			
			
		default:
			break;
		}

	}

	
	
	
	
	
	
	// *********
		// *********
		// ********* Servlet web Mapping for Login ***********
		// *********
		// *********
	
	
	protected void login_users(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
	
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/main_library_mgnt","root","admin123");
			
			
			String user_name = request.getParameter("get_user_name");
			String password = request.getParameter("get_user_pass");
			
			
			
			String sql = "select user_role from users where user_email=? and user_password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
		
			String user_role = null;
	
			while(rs.next()) {
				user_role = rs.getString(1);
				
				
				HttpSession session = request.getSession();
				session.setAttribute("user_role", user_role);
				
				
				response.sendRedirect("Dashboard.jsp");
			
			}
			
			
			
			if(user_role==null) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "login faild");
				response.sendRedirect("index.jsp");
			
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	protected void logout_user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
	
			
			HttpSession session = request.getSession();
			session.removeAttribute("user_role");
			
			
			response.sendRedirect("index.jsp");
			return;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

	// *********
	// *********
	// ********* Servlet web Mapping for User Creation Table ***********
	// *********
	// *********
	
	
	
	
	protected void new_user_creation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String user_name = request.getParameter("user_name");
			String user_role = request.getParameter("user_role");
			String user_email = request.getParameter("user_email");
			String user_phone = request.getParameter("user_phone");
			String user_password = request.getParameter("user_password");
			
			library_users lib_us = new library_users();
			
			
			lib_us.setUser_name(user_name);
			lib_us.setUser_role(user_role);
			lib_us.setUser_email(user_email);
			lib_us.setUser_phone(user_phone);
			lib_us.setUser_password(user_password);
			
			
			
			userDAO dao = new userDAO(DBConnect.getConn());
			boolean f = dao.adduser(lib_us);
			
			if(f) {
			
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert");
				
				response.sendRedirect("user_creation.jsp");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "faild");
				response.sendRedirect("user_creation.jsp");
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected void user_updation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String user_name = request.getParameter("user_name");
			String user_role = request.getParameter("user_role");
			String user_email = request.getParameter("user_email");
			String user_phone = request.getParameter("user_phone");
			String user_password = request.getParameter("user_password");
		
			library_users us = new library_users();
			
			us.setUser_id(user_id);
			us.setUser_name(user_name);
			us.setUser_role(user_role);
			us.setUser_email(user_email);
			us.setUser_phone(user_phone);
			us.setUser_password(user_password);
			
			userDAO us_dao = new userDAO(DBConnect.getConn());
			
			boolean f = false;
			f = us_dao.edit_user(us);
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update sucess");
				
				response.sendRedirect("User_modify.jsp");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				response.sendRedirect("User_modify.jsp");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void user_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
	
			int user_id = Integer.parseInt(request.getParameter("single_user_id"));
			
			userDAO us_dao = new userDAO(DBConnect.getConn());
			
			boolean f  = false;
			f = us_dao.delete_user(user_id);
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete sucess");
				
				response.sendRedirect("User_modify.jsp");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("User_modify.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	// *********
	// *********
	// ********* Servlet web Mapping for Department Table ***********
	// *********
	// *********

	protected void dept_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String dept_id = request.getParameter("dept_id");
			String dept_name = request.getParameter("dept_name");
			String dept_dur = request.getParameter("dept_dur");

			library_department dept = new library_department();

			dept.setDept_id(dept_id);
			dept.setDept_name(dept_name);
			dept.setDept_dur(dept_dur);

			DeptDAO dao = new DeptDAO(DBConnect.getConn());

			boolean f = dao.add_department(dept);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert success");
				
				response.sendRedirect("department_register.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert faild");
				
				response.sendRedirect("department_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void dept_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String dept_id = request.getParameter("edit_dept_id");
			String dept_name = request.getParameter("edit_dept_name");
			String dept_dur = request.getParameter("edit_dept_dur");

			library_department dept = new library_department();

			dept.setDept_id(dept_id);
			dept.setDept_name(dept_name);
			dept.setDept_dur(dept_dur);

			DeptDAO dao = new DeptDAO(DBConnect.getConn());

			boolean f = dao.edit_department(dept);

			if (f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update success");
				
				response.sendRedirect("department_register.jsp");
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				
				response.sendRedirect("department_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dept_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String delt_dept_id = request.getParameter("dept_id");
			System.out.print(delt_dept_id);

			DeptDAO dao = new DeptDAO(DBConnect.getConn());

			boolean f = dao.delete_department(delt_dept_id);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("department_register.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("department_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// *********
	// *********
	// ********* Servlet web Mapping for Category Table ***********
	// *********
	// *********

	protected void category_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String bcat_id = request.getParameter("bcat_id");
			String bcat_name = request.getParameter("bcat_name");
			String bcat_type = request.getParameter("bcat_type");

			book_category_enti category = new book_category_enti();

			category.setBcat_id(bcat_id);
			category.setBcat_name(bcat_name);
			category.setBcat_type(bcat_type);

			categoryDAO dao = new categoryDAO(DBConnect.getConn());

			boolean f = dao.add_category(category);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert success");
				
				response.sendRedirect("book_category_register.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert faild");
				
				response.sendRedirect("book_category_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void category_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String bcat_id = request.getParameter("edit_cat_id");
			String bcat_name = request.getParameter("edit_cat_name");
			String bcat_type = request.getParameter("edit_cat_type");

			book_category_enti category = new book_category_enti();

			category.setBcat_id(bcat_id);
			category.setBcat_name(bcat_name);
			category.setBcat_type(bcat_type);

			categoryDAO dao = new categoryDAO(DBConnect.getConn());

			boolean f = dao.edit_category(category);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update success");
				
				response.sendRedirect("book_category_register.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				
				response.sendRedirect("book_category_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void category_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String delt_cat_id = request.getParameter("cat_id");

			categoryDAO dao = new categoryDAO(DBConnect.getConn());

			boolean f = dao.delete_category(delt_cat_id);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("book_category_register.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("book_category_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// *********
	// *********
	// ********* Servlet web Mapping for Vender Table ***********
	// *********
	// *********

	protected void vender_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String vend_name = request.getParameter("vend_name");
			String vend_address = request.getParameter("vend_address");
			String vend_city = request.getParameter("vend_city");
			String vend_taluka = request.getParameter("vend_taluka");
			String vend_dist = request.getParameter("vend_dist");
			String vend_email = request.getParameter("vend_email");
			String vend_phone = request.getParameter("vend_phone");

			Vender_enti vend = new Vender_enti();

			vend.setVend_name(vend_name);
			vend.setVend_address(vend_address);
			vend.setVend_city(vend_city);
			vend.setVend_taluka(vend_taluka);
			vend.setVend_dist(vend_dist);
			vend.setVend_email(vend_email);
			vend.setVend_phone(vend_phone);

			VenderDAO dao = new VenderDAO(DBConnect.getConn());

			boolean f = dao.add_vender(vend);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert success");
				
				response.sendRedirect("vender_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert faild");
				
				response.sendRedirect("vender_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void vender_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int vend_id = Integer.parseInt(request.getParameter("edit_vend_id"));
			String vend_name = request.getParameter("edit_vend_name");
			String vend_address = request.getParameter("edit_vend_address");
			String vend_city = request.getParameter("edit_vend_city");
			String vend_taluka = request.getParameter("edit_vend_taluka");
			String vend_dist = request.getParameter("edit_vend_dist");
			String vend_email = request.getParameter("edit_vend_email");
			String vend_phone = request.getParameter("edit_vend_phone");

			Vender_enti vend = new Vender_enti();

			vend.setVend_id(vend_id);
			vend.setVend_name(vend_name);
			vend.setVend_address(vend_address);
			vend.setVend_city(vend_city);
			vend.setVend_taluka(vend_taluka);
			vend.setVend_dist(vend_dist);
			vend.setVend_email(vend_email);
			vend.setVend_phone(vend_phone);

			VenderDAO dao = new VenderDAO(DBConnect.getConn());

			boolean f = dao.edit_vender(vend);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update success");
				
				response.sendRedirect("vender_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				
				response.sendRedirect("vender_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void vender_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int delt_vend_id = Integer.parseInt(request.getParameter("vend_id"));

			VenderDAO dao = new VenderDAO(DBConnect.getConn());

			boolean f = dao.delete_vender(delt_vend_id);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("vender_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("vender_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// *********
	// *********
	// ********* Servlet web Mapping for Publisher Table ***********
	// *********
	// *********

	protected void publisher_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String publ_name = request.getParameter("publ_name");
			String publ_address = request.getParameter("publ_address");
			String publ_city = request.getParameter("publ_city");
			String publ_taluka = request.getParameter("publ_taluka");
			String publ_dist = request.getParameter("publ_dist");
			String publ_email = request.getParameter("publ_email");
			String publ_phone = request.getParameter("publ_phone");

			publisher_enti publ = new publisher_enti();

			publ.setPubl_name(publ_name);
			publ.setPubl_address(publ_address);
			publ.setPubl_city(publ_city);
			publ.setPubl_taluka(publ_taluka);
			publ.setPubl_dist(publ_dist);
			publ.setPubl_email(publ_email);
			publ.setPubl_phone(publ_phone);

			PublisherDAO dao = new PublisherDAO(DBConnect.getConn());

			boolean f = dao.add_publisher(publ);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert success");
				
				response.sendRedirect("publisher_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert faild");
				
				response.sendRedirect("publisher_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void publisher_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int publi_id = Integer.parseInt(request.getParameter("edit_publ_id"));
			String publi_name = request.getParameter("edit_publ_name");
			String publi_address = request.getParameter("edit_publ_address");
			String publi_city = request.getParameter("edit_publ_city");
			String publi_taluka = request.getParameter("edit_publ_taluka");
			String publi_dist = request.getParameter("edit_publ_dist");
			String publi_email = request.getParameter("edit_publ_email");
			String publi_phone = request.getParameter("edit_publ_phone");

			publisher_enti publ = new publisher_enti();

			publ.setPubl_id(publi_id);
			publ.setPubl_name(publi_name);
			publ.setPubl_address(publi_address);
			publ.setPubl_city(publi_city);
			publ.setPubl_taluka(publi_taluka);
			publ.setPubl_dist(publi_dist);
			publ.setPubl_email(publi_email);
			publ.setPubl_phone(publi_phone);

			PublisherDAO dao = new PublisherDAO(DBConnect.getConn());

			boolean f = dao.edit_publi(publ);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update success");
				
				response.sendRedirect("publisher_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				
				response.sendRedirect("publisher_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void publisher_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int delt_publ_id = Integer.parseInt(request.getParameter("publ_id"));

			PublisherDAO dao = new PublisherDAO(DBConnect.getConn());

			boolean f = dao.delete_publisher(delt_publ_id);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("publisher_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("publisher_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	protected void original_book_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			
			String book_dept = request.getParameter("book_dept");
			String book_category = request.getParameter("book_category");
			String book_classi_no = request.getParameter("book_Clasif_No");
			String book_title = request.getParameter("book_title");
			String book_sub_title = request.getParameter("book_sub_title");
			String book_subject = request.getParameter("book_subj");
			String book_edition = request.getParameter("book_edition");
			int book_copies = Integer.parseInt(request.getParameter("book_copies"));
			String book_author_name = request.getParameter("book_author");
			String book_publi_name = request.getParameter("book_publisher");
			String book_publi_year = request.getParameter("book_publ_year");
			String book_vender_name = request.getParameter("book_vend_name");
			String book_pages = request.getParameter("book_pages");
			double book_price = Double.parseDouble(request.getParameter("book_price"));
			String book_rack_no = request.getParameter("book_rack_no");
			String book_language = request.getParameter("book_language");

			Original_book_enti or_book = new Original_book_enti();

			
			or_book.setBook_dept(book_dept);
			or_book.setBook_catrgory(book_category);
			or_book.setBook_classif_no(book_classi_no);
			or_book.setBook_title(book_title);
			or_book.setBook_sub_title(book_sub_title);
			or_book.setBook_subject(book_subject);
			or_book.setBook_edition(book_edition);
			or_book.setBook_no_copies(book_copies);
			or_book.setBook_author(book_author_name);
			or_book.setBook_publisher(book_publi_name);
			or_book.setBook_publi_year(book_publi_year);
			or_book.setBook_vend_nm(book_vender_name);
			or_book.setBook_pages(book_pages);
			or_book.setBook_price(book_price);
			or_book.setBook_rack_no(book_rack_no);
			or_book.setBook_language(book_language);

			Original_bookDAO dao = new Original_bookDAO(DBConnect.getConn());

			boolean f = false;
			boolean ff = false;
			int i = 0;
			while (or_book.getBook_no_copies() > i) {
				boolean p = dao.one_id_Original_book(or_book);
				f = dao.add_Original_book(or_book);
				ff = dao.generate_book_QR(or_book);
				i++;
			}

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert");
				
				response.sendRedirect("Book_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "faild");
				
				response.sendRedirect("Book_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void original_book_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String book_id = request.getParameter("book_id");
			String book_dept = request.getParameter("book_dept");
			String book_category = request.getParameter("book_category");
			String book_classi_no = request.getParameter("book_Clasif_No");
			String book_title = request.getParameter("book_title");
			String book_sub_title = request.getParameter("book_sub_title");
			String book_subject = request.getParameter("book_subj");
			String book_edition = request.getParameter("book_edition");

			String book_author_name = request.getParameter("book_author");
			String book_publi_name = request.getParameter("book_publisher");
			String book_publi_year = request.getParameter("book_publ_year");
			String book_vender_name = request.getParameter("book_vend_name");
			String book_pages = request.getParameter("book_pages");
			double book_price = Double.parseDouble(request.getParameter("book_price"));
			String book_rack_no = request.getParameter("book_rack_no");
			String book_language = request.getParameter("book_language");

			Original_book_enti or_book = new Original_book_enti();

			or_book.setBook_id(book_id);
			or_book.setBook_dept(book_dept);
			or_book.setBook_catrgory(book_category);
			or_book.setBook_classif_no(book_classi_no);
			or_book.setBook_title(book_title);
			or_book.setBook_sub_title(book_sub_title);
			or_book.setBook_subject(book_subject);
			or_book.setBook_edition(book_edition);
			or_book.setBook_author(book_author_name);
			or_book.setBook_publisher(book_publi_name);
			or_book.setBook_publi_year(book_publi_year);
			or_book.setBook_vend_nm(book_vender_name);
			or_book.setBook_pages(book_pages);
			or_book.setBook_price(book_price);
			or_book.setBook_rack_no(book_rack_no);
			or_book.setBook_language(book_language);

			Original_bookDAO dao = new Original_bookDAO(DBConnect.getConn());

			boolean f = dao.edit_original_book(or_book);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update");
				
				response.sendRedirect("Display_book_data.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				response.sendRedirect("Display_book_data.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private void original_book_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			
			String delete_book_id = request.getParameter("single_book_id");

			Original_bookDAO dao = new Original_bookDAO(DBConnect.getConn());

			boolean f = dao.delete_original_book(delete_book_id);

			if (f) {
				System.out.print("Data Delete succesfull");
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_book_data.jsp");
			} else {
				System.out.print("Data Delete faild");
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("Display_book_data.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	

	protected void original_book_array(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String reason = request.getParameter("dead_stock_reason");
			String[] arr = request.getParameterValues("demo_array");
			

			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

		

			//String[] final_String = {};
			  
			  
			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			 

					Original_bookDAO dao = new Original_bookDAO(DBConnect.getConn());
					
					boolean f = false;
					
					f = dao.shift_deadstock_book(finala_arr, reason);
			 
					if (f) {
						HttpSession session = request.getSession();
						session.setAttribute("succmsg", "dead_stock_success");
						response.sendRedirect("Display_book_data.jsp");
					} else {
						HttpSession session = request.getSession();
						session.setAttribute("succmsg", "dead_stock_faild");
						response.sendRedirect("Display_book_data.jsp");
					}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	protected void original_book_array_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String arr[] = request.getParameterValues("delete_array_book");
			
			
			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			Original_bookDAO dao = new Original_bookDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.delete_original_book_array(finala_arr);
			
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_book_data.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("Display_book_data.jsp");
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

	/*
	 * protected void original_book_search(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try {
	 * 
	 * String serch_table = request.getParameter("search_table_name"); String
	 * serch_cont = request.getParameter("search_content");
	 * 
	 * Original_bookDAO dao = new Original_bookDAO(DBConnect.getConn());
	 * 
	 * dao.setSearch_table(serch_table); dao.setSearch_content(serch_cont);
	 * 
	 * }catch(Exception e){ e.printStackTrace(); } }
	 */

	// *********
	// *********
	// ********* Servlet web Mapping for Journal Table ***********
	// *********
	// *********

	protected void original_journal_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			
			String journal_dept = request.getParameter("journal_dept");
			String journal_category = request.getParameter("journal_category");
			String journal_classi_no = request.getParameter("journal_Clasif_No");
			String journal_title = request.getParameter("journal_title");
			String journal_sub_title = request.getParameter("journal_sub_title");
			String journal_subject = request.getParameter("journal_subj");
			String journal_edition = request.getParameter("journal_edition");
			int journal_copies = Integer.parseInt(request.getParameter("journal_copies"));
			String journal_author_name = request.getParameter("journal_author");
			String journal_publi_name = request.getParameter("journal_publisher");
			String journal_publi_year = request.getParameter("journal_publ_year");
			String journal_vender_name = request.getParameter("journal_vend_name");
			String journal_pages = request.getParameter("journal_pages");
			double journal_price = Double.parseDouble(request.getParameter("journal_price"));
			String journal_rack_no = request.getParameter("journal_rack_no");
			String journal_language = request.getParameter("journal_language");

			Original_journal_enti or_journal = new Original_journal_enti();

		
			or_journal.setJournal_dept(journal_dept);
			or_journal.setJournal_catrgory(journal_category);
			or_journal.setJournal_classif_no(journal_classi_no);
			or_journal.setJournal_title(journal_title);
			or_journal.setJournal_sub_title(journal_sub_title);
			or_journal.setJournal_subject(journal_subject);
			or_journal.setJournal_edition(journal_edition);
			or_journal.setJournal_no_copies(journal_copies);
			or_journal.setJournal_author(journal_author_name);
			or_journal.setJournal_publisher(journal_publi_name);
			or_journal.setJournal_publi_year(journal_publi_year);
			or_journal.setJournal_vend_nm(journal_vender_name);
			or_journal.setJournal_pages(journal_pages);
			or_journal.setJournal_price(journal_price);
			or_journal.setJournal_rack_no(journal_rack_no);
			or_journal.setJournal_language(journal_language);

			Original_journalDAO dao = new Original_journalDAO(DBConnect.getConn());

			boolean f = false;
			boolean ff = false;

			int i = 0;

			while (or_journal.getJournal_no_copies() > i) {
				boolean p = dao.one_id_Original_journal(or_journal);
				f = dao.add_Original_journal(or_journal);
				ff = dao.generate_journal_QR(or_journal);
				i++;
			}

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert");
				
				response.sendRedirect("Journal_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "faild");
				
				response.sendRedirect("Journal_master.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	protected void original_journal_edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String journal_id = request.getParameter("journal_id");
			String journal_dept = request.getParameter("journal_dept");
			String journal_category = request.getParameter("journal_category");
			String journal_classi_no = request.getParameter("journal_Clasif_No");
			String journal_title = request.getParameter("journal_title");
			String journal_sub_title = request.getParameter("journal_sub_title");
			String journal_subject = request.getParameter("journal_subj");
			String journal_edition = request.getParameter("journal_edition");
			
			String journal_author_name = request.getParameter("journal_author");
			String journal_publi_name = request.getParameter("journal_publisher");
			String journal_publi_year = request.getParameter("journal_publ_year");
			String journal_vender_name = request.getParameter("journal_vend_name");
			String journal_pages = request.getParameter("journal_pages");
			double journal_price = Double.parseDouble(request.getParameter("journal_price"));
			String journal_rack_no = request.getParameter("journal_rack_no");
			String journal_language = request.getParameter("journal_language");
			
			
			
			Original_journal_enti or_journal = new Original_journal_enti();

			or_journal.setJournal_id(journal_id);
			or_journal.setJournal_dept(journal_dept);
			or_journal.setJournal_catrgory(journal_category);
			or_journal.setJournal_classif_no(journal_classi_no);
			or_journal.setJournal_title(journal_title);
			or_journal.setJournal_sub_title(journal_sub_title);
			or_journal.setJournal_subject(journal_subject);
			or_journal.setJournal_edition(journal_edition);

			or_journal.setJournal_author(journal_author_name);
			or_journal.setJournal_publisher(journal_publi_name);
			or_journal.setJournal_publi_year(journal_publi_year);
			or_journal.setJournal_vend_nm(journal_vender_name);
			or_journal.setJournal_pages(journal_pages);
			or_journal.setJournal_price(journal_price);
			or_journal.setJournal_rack_no(journal_rack_no);
			or_journal.setJournal_language(journal_language);

			Original_journalDAO dao = new Original_journalDAO(DBConnect.getConn());

			boolean f = false;
			
			f = dao.Original_journal_edit(or_journal);
		

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update");
				
				response.sendRedirect("Display_journal_data.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				response.sendRedirect("Display_journal_data.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	protected void original_one_journal_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
	
			
			String or_jr = request.getParameter("single_book_id");
			
			Original_journalDAO dao = new Original_journalDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.delete_original_journal(or_jr);
			

			if (f) {
				
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_journal_data.jsp");
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("Display_journal_data.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	protected void original_journal_array_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String arr[] = request.getParameterValues("delete_array_journal");
			
			
			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			Original_journalDAO dao = new Original_journalDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.delete_original_journal_array(finala_arr);
			
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_journal_data.jsp");
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("Display_journal_data.jsp");
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	protected void original_journal_dead_stock(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String reason = request.getParameter("dead_stock_reason");
			String[] arr = request.getParameterValues("demo_array");
			

			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

		

			//String[] final_String = {};
			  
			  
			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			 

					Original_journalDAO dao = new Original_journalDAO(DBConnect.getConn());
					
					boolean f = false;
					
					f = dao.shift_dead_stock_journal(finala_arr, reason);
			 
					if (f) {
						
						HttpSession session = request.getSession();
						session.setAttribute("succmsg", "dead_stock_success");
						response.sendRedirect("Display_journal_data.jsp");
					} else {
						
						HttpSession session = request.getSession();
						session.setAttribute("succmsg", "dead_stock_faild");
						response.sendRedirect("Display_journal_data.jsp");
					}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	

	// *********
	// *********
	// ********* Servlet web Mapping for Magazine Table ***********
	// *********
	// *********
	
	
	

	protected void Original_magazine_register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		try {
			
			
			String mag_dept = request.getParameter("magazine_dept");
			String mag_cat = request.getParameter("magazine_category");
			String mag_classi_no = request.getParameter("magazine_Clasif_No");
			String mag_title = request.getParameter("magazine_title");
			String mag_sub_title = request.getParameter("magazine_sub_title");
			
			String mag_edition = request.getParameter("magazine_edition");
			int mag_no_of_copies =Integer.parseInt(request.getParameter("magazine_copies"));
			String mag_author = request.getParameter("magazine_author");
			String mag_publi_name = request.getParameter("magazine_publisher");
			String mag_publi_yy = request.getParameter("magazine_publ_year");
			String mag_vend_name = request.getParameter("book_vend_name");
			String mag_pages = request.getParameter("magazine_pages");
			Double mag_price = Double.parseDouble(request.getParameter("magazine_price"));
			String mag_rack_no = request.getParameter("magazine_rack_no");
			String mag_lang = request.getParameter("magazine_language");
			
			
			Magazine_enti mag_enti = new Magazine_enti();
			
			mag_enti.setMag_dept(mag_dept);
			mag_enti.setMag_catrgory(mag_cat);
			mag_enti.setMag_classif_no(mag_classi_no);
			mag_enti.setMag_title(mag_title);
			mag_enti.setMag_sub_title(mag_sub_title);
			
			mag_enti.setMag_edition(mag_edition);
			mag_enti.setMag_no_copies(mag_no_of_copies);
			mag_enti.setMag_author(mag_author);
			mag_enti.setMag_publisher(mag_publi_name);
			mag_enti.setMag_publi_year(mag_publi_yy);
			mag_enti.setMag_vend_nm(mag_vend_name);
			mag_enti.setMag_pages(mag_pages);
			mag_enti.setMag_price(mag_price);
			mag_enti.setMag_rack_no(mag_rack_no);
			mag_enti.setMag_language(mag_lang);
			
		
			
			Original_magDAO dao = new Original_magDAO(DBConnect.getConn());
			
			boolean f = false;
			boolean ff = false;

			int i = 0;

			while (mag_enti.getMag_no_copies() > i) {
				
				boolean p = dao.one_id_Original_magazine(mag_enti);
				
				f = dao.add_Original_magazine(mag_enti);
				ff = dao.generate_magazine_QR(mag_enti);
				i++;
			}
			
			
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert");
				
				response.sendRedirect("Magazine_master.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "faild");
				
				response.sendRedirect("Magazine_master.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	protected void Original_magazine_update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
			try {
			
				
				String mag_id = request.getParameter("magazine_edit_id");
				String mag_dept = request.getParameter("magazine_edit_id");
				String mag_cat = request.getParameter("magazine_cat");
				String mag_classi_no = request.getParameter("magazine_Clasif_No");
				String mag_title = request.getParameter("magazine_title");
				String mag_sub_title = request.getParameter("magazine_sub_title");			
				String mag_edition = request.getParameter("magazine_edition");
				String mag_author = request.getParameter("magazine_author");
				String mag_publi_name = request.getParameter("magazine_publisher");
				String mag_publi_yy = request.getParameter("magazine_publ_year");
				String mag_vend_name = request.getParameter("book_vend_name");
				String mag_pages = request.getParameter("magazine_pages");
				Double mag_price = Double.parseDouble(request.getParameter("magazine_price"));
				String mag_rack_no = request.getParameter("magazine_rack_no");
				String mag_lang = request.getParameter("magazine_language");
				
				
				Magazine_enti mag_enti = new Magazine_enti();
				
				mag_enti.setMag_id(mag_id);
				mag_enti.setMag_dept(mag_dept);
				mag_enti.setMag_catrgory(mag_cat);
				mag_enti.setMag_classif_no(mag_classi_no);
				mag_enti.setMag_title(mag_title);
				mag_enti.setMag_sub_title(mag_sub_title);
				mag_enti.setMag_edition(mag_edition);		
				mag_enti.setMag_author(mag_author);
				mag_enti.setMag_publisher(mag_publi_name);
				mag_enti.setMag_publi_year(mag_publi_yy);
				mag_enti.setMag_vend_nm(mag_vend_name);
				mag_enti.setMag_pages(mag_pages);
				mag_enti.setMag_price(mag_price);
				mag_enti.setMag_rack_no(mag_rack_no);
				mag_enti.setMag_language(mag_lang);
				
				Original_magDAO dao = new Original_magDAO(DBConnect.getConn());
				
				boolean f = dao.edit_original_magzine(mag_enti);
				
				if (f) {
					HttpSession session = request.getSession();
					session.setAttribute("succmsg", "update");
					
					response.sendRedirect("Display_magazine_data.jsp");
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("succmsg", "update faild");
					
					response.sendRedirect("Display_magazine_data.jsp");
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
	
	protected void Original_one_mag_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		try {
	
			String id = request.getParameter("single_mag_id");
			
			Magazine_enti mag_enti = new Magazine_enti();
			
			mag_enti.setMag_id(id);
			
			Original_magDAO dao = new Original_magDAO(DBConnect.getConn());
			boolean f = dao.one_magzine_delete(mag_enti);
			
			
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_magazine_data.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("Display_magazine_data.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	protected void original_magazine_array_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String arr[] = request.getParameterValues("delete_array_magazine");
			
			
			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			Original_magDAO dao = new Original_magDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.delete_original_magazine_array(finala_arr);
			
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_magazine_data.jsp");
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("Display_magazine_data.jsp");
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	protected void original_magazine_dead_stock(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String reason = request.getParameter("dead_stock_reason");
			String[] arr = request.getParameterValues("demo_array");
			

			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

		

			//String[] final_String = {};
			  
			  
			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			 

			Original_magDAO dao = new Original_magDAO(DBConnect.getConn());
					
					boolean f = false;
					
					f = dao.shift_dead_stock_magazine(finala_arr, reason);
			 
					if (f) {
						
						HttpSession session = request.getSession();
						session.setAttribute("succmsg", "dead_stock_success");
						response.sendRedirect("Display_magazine_data.jsp");
					} else {
						
						HttpSession session = request.getSession();
						session.setAttribute("succmsg", "dead_stock_faild");
						response.sendRedirect("Display_magazine_data.jsp");
					}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	

	// *********
	// *********
	// ********* Servlet web Mapping for Student Table ***********
	// *********
	// *********
	
	

	protected void student_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Part p = request.getPart("stud_photo");

			if (p != null) {

				String stud_id = request.getParameter("stud_id");
				String stud_name = request.getParameter("stud_name");
				String stud_dept = request.getParameter("stud_dept");
				String stud_class = request.getParameter("stud_class");
				String stud_date_or_birth = request.getParameter("stud_date_of_birth");
				String stud_city = request.getParameter("stud_city");
				String stud_taluka = request.getParameter("stud_taluka");
				String stud_dist = request.getParameter("stud_dist");
				String stud_phone = request.getParameter("stud_phone");
				String stud_email = request.getParameter("stud_email");

				Student_enti std_regis = new Student_enti();

				InputStream stream = p.getInputStream();

				std_regis.setStud_id(stud_id);
				std_regis.setStud_name(stud_name);
				std_regis.setStud_dept(stud_dept);
				std_regis.setStud_class(stud_class);
				std_regis.setStud_dob(stud_date_or_birth);
				std_regis.setStud_city(stud_city);
				std_regis.setStud_taluka(stud_taluka);
				std_regis.setStud_dist(stud_dist);
				std_regis.setStud_phone(stud_phone);
				std_regis.setStud_email(stud_email);
				std_regis.setStud_photo(stud_phone);
				std_regis.setInputStream(stream);

				Connection conn = DBConnect.getConn();

				StudentDAO dao = new StudentDAO(DBConnect.getConn());
				for_demo dao1 = new for_demo(DBConnect.getConn());

				boolean f = false;
				boolean ff = false;

				f = dao.add_student(std_regis, stream);

				ff = dao1.generate_demo_QR();

				
				
				if(f) {
					
					HttpSession session = request.getSession();
					session.setAttribute("succmsg", "insert");
					
					response.sendRedirect("Student_register.jsp");
					
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("succmsg", "faild");
					
					response.sendRedirect("Student_register.jsp");
				}
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	protected void student_update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			Part p = null;
			
			p = request.getPart("edit_stud_photo");
			
			String stud_id = request.getParameter("edit_stud_id");
			String stud_name = request.getParameter("edit_stud_name");
			String stud_dept = request.getParameter("edit_stud_dept");
			String stud_class = request.getParameter("edit_stud_class");
			String stud_date_or_birth = request.getParameter("edit_stud_dob");
			String stud_city = request.getParameter("edit_stud_city");
			String stud_taluka = request.getParameter("edit_stud_taluka");
			String stud_dist = request.getParameter("edit_stud_dist");
			String stud_phone = request.getParameter("edit_stud_phone");
			String stud_email = request.getParameter("edit_stud_email");

			Student_enti std_regis = new Student_enti();
			
			
			InputStream stream = p.getInputStream();	

			std_regis.setStud_id(stud_id);
			std_regis.setStud_name(stud_name);
			std_regis.setStud_dept(stud_dept);
			std_regis.setStud_class(stud_class);
			std_regis.setStud_dob(stud_date_or_birth);
			std_regis.setStud_city(stud_city);
			std_regis.setStud_taluka(stud_taluka);
			std_regis.setStud_dist(stud_dist);
			std_regis.setStud_phone(stud_phone);
			std_regis.setStud_email(stud_email);
			std_regis.setStud_photo(stud_phone);
			
			
			std_regis.setInputStream(stream);

			Connection conn = DBConnect.getConn();

			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			
			boolean f = false;
			
			
			
			f = dao.student_update(std_regis, stream);
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update success");
				
				response.sendRedirect("Display_students_data.jsp");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				
				response.sendRedirect("Display_students_data.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	protected void one_student_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {

			String book_id = request.getParameter("book_id");
			
			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.one_student_delete(book_id);
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_students_data.jsp");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("Display_students_data.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	protected void array_student_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
	

			String arr[] = request.getParameterValues("delete_array_stud");
			
			
			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			
			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.array_student_delete(finala_arr);
			
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_students_data.jsp");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				
				response.sendRedirect("Display_students_data.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
			
	

	
	protected void student_parmote(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
	
			
			String promot_class = request.getParameter("student_pramote_class");
			String[] arr = request.getParameterValues("pramote_stud_id");
			

			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;


			//String[] final_String = {};
			System.out.print("Pramote Class"+promot_class);
			  
			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			 
			
			
			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			boolean f= false;
			
			
			
			f = dao.pramot_student_class(finala_arr, promot_class);
			
			
			
			if (f) {
				System.out.print("Data Update succesful");
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "pramot success");
				response.sendRedirect("Display_students_data.jsp");
			} else {
				System.out.print("Data Update faild");
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "pramot faild");
				response.sendRedirect("Display_students_data.jsp");
			}
		
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}			
	
	
	
	
	
	

	
	// *********
		// *********
		// ********* Servlet web Mapping for Book transection of Staff ***********
		// *********
		// *********
	
	
	

	protected void staff_register(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		try {
	
			Part p = null;
			
			p = request.getPart("staff_photo");
			
			String staff_id = request.getParameter("staff_id");
			String staff_name = request.getParameter("staff_name");
			String staff_dept = request.getParameter("staff_dept");
			String staff_dob = request.getParameter("staff_date_of_birth");
			String staff_city = request.getParameter("staff_city");
			String staff_taluka = request.getParameter("staff_taluka");
			String staff_dist = request.getParameter("staff_dist");
			String staff_phone = request.getParameter("staff_phone");
			String staff_email = request.getParameter("staff_email");
			InputStream stream = p.getInputStream();
			
			
			Staff_enti stff = new Staff_enti();
			
			stff.setStaff_id(staff_id);
			stff.setStaff_name(staff_name);
			stff.setStaff_dept(staff_dept);
			stff.setStaff_dob(staff_dob);
			stff.setStaff_city(staff_city);
			stff.setStaff_taluka(staff_taluka);
			stff.setStaff_dist(staff_dist);
			stff.setStaff_phone(staff_phone);
			stff.setStaff_email(staff_email);
			stff.setInputStream(stream);
			
			Connection conn = DBConnect.getConn();

			StaffDAO dao = new StaffDAO(conn);
			
			boolean f = false;
			
			f = dao.add_stff(stff, stream);
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "insert");
				
				response.sendRedirect("Staff_register.jsp");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "faild");
				
				response.sendRedirect("Staff_register.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
protected void staff_update(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		try {


			Part p = null;
			
			p = request.getPart("staff_photo");
			
			String staff_id = request.getParameter("staff_id");
			String staff_name = request.getParameter("staff_name");
			String staff_dept = request.getParameter("staff_dept");
			String staff_dob = request.getParameter("staff_date_of_birth");
			String staff_city = request.getParameter("staff_city");
			String staff_taluka = request.getParameter("staff_taluka");
			String staff_dist = request.getParameter("staff_dist");
			String staff_phone = request.getParameter("staff_phone");
			String staff_email = request.getParameter("staff_email");
			InputStream stream = p.getInputStream();
			
			

			Staff_enti stff = new Staff_enti();
			
			stff.setStaff_id(staff_id);
			stff.setStaff_name(staff_name);
			stff.setStaff_dept(staff_dept);
			stff.setStaff_dob(staff_dob);
			stff.setStaff_city(staff_city);
			stff.setStaff_taluka(staff_taluka);
			stff.setStaff_dist(staff_dist);
			stff.setStaff_phone(staff_phone);
			stff.setStaff_email(staff_email);
			stff.setInputStream(stream);
			
			Connection conn = DBConnect.getConn();

			StaffDAO dao = new StaffDAO(conn);
			
			boolean f = false;
			

			f = dao.update_stff(stff, stream);
			
			if(f) {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update success");
				
				response.sendRedirect("Display_staff_data.jsp");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "update faild");
				
				response.sendRedirect("Display_staff_data.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
}
	
	
	
	
	
	
	
	
	
	
	
	// *********
		// *********
		// ********* Servlet web Mapping for Book transection of students ***********
		// *********
		// *********
	
	
	
	public String demoStr;
	public String demoprof;
	
	
	protected void transection_scann_stud_staf(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		try {
			
			String content = request.getParameter("scann_stud_id");
			String profile = request.getParameter("candi_type");
			
			demoStr = content;
			demoprof = profile;
			
			Stock_transection_studentDAO dao = new Stock_transection_studentDAO(DBConnect.getConn());
			
			boolean f;
			
		
			
			f = dao.check_stud_present_ornot(content, profile);
			
			if(f) {
				
				
				response.sendRedirect("Input_QR_books.jsp");
				
				
			}else {
				
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "notavailable");	
				
				response.sendRedirect("Input_QR_stud_staff.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
protected void 	transection_scann_stock(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		try {
			
			String content = request.getParameter("scann_book_id");
			String profile = request.getParameter("stock_type");
			
			String candi_id = demoStr;
			String candi_profile = demoprof;
			
			Stock_transection_studentDAO dao = new Stock_transection_studentDAO(DBConnect.getConn());
			
			boolean f;
			
			
			
			f = dao.check_stock_present_ornot(content, profile, candi_id, candi_profile);
			
			if(f) {
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "available");	
				
				response.sendRedirect("Input_QR_stud_staff.jsp");
				
			}else {
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "notavailable");	
				
				response.sendRedirect("Input_QR_books.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
}

	
	protected void 	return_scann_stock(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	
		try {
			
			String content = request.getParameter("scann_book_id");
			String profile = request.getParameter("stock_type");
			
			
			Stock_transection_studentDAO dao = new Stock_transection_studentDAO(DBConnect.getConn());
			
			boolean f;
			
			f = dao.return_stock(content, profile, request, response);
			
			

			if(f) {
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "returned");	
				
				response.sendRedirect("Return_stock_QR_scan.jsp");
				
			}else {
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "not_returned");	
				
				response.sendRedirect("Return_stock_QR_scan.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	

	protected void 	fine_calculation(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		try {
	
			
			Fine_enti f_enti = new Fine_enti();
			
			f_enti.setFine_tran_id(request.getParameter("fine_tr_id"));
			f_enti.setFine_stud_id(request.getParameter("fine_student_id"));
			f_enti.setFine_book_id(request.getParameter("fine_book_id"));
			f_enti.setFine_stud_name(request.getParameter("fine_stud_name"));
			f_enti.setFine_book_name(request.getParameter("fine_issu_book"));
			f_enti.setFine_issue_date(request.getParameter("fine_issu_date"));
			f_enti.setFine_last_date(request.getParameter("fine_last_date"));
			f_enti.setFine_late_days(request.getParameter("fine_late_days"));
			f_enti.setProfile(request.getParameter("fine_book_profile"));
			f_enti.setStud_dept(request.getParameter("stud_dept"));
			
			
			
			double fine_amount = Double.parseDouble(request.getParameter("fine_amount")); 
			f_enti.setFine_amount(fine_amount);
			
			
			FineDAO dao = new FineDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.fine_register(f_enti);
			
			
			if(f) {
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "returned");	
				
				response.sendRedirect("Return_stock_QR_scan.jsp");
				
			}else {
				
				HttpSession session=request.getSession();
				session.setAttribute("succMsg", "not_returned");	
				
				response.sendRedirect("Return_stock_QR_scan.jsp");
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
	
			
	
	
			
	
	
	// *********
		// *********
		// ********* Servlet web Mapping for Dead Stock Table Operations ***********
		// *********
		// *********
	
	
	

	protected void dead_stock_array_delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		try {
			
			String arr[] = request.getParameterValues("delete_array_deadstock");
			
			
			String dem = arr[0];

			String[] strsplit = dem.split(",");
			int leng = strsplit.length;

			ArrayList<String> finala_arr = new ArrayList<String>();
			 
			for(int i=0; i<leng; i++) {
				  
				  if(strsplit[i]!="") {
					  finala_arr.add(strsplit[i]) ; 
					  
				  }
			  
			  }
			Dead_stockDAO dao = new Dead_stockDAO(DBConnect.getConn());
			
			boolean f = false;
			
			f = dao.delete_dead_stock_array(finala_arr);
			
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete success");
				
				response.sendRedirect("Display_dead_stock.jsp");
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("succmsg", "delete faild");
				response.sendRedirect("Display_dead_stock.jsp");
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
