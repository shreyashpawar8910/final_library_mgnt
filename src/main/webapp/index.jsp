<%@page import="com.entity.Original_book_enti"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.Original_bookDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<%@include file="all_component/all_css.jsp" %>

<style type="text/css">

.home_page_container{
	
	

}

.main_navbar{
	margin-top : 0px;
	height: 90px;
	width: 100%;
	background: linear-gradient(#437fc7, #e580ff);
}
.main_navbar h2{
	margin-top : 0px;
	padding-top: 5px;
	text-align: center;
	font-size: 30px;
	font-family: Times New Roman;
 	font-weight: bolder;
 	color: white;
	
}

.main_navbar h3{

	text-align: center;
	font-size: 25px;
	font-family: Times New Roman;
 	font-weight: bolder;
 	color: black;	
}

.main_navbar button{
	margin-top: -60px;
	margin-left: 1270px;
	position: absolute;
	border: 1px solid;
	background: white;
	height: 40px;
	width: 100px;
}


.card-1{
	
	margin-top: 30px;
	margin-left: 300px; 
	height: 100px;
	width: 800px;
	border: 1px solid;
	box-shadow: 5px 5px gray;
}

.card-1 input{

	margin-top: 35px;
	margin-left: 80px;
	height: 40px;
	width: 450px;
	padding-left: 10px;
	border-radius: 5px;
	
}


.card-1 button{
	
	margin-top: 35px;
	margin-left: 100px;
	position: absolute;
	border: 1px solid;
	border-radius: 5px;
	height: 40px;
	width: 100px;
	background: #cccccc;
	font-size: 19px;
	font-weight: bolder;
	font-family: Times New Roman;
	
}

.card_display_book{


	margin-top: 40px;
	margin-left: 250px; 
	height: 250px;
	width: 900px;
	border: 1px solid;
	font-family: Times New Roman;
	box-shadow: 5px 5px gray;
	background: #e6e6e6;

}

.card_display_book .col input{
	
	width: 280px;
	border-radius: 3px;
	padding-left: 10px; 
}

.card_display_book .haiding{
	text-align: center;
	font-size: 25px;
	color: #ff8080;
	font-weight: bolder;
}

.card-body{
	border: 2px solid;
	box-shadow: 3px 3px gray;
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
	height: 550vh;
}





.login_form{
	
	width: 500px;
	height: 500px;
	top: -580px;
	margin-left: 480px;
	border: 1px solid;
	position: absolute;
	background: white;
}


.show_login_form{
	top: 80px;
	z-index: 1;
}


.login_form span{

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


.login_form .login_container{

	
	width: 400px;
	height: 420px;
	margin-left: 50px;
	margin-top: 40px;
}


.login_form .login_container .login_haiding{

	margin-top: 30px;
	text-align: center;
	font-size: 100px;
}

.login_form .login_container .row-1{
	
	margin-left: 10px;

} 

.login_form .login_container .row .col input{
	
	margin-top: 10px;
	width: 100%;
	height: 40px;
	border-radius: 5px;
}

.login_form .login_container .row .col button{
	
	margin-top: 30px;
	width: 100%;
	height: 40px;
	border-radius: 10px;
	background: #437fc7;
	color: white;
	font-size: 20px;
	font-weight: bolder;
}

</style>





<script type="text/javascript">

function closeallpages(){
	

	var windows = window.opener.window;
	alert("hello");
	for(var i =0; i < windows.length; i++){
		
		if(windows[i].name !==window.name){
			windows[i].close();
		}
	}
	
}

setTimeout(closeallpages, 5000);

</script>



</head>
<body>


<div class="home_page_container">



	<%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succmsg");
    		   
    		   
    		   %>
    		    		
    				
    		 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="login faild"){
    		 		
    		 		swal("Error", "Login faild, Please check User Id and Password", "error");
    		 	}
    		 	
    		  
    		</script>
    		
    		<% session.removeAttribute("succmsg"); %>
    		




	<div class="main_navbar">
		<h2>Yashwantrao Chavan Mahavidhyalaya, Islampur</h2>
		<h3>Library Management System</h3>
		<button class="btn" onclick="login_display()"><i class="fa-solid fa-user"></i> &nbsp;Login</button>
	</div>
	
	
		
	<div class="card-1">
	
	<form action="Search_index_page.jsp">
	
		<input type="text" placeholder="Enter Book Name" name="search_field" required="required">
		<button class="btn">Search</button>
	
	</form>

	</div>
	<br><br>
	
	 <div class="container">
            <div class="row">
                <div class="col-md-12">
	
		<%
			Original_bookDAO Or_book_dao = new Original_bookDAO(DBConnect.getConn());
			List<Original_book_enti> list = Or_book_dao.getall_or_books();
			
			int i = 0;
			for(Original_book_enti or_books:list){
		
			%>
			
			  <div class="card mt-2">
            <div class="card-body">
                <div class="text-center text-primary">
                    <i class="far fa-clipboard fa-2x"></i>
                </div>
    
                
                <h5><%=or_books.getBook_title() %></h5>
                <p><%=or_books.getBook_author() %></p>
                <br>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control form-control-sm" value="Publication :  <%=or_books.getSearch_publisher() %>" readonly>
                    </div>
                    
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control form-control-sm" value="Publisher Year :  <%=or_books.getBook_publi_year() %>" readonly>
                    </div>
                    
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control form-control-sm" value="Edition : <%=or_books.getBook_edition() %>" readonly>
                    </div>
                </div>
                
                
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control form-control-sm" value="Language :  <%=or_books.getBook_language() %>" readonly>
                    </div>
                    
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control form-control-sm" value="Location :  <%=or_books.getBook_rack_no() %>" readonly>
                    </div>
                    
                    <div class="form-group col-md-3">
                    
                    	
                        
                    </div>
                </div>
                
                <%
						if(or_books.getBook_status().equals("available")){
				%>
                    
                <h6>Status : <b style="color: green"> <%=or_books.getBook_status() %></b></h6>      
                        
                <%}else{ %>
                
                
                    
                <h6>Status : <b style="color: red"> <%=or_books.getBook_status() %></b></h6>      
                        
                <%} %>
                
                
                
            </div>
        </div>
			
			<br><br>
			<%
	
			if(i>=9){
				break;
			}
				
			i++;
			
			} %>
	
	</div>
	</div>
	</div>



</div>

	
			<!-- This Tag for Show Popup for Edit record  -->
	
	
	<div class="overlay"></div>	
	
	<div class="login_form">
	<span onclick="remove_login_display()">&times;</span>
		<div class="login_container">
			
			<div class="login_haiding"><i class="fa-solid fa-user"></i></div>
			<form  action="login_user" method="post">
			
			
				<div class="row-1">
					<div class="col">Email Id</div>
				</div>
			
				<div class="row">
					<div class="col"><input type="text" placeholder="Email Id" name="get_user_name" required="required"></div>
				</div>
			
				<br>
			
				<div class="row-1">
					<div class="col">Password</div>
				</div>
			
				<div class="row">
					<div class="col"><input type="password" placeholder="Password" name="get_user_pass" required="required"></div>
				</div>
			
				<br>
				<div class="row">
					<div class="col"><button class="btn">Login</button>  </div>
				</div>
			
			
			</form>
		</div>
	
	</div>
	
	
</body>

<script type="text/javascript">

	function login_display() {
		document.querySelector('.overlay').classList.add('showoverlay');
		document.querySelector('.login_form').classList.add('show_login_form');
	}
	
	
	
	function remove_login_display() {
		document.querySelector('.overlay').classList.remove('showoverlay');
		document.querySelector('.login_form').classList.remove('show_login_form');
	}

</script>


</html>