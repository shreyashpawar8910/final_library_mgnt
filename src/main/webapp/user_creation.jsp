<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Creation</title>
<%@include file="all_component/all_css.jsp" %>

<style type="text/css">

.user_creation_container{
	
	margin-left: 250px;
	margin-top: 0px;
	height: 100vh;
	width: 82%;

}


.page_haiding{
		background: #437fc7;
		text-align: center;
		
		color: white;
}




.row_design{
	margin-top: 50px;
	margin-left: 150px;
	width: 850px;
	border: 1px solid;
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

.row  .btn{
	color: black;
	text-decoration: none;
	border: 1px solid;
	margin-left: 330px;
	padding: 5px 25px 5px 25px;
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
    		 		
    		 		swal("Error", "User Role is already Exist", "error");
    		 	}
    		 	else if(msggg=="insert"){
    		 		swal("Success", "User Register Sucessfull", "success");
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
    		
	





<div class="user_creation_container">
		
		<div class="page_haiding">
			<h3>User Creation</h3>
		</div>


		<div class="row_design">
		<form action="user_creation" method="post">
		<div class="row">
			<div class="col">Name </div>
			<div class="col">Role</div>
			
		</div>
		<div class="row">

			<div class="col"><input type="text" name="user_name" placeholder="Name" required="required"  > </div>
			<div class="col">
			<select  name="user_role" required="required"> 
				<option value="-1">Select Role</option>
				<option value="Admin">Admin</option>
				<option value="Librarian">Librarian</option>
				<option value="Teacher">Teacher</option>
				<option value="Principle">Principle</option>
			</select>
			</div>
			
		</div>
				<br>
				
		<div class="row">
			<div class="col">Email Id </div>
			<div class="col">Phone Number</div>
		
		</div>
		<div class="row">
			<div class="col"><input type="email" placeholder="Email Id" name="user_email" required="required"  > </div>
			<div class="col"><input type="text" placeholder="Phone Number" name="user_phone" required="required"> </div>	
		</div>
	
		<br>
				
		<div class="row">
			<div class="col">Password </div>
			
		
		</div>
		<div class="row">
			<div class="col"><input type="password" placeholder="Password" name="user_password" required="required"> </div>
			
		</div>
		

				
		<br><br><br>
		<div class="row">
		<button class="btn" type="submit" value="Register">Register</button>
		
		

		<div class="col"></div>
		</div>
		</form>
		
		
	</div>
	
		
		
		
</div>


</body>	
</html>	