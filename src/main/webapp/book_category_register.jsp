<%@page import="com.entity.book_category_enti"%>
<%@page import="com.dao.categoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>

<%@include file="all_component/all_css.jsp" %>

<style type="text/css">



.dept_container{
	margin-left: 250px;
	margin-top: 0px;
	height: 93vh;
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

.row .col .btn a{
	color: black;
	text-decoration: none;
}

.card{
	width: 800px;
	margin-left: 180px;
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
	left: 40%;
	width: 550px;
	height: 350px;
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
    		 		
    		 		swal("Error", "Category Insertion Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="insert success"){
    		 		
    		 		swal("Success", "Category Insertion Sucessfull", "success");
    		 		
				}else if(msggg=="update faild"){
    		 		
    		 		swal("Error", "Category Update Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="update success"){
    		 	
    		 		swal("Success", "Category Update Sucessfull", "success");
    		 		
				}if(msggg=="delete faild"){
    		 		
    		 		swal("Error", "Category Delete Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="delete success"){
    		 		swal("Success", "Department Delete Sucessfull", "success");
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
	
	

	<div class="dept_container">	
	
	<div class="page_haiding">
		<h3>Category Master</h3>
	</div>
	
	
	<div class="row_design">
		<form action="save_category" method="post">
		<div class="row">
			<div class="col">Category ID </div>
			<div class="col">Category Name</div>
			<div class="col">Category Type</div>
		</div>
		<div class="row">
		
			<%
				book_category_enti b_cat1 =new book_category_enti();
				categoryDAO catdao1 = new categoryDAO(DBConnect.getConn());
			boolean f = catdao1.last_id_category(b_cat1) ;
			%>
			
			<div class="col"><input type="text" name="bcat_id" value="<%=b_cat1.getBcat_id() %>" required="required" readonly> </div>
			<div class="col"><input type="text" placeholder="Category Name" name="bcat_name" required="required"> </div>
			<div class="col">
			
			<select  name="bcat_type" required="required">
				<option value="-1">Select Category</option>
				<option>Book</option>
				<option>Journal</option>
				<option>Magzine</option>
			
			</select> 
			</div>

		</div>
				
		<br><br><br>
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
			<th>Type</th>
			<th>Action</th>

		</thead>
		<tbody>
	
			
			<%
			categoryDAO catdao = new categoryDAO(DBConnect.getConn());
			List<book_category_enti> list = catdao.getAllcategory();
			for(book_category_enti bcat:list){
			%>
		
				<tr>			
					
					<td><%=bcat.getBcat_id() %></td>
					<td><%=bcat.getBcat_name() %></td>
					<td><%=bcat.getBcat_type() %></td>

					<td>
					<a href="#" onclick="showedit_category_model('<%=bcat.getBcat_id()%>','<%=bcat.getBcat_name()%>','<%=bcat.getBcat_type()%>')">Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="cat_delete?cat_id=<%=bcat.getBcat_id() %>" style="color: red;">Delete</a></td>
				</tr>
				
		
			<%
			}
			%>	
			
			
		</tbody>
		
		
	
	</table>
	</div>
		
		
	</div>
	
	<div>
		<div class="overlay"></div>	
		
		<div class="update_form">
		
			<span onclick="closeedit_model()">&times;</span>
			
			<form action="category_edit" method="post">
			
			<div>
					<label>Category Id</label>
					<input type="text" id="categoryIdText" name="edit_cat_id" readonly>
				</div>
				<div>
					<label>Category Name</label>
					<input type="text"  id="categorynameid" name="edit_cat_name">
				</div>
				<div>
					<label>Category Type</label>
					<input type="text" id="categorytypeId" name="edit_cat_type">
				</div>
				<button>Update</button>
			
			</form>
		</div>
		
	</div>
		
</body>
	<script type="text/javascript">
		function showedit_category_model(cat_id,cat_name,cat_type) {
			
			document.getElementById('categoryIdText').value=cat_id;
			document.getElementById('categorynameid').value=cat_name;
			document.getElementById('categorytypeId').value=cat_type;			
			
			document.querySelector('.overlay').classList.add('showoverlay');
			document.querySelector('.update_form').classList.add('showupdate_form');
		}
		
		function closeedit_model() {
			document.querySelector('.overlay').classList.remove('showoverlay');
			document.querySelector('.update_form').classList.remove('showupdate_form');
		}
		
	</script>
</html>