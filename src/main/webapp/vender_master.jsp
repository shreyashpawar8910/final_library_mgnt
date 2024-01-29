<%@page import="com.entity.Vender_enti"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.VenderDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vender Master</title>

<style type="text/css">




.vender_container{
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
table{
	
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
    		 		
    		 		swal("Error", "Vender Insertion Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="insert success"){
    		 		
    		 		swal("Success", "Vender Insertion Sucessfull", "success");
    		 		
				}else if(msggg=="update faild"){
    		 		
    		 		swal("Error", "Vender Update Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="update success"){
    		 	
    		 		swal("Success", "Vender Update Sucessfull", "success");
    		 		
				}if(msggg=="delete faild"){
    		 		
    		 		swal("Error", "Vender Delete Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="delete success"){
    		 		swal("Success", "Vender Delete Sucessfull", "success");
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
	
	
	<div class="vender_container">	
	
	<div class="page_haiding">
		<h3>Vender Master</h3>
	</div>
	
	
	<div class="row_design">
		<form action="vender_register" method="post">
		<div class="row">
			<div class="col">Vender Name </div>
			<div class="col">Vender Address</div>
			<div class="col">Vender City</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Vender Name" name="vend_name" required="required" > </div>
			<div class="col"><input type="text" placeholder="Vender Address" name="vend_address" required="required"> </div>
			<div class="col"><input type="text" placeholder="Vender City" name="vend_city" required="required"> </div>
		</div>
				
		<br>
				
		<div class="row">
			<div class="col">Vender Talula </div>
			<div class="col">Vender District</div>
			<div class="col">Vender Email</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Vender Taluka" name="vend_taluka" required="required" > </div>
			<div class="col"><input type="text" placeholder="Vender District" name="vend_dist" required="required"> </div>
			<div class="col"><input type="email" placeholder="Vender Email" name="vend_email" required="required"> </div>
		</div>
				
		<br>
		
		<div class="row">
			<div class="col">Vender Phone </div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Vender Phone" name="vend_phone" required="required" > </div>
			
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
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Action&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>
			
		</thead>
		<tbody>
	
			
			<%
			VenderDAO venddao = new VenderDAO(DBConnect.getConn());
			List<Vender_enti> list = venddao.getallvenders();
			for(Vender_enti vend:list){
			%>
		
				<tr>			
					<td><%=vend.getVend_id() %></td>
					<td><%=vend.getVend_name() %></td>
					<td><%=vend.getVend_address() %></td>
					<td><%=vend.getVend_city() %></td>
					<td><%=vend.getVend_taluka() %></td>
					<td><%=vend.getVend_dist() %></td>
					<td><%=vend.getVend_email() %></td>
					<td><%=vend.getVend_phone() %></td>
					<td>
					<a href="#" onclick="showedit_category_model(<%=vend.getVend_id() %>, '<%=vend.getVend_name() %>', '<%=vend.getVend_address() %>', '<%=vend.getVend_city() %>', 
					'<%=vend.getVend_taluka() %>', '<%=vend.getVend_dist() %>', '<%=vend.getVend_email() %>', '<%=vend.getVend_phone() %>')">Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="vend_delete?vend_id=<%=vend.getVend_id() %>" style="color: red;">Delete</a></td>
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
			
			<form action="vender_edit" method="post">
			
			<div class="row">
				<div class="col"><input type="hidden" id="venderIdText" name="edit_vend_id" readonly></div>		
				</div>
			
			<div class="row">
					<div class="col">Vender Name</div>
					<div class="col">Vender Address</div>
					<div class="col">Vender City</div>
							
				</div>
				
				<div class="row">
					<div class="col"><input type="text" id="vendernameText" name="edit_vend_name" ></div>
					<div class="col"><input type="text" id="venderaddressID" name="edit_vend_address" ></div>
					<div class="col"><input type="text" id="vendercityId" name="edit_vend_city" ></div>
								
				</div>
				
				<div class="row">
					<div class="col">Vender Taluka</div>
					<div class="col">Vender District</div>
					<div class="col">Vender Email</div>
							
				</div>
				
				<div class="row">
					<div class="col"><input type="text" id="vendertalukaID" name="edit_vend_taluka" ></div>
					<div class="col"><input type="text" id="venderdistID" name="edit_vend_dist" ></div>
					<div class="col"><input type="text" id="vendemailID" name="edit_vend_email" ></div>
								
				</div>
				
				<div class="row">
					<div class="col">Vender Phone</div>
												
				</div>
				
				<div class="row">
					<div class="col"><input type="text" id="venderphoneID" name="edit_vend_phone" ></div>			
				</div>
				
				
				<button>Update</button>
			
			</form>
		</div>
		
	</div>
	
	
</body>

	<script type="text/javascript">
		function showedit_category_model(vend_id, vend_name, vend_address, vend_city, vend_taluka, vend_dist, vend_email, vend_phone) {
			
			document.getElementById('venderIdText').value=vend_id;
			document.getElementById('vendernameText').value=vend_name;
			document.getElementById('venderaddressID').value=vend_address;			
			
			document.getElementById('vendercityId').value=vend_city;
			document.getElementById('vendertalukaID').value=vend_taluka;	
			document.getElementById('venderdistID').value=vend_dist;
			document.getElementById('vendemailID').value=vend_email;	
			document.getElementById('venderphoneID').value=vend_phone	;	
			
			document.querySelector('.overlay').classList.add('showoverlay');
			document.querySelector('.update_form').classList.add('showupdate_form');
		}
		
		function closeedit_model() {
			document.querySelector('.overlay').classList.remove('showoverlay');
			document.querySelector('.update_form').classList.remove('showupdate_form');
		}
		
	</script>

</html>