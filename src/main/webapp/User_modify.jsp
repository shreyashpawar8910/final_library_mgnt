<%@page import="com.entity.library_users"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.userDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Modification</title>


<style type="text/css">


.user_modify_container{
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


	
.card{
	margin-top: 10px;
	width: 1080px;
	margin-left: 30px;
}

.table-bordered {
	border: 1px solid;
}

.card{
	height: 350px;
	max-height: 350px;
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

.user_modify_container .btn-download{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 50px;
}











.overlay{
	width: 100%;
	height: 100vh;
	top: 0%;
	position: absolute;
	background: rgba(0,0,0,0.5);
	opacity: 0;
	z-index: -1;
	
}

.showoverlay{
	opacity: 1;
	z-index: 1;
}

.update_form  {
	top: -150%;
	left: 25%;
	width: 800px;
	height: 500px;
	position: absolute;
	background: white;
	padding: 30px; 	
	transition: 2s;
}

.showupdate_form{
	top: 10%;
	z-index: 1;
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
	margin-left: 280px;
	padding: 5px 25px 5px 25px;
}




.update_form span{
	position: absolute;
	right: 0px;	
	width: 30px;
	height: 30px;
	cursor: pointer;
	background: green;  
	color: white;
	line-height: 30px;
	text-align: center;	
	top: 0px;

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
    			
    		 	if(msggg=="update sucess"){
    		 		
					swal("Success", "User Updation Sucessfull", "success");
					
				}else if(msggg=="update faild"){
    		 	
					swal("Error", "User Updation unsucessfull", "error");
					
				}else if(msggg=="delete sucess"){
    		 		
					swal("Success", "User Delete Sucessfull", "success");
					
				}else if(msggg=="delete faild"){
    		 	
					swal("Error", "User Delete unsucessfull", "error");
					
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
    		
	
			


	<div class="user_modify_container">
	
		<div class="page_haiding">
			<h3>User Master</h3>
		</div>
		
		
		<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>
	<div class="card">
	<table class="table table-bordered" id="table2">
		<thead>
			
			
			<th>ID</th>
			<th>Name</th>
			<th>Role</th>
			<th>Email</th>
			<th>Phone</th>
			
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Action &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			
		</thead>
		<tbody>
	
			
			<%
			userDAO us_dao = new userDAO(DBConnect.getConn());
			List<library_users> list = us_dao.getAll_users();
			
			
			for(library_users us:list){
		
			%>
		
				<tr>			
					
					<td><%=us.getUser_id() %></td>
					<td><%=us.getUser_name() %></td>
					<td><%=us.getUser_role() %></td>
					<td><%=us.getUser_email() %></td>
					<td><%=us.getUser_phone() %></td>
					
					<td>
					<a href="#" onclick="showedit_category_model(<%=us.getUser_id() %>, '<%=us.getUser_name() %>', 
						'<%=us.getUser_role() %>', '<%=us.getUser_email() %>', '<%=us.getUser_phone() %>','<%=us.getUser_password()%>')">Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="single_user_delet?single_user_id=<%=us.getUser_id() %>" style="color: red;">Delete</a></td>
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
		
		
		<!-- This is Hidden Table for print Reports -->
		
		<table class="table table-bordered" id="usertable" hidden>
		<thead>
			
			
			
			<th>Name</th>
			<th>Role</th>
			<th>Email</th>
			<th>Phone</th>
			
			
			
		</thead>
		<tbody>
	
			
			<%
			
			List<library_users> list2 = us_dao.getAll_users();
			
			
			for(library_users us:list2){
		
			%>
		
				<tr>			
					
					
					<td><%=us.getUser_name() %></td>
					<td><%=us.getUser_role() %></td>
					<td><%=us.getUser_email() %></td>
					<td><%=us.getUser_phone() %></td>
					
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
		
		
		
	
	
	</div>




			<!-- This Tag for Show Popup for Edit record  -->
	
	
	<div class="overlay"></div>	

		
		
		<div class="update_form">
		
			<span onclick="closeedit_model()">&times;</span>
			
		<form action="user_updation" method="post">
		<div class="row">
			<div class="col">Name </div>
			<div class="col">Role</div>
			
		</div>
		<div class="col"><input type="text" id="edit_user_id" name="user_id" required="required" hidden > </div>
		<div class="row">
		
		

			<div class="col"><input type="text" id="edit_user_name" name="user_name" placeholder="Name" required="required"  > </div>
			<div class="col">
			<input  name="user_role" required="required" id="edit_user_role" readonly="readonly"></div>
			
		</div>
				<br>
				
		<div class="row">
			<div class="col">Email Id </div>
			<div class="col">Phone Number</div>
		
		</div>
		<div class="row">
			<div class="col"><input type="email" id="edit_user_email" placeholder="Email Id" name="user_email" required="required"  > </div>
			<div class="col"><input type="text" id="edit_user_phone" placeholder="Phone Number" name="user_phone" required="required"> </div>	
		</div>
	
		<br>
				
		<div class="row">
			<div class="col">Password </div>
			
		
		</div>
		<div class="row">
			<div class="col"><input type="password" id="edit_user_password" placeholder="Password" name="user_password" required="required"> </div>
			
		</div>
		

				
		<br><br>
		<div class="row">
		<button class="btn" type="submit" value="Register">Update</button>
		
		

		<div class="col"></div>
		</div>
		</form>
			
		</div>		
		
		


</body>






<script type="text/javascript">
function showedit_category_model(user_id, user_name, user_role, user_email, user_phone, user_password) {
	
	document.getElementById('edit_user_id').value = user_id;
	document.getElementById('edit_user_name').value = user_name; 
	document.getElementById('edit_user_role').value = user_role;
	document.getElementById('edit_user_email').value = user_email;
	document.getElementById('edit_user_phone').value = user_phone;
	document.getElementById('edit_user_password').value = user_password;


	
	
	document.querySelector('.overlay').classList.add('showoverlay');
	document.querySelector('.update_form').classList.add('showupdate_form');
}



function closeedit_model() {
	document.querySelector('.overlay').classList.remove('showoverlay');
	document.querySelector('.update_form').classList.remove('showupdate_form');
	

}










// For Download Table Data  


function generate() {  
    var doc = new jsPDF('landscape');  
    var htmlstring = '';  
    var tempVarToCheckPageHeight = 0;  
    var pageHeight = 0;  
    pageHeight = doc.internal.pageSize.height;  
    specialElementHandlers = {  
        // element with id of "bypass" - jQuery style selector  
        '#bypassme': function(element, renderer) {  
            // true = "handled elsewhere, bypass text extraction"  
            return true  
        }  
    };  
    margins = {  
        top: 10,  
        bottom: 60,  
        left: 20,  
        right: 20,  
        width: 650  
    };  
    var y = 20;  

   
    doc.setFont('Bell MT');
    doc.setFontSize(20);
    doc.setFontType("bold");
    doc.setTextColor("#ff884d");
    doc.text(50, y = y + 10, "YASHWANTRAO  CHAVAN  MAHAVIDHYALAYA  ISLAMPUR");
      
    
    doc.setFont('Bell MT');
    doc.setFontSize(17);
    doc.setFontType("bold");
    doc.setTextColor(255, 99, 71, 0.5);
    doc.text(110, y = y + 10, "Library Management System");
    
    doc.setFont('Bell MT');
    doc.setFontSize(14);
    doc.setFontType();
    doc.setTextColor("black");
    doc.text(135, y = y + 10, "Report on");
    
    doc.setFont('Bell MT');
    doc.setFontSize(18);
    doc.setFontType("bold");
    doc.setTextColor(255, 99, 71, 0.5);

    doc.text(129, y = y + 10, "System Users");
    
    
    doc.autoTable({  
        html: '#usertable',  
        startY: 70,  
        theme: 'grid',  
       
         
        styles: {  
            minCellHeight: 20  
        } 
        
    })  
    doc.save('System users.pdf');  
}  






	</script>
	




</html>