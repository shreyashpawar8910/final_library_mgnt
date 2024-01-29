<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>  

<%@include file="all_component/all_css.jsp" %>

<style type="text/css">

*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Times New Roman;
}

.side-bar{
	background:  #437fc7;
	height: 100vh;
	width: 250px;
	position: fixed;
	top: 0;
	left: 0;
	overflow: scroll;
	overflow-x: hidden; 

}

.side-bar .menu{
	width: 100%;
	margin-top: 0px;

}

.side-bar .menu .item{
	position: relative;
	cursor: pointer;		
	border: 1px solid;
		
}

.side-bar .menu .item a{
	color: white;

	font-size: 19px;
	text-decoration: none;
	display: block;
	padding: 5px 15px;
	line-height: 50px;
	
}

.side-bar .menu .item :hover{
		background: white;
		color: #437fc7;
		transition: .4s;
		border-radius: 10px;
		
}

.side-bar .menu .item i{
	margin-right: 15px;
}

.side-bar .menu .item a .dropdown{
	position: absolute;
	right: 0;
	margin: 20px;
	transition: .3s easa;
	
}

.side-bar .menu .item .sub-menu{
	background: #437fc7;
	display: none;
	border: 1px solid;
}


.side-bar .menu .item .sub-menu a{
	padding-left: 40px;
	
}

.rotate{
transform: rotate(90deg);

}
 .lable h4{
 	color: white;
 }

.upper_navbar{
	margin-left: 250px;
	background: linear-gradient( #e699ff, #437fc7);
	height: 72px;
}

.upper_navbar h5{
	padding-top: 10px;
	padding-left: 15px;
	font-family: Times New Roman;
	font-size: 36px;
	text-align: center;
	color: #ff704d;
	font-weight: bolder;
}


.upper_navbar h4{
	margin-top: -29px;
	padding-left: 930px;
	font-family: Times New Roman;
	font-size: 18px;
}


.upper_navbar h6{
	text-align: center;
	font-family: Times New Roman;
	font-size: 20px;


}

.libr_haiding{
	background: linear-gradient(#437fc7, #e699ff);
	height: 75px;
}


.libr_haiding h6{
	margin-top: 30px;
	text-align: center;
	font-size: 25px;
	color: yellow;
	font-family: Times New Roman;
	font-weight: bolder;
}


::-webkit-scrollbar{
	width: 0px;
}


</style>




</head>




<body>
	
	<%
	String for_login = (String)session.getAttribute("user_role");
	
	
	 %>
	
		
	<div class="upper_navbar">
		
	
	
	</div>
	
	<div class="side-bar">
	
		<div class="libr_haiding">	<h6>Library  Management System</h6></div>
		
		
		<div class="menu">
			<div class="item"><a href="Dashboard.jsp"><i class="fa-solid fa-house"></i>Dashboard</a></div>
			
			<div class="item">
				<a class="sub-btn"><i class="fa-solid fa-book"></i>Stock Entry <i class="fas fa-angle-right dropdown"></i> </a>
				<div class="sub-menu">
					<a href="Book_master.jsp" class="sub-item">Book</a>
					<a href="Journal_master.jsp" class="sub-item">journal</a>
					<a href="Magazine_master.jsp" class="sub-item">Magazine</a>
					<a href="#" class="sub-item">Newspaper</a>
				</div>
				
			</div>
			
			<div class="item">
				<a class="sub-btn"><i class="fa-solid fa-pen-to-square"></i>General Master <i class="fas fa-angle-right dropdown"></i></a>
				<div class="sub-menu">
					<a href="Student_register.jsp" class="sub-item">Student Master</a>
					<a href="Staff_register.jsp" class="sub-item">Staff Master</a>
					<a href="department_register.jsp" class="sub-item">Department Master</a>
					
					<a href="book_category_register.jsp" class="sub-item">Category Master</a>
					<a href="vender_master.jsp" class="sub-item">Vender Master</a>
					
				</div>
			</div>
			
			<div class="item">
				<a class="sub-btn"><i class="fa-sharp fa-regular fa-eye"></i> View Records <i class="fas fa-angle-right dropdown"></i></a>
				
					<div class="sub-menu">
						<a href="Display_book_data.jsp" class="sub-item">Books</a>
						<a href="Display_journal_data.jsp" class="sub-item">Journal</a>
						<a href="Display_magazine_data.jsp" class="sub-item">Magazine</a>
						<a href="Display_students_data.jsp" class="sub-item">Students</a>
						<a href="Display_staff_data.jsp" class="sub-item">Staff</a>
						
					</div>		
				
			</div>
	
			
			<div class="item">
				<a class="sub-btn"><i class="fa-sharp fa-solid fa-arrow-right-arrow-left"></i> Transaction <i class="fas fa-angle-right dropdown"></i></a> 
				<div class="sub-menu">
	
					<a href="Input_QR_stud_staff.jsp" class="sub-item">Issue</a>
					<a href="Return_stock_QR_scan.jsp" class="sub-item">Return</a>		
					
					<a class="sub-btn">Reports <i class="fas fa-angle-right dropdown"></i></a> 
						<div class="sub-menu">
	
					<a href="Tran_report_student.jsp" class="sub-item">Students Reports</a>
					<a href="Tran_report_staff.jsp" class="sub-item">Staff Reports</a>		
					</div>
			
						
						
					
				</div>
			</div>
			
			
			
				<%if(for_login.equals("Admin") || for_login.equals("Principle")){ %>
			
			<div class="item">
				<a class="sub-btn"><i class="fa-solid fa-users"></i>User Creation <i class="fas fa-angle-right dropdown"></i></a>
				<div class="sub-menu">
					<a href="user_creation.jsp" class="sub-item">Create New</a>
					<a href="User_modify.jsp" class="sub-item">Modify</a>			
				</div>
			</div>
			
			<%} %>
			
			<div class="item">
				<a href="Display_dead_stock.jsp"><i class="fa-solid fa-trash"></i> Lost/Disposal Stock</a>
			</div>
			
			
			
			<%if(for_login.equals("Admin") || for_login.equals("Principle")){ %>
			
			<div class="item">
				<a href="Display_fine_data.jsp"><i class="fa-solid fa-indian-rupee-sign"></i>Fines</a>
			</div>
			<%} %>
						
			
			
			
			<div class="item">
				<a href="logout"><i class="fa-solid fa-right-from-bracket"></i>Logout</a>
			</div>
		
			
		</div>
	</div>
	

	
	<script src="js/jquery.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('.sub-btn').click(function(){
			$(this).next('.sub-menu').slideToggle();
			$(this).find('.dropdown').toggleClass('rotate');
	});
	});
	
	</script>
	
</body>
</html>

