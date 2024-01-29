<%@page import="com.dao.StaffDAO"%>
<%@page import="com.entity.Staff_enti"%>
<%@page import="com.entity.library_department"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Search Staff </title>


<style type="text/css">


.book_data_container{
	margin-left: 250px;
	margin-top: 0px;
	height: 100%;
	width: 82%;
	
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
	margin-top: 20px;
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

.page_haiding{
		background: #437fc7;
		text-align: center;
		
		color: white;
}

.btn_row{
	margin-top: 30px;
	margin-left: 500px;

}

.btn_row a{

	border: 1px solid;
	cursor: pointer;
	padding: 7px 17px;	
	background: #cccccc;
	border-radius: 5px; 
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
	left: 20%;
	width: 1050px;
	height: 540px;
	position: absolute;
	background: white;
	padding: 30px; 	
	transition: 2s;
}

.showupdate_form{
	top: 10%;
	z-index: 1;
}

.update_form input{
	width:100%;
	height: 35px; 
	margin-bottom: 15px;
	padding-left: 10px; 
}

.update_form img{
	height: 150px;
	width: 120px;
	margin-left: 400px;
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
	transition: 2s;
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
	
	
	
	
    		
    		

	<div class="book_data_container">
	
		<div class="page_haiding">
			<h3>Staff Master</h3>
		</div>
		
	<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>	
	

	<div class="card">
	<table class="table table-bordered" id="table1">
		<thead>
			
			<th> <input type="checkbox" id= "checkbox_all" onchange ="selectcheckall()" /></th>
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>		
			<th>DOB</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Photo</th>
			<th>&nbsp;&nbsp;Action &nbsp;&nbsp;&nbsp;&nbsp;</th>
			
		</thead>
		<tbody>
	
			<%
				
			String serch_table = request.getParameter("search_table_name");
			String serch_cont = request.getParameter("search_content");
			
			
				StaffDAO dao = new StaffDAO(DBConnect.getConn());
				List<Staff_enti> list = dao.get_search_staff(serch_table, serch_cont);
				
				for(Staff_enti staff:list){
			%>
	
		
				<tr>			
					<td><input type="checkbox" class="checkbox_one" value="<%=staff.getStaff_id() %>" name= "check_bx" /></td>
					<td><%=staff.getStaff_id() %></td>
					<td><%=staff.getStaff_name() %></td>
				
					<td><%=staff.getStaff_dept() %></td>
					<td><%=staff.getStaff_dob() %></td>
					<td>A/P: <%=staff.getStaff_city() %>, Tal: <%=staff.getStaff_taluka() %>, Dist: <%=staff.getStaff_dist() %></td>
					<td><%=staff.getStaff_phone() %></td>
					<td><%=staff.getStaff_email() %></td>	
					<td><img alt="Image not found" src="<%=staff.getEncodeimg() %>"  style="height: 100px; width: 80px;"> </td>
					<td>
					<a	href="#" onclick="showedit_category_model('<%=staff.getStaff_id() %>', '<%=staff.getStaff_name() %>', 
					'<%=staff.getOriginal_dept() %>', '<%=staff.getStaff_dob() %>', ' <%=staff.getStaff_city() %>', 
					' <%=staff.getStaff_taluka() %>', '<%=staff.getStaff_dist() %>', '<%=staff.getStaff_phone() %>', 
					'<%=staff.getStaff_email() %>')"  >Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="" style="color: red;">Delete</a></td>
				</tr>
				
		
			<%
			
				}
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
		
		
		
		
		<table class="table table-bordered" id="staffTable" hidden>
		<thead>
			
			
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>		
			<th>DOB</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Email</th>
			
			
			
		</thead>
		<tbody>
	
			<%
				
			
			
				List<Staff_enti> list2 = dao.get_search_staff(serch_table, serch_cont);
				
				for(Staff_enti staff:list2){
			%>
	
		
				<tr>			
					
					<td><%=staff.getStaff_id() %></td>
					<td><%=staff.getStaff_name() %></td>
				
					<td><%=staff.getStaff_dept() %></td>
					<td><%=staff.getStaff_dob() %></td>
					<td>A/P: <%=staff.getStaff_city() %>, Tal: <%=staff.getStaff_taluka() %>, Dist: <%=staff.getStaff_dist() %></td>
					<td><%=staff.getStaff_phone() %></td>
					<td><%=staff.getStaff_email() %></td>	
					
					
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
		
		<div>
	
		
		</div>
		
	
	<div class="overlay"></div>	
	
		
		<div class="update_form">
		
			<span onclick="closeedit_model()">&times;</span>
			
			<form action="staff_update" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col">Staff ID</div>
			<div class="col">Staff Name</div>
			<div class="col">Department</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" placeholder="Staff Id" id = "edit_stff_id" name="staff_id" required="required" > </div>
			<div class="col"><input type="text" placeholder="Staff Full Name" id = "edit_stff_name" name="staff_name" required="required" > </div>
			
			
				<div class="col"><select  name="staff_dept" id = "edit_stff_dept" required="required" >
				<option value="-1"> Select Department</option>			
				<%
					try{
						
						DeptDAO dao2 = new DeptDAO(DBConnect.getConn());
						List<library_department> list3 = dao2.getAlldept();
						for(library_department dept:list3){
						%>
						<option value="<%=dept.getDept_id()%>"><%=dept.getDept_name() %></option>
						
						<%							
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				%>	
				
				</select> </div>
		</div>
		
		<br>
		
		<div class="row">
			
			<div class="col">Date of Birth</div>
			<div class="col">City</div>
			<div class="col">Taluka</div>
		</div>		
		
		<div class="row">
			
			<div class="col"><input type="date" id = "edit_stff_dob" name="staff_date_of_birth" required="required"> </div>
			<div class="col"><input type="text" id = "edit_stff_city" placeholder="City" name="staff_city" required="required"> </div>
			<div class="col"><input type="text" placeholder="Taluka" id ="edit_stff_taluka" name="staff_taluka" required="required" > </div>
		</div>
				
		<br>
		
		<div class="row">
			
			<div class="col">District</div>
			<div class="col">Phone</div>
			<div class="col">Email</div>
		</div>
		<div class="row">
			
			<div class="col"><input type="text" placeholder="District" id = "edit_stff_dist" name="staff_dist" required="required"> </div>
			<div class="col"><input type="number" placeholder="Phone" id = "edit_stff_phone" name="staff_phone" required="required"> </div>
			<div class="col"><input type="email" placeholder="Email ID" id = "edit_stff_email" name="staff_email" required="required" > </div>
		</div>	
		
		<br>
		
		<div class="row">
			
			<div class="col">Photo</div>
			
		</div>
		<div class="row">
			
			<div class="col"><input  type="file" name="staff_photo" style="padding: 5px; height: 40px;"> </div>
		</div>
				
		<br>
			
				
		<br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Update</button></div>

		<div class="col"></div>
		</div>
		</form>
		
		</div>
		
		
		
		
		
		<!-- For Delete Checked Records  -->
		
		<div class="delete_arr_form">
		<span onclick="closeedit_model()">&times;</span>
		<i class="fa-regular fa-circle-xmark"></i>
		<form action="student_array_delete" method="post">
			<input id = "delete_array" name="delete_array_stud" hidden>
			<label>Do you want to delete records ?</label><br><br>
						<button class="btn-yes" type="submit" value="Register">Yes</button>
						<a href="Display_students_data.jsp"  class="btn-no" >No</a>
		</form>
		</div>
		
		

</body>


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
	
	


//For Download Table Data  


function generate() { 
	
	var tab = "<%=serch_table%>";
	var temp_cont = "<%=serch_cont%>";
	
	var cont = temp_cont.toUpperCase();
	
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

if(tab=="stf_dept"){
	 
	 doc.text(117, y = y + 10, "Staff Department : "+cont);

}else{
	 
	 doc.text(138, y = y+10, "Staff");
	 
}


doc.autoTable({  
   html: '#staffTable',  
   startY: 70,  
   theme: 'grid',  

   styles: {  
       minCellHeight: 20  
   } 


})  
doc.save('Search Staff.pdf');  
}  
	
</script>






<script type="text/javascript">
function showedit_category_model(id, name, dept, dob, city, taluka, dist, phone, email) {
	

	document.getElementById('edit_stff_id').value = id;
	document.getElementById('edit_stff_name').value = name;
	document.getElementById('edit_stff_dept').value = dept;
	document.getElementById('edit_stff_dob').value = dob;
	document.getElementById('edit_stff_city').value = city;
	document.getElementById('edit_stff_taluka').value = taluka;
	document.getElementById('edit_stff_dist').value = dist;
	document.getElementById('edit_stff_phone').value = phone;
	document.getElementById('edit_stff_email').value = email;

	
	
	
	
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