<%@page import="com.entity.book_category_enti"%>
<%@page import="com.dao.categoryDAO"%>
<%@page import="com.entity.library_department"%>
<%@page import="com.dao.DeptDAO"%>
<%@page import="com.entity.Magazine_enti"%>
<%@page import="com.dao.Original_magDAO"%>
<%@page import="com.entity.publisher_enti"%>
<%@page import="com.dao.PublisherDAO"%>
<%@page import="com.entity.Vender_enti"%>
<%@page import="com.dao.VenderDAO"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.Original_bookDAO"%>
<%@page import="com.entity.Original_book_enti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Magazine</title>

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
	margin-left: 420px;

}

.btn_row a{

	border: 1px solid;
	cursor: pointer;
	padding: 7px 13px;	
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

.update_form  {
	top: -150%;
	left: 20%;
	width: 1050px;
	height: 640px;
	position: absolute;
	background: white;
	padding: 30px; 	
	transition: 2s;
}

.showupdate_form{
	top: 3%;
	z-index: 1;
}

.update_form input{
	width:100%;
	height: 35px; 
	margin-bottom: 15px;
	padding-left: 10px; 
}

.update_form select{
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




.stock_update{
	margin-top: -63%;
	margin-left: 44%;
	height: 130px;
	width: 440px;
	padding: 60px 25px;
	background: white;	
	position: absolute;
	transition: 2s;
	z-index: 10;
	
}
.stock_update input{
	height: 40px;
	width: 300px;
	border: 1px solid;
	padding: 5px;
}

.stock_update span{
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


.stock_update button{
	border: 1px solid;
	border-radius: 10px;
	background: #437fc7; 
	color: white;
	width: 80px;
	margin-left: 5px;
}
	
.show_stockupdate{
	margin-top: -33%;
	margin-left: 44%;
	z-index: 25;
	opacity: 1;
}



/**************/
	
	
	
.delete_arr_form{

	margin-left: 650px;
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

	margin-left: 650px;
	margin-top: -475px;
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
	
	<script>var bookData;</script>
	
	
			<!--This Code for display an success or error message to the user  -->
    		    		
	
	  
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
    		 		
				}else if(msggg=="update"){
    		 	
    		 		swal("Success", "Magazine Update Sucessfull", "success");
    		 		
    		 	}else if(msggg=="update faild"){
    		 	
    		 		swal("Error", "Magazine Update Unsucessfull", "error");
    		 		
    		 	}else if(msggg == "dead_stock_success"){
					
					swal("Success", "Magazine Shifted in dead stock Sucessfull", "success");
					
				}else if(msggg == "dead_stock_faild"){
					
					swal("Error", "Magazine Shifted in dead stock Unsucessfull", "error");
					
				}
    		 	
    		 	
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
    		
	
	
	
	
	<div class="book_data_container">
	
		<div class="page_haiding">
			<h3>Magazine Master</h3>
		</div>
		
		<form action="Display_search_magazine_data.jsp" method="get">
		<div class="row_design">
		<div class="row">
			<div class="col"><select name="search_table_name">
			
				<option value="or_mag_id">ID</option>
				<option value="or_mag_title">Title</option>
				<option value="or_mag_author">Author</option>
				<option value="or_mag_dept">Department</option>
				<option value="or_mag_language">Language</option>	
			
			</select></div>
			<div class="col"><input type="text" name="search_content" required/></div>
			<div class="col"><button>Search</button></div>
		</div>
		</div>
		</form>
	
	
	
	
		<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>
	<div class="card">
	<table class="table table-bordered" id="table1">
		<thead>
			
			<th> <input type="checkbox" id= "checkbox_all" onchange ="selectcheckall()" /></th>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
		
			<th>Language</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Action &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			
		</thead>
		<tbody>
	
			
			<%
			Original_magDAO Or_mag_dao = new Original_magDAO(DBConnect.getConn());
			List<Magazine_enti> list = Or_mag_dao.getall_or_magzine();
			
			
			for(Magazine_enti or_mag:list){
		
			%>
		
				<tr>			
					<td><input type="checkbox" class="checkbox_one" value="<%=or_mag.getMag_id()%>" name= "check_bx" /></td>
					<td><%=or_mag.getMag_id() %></td>
					<td><%=or_mag.getMag_title() %></td>
					<td><%=or_mag.getMag_author() %></td>
					<td><%=or_mag.getMag_dept() %></td>
					<td><%=or_mag.getMag_catrgory() %></td>
					<td><%=or_mag.getMag_language() %></td>
					
					<td>
					<a href="#" onclick="showedit_category_model(<%=or_mag.getMag_id() %>, '<%=or_mag.getMag_dept()%>', 
						'<%=or_mag.getMag_catrgory() %>', '<%=or_mag.getMag_classif_no()%>', '<%=or_mag.getMag_title() %>',
						'<%=or_mag.getMag_sub_title()%>', '<%=or_mag.getMag_edition() %>', '<%=or_mag.getMag_author()%>',
						'<%=or_mag.getMag_publisher() %>', '<%=or_mag.getMag_publi_year()%>', '<%=or_mag.getMag_vend_nm()%>',
						'<%=or_mag.getMag_pages()%>', <%=or_mag.getMag_price()%>, '<%=or_mag.getMag_rack_no()%>', 
						'<%=or_mag.getMag_language() %>')">Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="single_mag_delet?single_mag_id=<%=or_mag.getMag_id()%>" style="color: red;">Delete</a></td>
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
		
		
		
		<!-- This Hidden table for print Report in pdf -->
		
		
		<table id="OrMagTable" class="table table-bordered" hidden>
		<thead>
			
			
			
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Edition</th>
			<th>Publisher</th>
			<th>Language</th>
			
			
		</thead>
		<tbody>
	
		<%
		
			List<Magazine_enti> list1 = Or_mag_dao.getall_or_magzine();
			
			
			for(Magazine_enti or_mag:list1){
		
			%>
		
				<tr>			
					
					<td><%=or_mag.getMag_id() %></td>
					<td><%=or_mag.getMag_title() %></td>
					<td><%=or_mag.getMag_author() %></td>
					<td><%=or_mag.getMag_dept() %></td>
					<td><%=or_mag.getMag_catrgory() %></td>
					<td><%=or_mag.getMag_edition() %></td>
					<td><%=or_mag.getSearch_publisher() %></td>
					<td><%=or_mag.getMag_language() %></td>
					
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
			
			
				
		<div class="btn_row">
		

			
			<a onclick=" checkedarray()" >Dispose Book</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			

			<a onclick="checkedarray_fordelete()">Delete</a>
			
		
			
			
		</div>
	
	</div>
		
		
		
			
	<!-- This Tag for Show Popup for Edit record  -->
	
	
	<div class="overlay"></div>	
	
		
		<div class="update_form">
		
			<span onclick="closeedit_model()">&times;</span>
			
			
			
	<form action="original_magazine_update" method="post">
		<div class="row">
			
			<div class="col">ID</div>
			<div class="col">Department</div>
			<div class="col">Category</div>
			
		</div>
		<div class="row">
			
			<div class="col"><input type="text"  id="edit_mag_id" name="magazine_edit_id"  readonly="readonly" > </div>
			
			
			 <div class="col"><input type="text"  id="edit_mag_dept" name="magazine_edit_dept"  readonly="readonly" > </div>
			  <div class="col"><input type="text" id="edit_mag_cat" name="magazine_cat" readonly="readonly" > </div>
			
		</div>
		
		<br>
		
		<div class="row">
			<div class="col">Classification No. </div>
			<div class="col">Title</div>
			<div class="col">Sub-title</div>
			
			
		</div>		
		
		<div class="row">
			
			 <div class="col"><input type="text" id="edit_mag_classino" placeholder="Classification No." name="magazine_Clasif_No"  > </div>
			<div class="col"><input type="text" id="edit_mag_title"  name="magazine_title" required="required"> </div>
			<div class="col"><input type="text" id="edit_mag_sub_title"  name="magazine_sub_title" > </div>
			
		</div>
				
		<br>
		
		<div class="row">
			
			<div class="col">Edition</div>	
			<div class="col">Author Name</div>
			<div class="col">Publisher Name</div>
		</div>
		<div class="row">
			
			<div class="col"><input type="text" id="edit_mag_edition"  name="magazine_edition" > </div>
			
			<div class="col"><input type="text" id="edit_mag_author"  name="magazine_author" required="required" > </div>
			
		 
					
			<div class="col"><select name="magazine_publisher" id = "edit_mag_publi" required="required"> 
					
			<option value="-1"> Select Publisher</option>			
				<%
					try{
						
						PublisherDAO publdao = new PublisherDAO(DBConnect.getConn());
						List<publisher_enti> list2 = publdao.getallpublishers();
						for(publisher_enti publ:list2){
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
		</div>	
		
		
		
		<br>
		
		<div class="row">
			
			
			<div class="col">Publishing Year</div>
			<div class="col">Vender Name</div>
			<div class="col">Magazine Pages</div>
		</div>
		<div class="row">
			
			
			
			<div class="col"><input type="text" id="edit_mag_publi_yy" name="magazine_publ_year" required="required"> </div>
			
			
				<div class="col">
			<select name="book_vend_name" id="edit_mag_vend" required="required" > 
				<option value="-1">Select Vender</option>
				
				<%				
					try{
						VenderDAO venddao = new VenderDAO(DBConnect.getConn());
						List<Vender_enti> list5 = venddao.getallvenders();
						for(Vender_enti vend:list5){
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
			<div class="col"><input type="text" id="edit_mag_page" name="magazine_pages" required="required"> </div>
		</div>
				
		<br>
		
		<div class="row">
			
			
			<div class="col">Magazine Price</div>
			<div class="col">Rack Number</div>
			<div class="col">Language</div>
		</div>
		<div class="row">
			
			
			
			
			<div class="col"><input type="text" id="edit_mag_price" name="magazine_price" required="required"> </div>
			<div class="col"><input type="text" id="edit_mag_rack" name="magazine_rack_no" required="required" > </div>
			<div class="col"><input type="text" id="edit_mag_lang" name="magazine_language" required="required"> </div>
		</div>
		
		<br>		
				
		<br><br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Update</button></div>

		<div class="col"></div>
		</div>
		</form>
			
		</div>		
		
		
		
		
			<!-- This tag for popup form to enter reason of shifting record into dead stock  -->
		
		
			<div class="stock_update">
			<span onclick="closeedit_model()">&times;</span>
			<form action="array_dead_stock_mag" method="post" >
	
				<input id="array_script" name="demo_array"  hidden>
				<input type ="text" name="dead_stock_reason"  placeholder="Enter Reason" >
		
				<button class="btn" type="submit" value="Register">Set</button>
		
			</form>
		</div>
		
		
		<!-- For Delete Checked Records  -->
		
		<div class="delete_arr_form">
		<span onclick="closeedit_model()">&times;</span>
		<i class="fa-regular fa-circle-xmark"></i>
		<form action="magazine_array_delete" method="post">
			<input id = "delete_array" name="delete_array_magazine" hidden>
			<label>Do you want to delete records ?</label><br><br>
						<button class="btn-yes" type="submit" value="Register">Yes</button>
						<a href="Display_magazine_data.jsp"  class="btn-no" >No</a>
		</form>
		</div>
	
	
	
	
	
	
</body>




<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>  

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>  

<script type="text/javascript">


	function selectcheckall(){
		
		var tab = document.getElementById('table1');
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
		
		
		var tab1 = document.getElementById('table1');
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
		
		
		var tab1 = document.getElementById('table1');
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
	    doc.text(124, y = y + 10, "Total Magazines");
	    
	    
	    doc.autoTable({  
	        html: '#OrMagTable',  
	        startY: 70,  
	        theme: 'grid',  
	       
	         
	        styles: {  
	            minCellHeight: 20  
	        } 
	        
	    })  
	    doc.save('All_Magazines.pdf');  
	}  

	
	
</script>





<script type="text/javascript">
function showedit_category_model(book_id, book_dept, book_cat, book_classino, book_title, book_sub_title, book_edition, 
		book_author, book_publi, book_publi_yy, book_vend, book_page, book_price, book_rack, book_lang) {
	
	document.getElementById('edit_mag_id').value = book_id;
	document.getElementById('edit_mag_dept').value = book_dept; 
	document.getElementById('edit_mag_cat').value = book_cat;
	document.getElementById('edit_mag_classino').value = book_classino;
	document.getElementById('edit_mag_title').value = book_title;
	document.getElementById('edit_mag_sub_title').value = book_sub_title;
	
	document.getElementById('edit_mag_edition').value = book_edition;
	document.getElementById('edit_mag_author').value = book_author;
	document.getElementById('edit_mag_publi').value = book_publi;
	document.getElementById('edit_mag_publi_yy').value = book_publi_yy;
	document.getElementById('edit_mag_vend').value = book_vend;
	document.getElementById('edit_mag_page').value = book_page;
	document.getElementById('edit_mag_price').value = book_price;
	document.getElementById('edit_mag_rack').value = book_rack;
	document.getElementById('edit_mag_lang').value = book_lang;

	
	
	document.querySelector('.overlay').classList.add('showoverlay');
	document.querySelector('.update_form').classList.add('showupdate_form');
}



function closeedit_model() {
	document.querySelector('.overlay').classList.remove('showoverlay');
	document.querySelector('.update_form').classList.remove('showupdate_form');
	
	document.querySelector('.overlay').classList.remove('showoverlay');
	document.querySelector('.stock_update').classList.remove('show_stockupdate');
	
	document.querySelector('.overlay').classList.remove('showoverlay');
	document.querySelector('.delete_arr_form').classList.remove('show_delete_arr_form');
}

	</script>
	













</html>