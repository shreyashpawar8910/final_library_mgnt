<%@page import="com.entity.library_department"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Register</title>


<style type="text/css">


.staff_container{
	margin-left: 250px;
	margin-top: 0px;
	height: 100%;
	width: 82%;
	
}

.page_haiding{
		background: #437fc7;
		text-align: center;
		

		color: white;
}
page_haiding h3{
	text-align: center;
}

.row_design{
	margin-top: 50px;
}

.row .col .btn{
	height: 35px;
	width: 90px;
	border: 1px solid;
}

.row{
	width: 100%;
	padding-left: 60px;
	margin: 10px; 
	opacity: 10;
	font-size: 17px;
}
.row .col input{
	height: 35px;
	width: 280px;
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}

.row .col select{
	height: 35px;
	width: 280px;
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}

.row .col button{
	height: 35px;
	width: 280px;
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}

.row .col .btn a{
	color: black;
	text-decoration: none;
}

.card{
	width: 1080px;
	margin-left: 30px;
}

.table-bordered {
	border: 1px solid;
}

.card{
	height: 250px;
	max-height: 250px;
	overflow: scroll;
}
table tr td a{
	text-decoration: none;
	color: black;
	
}

table tr td a a{
	cursor: pointer;
	text-decoration: none;

}
table{
	text-align: center;
}

</style>



</head>

<body>
	
	<%@include file="lbl_side_nav.jsp" %>
	
	
	 <%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succmsg");
    		   
    		   
    		   %>	 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="faild"){
    		 		
    		 		swal("Error", "Student Registration Faild", "error");
    		 	}
    		 	else if(msggg=="insert"){
    		 		
    		 		swal("Success", "Student Registration Sucessfull", "success");
    		 		
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
	
	
	
	
	<div class="staff_container">	
	
	<div class="page_haiding">
		<h3>Staff Registration</h3>
	</div>
	
	
	<div class="row_design">
		<form action="staff_register" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col">Staff ID</div>
			<div class="col">Staff Name</div>
			<div class="col">Department</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Staff Id"  name="staff_id" required="required" > </div>
			<div class="col"><input type="text" placeholder="Staff Full Name"  name="staff_name" required="required" > </div>
			
			
				<div class="col"><select  name="staff_dept" required="required" >
				<option value="-1"> Select Department</option>			
				<%
					try{
						
						DeptDAO dao = new DeptDAO(DBConnect.getConn());
						List<library_department> list = dao.getAlldept();
						for(library_department dept:list){
						%>
						<option value="<%=dept.getDept_id()%>"><%=dept.getDept_name() %></option>
						
						<%							
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				%>	
				
				</select> </div>
		</div>
		
		<br>
		
		<div class="row">
			
			<div class="col">Date of Birth</div>
			<div class="col">City</div>
			<div class="col">Taluka</div>
		</div>		
		
		<div class="row">
			
			<div class="col"><input type="date" name="staff_date_of_birth" required="required"> </div>
			<div class="col"><input type="text" placeholder="City" name="staff_city" required="required"> </div>
			<div class="col"><input type="text" placeholder="Taluka" name="staff_taluka" required="required" > </div>
		</div>
				
		<br>
		
		<div class="row">
			
			<div class="col">District</div>
			<div class="col">Phone</div>
			<div class="col">Email</div>
		</div>
		<div class="row">
			
			<div class="col"><input type="text" placeholder="District" name="staff_dist" required="required"> </div>
			<div class="col"><input type="number" placeholder="Phone" name="staff_phone" required="required"> </div>
			<div class="col"><input type="email" placeholder="Email ID" name="staff_email" required="required" > </div>
		</div>	
		
		<br>
		
		<div class="row">
			
			<div class="col">Photo</div>
			
		</div>
		<div class="row">
			
			<div class="col"><input  type="file" name="staff_photo" required="required" style="padding: 5px; height: 40px;"> </div>
		</div>
				
		<br>
			
				
		<br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Save</button></div>

		<div class="col"></div>
		</div>
		</form>
		
	</div>
	

	</div>
	
	
	
	
</body>
</html>