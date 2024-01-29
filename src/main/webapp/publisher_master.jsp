<%@page import="com.entity.publisher_enti"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.PublisherDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publisher</title>

<style type="text/css">



.publisher_container{
	margin-left: 250px;
	margin-top: 0px;
	height: 100%;
	width: 82%;
	border: 2px solid;
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

.overlay{
	width: 100%;
	height: 130vh;
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
	top: -70%;
	left: 20%;
	width: 1050px;
	height: 400px;
	position: absolute;
	background: white;
	padding: 30px; 	
	transition: 2s;
}

.showupdate_form{
	top: 25%;
	z-index: 1;
}

.update_form input{
	width:100%;
	height: 35px; 
	margin-bottom: 15px;
	padding-left: 10px; 
}

.update_form button{
	background: #437fc7;
	color: white;
	padding: 10px 30px;
	border: none;
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
    			
    		 	if(msggg=="insert faild"){
    		 		
    		 		swal("Error", "Publisher Insertion Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="insert success"){
    		 		
    		 		swal("Success", "Publisher Insertion Sucessfull", "success");
    		 		
				}else if(msggg=="update faild"){
    		 		
    		 		swal("Error", "Publisher Update Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="update success"){
    		 	
    		 		swal("Success", "Publisher Update Sucessfull", "success");
    		 		
				}if(msggg=="delete faild"){
    		 		
    		 		swal("Error", "Publisher Delete Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="delete success"){
    		 		swal("Success", "Publisher Delete Sucessfull", "success");
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
    		
    		
    		
	
	<div class="publisher_container">	
	
	<div class="page_haiding">
		<h3>Publisher Master</h3>
	</div>
	
	
	<div class="row_design">
		<form action="publisher_register" method="post">
		<div class="row">
			<div class="col">Publisher Name </div>
			<div class="col">Publisher Address</div>
			<div class="col">Publisher City</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Publisher Name" name="publ_name" required="required" > </div>
			<div class="col"><input type="text" placeholder="Publisher Address" name="publ_address" > </div>
			<div class="col"><input type="text" placeholder="Publisher City" name="publ_city" required="required"> </div>
		</div>
				
		<br>
				
		<div class="row">
			<div class="col">Publisher Talula </div>
			<div class="col">Publisher District</div>
			<div class="col">Publisher Email</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Publisher Taluka" name="publ_taluka"  > </div>
			<div class="col"><input type="text" placeholder="Publisher District" name="publ_dist" > </div>
			<div class="col"><input type="email" placeholder="Publisher Email" name="publ_email" required="required"> </div>
		</div>
				
		<br>
		
		<div class="row">
			<div class="col">Publisher Phone </div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Publisher Phone" name="publ_phone" required="required" > </div>
			
		</div>	
				
		<br><br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Save</button></div>

		<div class="col"></div>
		</div>
		</form>
		
	</div>
	
	<br><br><br>
	<div class="card">
	<table class="table table-bordered">
		<thead>
			
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Taluka</th>
			<th>District</th>
			<th>Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>Phone</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Action &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			
		</thead>
		<tbody>
	
			
			<%
			PublisherDAO publdao = new PublisherDAO(DBConnect.getConn());
			List<publisher_enti> list = publdao.getallpublishers();
			for(publisher_enti publ:list){
			%>
		
				<tr>			
					<td><%=publ.getPubl_id() %></td>
					<td><%=publ.getPubl_name() %></td>
					<td><%=publ.getPubl_address() %></td>
					<td><%=publ.getPubl_city() %></td>
					<td><%=publ.getPubl_taluka() %></td>
					<td><%=publ.getPubl_dist() %></td>
					<td><%=publ.getPubl_email() %></td>
					<td><%=publ.getPubl_phone() %></td>
					<td>
					<a href="#" onclick="showedit_category_model(<%=publ.getPubl_id() %>, '<%=publ.getPubl_name() %>', '<%=publ.getPubl_address() %>',
					'<%=publ.getPubl_city() %>', '<%=publ.getPubl_taluka() %>', '<%=publ.getPubl_dist() %>', '<%=publ.getPubl_email() %>', 
					'<%=publ.getPubl_phone() %>')">Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="publisher_delete?publ_id=<%=publ.getPubl_id() %>" style="color: red;">Delete</a></td>
				</tr>
				
		
			<%
			}
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
	
	<div class="overlay"></div>	
		
		<div class="update_form">
		
			<span onclick="closeedit_model()">&times;</span>
			
			<form action="publisher_edit" method="post">
			
			<div class="row">
				<div class="col"><input type="hidden" id="publIdText" name="edit_publ_id" readonly></div>		
				</div>
			
			<div class="row">
					<div class="col">Publisher Name</div>
					<div class="col">Publisher Address</div>
					<div class="col">Publisher City</div>
							
				</div>
				
				<div class="row">
					<div class="col"><input type="text" id="publnameText" name="edit_publ_name" ></div>
					<div class="col"><input type="text" id="publaddressID" name="edit_publ_address" ></div>
					<div class="col"><input type="text" id="publcityId" name="edit_publ_city" ></div>
								
				</div>
				
				<div class="row">
					<div class="col">Publisher Taluka</div>
					<div class="col">Publisher District</div>
					<div class="col">Publisher Email</div>
							
				</div>
				
				<div class="row">
					<div class="col"><input type="text" id="publtalukaID" name="edit_publ_taluka" ></div>
					<div class="col"><input type="text" id="publdistID" name="edit_publ_dist" ></div>
					<div class="col"><input type="text" id="publmailID" name="edit_publ_email" ></div>
								
				</div>
				
				<div class="row">
					<div class="col">Publisher Phone</div>
												
				</div>
				
				<div class="row">
					<div class="col"><input type="text" id="publphoneID" name="edit_publ_phone" ></div>			
				</div>
				
				
				<button>Update</button>
			
			</form>
		</div>
		
	</div>
	
	
	
</body>

	<script type="text/javascript">
		function showedit_category_model(publ_id, publ_name, publ_address, publ_city, publ_taluka, publ_dist, publ_email, publ_phone) {
			
			document.getElementById('publIdText').value=publ_id;
			document.getElementById('publnameText').value=publ_name;
			document.getElementById('publaddressID').value=publ_address;			
			
			document.getElementById('publcityId').value=publ_city;
			document.getElementById('publtalukaID').value=publ_taluka;	
			document.getElementById('publdistID').value=publ_dist;
			document.getElementById('publmailID').value=publ_email;	
			document.getElementById('publphoneID').value=publ_phone	;	
			
			document.querySelector('.overlay').classList.add('showoverlay');
			document.querySelector('.update_form').classList.add('showupdate_form');
		}
		
		function closeedit_model() {
			document.querySelector('.overlay').classList.remove('showoverlay');
			document.querySelector('.update_form').classList.remove('showupdate_form');
		}
		
	</script>
	

</html>