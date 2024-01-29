<%@page import="com.entity.Vender_enti"%>
<%@page import="com.dao.VenderDAO"%>
<%@page import="com.entity.publisher_enti"%>
<%@page import="com.dao.PublisherDAO"%>
<%@page import="com.entity.book_category_enti"%>
<%@page import="com.dao.categoryDAO"%>
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
<title>Book Master</title>

<style type="text/css">



.book_container{
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
	
	
	
	
			<!--This Code for display an success or error message to the user  -->
    		    		
	
	  
    		   <%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succmsg");
    		   
    		   
    		   %>
    		    		
    				
    		 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="faild"){
    		 		
    		 		swal("Error", "Book Insertion Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="insert"){
    		 		swal("Success", "Book Insertion Sucessfull", "success");
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
    		
	
	
	
	
	
	<div class="book_container">	
	
	<div class="page_haiding">
		<h3>Book Master</h3>
	</div>
	
	
	<div class="row_design">
		<form action="original_book_register" method="post">
		<div class="row">
			
			<div class="col">Department</div>
			<div class="col">Category</div>
			<div class="col">Classification No. </div>
			
		</div>
		<div class="row">
			
			<div class="col"><select  name="book_dept" required="required" >
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
			<div class="col"><select name="book_category" required="required" >
				<option value="-1"> Select Category</option>
				
				<%
				try{
					
					categoryDAO catdao = new categoryDAO(DBConnect.getConn());
					List<book_category_enti> list = catdao.getAllcategory();
					for(book_category_enti bcat:list){
						if(bcat.getBcat_type().equals("Book")||bcat.getBcat_type().equals("book")){
					%>
					<option value="<%=bcat.getBcat_id() %>"><%=bcat.getBcat_name() %></option>
					
					<%							
						}}
					
				}catch(Exception e){
					e.printStackTrace();
				}
				%>
				
				
				</select>

			 </div>
			 
			 <div class="col"><input type="text" placeholder="Classification No." name="book_Clasif_No"  > </div>
		</div>
		
		<br>
		
		<div class="row">
			
			<div class="col">Title</div>
			<div class="col">Sub-title</div>
			<div class="col">Subject </div>
		</div>		
		
		<div class="row">
			
			<div class="col"><input type="text" placeholder="Title" name="book_title" required="required"> </div>
			<div class="col"><input type="text" placeholder="Sub-title" name="book_sub_title" > </div>
			<div class="col"><input type="text" placeholder="Subject" name="book_subj" > </div>
			
		</div>
				
		<br>
		
		<div class="row">
			
			<div class="col">Edition</div>
			<div class="col">No. of Copies</div>
			<div class="col">Author Name</div>
		</div>
		<div class="row">
			
			<div class="col"><input type="text" placeholder="Edition" name="book_edition" > </div>
			<div class="col"><input type="number" placeholder="Book Copies" name="book_copies" required="required"> </div>
			<div class="col"><input type="text" placeholder="Author Name" name="book_author" required="required" > </div>
			
		</div>	
		
		<br>
		
		<div class="row">
			
			<div class="col">Publisher Name</div>
			<div class="col">Publishing Year</div>
			<div class="col">Vender Name</div>
			
		</div>
		<div class="row">
			
			
			<div class="col"><select name="book_publisher" required="required"> 
					
			<option value="-1"> Select Publisher</option>			
				<%
					try{
						
						PublisherDAO publdao = new PublisherDAO(DBConnect.getConn());
						List<publisher_enti> list = publdao.getallpublishers();
						for(publisher_enti publ:list){
						%>
						<option value="<%=publ.getPubl_id()%>"><%=publ.getPubl_name() %></option>
						
						<%							
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				%>	
				
				</select>
			</div>
			
			<div class="col"><input type="text" placeholder="Publishing Year" name="book_publ_year" > </div>
			
			<div class="col">
			<select name="book_vend_name" required="required" > 
				<option value="-1">Select Vender</option>
				
				<%				
					try{
						VenderDAO venddao = new VenderDAO(DBConnect.getConn());
						List<Vender_enti> list = venddao.getallvenders();
						for(Vender_enti vend:list){
							%>	
							<option value="<%=vend.getVend_id()%>"><%=vend.getVend_name() %></option>
							<%
						}	
					}catch(Exception e){
						e.printStackTrace();
					}
				
				%>
				
			</select>
			</div>
			
		</div>
				
		<br>
		
		<div class="row">
			
			<div class="col">Book Pages</div>
			<div class="col">Book Price</div>
			<div class="col">Rack Number</div>
		</div>
		<div class="row">
			
			
			
			<div class="col"><input type="text" placeholder="Book Pages" name="book_pages" > </div>
			<div class="col"><input type="text" placeholder="Book Price" name="book_price" required="required"> </div>
			<div class="col"><input type="text" placeholder="Rack Number" name="book_rack_no" required="required" > </div>
		</div>
				
		<br>
		
		<div class="row">
			
			<div class="col">Language</div>
		</div>
		<div class="row">
			
			<div class="col"><input type="text" placeholder="Book" name="book_language" required="required"> </div>
		</div>
				
		<br>		
				
		<br><br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Save</button></div>
	
		<div class="col"></div>
		</div>
		</form>
			<br><br>
	</div>
	</div>
</body>
</html>