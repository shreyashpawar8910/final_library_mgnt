<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.function.Function"%>
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
<title>Department Register</title>
<%@include file="all_component/all_css.jsp" %>

<style type="text/css">


.dept_container{
	margin-left: 250px;
	margin-top: 0px;
	height: 93vh;
	width: 82%;
	
}

.dept_container .btn-download{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
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
    		 		
    		 		swal("Error", "Department Insertion Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="insert success"){
    		 		
    		 		swal("Success", "Department Insertion Sucessfull", "success");
    		 		
				}else if(msggg=="update faild"){
    		 		
    		 		swal("Error", "Department Update Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="update success"){
    		 	
    		 		swal("Success", "Department Update Sucessfull", "success");
    		 		
				}if(msggg=="delete faild"){
    		 		
    		 		swal("Error", "Department Delete Unsucessfull", "error");
    		 	}
    		 	else if(msggg=="delete success"){
    		 		swal("Success", "Department Delete Sucessfull", "success");
				}
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		
	
	
	
	<div class="dept_container">	
	
	<div class="page_haiding">
		<h3>Department Master</h3>
	</div>
	
	
	<div class="row_design">
		<form action="department" method="post">
		<div class="row">
			<div class="col">Department ID </div>
			<div class="col">Department Name</div>
			<div class="col">Department Duration</div>
		</div>
		<div class="row">
		
			<%
			library_department dept1 = new library_department();
			DeptDAO dao1 = new DeptDAO(DBConnect.getConn());
			boolean f = dao1.last_id_department(dept1);
			%>
		
			<div class="col"><input type="text" value="<%=dept1.getDept_id() %>" name="dept_id" required="required"  readonly> </div>
			<div class="col"><input type="text" placeholder="Department Name" name="dept_name" required="required"> </div>
			<div class="col"><input type="number" placeholder="Department duration" name="dept_dur" required="required"> </div>
		</div>
				
		<br><br><br>
		<div class="row">
		<div class="col"><button class="btn" type="submit" value="Register">Save</button></div>
		
		

		<div class="col"></div>
		</div>
		</form>
		
		
	</div>
	
	<br><br><br>
		<div class="col"><button class="btn-download" type="submit" id="download" onclick="generate()"><i class="fa-solid fa-download"></i>&nbsp; Download</button></div>	
	<br>
	<div class="card">
	<table id="deptTable" class="table table-bordered">
		<thead>
		
			<th>ID</th>
			<th>Name</th>
			<th>Duration</th>
			<th>Actions</th>

		</thead>
		<tbody>
	
			
			<%
				DeptDAO dao = new DeptDAO(DBConnect.getConn());
				List<library_department> list = dao.getAlldept();
				for(library_department dept:list){
			%>
		
				<tr>			
					
					<td><%=dept.getDept_id() %></td>
					<td><%=dept.getDept_name() %></td>
					<td><%=dept.getDept_dur() %></td>
					<td>
					<a href="#" onclick="showedit_model(<%=dept.getDept_id()%>,'<%=dept.getDept_name()%>',<%=dept.getDept_dur()%>)">Edit</a>
					&nbsp;&nbsp;&nbsp;
					<a href="dept_delete?dept_id=<%=dept.getDept_id() %>" style="color: red;">Delete</a></td>
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
			
			<form action="dept_edit" method="post">
			
			<div>
					<label>Department Id</label>
					<input type="text" id="deptIdText" name="edit_dept_id" readonly>
				</div>
				<div>
					<label>Department Name</label>
					<input type="text"  id="deptnameid" name="edit_dept_name">
				</div>
				<div>
					<label>Department Duration</label>
					<input type="text" id="deptdurId" name="edit_dept_dur">
				</div>
				<button>Update</button>
			
			</form>
		</div>
		
	</div>
		
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>  


	<script type="text/javascript">
	
	$("#deptTable").tableHTMLExport({
		  type:'pdf',
		  orientation:'p'
		});

	
		function showedit_model(id,name,dur) {
			
			document.getElementById('deptIdText').value=id;
			document.getElementById('deptnameid').value=name;
			document.getElementById('deptdurId').value=dur;
			
			document.querySelector('.overlay').classList.add('showoverlay');
			document.querySelector('.update_form').classList.add('showupdate_form');
		}
		
		function closeedit_model() {
			document.querySelector('.overlay').classList.remove('showoverlay');
			document.querySelector('.update_form').classList.remove('showupdate_form');
		}
		
		
		function generate() {  
		    var doc = new jsPDF('p', 'pt', 'letter');  
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
		        top: 150,  
		        bottom: 60,  
		        left: 40,  
		        right: 40,  
		        width: 600  
		    };  
		    var y = 20;  
		    doc.setLineWidth(2);  
		    doc.text(150, y = y + 10, "Yashwantrao Chavan Mahavidhlaya Islampur");  
		    doc.autoTable({  
		        html: '#deptTable',  
		        startY: 70,  
		        theme: 'grid',  
		       
		        columnStyles: {  
		            0: {  
		                cellWidth: 50,  
		            },  
		            1: {  
		                cellWidth: 50,  
		            },  
		            2: {  
		                cellWidth: 50,  
		            }  
		        },  
		        styles: {  
		            minCellHeight: 20  
		        } 
		        
		    })  
		    doc.save('Department.pdf');  
		}  
		
	</script>
	
</html>


