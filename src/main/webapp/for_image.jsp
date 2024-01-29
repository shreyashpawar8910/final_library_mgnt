<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.entity.Student_enti"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.img_css{
	height: 300px;
	width: 300px;
	border: 2px solid;

}

</style>

</head>
<body>
	<div class="img_css">
		
		
			<%
			
			
			
			Connection conn = DBConnect.getConn();
			Student_enti stud = new Student_enti();
			
			
			String stud_id = request.getParameter("stud_id");
			
			String sql = "select * from students where Stud_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stud_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stud.setBarr(rs.getBytes(11));
			}
			
		

				OutputStream img;
				response.setContentType("image/jpeg");
				response.setContentLengthLong(stud.getBarr().length);
				img = response.getOutputStream();
				img.write(stud.getBarr());
			
				
				
				img.flush();
				img.close();
				
		
			%>
		
		</div>
		
		
		
</body>

	
		
</html>