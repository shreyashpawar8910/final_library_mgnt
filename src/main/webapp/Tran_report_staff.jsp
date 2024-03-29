<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.Stock_transection_studentDAO"%>
<%@page import="com.entity.Stock_transection_student_enti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Reports of Staff</title>

<style type="text/css">

.tr_stud_container{

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



.row_design{
	margin-top: 50px;
	margin-left: 230px;	
	height: 220px;
	width: 700px;
	border: 1px solid;
	padding-left: 30px;
	box-shadow: 5px 5px 5px rgba(0,0,0,0.5);
}



.row_design .col select{
	height: 35px;
	width: 170px;
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}

.row_design .col input{
	height: 35px;
	width: 290px;
	
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}


.row_design input{
	height: 35px;
	width: 290px;

	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}



.row_design .col button{
	height: 35px;
	width: 200px;
	margin-left: 200px;	
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}

.card{
	margin-top: 10px;
	width: 1080px;
	margin-left: 30px;
	height: 350px;
	max-height: 350px;
	overflow: scroll;
}

.tr_stud_container .btn-download{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 50px;
}

	

</style>


</head>
<body>

	<%@include file="lbl_side_nav.jsp" %>
	
	
	<div class="tr_stud_container">
		
		<div class="page_haiding">
			<h3>Staff Transaction Reports</h3>
		</div>
		
		
		<form action="Search_tran_report_staff.jsp" method="get">
		<div class="row_design"><br>
		<div class="row">
			<div class="col"><select name="search_table_name">
				
				<option value="tr_stud_stud_id">Staff ID</option>				
				<option value="tr_stud_name">Staff Name</option>
				<option value="tr_book_id">Book ID</option>
				<option value="tr_book_name">Book Name</option>
				<option value="tr_stud_dept">Department</option>
			
			</select></div>
			<div class="col"><input type="text" name="search_content" /></div>
		</div><br>
		
			<div class="row">	
				<div class="col ">From date : </div>
				<div class="col ">To date : </div>
		</div>
		
			<div class="row">
				<div class="col "><input type="date" name="from_date"> </div>
				<div class="col "><input type="date" name="to_date"></div>
			</div>
		<br>	
		
	
		
		<div class="row">
				<div class="col"><button>Search</button></div>
		</div>
		
		
		
		</div>
		</form>
	
	
	
			
<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>

	<div class="card">
	<table id="table1" class="table table-bordered" >
		<thead>
			
			
			<th>Student Name</th>
			<th>Stock Name</th>
			<th>Stock Category</th>
			<th>Department</th>
			<th>Issued Date</th>
			<th>Return Date</th>
			<th>Late Days</th>
			
		</thead>
		<tbody>
	
			
			<%
			
			String candi_type = "teacher";
			
				Stock_transection_studentDAO dao = new Stock_transection_studentDAO(DBConnect.getConn());
				List<Stock_transection_student_enti>list = dao.getall_students_transaction(candi_type);
				
				for(Stock_transection_student_enti stk:list){
			
			%>
		
				<tr>			
					<td><%=stk.getTran_stud_name() %></td>
					<td><%=stk.getTran_book_name() %></td>
					<td><%=stk.getStock_category() %></td>
					<td><%=stk.getTran_stud_dept() %></td>
					<td><%=stk.getIssue_date() %></td>
					<td><%=stk.getReturn_date() %></td>
					<td><%=stk.getTran_let_day() %></td>
				</tr>
				
		
			<%
			
				}
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
		
		
		
		<!-- This is Hidden Table for print table data into pdf format  -->
		
		<table id="tranTable" class="table table-bordered"  hidden>
		<thead>
			
			
			<th>Student Name</th>
			<th>Stock Name</th>
			<th>Stock Category</th>
			<th>Department</th>
			<th>Issued Date</th>
			<th>Return Date</th>
			<th>Late Days</th>
			
		</thead>
		<tbody>
	
			
			<%
			
			
			
				
				List<Stock_transection_student_enti>list1 = dao.getall_students_transaction(candi_type);
				
				for(Stock_transection_student_enti stk:list1){
			
			%>
		
				<tr>			
					<td><%=stk.getTran_stud_name() %></td>
					<td><%=stk.getTran_book_name() %></td>
					<td><%=stk.getStock_category() %></td>
					<td><%=stk.getTran_stud_dept() %></td>
					<td><%=stk.getIssue_date() %></td>
					<td><%=stk.getReturn_date() %></td>
					<td><%=stk.getTran_let_day() %></td>
				</tr>
				
		
			<%
			
				}
			
			%>
			
			
		</tbody>
	
	</table>	
		
	
	</div>

</body>

<script type="text/javascript">


//For Download Table Data  


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
 doc.text(106, y = y + 10, "All Transaction of Students");
 
 
 doc.autoTable({  
     html: '#tranTable',  
     startY: 70,  
     theme: 'grid',  

     styles: {  
         minCellHeight: 20  
     } 

 
 })  
 doc.save('All Student Transaction.pdf');  
}  



</script>


</html>