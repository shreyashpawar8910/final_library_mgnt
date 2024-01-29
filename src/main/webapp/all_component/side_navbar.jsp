<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<%@ include file="all_css.jsp" %>

<style type="text/css">

.heading{
	height: 80px;
	width: 100%;
	background: #e6e6e6;

}

.heading h1{
 text-align: center;

}

.heading p{
 text-align: center;
 
}

.heading button{
	margin-left: 300px;
	margin-top: 10px;
}

*{
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}

.sidebar{
	position: fixed;
	left: 0;
	width: 200px;
	height: 100%;
	background: #437fc7;
	border-radius: 20px;
}


.sidebar ul a{
	color: white;
	display: block;
	height: 100%;
	width: 100%;
	line-height: 40px;
	font-size: 16px;
	padding-left: 22px;
	box-sizing: border-box;
	border-top: 1px solid rgb(0, 102, 204);
	border-bottom: 1px solid black;
}

.sidebar ul a:hover{
	padding-left: 50px;
	text-decoration: none;
	transition: .4s;
}

.sidebar header{	
	font-size: 22px;
	text-align: center;
	color: white;
	line-height: 70px;
	font-family: serif;
	background: #0066cc;
	border: 1px solid black;	
}

</style>

</head>
<body>

	
	<nav class="heading">
		<h1> Library Management System</h1>
		<p>Yashwantrao Chavan College, Islampur</p>	
	</nav>


	<div class="sidebar">
		<header>All Menu</header>
		
		<ul>
			<li><a href="#"><i class="fa-solid fa-house"></i>&nbsp;&nbsp; Dashboard</a></li>
			<li><a href="#"><i class="fa-solid fa-book"></i>&nbsp;&nbsp; Stock Entry</a></li>
			<li><a href="#"><i class="fa-solid fa-pen-to-square"></i>&nbsp;&nbsp; General Master</a></li>
			<li><a href="#"><i class="fa-sharp fa-solid fa-money-check-pen"></i>&nbsp;&nbsp; Modification</a></li>
			<li><a href="#"><i class="fa-solid fa-arrows-spin"></i>&nbsp;&nbsp; Transaction</a></li>
			<li><a href="#"><i class="fa-solid fa-magnifying-glass"></i>&nbsp;&nbsp; Search</a></li>
			<li><a href="#"><i class="fa-solid fa-signal-strong"></i>&nbsp;&nbsp; Current Status</a></li>
			<li><a href="#"><i class="fa-solid fa-users"></i>&nbsp;&nbsp; User Creation</a></li>
			<li><a href="#"><i class="fa-solid fa-trash"></i>&nbsp;&nbsp; Lost/Disposal Stock</a></li>
			<li><a href="#"><i class="fa-solid fa-indian-rupee-sign"></i>&nbsp;&nbsp; Fines</a></li>
			<li><a href="#"><i class="fa-solid fa-file-pdf"></i>&nbsp;&nbsp; Report</a></li>
			<li><a href="#"><i class="fa-solid fa-right-from-bracket"></i>&nbsp;&nbsp; Logout</a></li>
			
		
		</ul>
		
	</div>
</body>
</html>