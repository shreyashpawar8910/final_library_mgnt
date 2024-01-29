package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginservlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/main_library_mgnt","root","admin123");
			
			
			String em = req.getParameter("login_email");
			String ps = req.getParameter("login_password");
			String sql = "select user_email from users where user_email=? and user_password=?";
			
			PreparedStatement prp = conn.prepareStatement(sql);
			prp.setString(1, em);
			prp.setString(2, ps);
			ResultSet rs = prp.executeQuery();			
			if(rs.next()) {
				resp.sendRedirect("all_component/lbl_side_nav.jsp");
			}
			else {
				resp.sendRedirect("user_creation.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
