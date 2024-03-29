<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.FineDAO"%>
<%@page import="com.entity.Fine_enti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Fine Report</title>


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




.card{
	margin-top: 40px;
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


.display_tot_fine{

margin-top: -390px;
margin-left: 30px;

position: absolute; 

}
.display_tot_fine input{
	border-radius: 5px;
	padding: 0px 0px 0px 5px;
}
	
	



</style>


</head>
<body>

	<%@include file="lbl_side_nav.jsp" %>
	
	
	<div class="tr_stud_container">
		
		<div class="page_haiding">
			<h3>Fine Reports</h3>
		</div>
		
		
			
	
	
	
			
<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>

	<div class="card">
	<table id="table1" class="table table-bordered" >
		<thead>
			
			
			<th>Candidate Name</th>
			<th>Stock Name</th>
			<th>Department</th>
			<th>Diposit Date</th>
			<th>Fine Amount</th>
			
			
			
		</thead>
		<tbody>
	
			
			<%
			
			

			
			String profile = request.getParameter("search_table_name");
			String content = request.getParameter("search_content");
			String from_date = request.getParameter("from_date");
			String to_date = request.getParameter("to_date");
			
				Double total_fine = 0.0;
				FineDAO f_dao = new FineDAO(DBConnect.getConn());
				List<Fine_enti>list = f_dao.get_search_fine_details(profile, content, from_date, to_date);
				
				for(Fine_enti f_enti:list){
			
			%>
		
				<tr>		
						
					<td><%=f_enti.getFine_stud_name()%></td>
					<td><%=f_enti.getFine_book_name() %></td>
					<td><%=f_enti.getStud_dept() %></td>
					<td><%=f_enti.getFine_issue_date() %></td>
					<td><%=f_enti.getFine_amount() %></td>
					
					<td hidden><%total_fine = f_enti.getTotal_fine(); %></td>
				</tr>
				
		
			<%
			
				}
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
	
	<div class="display_tot_fine">
		<input  value="Total Fine :       <%=total_fine%>">
	</div>
		
		
	
			
			
			<!-- This is hidden Table for print report -->
			
			<table id="table1" class="table table-bordered" hidden>
			
		<thead>
			
			
			<th>Candidate Name</th>
			<th>Stock Name</th>
			<th>Department</th>
			<th>Diposit Date</th>
			<th>Fine Amount</th>
			
			
			
		</thead>
		<tbody>
	
			
			<%
				

				List<Fine_enti>list1 = f_dao.getall_fine_details();
				
				for(Fine_enti f_enti:list1){
			
			%>
		
				<tr>		
						
					<td><%=f_enti.getFine_stud_name()%></td>
					<td><%=f_enti.getFine_book_name() %></td>
					<td><%=f_enti.getStud_dept() %></td>
					<td><%=f_enti.getFine_issue_date() %></td>
					<td><%=f_enti.getFine_amount() %></td>
					
					
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
	
	var tot_fin = "<%=total_fine%>";
	
	
	
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
 doc.text(124, y = y + 10, "All Fine Details");
 
 
 doc.setFont('Bell MT');
 doc.setFontSize(14);
 doc.setFontType("bold");
 doc.setTextColor("#ff884d");
 doc.text(20, y = y + 25, "Total Fine :     "+tot_fin);
 
 doc.autoTable({  
     html: '#table1',  
     startY: 90,  
     theme: 'grid',  

     styles: {  
         minCellHeight: 20  
     } 

 
 })  
 doc.save('Fine Report.pdf');  
}  




</script>


</html>