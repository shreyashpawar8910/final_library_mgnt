<%@page import="java.util.Date"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Students Fine Collection</title>

<style type="text/css">



.fine_container{
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
	width: 150px;
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

.row .col .btn a{
	color: black;
	text-decoration: none;
}


</style>

</head>


<body>


<%@include file="lbl_side_nav.jsp" %>

		<%
		
		String error = request.getParameter("error");
		%>
	<!--This Code for display an success or error message to the user  -->
    		    		
	
	  
    		   
    		    		
    				
    		 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=error%>";
    		 
    			
    		 	if(1){
    		 		
    		 		
    		 		swal("Error", "A Student has cross the deadline for returning the book. He will have to pay a fine while returning the Book ", "error");
				}
    		  
    		</script>
    		
    		
    		
    		


	
	<div class="fine_container">	
	
	<div class="page_haiding">
		<h3>Fine Master</h3>
	</div>
	
	
    		  
    		  	
    	
    		
	
	
	<%
	
		String tran_d = request.getParameter("tran_id");
		String book_name = request.getParameter("book_name");
		String issue_date = request.getParameter("issu_date");
		String stud_name = request.getParameter("stud_name");
		String last_date = request.getParameter("last_date");
		String late_days = request.getParameter("late_day");
		String fine_amount = request.getParameter("fine_amount");
		
		
		String book_id = request.getParameter("book_id");
		String student_id = request.getParameter("student_id");
		String profile = request.getParameter("profile");
		
		String department = request.getParameter("student_dept");
	%>
	
	
	    		
    	
    		
	
	
	<div class="row_design">
		<form action="student_fine" method="post">
		<div class="row">
			<div class="col">Student Name </div>
			<div class="col">Issued Book</div>
			<div class="col">Issued Date</div>
		</div>
		<div class="row">
		<input type="text" value="<%=tran_d %>" name="fine_tr_id" hidden>
		<input type="text" value="<%=profile%>" name="fine_book_profile" hidden>
		<input type="text" value="<%=department%>" name="stud_dept" hidden>
		
			<div class="col"><input type="text" value="<%=stud_name %>" name="fine_stud_name" required="required" readonly="readonly"> </div>
			<div class="col"><input type="text" value="<%=book_name %>" name="fine_issu_book" readonly="readonly"> </div>
			<div class="col"><input type="text"  value="<%=issue_date %>" name="fine_issu_date" required="required" readonly="readonly"> </div>
		</div>
				
		<br>
				
		<div class="row">
			<div class="col">Last Date </div>
			<div class="col">Late Days</div>
			<div class="col">Fine Amount</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" value="<%=last_date %>" name="fine_last_date"  readonly="readonly"> </div>
			<div class="col"><input type="text" value="<%=late_days %>" name="fine_late_days" readonly="readonly"> </div>
			<div class="col"><input type="number" value="<%=fine_amount %>" name="fine_amount" required="required" style="color: red;" readonly="readonly"> </div>
	
			<input type="text" value="<%=book_id %>" name="fine_book_id" hidden>
			<input type="text" value="<%=student_id %>" name="fine_student_id" hidden>
	
		</div>
				
		<br>
		
				<br><br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Collect Fine</button></div>

		<div class="col"></div>
		</div>
		</form>
		
	</div>
	</div>
</body>
</html>