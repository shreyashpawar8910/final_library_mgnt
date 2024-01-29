<%@page import="com.entity.Staff_enti"%>
<%@page import="com.dao.StaffDAO"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Student_enti"%>
<%@page import="com.entity.library_department"%>
<%@page import="com.dao.DeptDAO"%>
<%@page import="com.entity.Dead_stock_enti"%>
<%@page import="com.dao.Dead_stockDAO"%>
<%@page import="com.entity.Magazine_enti"%>
<%@page import="com.dao.Original_magDAO"%>
<%@page import="com.entity.Original_journal_enti"%>
<%@page import="com.dao.Original_journalDAO"%>
<%@page import="com.entity.Stock_transection_student_enti"%>
<%@page import="com.dao.Stock_transection_studentDAO"%>
<%@page import="com.entity.Original_book_enti"%>
<%@page import="com.dao.Original_bookDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.DashboardDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<style type="text/css">

.dashboard_container{
	margin-left: 250px;
	margin-top: -72px;

	z-index: 2;
	height: 100vh;
	width: 82%;
	
	background: linear-gradient(#437fc7, #e699ff);
}

.page_haiding{
		background: #437fc7;
		text-align: center;
		border: 1px solid;

		color: white;
}
page_haiding h3{
	text-align: center;
	
}

.book{
	margin-left: 10px;
	margin-top: 30px;
	color: white;
}


.card-1{
	background: white;
	margin-top: -5px;
	margin-left: 10px;
	height: 180px;
	width: 230px;
	border: 1px solid;
	background: #e6e6e6;
	box-shadow: 4px 4px 4px black;
	border-radius: 10px;
}
.card-1 h1{
	text-align: center;
	margin-top: 5px;
	color: blue;
	
}


/* ********************************************* */



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







/**** For Total Book Display***********  */

.total_book{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_total_book{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.total_book span{
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


.total_book_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.total_book_table-bordered {
	border: 1px solid;
}

.btn-download_tot_book{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}




/*********** For Issued Book Display ******************  */


.issued_book{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_issued_book{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.issued_book span{
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


.issued_book_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_issued_book{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}





/*************** For available Book Display ********************  */



.available_book{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_available_book{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.available_book span{
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


.available_book_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.available_book_table-bordered {

}

.btn-download_available_book{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}



/*****************************/
/* **************************** */



/**** For Total Journal Display***********  */

.total_journal{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_total_journal{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.total_journal span{
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


.total_journal_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.total_journal_table-bordered {
	border: 1px solid;
}

.btn-download_total_journal{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}





/**** For Issued Journal Display***********  */

.issued_journal{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_issued_journal{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.issued_journal span{
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


.issued_journal_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.issued_journal_table-bordered {
	border: 1px solid;
}

.btn-download_issued_journal{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}




/**** For available Journal Display***********  */

.available_journal{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_available_journal{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.available_journal span{
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


.available_journal_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.available_journal_table-bordered {
	border: 1px solid;
}

.btn-download_available_journal{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}








/*****************************/
/* **************************** */



/**** For Total magazine Display***********  */

.total_magazine{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_total_magazine{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.total_magazine span{
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


.total_magazine_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.total_magazine_table-bordered {
	border: 1px solid;
}

.btn-download_total_magazine{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}





/**** For Issued magazine Display***********  */

.issued_magazine{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_issued_magazine{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.issued_magazine span{
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


.issued_magazine_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.issued_magazine_table-bordered {
	border: 1px solid;
}

.btn-download_issued_magazine{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}




/**** For available magazine Display***********  */

.available_magazine{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_available_magazine{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.available_magazine span{
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


.available_magazine_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}

.available_magazine_table-bordered {
	border: 1px solid;
}

.btn-download_available_magazine{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}












/*****************************/
/* **************************** */



/**** For Book Deadstock Display***********  */

.book_deadstock{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_book_deadstock{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.book_deadstock span{
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


.book_deadstock_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_book_deadstock{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}





/**** For Journal Deadstock Display***********  */

.journal_deadstock{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_journal_deadstock{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.journal_deadstock span{
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


.journal_deadstock_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_journal_deadstock{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}




/**** For magazine Deadstock Display***********  */

.magazine_deadstock{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_magazine_deadstock{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.magazine_deadstock span{
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


.magazine_deadstock_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_magazine_deadstock{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}



/* **********************  */
/* ************************ */
/* ***** Department *********** */





/**** For Departments Display***********  */

.department{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_department{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.department span{
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


.department_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_department{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}




/* **********************  */
/* ************************ */
/* ***** Students *********** */





/**** For Students Display***********  */

.student{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_student{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.student span{
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


.student_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_student{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}





/* **********************  */
/* ************************ */
/* ***** Staff *********** */





/**** For Staff Display***********  */

.staff{
	
	margin-left: 170px;
	margin-top: -1400px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	transition: 2s;
}

.show_staff{
	margin-left: 170px;
	margin-top: -600px;
	height: 500px;
	width: 1100px;
	background: white;
	position: absolute;
	z-index: 5;
}


.staff span{
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


.staff_card{
	margin-top: 30px;
	width: 1080px;
	margin-left: 10px;
	height: 350px;
	max-height: 350px;
	border: 1px solid;
	overflow: scroll;
}



.btn-download_staff{
	border: 1px solid;
	padding: 5px 9px;
	margin-left: 500px;
	border-radius: 10px;
	margin-top: 40px;
}











</style>


</head>

<body>

	
	
	<%@include file="lbl_side_nav.jsp" %>
	<div class="dashboard_container">
		
		<%
			String for_log = (String)session.getAttribute("user_role");
		
		
	%>
		
	
	<br>
	<h2 style="color: white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa-solid fa-bars"></i>&nbsp;&nbsp;Dashboard</h2>
	
	<br>
	
	
	<div class="row">
		<div class="col"><h5 class="book"><u> Books </u></h5></div>
			<div class="col"><h5 class="book"><u> Journal </u></h5></div>
			<div class="col"><h5 class="book"><u> Magazine </u></h5></div>
			<div class="col"><h5 class="book"><u> Dead Stock </u></h5></div>
	
	</div>
	



	<div class="row">
		<div class="col">
		<div class="card-1">
		<h1><i class="fa-solid fa-book"></i></h1>
		<br>
		
		<%
			DashboardDAO dao = new DashboardDAO(DBConnect.getConn());
			long total_book  = dao.total_books();
			long issued_book = dao.issued_books();
			long available_book = dao.availabel_books();
			
		%>
		
		
		<h6 style="color: black; cursor: pointer;" onclick="show_total_book()">&nbsp;&nbsp;Total Books&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=total_book %></h6>
		<h6 style="color: red; cursor: pointer;" onclick="show_issued_book()">&nbsp;&nbsp;Issued Books&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=issued_book %></h6>
		<h6 style="color: green; cursor: pointer;" onclick="show_available_book()">&nbsp;&nbsp;Available Books : &nbsp;&nbsp;<%=available_book %></h6>
		
	</div>
	
</div>



	
	<div class="col">
		<div class="card-1">
		<h1 style="color: #cc9900;"><i class="fa-solid fa-book"></i></h1>
		<br>
		
		<%
			
			long total_journal  = dao.total_journal();
			long issued_journal  = dao.issued_journal();
			long available_journal = dao.availabel_journal();
			
		%>
		
		
		<h6 style="color: black; cursor: pointer;" onclick="show_total_journal()">&nbsp;&nbsp;Total Journal&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=total_journal %></h6>
		<h6 style="color: red; cursor: pointer;" onclick="show_issued_journal()">&nbsp;&nbsp;Issued Journal&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=issued_journal %></h6>
		<h6 style="color: green; cursor: pointer;" onclick="show_available_journal()">&nbsp;&nbsp;Available Journal : &nbsp;&nbsp;<%=available_journal %></h6>
		
	</div>
	
</div>
	

	
	<div class="col">
		<div class="card-1">
			<h1 style="color: #990033;"><i class="fa-solid fa-book"></i></h1>
			<br>
		
			<%
			
				long total_magazine  = dao.total_magazine();
				long issued_magazine  = dao.issued_magazine();
				long available_magazine = dao.availabel_magazine();
			
			%>
		
		
			<h6 style="color: black; cursor: pointer;" onclick="show_total_magazine()">&nbsp;&nbsp;Total Magazine&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=total_magazine %></h6>
			<h6 style="color: red; cursor: pointer;" onclick="show_issued_magazine()">&nbsp;&nbsp;Issued Magazine&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=issued_magazine %></h6>
			<h6 style="color: green; cursor: pointer;" onclick="show_available_magazine()">&nbsp;&nbsp;Available Magazine : &nbsp;&nbsp;<%=available_magazine %></h6>
		
		</div>
	
	</div>
	
	
	
	
	<div class="col">
		<div class="card-1">
			<h1 style="color: red;"><i class="fa-solid fa-trash"></i></h1>
			<br>
		
			<%
			
				long book_Dead_stock  = dao.total_book_dead_stock();
				long journal_Dead_stock  = dao.total_journal_dead_stock();
				long magazine_Dead_stock  = dao.total_magazine_dead_stock();
			%>
		
		
			<h6 style="color: black; cursor: pointer;" onclick="show_book_deadstock()">&nbsp;&nbsp;Book Dead Stock&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=book_Dead_stock %></h6>
			<h6 style="color: black; cursor: pointer;" onclick="show_journal_deadstock()">&nbsp;&nbsp;Journal Dead Stock&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=journal_Dead_stock %></h6>
			<h6 style="color: black; cursor: pointer;" onclick="show_magazine_deadstock()">&nbsp;&nbsp;Magazine Dead Stock : &nbsp;&nbsp;<%=magazine_Dead_stock %></h6>
		
		</div>
	
	</div>

	</div>
	
	
	
	
	
	
	<br><br>
	
	
	
	
	
	
	
	
	
	<div class="row">
			<div class="col"><h5 class="book"><u> Total Department </u></h5></div>
			<div class="col"><h5 class="book"><u> Total Students </u></h5></div>
			<div class="col"><h5 class="book"><u> Total Staff </u></h5></div>
			<div class="col"><h5 class="book"><u> Total Users </u></h5></div>
			
	
	</div>
	

	<div class="row">
	
		<div class="col">
		<div class="card-1">
			<h1 style="color: red;"><i class="fa-solid fa-graduation-cap"></i></h1>
			<br>
		
			<%
			
				long total_department  = dao.total_department();
			
			
			%>
		
		
			<h6 style="text-align: center; font-size: 28px; cursor: pointer;" onclick="show_department()"><%=total_department %></h6>
		
		</div>
	
	</div>
	
	
	
	
	
	
	
		<div class="col">
		<div class="card-1">
		<h1><i class="fa-solid fa-users"></i></h1>
		<br>
		
		<%
			
			long total_students  = dao.total_students();
			
		%>
		
		
		<h6 style="text-align: center; font-size: 28px; cursor: pointer;" onclick="show_student()"><%=total_students %></h6>
		
	</div>
	
</div>
	
	<div class="col">
		<div class="card-1">
		<h1 style="color: #cc9900;"><i class="fa-solid fa-person-chalkboard"></i></h1>
		<br>
		
		<%
			
			long total_staff  = dao.total_staff();
			
		%>
		
		
		<h6 style="text-align: center; font-size: 28px; cursor: pointer;" onclick="show_staff()"><%=total_staff %></h6>
		
	</div>
	
</div>
	
	
	
	
	
	
	
	<div class="col">
		<div class="card-1">
			<h1 style="color: #990033;"><i class="fa-solid fa-user-large"></i></h1>
			<br>
		
			<%
			
				long total_users  = dao.total_users();
				
			%>
			
			<h6 style="text-align: center; font-size: 28px; cursor: pointer;"><%=total_users %></h6>
			
		</div>
	
	</div>
	
	
	

	</div>			
	
	
	

	
	</div>





	
	
	
	<!-- ************************************************************************* -->
	<!-- ************************************************************************** -->





	
	
	<div class="overlay"></div>	
	
	
	
	<!--*********** Total Book ********************  -->
	
	<div class="total_book">
	<div><h3 style="text-align: center; color: black;"><u> Total Books </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_tot_book" type="submit" id="download" onclick="generate_total_book()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="total_book_card">
		
		<table id="TotalbookTable" class="table total_book_table-bordered" >
		<thead>
			
			
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Subject</th>
			<th>Edition</th>
			<th>Publisher</th>
			<th>Language</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			Original_bookDAO Or_book_dao = new Original_bookDAO(DBConnect.getConn());
			List<Original_book_enti> list1 = Or_book_dao.getall_or_books();

			for(Original_book_enti or_books:list1){
		
			%>
		
				<tr>			
					
					<td><%=or_books.getBook_id() %></td>
					<td><%=or_books.getBook_title() %></td>
					<td><%=or_books.getBook_author() %></td>
					<td><%=or_books.getBook_dept() %></td>
					<td><%=or_books.getBook_catrgory() %></td>
					<td><%=or_books.getBook_subject() %></td>
					<td><%=or_books.getBook_edition() %></td>
					<td><%=or_books.getSearch_publisher() %></td>
					<td><%=or_books.getBook_language() %></td>
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
	</div>
	
	
	
	
	
				<!--*********** Issued Book ********************  -->
	
	
	<div class="issued_book">
		<div><h3 style="text-align: center; color: red;"><u> Issued Books </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_issued_book" type="submit" id="download" onclick="generate_issued_book()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="issued_book_card">
		
		<table id="issuedbookTable" class="table total_book_table-bordered" >
		<thead>
			
			
			<th>Book ID</th>
			<th>Title</th>
			
			<th>Issued by</th>
			<th>Department</th>
			<th>Issued Date</th>
			<th>Return Date</th>
			<th>Book Price</th>
			<th>Candidate Type</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			Stock_transection_studentDAO stk_dao = new Stock_transection_studentDAO(DBConnect.getConn());
			List<Stock_transection_student_enti> list2 = stk_dao.getall_issued_book_transaction();

			for(Stock_transection_student_enti stk_tr :list2){
		
			%>
		
				<tr>			
					
					<td><%=stk_tr.getTran_book_id() %></td>
					<td><%=stk_tr.getTran_book_name() %></td>
					<td><%=stk_tr.getTran_stud_name() %></td>
					<td><%=stk_tr.getTran_stud_dept() %></td>
					<td><%=stk_tr.getIssue_date() %></td>
					<td><%=stk_tr.getTran_virt_retur_date() %></td>
					<td><%=stk_tr.getStock_price() %></td>
					<td><%=stk_tr.getCandi_type() %></td>
					
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
	</div>
	
	
	
	
		<!--*********** Availabel Book ********************  -->
	
	
	<div class="available_book">
		<div><h3 style="text-align: center; color: red;"><u> Available Books </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_available_book" type="submit" id="download" onclick="generate_avalable_book()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="available_book_card">
		
		<table id="availablebookTable" class="table total_book_table-bordered" >
		<thead>
			
			
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Subject</th>
			<th>Edition</th>
			<th>Publisher</th>
			<th>Language</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			
			List<Original_book_enti> list3 = Or_book_dao.get_available_or_books();

			for(Original_book_enti or_books:list3){
		
			%>
		
				<tr>			
					
					<td><%=or_books.getBook_id() %></td>
					<td><%=or_books.getBook_title() %></td>
					<td><%=or_books.getBook_author() %></td>
					<td><%=or_books.getBook_dept() %></td>
					<td><%=or_books.getBook_catrgory() %></td>
					<td><%=or_books.getBook_subject() %></td>
					<td><%=or_books.getBook_edition() %></td>
					<td><%=or_books.getSearch_publisher() %></td>
					<td><%=or_books.getBook_language() %></td>
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
	</div>
	</div>
	
	
	
	
	
	
	
	<!-- ************************************************ -->
	<!-- ************************************************ -->
	<!--*********** Total Journal ********************  -->
	
	
	<div class="total_journal">
		<div><h3 style="text-align: center; color: red;"><u> Total Journal </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_total_journal" type="submit" id="download" onclick="generate_total_journal()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="total_journal_card">

			<table id="TotaljournalTable" class="table table-bordered" >
		<thead>
			
			
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Subject</th>
			<th>Edition</th>
			<th>Publisher</th>
			<th>Language</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			Original_journalDAO Or_jr_dao = new Original_journalDAO(DBConnect.getConn());
			List<Original_journal_enti> list4 = Or_jr_dao.getall_or_journal();

			for(Original_journal_enti or_jr:list4){
		
			%>
		
				<tr>			
					
					<td><%=or_jr.getJournal_id() %></td>
					<td><%=or_jr.getJournal_title() %></td>
					<td><%=or_jr.getJournal_author() %></td>
					<td><%=or_jr.getJournal_dept() %></td>
					<td><%=or_jr.getJournal_catrgory() %></td>
					<td><%=or_jr.getJournal_subject() %></td>
					<td><%=or_jr.getJournal_edition() %></td>
					<td><%=or_jr.getSearch_publisher() %></td>		
					<td><%=or_jr.getJournal_language() %></td>
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
		
		
	</div>
	</div>
	
	
	
	
	
	<!--*********** Issued Journal ********************  -->
	
	
	<div class="issued_journal">
		<div><h3 style="text-align: center; color: red;"><u> Issued Journal </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_issued_journal" type="submit" id="download" onclick="generate_issued_journal()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="issued_journal_card">

			<table id="issuedjournalTable" class="table total_book_table-bordered" >
		<thead>
			
			
			<th>Journal ID</th>
			<th>Title</th>
			
			<th>Issued by</th>
			<th>Department</th>
			<th>Issued Date</th>
			<th>Return Date</th>
			<th>Journal Price</th>
			<th>Candidate Type</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			
			List<Stock_transection_student_enti> list5 = stk_dao.getall_issued_journal_transaction();

			for(Stock_transection_student_enti stk_tr :list5){
		
			%>
		
				<tr>			
					
					<td><%=stk_tr.getTran_book_id() %></td>
					<td><%=stk_tr.getTran_book_name() %></td>
					<td><%=stk_tr.getTran_stud_name() %></td>
					<td><%=stk_tr.getTran_stud_dept() %></td>
					<td><%=stk_tr.getIssue_date() %></td>
					<td><%=stk_tr.getTran_virt_retur_date() %></td>
					<td><%=stk_tr.getStock_price() %></td>
					<td><%=stk_tr.getCandi_type() %></td>
					
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
		
		
	</div>
	</div>
	
	
	
		<!--*********** Available Journal ********************  -->
	
	
	<div class="available_journal">
		<div><h3 style="text-align: center; color: red;"><u> Available Journal </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_available_journal" type="submit" id="download" onclick="generate_available_journal()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="available_journal_card">

			<table id="availablejournalTable" class="table table-bordered" >
		<thead>
			
			
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Department</th>
			<th>Category</th>
			<th>Subject</th>
			<th>Edition</th>
			<th>Publisher</th>
			<th>Language</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			
			List<Original_journal_enti> list6 = Or_jr_dao.get_available_or_journal();

			for(Original_journal_enti or_jr:list6){
		
			%>
		
				<tr>			
					
					<td><%=or_jr.getJournal_id() %></td>
					<td><%=or_jr.getJournal_title() %></td>
					<td><%=or_jr.getJournal_author() %></td>
					<td><%=or_jr.getJournal_dept() %></td>
					<td><%=or_jr.getJournal_catrgory() %></td>
					<td><%=or_jr.getJournal_subject() %></td>
					<td><%=or_jr.getJournal_edition() %></td>
					<td><%=or_jr.getSearch_publisher() %></td>		
					<td><%=or_jr.getJournal_language() %></td>
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
		
		
	</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- ************************************************ -->
	<!-- ************************************************ -->
	<!--*********** Total Magazine ********************  -->
	
	
	<div class="total_magazine">
		<div><h3 style="text-align: center; color: red;"><u> Total Magazine </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_total_magazine" type="submit" id="download" onclick="generate_total_magazine()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="total_magazine_card">

			<!-- This Hidden table for print Report in pdf -->
		
		
		<table id="TotalmagazineTable" class="table table-bordered" >
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
			Original_magDAO Or_mag_dao = new Original_magDAO(DBConnect.getConn());
			List<Magazine_enti> list7 = Or_mag_dao.getall_or_magzine();
			
			
			for(Magazine_enti or_mag:list7){
		
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
	</div>
	</div>
	
	
	
	
	
	<!--*********** Issued Journal ********************  -->
	
	
	<div class="issued_magazine">
		<div><h3 style="text-align: center; color: red;"><u> Issued Magazine </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_issued_magazine" type="submit" id="download" onclick="generate_issued_magazine()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="issued_magazine_card">

			<table id="issuedmagazineTable" class="table total_book_table-bordered" >
		<thead>
			
			
			<th>Journal ID</th>
			<th>Title</th>
			
			<th>Issued by</th>
			<th>Department</th>
			<th>Issued Date</th>
			<th>Return Date</th>
			<th>Journal Price</th>
			<th>Candidate Type</th>
			
			
		</thead>
		<tbody>
	
			
			<%
			
			List<Stock_transection_student_enti> list8 = stk_dao.getall_issued_magazine_transaction();

			for(Stock_transection_student_enti stk_tr :list8){
		
			%>
		
				<tr>			
					
					<td><%=stk_tr.getTran_book_id() %></td>
					<td><%=stk_tr.getTran_book_name() %></td>
					<td><%=stk_tr.getTran_stud_name() %></td>
					<td><%=stk_tr.getTran_stud_dept() %></td>
					<td><%=stk_tr.getIssue_date() %></td>
					<td><%=stk_tr.getTran_virt_retur_date() %></td>
					<td><%=stk_tr.getStock_price() %></td>
					<td><%=stk_tr.getCandi_type() %></td>
					
					
				</tr>
				
		
			<%
			
			
			}
			
			
			%>
			
			
		</tbody>
	
	</table>	
		
		
	</div>
	</div>
	
	
	
		<!--*********** Available magazine ********************  -->
	
	
	<div class="available_magazine">
		<div><h3 style="text-align: center; color: red;"><u> Available Magazine </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_available_magazine" type="submit" id="download" onclick="generate_available_magazine()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="available_magazine_card">

			<table id="availablemagazineTable" class="table table-bordered" >
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
			
			List<Magazine_enti> list9 = Or_mag_dao.get_available_or_magzine();
			
			
			for(Magazine_enti or_mag:list9){
		
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
	</div>
	</div>
	
	
	
	
	
	
	
	
		
	<!-- ************************************************ -->
	<!-- ************************************************ -->
	
	<!--*********** Book Deadstock ********************  -->
	
	
	<div class="book_deadstock">
		<div><h3 style="text-align: center; color: red;"><u> Book Deadstock </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_book_deadstock" type="submit" id="download" onclick="generate_book_deadstock()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="book_deadstock_card">

			<!-- This Hidden table for print Report in pdf -->
		
		
		<!-- This Hidden table for print Report in pdf -->
		
		
		<table id="bookdeadstockTable" class="table table-bordered"  >
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
			Dead_stockDAO dead_dao = new Dead_stockDAO(DBConnect.getConn());
			List<Dead_stock_enti> list10 = dead_dao.get_book_dead_stock();
			
			for(Dead_stock_enti or_dead:list10){
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
			
	</div>
	</div>
	
	
	
	
	
	<!--*********** Journal Deadstock ********************  -->
	
	
	<div class="journal_deadstock">
		<div><h3 style="text-align: center; color: red;"><u> Journal Deadstock </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_journal_deadstock" type="submit" id="download" onclick="generate_journal_deadstock()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="journal_deadstock_card">

			<!-- This Hidden table for print Report in pdf -->
		
		
		<!-- This Hidden table for print Report in pdf -->
		
		
		<table id="journaldeadstockTable" class="table table-bordered"  >
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
			
			List<Dead_stock_enti> list11 = dead_dao.get_journal_dead_stock();
			
			for(Dead_stock_enti or_dead:list11){
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
			
	</div>
	</div>
	
	
	
	
	<!--*********** Journal Deadstock ********************  -->
	
	
	<div class="magazine_deadstock">
		<div><h3 style="text-align: center; color: red;"><u> Magazine Deadstock </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_magazine_deadstock" type="submit" id="download" onclick="generate_magazine_deadstock()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="magazine_deadstock_card">

			<!-- This Hidden table for print Report in pdf -->
		
		
		<!-- This Hidden table for print Report in pdf -->
		
		
		<table id="magazinedeadstockTable" class="table table-bordered"  >
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
			
			List<Dead_stock_enti> list12 = dead_dao.get_magazine_dead_stock();
			
			for(Dead_stock_enti or_dead:list12){
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
			
	</div>
	</div>
	
	
	
	
	
	
	
	
	<!-- ********************************************* -->
	
	
	
	<!--*********** Department ********************  -->
	
	
	<div class="department">
		<div><h3 style="text-align: center; color: red;"><u> Departments </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_department" type="submit" id="download" onclick="generate_department()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="department_card">

			<!-- This Hidden table for print Report in pdf -->
		
		
		<!-- This Hidden table for print Report in pdf -->
		
		<table id="deptTable" class="table table-bordered">
		<thead>
		
			<th>ID</th>
			<th>Name</th>
			<th>Duration</th>
			

		</thead>
		<tbody>
	
			
			<%
				DeptDAO dept_dao = new DeptDAO(DBConnect.getConn());
				List<library_department> list13 = dept_dao.getAlldept();
				for(library_department dept:list13){
			%>
		
				<tr>			
					
					<td><%=dept.getDept_id() %></td>
					<td><%=dept.getDept_name() %></td>
					<td><%=dept.getDept_dur() %></td>
					
				</tr>
				
		
			<%
				}
		
			%>
			
			
		</tbody>
	
	</table>	
			
	</div>
	</div>
	
	
	
	
	
	<!--*********** Student ********************  -->
	
	
	<div class="student">
		<div><h3 style="text-align: center; color: red;"><u> Students </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_student" type="submit" id="download" onclick="generate_student()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="student_card">

			<!-- This Hidden table for print Report in pdf -->
		
		<!-- This Hidden table for Print data into Database -->

		
		<table class="table table-bordered" id="studentTable" >
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
			StudentDAO stud_dao = new StudentDAO(DBConnect.getConn());
			List<Student_enti> list14 = stud_dao.getall_students();
			
			for(Student_enti stud:list14){
		
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

			
			
	</div>
	</div>
	
	
	
	
	
	<!--*********** Student ********************  -->
	
	
	<div class="staff">
		<div><h3 style="text-align: center; color: red;"><u> Staff </u></h3></div>
			<span onclick="closeedit_model()">&times;</span>
	<button class="btn-download_staff" type="submit" id="download" onclick="generate_staff()"><i class="fa-solid fa-download"></i>&nbsp; Download</button>
	<!-- This Hidden table for print Report in pdf -->
		<div class="staff_card">

			<!-- This Hidden table for print Report in pdf -->
		
		
		<table class="table table-bordered" id="staffTable" >
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
				
			
				StaffDAO staff_dao = new StaffDAO(DBConnect.getConn());
				List<Staff_enti> list15 = staff_dao.getall_staff();
				
				for(Staff_enti staff:list15){
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
			
			
	</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
</body>

<script type="text/javascript">

	function show_total_book(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.total_book').classList.add('show_total_book');
		
	}
	
	
	
	function show_issued_book(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.issued_book').classList.add('show_issued_book');
	}
	
	
	
	
	function show_available_book(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.available_book').classList.add('show_available_book');
	}
	
	
	//***************************
	//**************************
	//***** Journal ************
	
	
	
	function show_total_journal(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.total_journal').classList.add('show_total_journal');
	}
	
	function show_issued_journal(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.issued_journal').classList.add('show_issued_journal');
	}
	
	
	function show_available_journal(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.available_journal').classList.add('show_available_journal');
	}
	
	
	
	//***************************
	//**************************
	//***** Magazine ************
	
	
	
	function show_total_magazine(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.total_magazine').classList.add('show_total_magazine');
	}
	
	function show_issued_magazine(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.issued_magazine').classList.add('show_issued_magazine');
	}
	
	
	function show_available_magazine(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.available_magazine').classList.add('show_available_magazine');
	}
	
	
	
	
	
	//***************************
	//**************************
	//***** Dead Stock ************
	
	
	function show_book_deadstock(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.book_deadstock').classList.add('show_book_deadstock');
	}
	
	
	function show_journal_deadstock(){
		
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.journal_deadstock').classList.add('show_journal_deadstock');
	}
	
	
	function show_magazine_deadstock(){
	
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.magazine_deadstock').classList.add('show_magazine_deadstock');
	}
	
	
	
	
	//***************************
	//**************************
	//***** Department ************
	
	
	function show_department(){
	
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.department').classList.add('show_department');
	}
	
	
	//***** Students ************
	
	
	function show_student(){
	
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.student').classList.add('show_student');
	}
	
	

	//***** Staff ************
	
	
	function show_staff(){
	
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.staff').classList.add('show_staff');
	}
	
	
	
	
	
	function closeedit_model() {
		document.querySelector('.overlay').classList.remove('showoverlay');
		document.querySelector('.total_book').classList.remove('show_total_book');
		
		document.querySelector('.issued_book').classList.remove('show_issued_book');
		
		document.querySelector('.available_book').classList.remove('show_available_book');
		
		
		document.querySelector('.total_journal').classList.remove('show_total_journal');
		
		document.querySelector('.issued_journal').classList.remove('show_issued_journal');
		
		document.querySelector('.available_journal').classList.remove('show_available_journal');
		
		
		document.querySelector('.total_magazine').classList.remove('show_total_magazine');
		
		document.querySelector('.issued_magazine').classList.remove('show_issued_magazine');
		
		document.querySelector('.available_magazine').classList.remove('show_available_magazine');
		
		

		document.querySelector('.book_deadstock').classList.remove('show_book_deadstock');
		
		document.querySelector('.journal_deadstock').classList.remove('show_journal_deadstock');
		
		document.querySelector('.magazine_deadstock').classList.remove('show_magazine_deadstock');
		
		
		
		document.querySelector('.department').classList.remove('show_department');
		
		document.querySelector('.student').classList.remove('show_student');
		
		document.querySelector('.staff').classList.remove('show_staff');
		
	}
	
	
	
</script>














<script type="text/javascript">



//***************
//For Download Table Data of Total Book
//*********************


function generate_total_book() {  
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

    doc.text(129, y = y + 10, "Total Books");
    
    
    doc.autoTable({  
        html: '#TotalbookTable',  
        startY: 70,  
        theme: 'grid',  
       
         
        styles: {  
            minCellHeight: 20  
        } 
        
    })  
    doc.save('All_Books.pdf');  
}  







//***************
//For Download Table Data of Issued Book
//*********************


function generate_issued_book() {  
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

  doc.text(128, y = y + 10, "Issued Books");
  
  
  doc.autoTable({  
      html: '#issuedbookTable',  
      startY: 70,  
      theme: 'grid',  
     
       
      styles: {  
          minCellHeight: 20  
      } 
      
  })  
  doc.save('Issued Books.pdf');  
}  





//***************
//For Download Table Data of Available Book
//*********************


function generate_avalable_book() {  
	
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

doc.text(124, y = y + 10, "Available Books");


doc.autoTable({  
    html: '#availablebookTable',  
    startY: 70,  
    theme: 'grid',  
   
     
    styles: {  
        minCellHeight: 20  
    } 
    
})  
doc.save('Available Books.pdf');  
}  





//********************************
//******* Joural ******************
//**********************************

function generate_total_journal(){
	
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

	doc.text(125, y = y + 10, "Total Journal");


	doc.autoTable({  
	    html: '#TotaljournalTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Total Journal.pdf');  
}




function generate_issued_journal(){
	
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

	doc.text(125, y = y + 10, "Issued Journal");


	doc.autoTable({  
	    html: '#issuedjournalTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Issued Journal.pdf');  
}





function generate_available_journal(){
	
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

	doc.text(123, y = y + 10, "Available Journal");


	doc.autoTable({  
	    html: '#availablejournalTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Available Journal.pdf');  
}












//********************************
//******* Magazine ******************
//**********************************

function generate_total_magazine(){
	
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

	doc.text(125, y = y + 10, "Total Magazine");


	doc.autoTable({  
	    html: '#TotalmagazineTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Total Magazine.pdf');  
}




function generate_issued_magazine(){
	
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

	doc.text(125, y = y + 10, "Issued Magazine");


	doc.autoTable({  
	    html: '#issuedmagazineTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Issued Magazine.pdf');  
}





function generate_available_magazine(){
	
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

	doc.text(123, y = y + 10, "Available Magazine");


	doc.autoTable({  
	    html: '#availablemagazineTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Available Magazine.pdf');  
}








//***********************
//***********************
//**** Deadstock *********





function generate_book_deadstock(){
	
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

	doc.text(119, y = y + 10, "Book Dead Stock");


	doc.autoTable({  
	    html: '#bookdeadstockTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Book Dead Stock.pdf');  
}








function generate_journal_deadstock(){
	
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

	doc.text(117, y = y + 10, "Journal Dead Stock");


	doc.autoTable({  
	    html: '#journaldeadstockTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Journal Dead Stock.pdf');  
}



//****************************
//****************************

function generate_magazine_deadstock(){
	
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

	doc.text(117, y = y + 10, "Magazine Dead Stock");


	doc.autoTable({  
	    html: '#magazinedeadstockTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Magazine Dead Stock.pdf');  
}










//****************************
//****************************
// ***** Department **********



function generate_department(){
	
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

	doc.text(123, y = y + 10, "Departments");


	doc.autoTable({  
	    html: '#deptTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Departments.pdf');  
}






//****************************
//***** Students **********



function generate_student(){
	
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

	doc.text(125, y = y + 10, "Students");


	doc.autoTable({  
	    html: '#studentTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Total Students.pdf');  
}





//****************************
//***** Staff **********



function generate_staff(){
	
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

	doc.text(128, y = y + 10, "Staff");


	doc.autoTable({  
	    html: '#staffTable',  
	    startY: 70,  
	    theme: 'grid',  
	   
	     
	    styles: {  
	        minCellHeight: 20  
	    } 
	    
	})  
	doc.save('Total Staff.pdf');  
}







</script>



</html>