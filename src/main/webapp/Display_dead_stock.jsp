<%@page import="com.entity.Dead_stock_enti"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.Dead_stockDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dead Stock</title>

<style type="text/css">


	
.book_data_container{
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
	margin-left: 170px;	
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
	width: 320px;
	margin-left: -130px;
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
}


.row_design .col button{
	height: 35px;
	width: 200px;
	margin-left: -60px;	
	border: 1px solid black;
	border-radius: 5px;
	padding: 5px;
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



.btn_row{
	margin-top: 30px;
	margin-left: 520px;

}

.btn_row a{

	border: 1px solid;
	cursor: pointer;
	padding: 7px 20px;	
	background: #cccccc;
	border-radius: 5px; 
}







.overlay{
	width: 100%;
	height: 105vh;
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





/**************/
	
	
	
.delete_arr_form{

	margin-left: 610px;
	margin-top: -875px;
	background: white;
	height: 180px;
	width: 350px;
	border: 2px solid black;
	border-radius: 2px 2px 15px 15px;
	position: absolute;
	transition: 1s;
	z-index: 10;


}

.delete_arr_form span{
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

.delete_arr_form i{

	font-size: 45px;
	margin-top: 20px;
	margin-left: 150px;
	color: red;
}
	
.delete_arr_form label{
	margin-left: 65px;
	margin-top: 10px;
}
	
.delete_arr_form button{
	margin-left: 90px;
	border: 1px solid black;
	padding: 4px 15px;
}

.delete_arr_form a{
	
	border: 1px solid black;
	padding: 7px 17px;
	color: black;
	cursor: pointer;
	margin-left: 50px;
	text-decoration: none:
	

}

.show_delete_arr_form{

	margin-left: 610px;
	margin-top: -455px;
	background: white;
	height: 180px;
	width: 350px;
	border: 2px solid black;
	border-radius: 2px 2px 15px 15px;
	position: absolute;
	transition: 2s;
	z-index: 10;


}
	
	
.book_data_container .btn-download{
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
	
    		   <%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succmsg");
    		   
    		   
    		   %>
    		    		
    				
    		 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="delete faild"){
    		 		
    		 		swal("Error", "Magazine Delete Unsucessfull", "error");
    		 		
    		 	}else if(msggg=="delete success"){
    		 		
    		 		swal("Success", "Magazine Delete Sucessfull", "success");
    		 		
				}
    		 	
    		 	
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>

	
	
	
	
	
	<div class="book_data_container">
	
		<div class="page_haiding">
			<h3>Dead Stock</h3>
		</div>
		
		<form action="Display_search_Deadstock.jsp" method="get">
		<div class="row_design">
		<div class="row">
			<div class="col"><select name="search_table_name">
			
				<option value="b_dead_id">ID</option>
				<option value="b_dead_title">Title</option>
				<option value="b_dead_author">Author</option>
				<option value="b_dead_dept">Department</option>
				<option value="b_dead_stock_cat">Category</option>	
			
			</select></div>
			<div class="col"><input type="text" name="search_content" required/></div>
			<div class="col"><button>Search</button></div>
		</div>
		</div>
		</form>
	
	
		<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>
	<div class="card">
	<table class="table table-bordered" id="table2">
		<thead>
			
			<th> <input type="checkbox" id= "checkbox_all" onchange ="selectcheckall()" /></th>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Reason</th>
			<th>Dispose Date</th>
			
			
		</thead>
		<tbody>
	
			
			<%
				Dead_stockDAO dead_dao = new Dead_stockDAO(DBConnect.getConn());
				List<Dead_stock_enti> list = dead_dao.getall_or_dead_stock();
				
				for(Dead_stock_enti or_dead:list){
			
			%>
		
				<tr>			
					<td><input type="checkbox" class="checkbox_one" value="<%=or_dead.getDead_id() %>" name= "check_bx" /></td>
					<td><%=or_dead.getDead_id() %></td>
					<td><%=or_dead.getDead_title() %></td>
					<td><%=or_dead.getDead_author() %></td>
					<td><%=or_dead.getDead_dept() %></td>
					<td><%=or_dead.getDead_stock_category() %></td>
					<td><%=or_dead.getDead_reason() %></td>
					<td><%=or_dead.getDead_date() %></td>
					
				</tr>
				
		
			<%
			
			
				}
			
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
		
		
		
		<!-- This Hidden table for print Report in pdf -->
		
		
		<table id="bookTable" class="table table-bordered" id="table1" hidden>
		<thead>
			
			
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Reason</th>
			<th>Dispose Date</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			List<Dead_stock_enti> list1 = dead_dao.getall_or_dead_stock();
			
			for(Dead_stock_enti or_dead:list1){
			%>
		
				<tr>			
					
					<td><%=or_dead.getDead_id() %></td>
					<td><%=or_dead.getDead_title() %></td>
					<td><%=or_dead.getDead_author() %></td>
					<td><%=or_dead.getDead_dept() %></td>
					<td><%=or_dead.getDead_stock_category() %></td>
					<td><%=or_dead.getDead_reason() %></td>
					<td><%=or_dead.getDead_date() %></td>
					
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
			
			
		<div class="btn_row">
		

			
		

			<a onclick="checkedarray_fordelete()">Delete</a>
			
		
			</div>
	
		</div>
	

	<div class="overlay"></div>	
		
	
		
		<!-- For Delete Checked Records  -->
		
		<div class="delete_arr_form">
		<span onclick="closeedit_model()">&times;</span>
		<i class="fa-regular fa-circle-xmark"></i>
		<form action="dead_stock_array_delete" method="post">
			<input id = "delete_array" name="delete_array_deadstock" hidden>
			<label>Do you want to delete records ?</label><br><br>
						<button class="btn-yes" type="submit" value="Register">Yes</button>
						<a href="Display_dead_stock.jsp"  class="btn-no" >No</a>
		</form>
		</div>


</body>




<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>  

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>  

<script type="text/javascript">


	function selectcheckall(){
		
		var tab = document.getElementById('table2');
		var rowcont = tab.rows.length;
		var tot_rowcont = tab.tBodies[0].rows.length; 
		//alert(tot_rowcont);
		
		
		const ischeck = document.getElementById('checkbox_all').checked;
		const els = document.getElementsByClassName("checkbox_one");
		
		
		if(ischeck){
				var i=0;
				
				while(i<tot_rowcont){
					els[i].checked = true;
					i++;
				}
			
			}else{
				var i=0;
				
				while(i<tot_rowcont){
					els[i].checked = false;
					i++;
				}
			}
			
	
	}
	
	
	
	function checkedarray(){
		
		
		var tab1 = document.getElementById('table2');
		var rowcont1 = tab1.rows.length;
		var tot_rowcont1 = tab1.tBodies[0].rows.length; 
		
		
		
		const els1 = document.getElementsByClassName("checkbox_one");
		
		const arrvalue = [];
		var cnt1 = 0;
		
		
		while(cnt1<tot_rowcont1){
			
			if(els1[cnt1].checked){
				var asd = els1[cnt1].value;
				 arrvalue[cnt1] = asd;
			}
			
			cnt1++;
		}
		

		document.getElementById("array_script").value = arrvalue;		
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.stock_update').classList.add('show_stockupdate');
	}

	
	
	
	

	function checkedarray_fordelete(){
		
	
		var tab1 = document.getElementById('table2');
		var rowcont1 = tab1.rows.length;
		var tot_rowcont1 = tab1.tBodies[0].rows.length; 
		
		
		
		const els1 = document.getElementsByClassName("checkbox_one");
		
		const arrvalue = [];
		var cnt1 = 0;
		
		
		while(cnt1<tot_rowcont1){
			
			if(els1[cnt1].checked){
				var asd = els1[cnt1].value;
				 arrvalue[cnt1] = asd;
			}
			
			cnt1++;
		}
		
		
		document.getElementById("delete_array").value = arrvalue;			
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.delete_arr_form').classList.add('show_delete_arr_form');
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
	    doc.text(130, y = y + 10, "Dead Stock");
	    
	    
	    doc.autoTable({  
	        html: '#bookTable',  
	        startY: 70,  
	        theme: 'grid',  
	       
	         
	        styles: {  
	            minCellHeight: 20  
	        } 
	        
	    })  
	    doc.save('Dead Stocks.pdf');  
	}  

	
	
</script>





<script type="text/javascript">
function showedit_category_model(book_id, book_dept, book_cat, book_classino, book_title, book_sub_title, book_subject, book_edition, 
		book_author, book_publi, book_publi_yy, book_vend, book_page, book_price, book_rack, book_lang) {
	
	document.getElementById('edit_book_id').value = book_id;
	document.getElementById('edit_book_dept').value = book_dept; 
	document.getElementById('edit_book_cat').value = book_cat;
	document.getElementById('edit_book_classino').value = book_classino;
	document.getElementById('edit_book_title').value = book_title;
	document.getElementById('edit_book_sub_title').value = book_sub_title;
	document.getElementById('edit_book_subject').value = book_subject;
	document.getElementById('edit_book_edition').value = book_edition;
	document.getElementById('edit_book_author').value = book_author;
	document.getElementById('edit_book_publi').value = book_publi;
	document.getElementById('edit_book_publi_yy').value = book_publi_yy;
	document.getElementById('edit_book_vend').value = book_vend;
	document.getElementById('edit_book_page').value = book_page;
	document.getElementById('edit_book_price').value = book_price;
	document.getElementById('edit_book_rack').value = book_rack;
	document.getElementById('edit_book_lang').value = book_lang;

	
	
	document.querySelector('.overlay').classList.add('showoverlay');
	document.querySelector('.update_form').classList.add('showupdate_form');
}



function closeedit_model() {

	
	document.querySelector('.overlay').classList.remove('showoverlay');
	document.querySelector('.delete_arr_form').classList.remove('show_delete_arr_form');
}

	</script>
	






</html>