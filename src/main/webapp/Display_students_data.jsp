<%@page import="java.io.OutputStream"%>
<%@page import="com.entity.library_department"%>
<%@page import="com.dao.DeptDAO"%>
<%@page import="com.entity.Student_enti"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Students Record</title>


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

.page_haiding{
		background: #437fc7;
		text-align: center;
		
		color: white;
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
	
	
	
	
    		   <%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succmsg");
    		   
    		   
    		   %>	 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="pramot faild"){
    		 		
    		 		swal("Error", "Student Pramote Faild", "error");
    		 	}
    		 	else if(msggg=="pramot success"){
    		 		
    		 		swal("Success", "Student Pramote Sucessfull", "success");
    		 		
				}else if(msggg =="update success"){
					
					swal("Success", "Student Data Update Sucessfull", "success");
					
				}else if(msggg =="update faild"){
					
					swal("Error", "Student Data Update Faild", "error");
					
				}else if(msggg =="delete success"){
					
					swal("Success", "Student Data Delete Sucessfull", "success");
					
				}else if(msggg =="delete faild"){
					
					swal("Error", "Student Data Delete Faild", "error");
					
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
    		

	<div class="book_data_container">
	
		<div class="page_haiding">
			<h3>Student Master</h3>
		</div>
		
		<form action="Display_student_search_data.jsp" method="get">
		<div class="row_design">
		<div class="row">
			<div class="col"><select name="search_table_name">
			
				<option value="Stud_id">ID</option>
				<option value="stud_name">Name</option>
				<option value="stud_class">Class</option>
				<option value="stud_dept">Department</option>
			
			</select></div>
			<div class="col"><input type="text" name="search_content" required/></div>
			<div class="col"><button>Search</button></div>
		</div>
		</div>
		</form>
	
	
<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>

	<div class="card">
	<table id="table1" class="table table-bordered" >
		<thead>
			
			<th> <input type="checkbox" id="checkbox_all" onchange ="selectcheckall()" ></th>
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Class</th>
			<th>DOB</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Photo</th>
			<th>&nbsp;&nbsp;Action &nbsp;&nbsp;&nbsp;&nbsp;</th>
			
		</thead>
		<tbody>
	
			
			<%
			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			List<Student_enti> list = dao.getall_students();
			
			for(Student_enti stud:list){
		
			%>
		
				<tr>			
					<td><input type="checkbox" class="checkbox_one" value="<%=stud.getStud_id() %>" name= "check_bx" ></td>
					<td><%=stud.getStud_id() %></td>
					<td><%=stud.getStud_name() %></td>
					<td><%=stud.getStud_dept() %></td>
					<td><%=stud.getStud_class() %></td>
					<td><%=stud.getStud_dob() %></td>
					<td>A/P: <%=stud.getStud_city() %>, Tal: <%=stud.getStud_taluka() %>, Dist: <%=stud.getStud_dist() %></td>
					<td><%=stud.getStud_phone() %></td>
					<td><%=stud.getStud_email() %></td>	
					<td><img alt="Image not found" src="<%=stud.getEncodeimg() %>"  style="height: 100px; width: 80px;"> </td>
					<td>
					<a	href="#" onclick="showedit_category_model('<%=stud.getStud_id()%>', '<%=stud.getStud_name() %>', '<%=stud.getOriginal_dept() %>',
						'<%=stud.getStud_class() %>', '<%=stud.getStud_dob() %>', '<%=stud.getStud_city() %>', '<%=stud.getStud_taluka() %>',
						'<%=stud.getStud_dist() %>', '<%=stud.getStud_phone() %>', '<%=stud.getStud_email() %>')"  >Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="delete_one_stud?book_id=<%=stud.getStud_id() %>" style="color: red;">Delete</a></td>
				</tr>
				
		
			<%
			
			}
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
		
		
		<!-- This Hidden table for Print data into Database -->

		
		<table class="table table-bordered" id="studentTable" hidden>
		<thead>
			
			
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Class</th>
			<th>DOB</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Email</th>
		
			
		</thead>
		<tbody>
	
			
			<%
			
			List<Student_enti> list4 = dao.getall_students();
			
			for(Student_enti stud:list4){
		
			%>
		
				<tr>			
					
					<td><%=stud.getStud_id() %></td>
					<td><%=stud.getStud_name() %></td>
					<td><%=stud.getStud_dept() %></td>
					<td><%=stud.getStud_class() %></td>
					<td><%=stud.getStud_dob() %></td>
					<td>A/P: <%=stud.getStud_city() %>, Tal: <%=stud.getStud_taluka() %>, Dist: <%=stud.getStud_dist() %></td>
					<td><%=stud.getStud_phone() %></td>
					<td><%=stud.getStud_email() %></td>	
					
				</tr>
				
		
			<%
			
			}
			
			%>
			
			
		</tbody>
	
	</table>	

			
			
		<div class="btn_row">
		

			
			<a onclick=" checkedarray()" >Pramote to Next Class</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			<a onclick="checkedarray_fordelete()">Delete</a>
		</div>
	
		</div>
		
		<div>
	
		
		</div>
		
	
	<div class="overlay"></div>	
	
		
		<div class="update_form">
		
			<span onclick="closeedit_model()">&times;</span>
			
			<form action="student_update_one" method="post" enctype="multipart/form-data">
			
				
		<!-- <div >
			<img  alt="Image not found" src="for_image.jsp">
		</div> -->
		
		<br>
			
			
		<div class="row">
			<div class="col">Student ID</div>
			<div class="col">Student Name</div>
			<div class="col">Department</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" id="edit_student_id" readonly name="edit_stud_id" required="required" > </div>
			<div class="col"><input type="text" id="edit_student_name"  name="edit_stud_name" required="required" > </div>	
		
			
				<div class="col">
				<select  name="edit_stud_dept"  required="required" id="edit_student_dept">
					<option value="-1"> Select Department</option>			
					<%
					try{
						
						DeptDAO dao1 = new DeptDAO(DBConnect.getConn());
						List<library_department> list1 = dao1.getAlldept();
						for(library_department dept:list1){
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
			<div class="col">Class</div>
			<div class="col">Date of Birth</div>
			<div class="col">City</div>
		</div>		
		
		<div class="row">
			<div class="col"><input type="text" id="edit_student_class" name="edit_stud_class" required="required"> </div>
			<div class="col"><input type="date" id="edit_student_dob" name="edit_stud_dob" required="required"> </div>
			<div class="col"><input type="text" id="edit_student_city" name="edit_stud_city" required="required"> </div>
		</div>
				
		<br>
		
		<div class="row">
			<div class="col">Taluka</div>
			<div class="col">District</div>
			<div class="col">Phone</div>
		</div>
		<div class="row">
			<div class="col"><input type="text" id="edit_student_taluka" name="edit_stud_taluka" required="required" > </div>
			<div class="col"><input type="text" id="edit_student_dist" name="edit_stud_dist" required="required"> </div>
			<div class="col"><input type="number" id="edit_student_phone" name="edit_stud_phone" required="required"> </div>
		</div>	
		
		<br>
		
		<div class="row">
			<div class="col">Email</div>
			<div class="col">Photo</div>
			
		</div>
		<div class="row">
			<div class="col"><input type="email" id="edit_student_email" name="edit_stud_email" required="required" > </div>
			<div class="col"><input  type="file" name="edit_stud_photo" style="padding: 5px; height: 40px;"> </div>
		</div>
				
		<br>
		 
				
		<br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Update</button></div>

		
		</div>
		</form>
		</div>		
		
		
		
		
		<!-- This tag for popup form to enter reason of shifting record into dead stock  -->
		
		
			<div class="stock_update">
			<span onclick="closeedit_model()">&times;</span>
			<form action="stud_pramote" method="post" >
	
				<input id="array_script" name="pramote_stud_id"  hidden>
				<input type ="text" name="student_pramote_class"  placeholder="Enter Next Class" required>
				
				
		
				<button class="btn" type="submit" value="Register">Set</button>
		
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.debug.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.2.3/jspdf.plugin.autotable.js"></script>
 


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
    doc.text(128, y = y + 10, "Total Students");
    
    
    doc.autoTable({  
        html: '#studentTable',  
        startY: 70,  
        theme: 'grid',  
 
        styles: {  
            minCellHeight: 20  
        } 
 
    
    })  
    doc.save('All_Students.pdf');  
}  

	
	
</script>






<script type="text/javascript">
function showedit_category_model(id, name, dept, stud_class, dob, city, taluka, dist, phone, email) {
	

	document.getElementById('edit_student_id').value = id;
	document.getElementById('edit_student_name').value = name;
	document.getElementById('edit_student_dept').value = dept;	
	document.getElementById('edit_student_class').value = stud_class;
	document.getElementById('edit_student_dob').value = dob;
	document.getElementById('edit_student_city').value = city;
	document.getElementById('edit_student_taluka').value = taluka;
	document.getElementById('edit_student_dist').value = dist;
	document.getElementById('edit_student_phone').value = phone;
	document.getElementById('edit_student_email').value = email;

	
	
	
	
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