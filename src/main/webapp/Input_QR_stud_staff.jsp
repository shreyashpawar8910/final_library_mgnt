<%@page import="com.entity.Student_enti"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
 <head>
 
 
	<meta charset="ISO-8859-1">

    <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <title>Scann QR for Student/Staff</title>

<style type="text/css">

.show_qr{

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



.show_qr .video_for_stud{
	
	margin-left: 340px;
	margin-top: -70px;
	height: 400px;
	width: 450px;
	border: 2px solid;
}

.card{
	margin-top: 0px;
	width: 1145px;
	height: 585px;
	margin-left: 0px;
	border: 1px solid;
}

.show_qr .card h4{
	
	font-family: initial;
	text-align: center;
	margin-top: 30px;
	
}
.show_qr .card h4 u{
	
	font-family: initial;
	
}

.next_form{
	margin-top: 20px;
	margin-left: 460px;
	
}

.next_form p{
	
	height: 40px;
	width: 200px;
	border: 2px solid;
	border-radius: 15px;
	padding-top: 5px; 
	padding-left: 70px; 
	font: 30px;	
}


.next_form button{
	margin-top: 0px;
	margin-left: 50px;
	border: 1px solid;
	border-radius: 10px;
	background: #437fc7; 
	color: white;
	width: 100px;
	
}


</style>

</head>
  
  
  <body>
  
  <%@include file="lbl_side_nav.jsp" %>
	
	
  <div class="show_qr">
  
 		 <div class="page_haiding">
			<h3>Student ID Scan</h3>
		</div>
		
		
		
		<div class="card">
  		
  		<h4><u> Scan Student/Teacher ID Card </u></h4>
  		
  		<div>
  		<br><br>
  		
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="radio_student" value="student" onchange="radio_category_name()"> &nbsp;&nbsp;Students <br>	
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="radio_student" value="teacher" onchange="radio_category_name()"> &nbsp;&nbsp;Teacher <br>
  				
  		</div>
  		
    	<video id="preview" class="video_for_stud"></video>	
    
    	
    	
    	<form action="check_studid" class="next_form">
    	
    		<p id="disply" ></p>
    		<input id="hidden_display" name="scann_stud_id" hidden >
    		
    		<p id="hidden_profile" hidden></p> 
    		  
    		  <input id="asdf" name="candi_type" hidden>  
    		  
    		  
    		  
    		  
    		  
    		   <%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succMsg");
    		   
    		   
    		   %>
    		    		
    		 <input id="msg_get_id" value="<%=msgget %>" hidden >		<!--This input hidden tag for get value of session  -->
    		    		
    		 
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="notavailable"){
    		 		
    		 		swal("Error", "This Candidate cannot be registered in System", "error");
    		 	}
    		 	
				if(msggg=="available"){
    		 		
					swal("Sucess", "Book Issued Sucessfull", "success");
    		 	}
    		  
    		</script>
    		
    		<% session.removeAttribute("succMsg"); %>
    		
    		
    		
    		
    		
    		
    		<button class="btn" type="submit" value="Register">Next	</button>
    	</form>
    	
    </div>

    
    <%-- <%
    Student_enti std = new Student_enti();
    	if(std.getMessage_var()=="not available"){
    		
    		%>
    		
    		<script type="text/javascript">
    		
    		//swal("Good job!", "You clicked the button!", "success");
    		</script>
    		
    		<%
    		
    	}
    
    %> --%>
    
    	<script>
    	
    	
    	

      	function radio_category_name() {
			
      		var stud_rd = document.getElementsByName("radio_student");
      		
      		var i;
      		for(i=0;i<=stud_rd.length; i++){
      			if(stud_rd[i].checked){
      					
      				//document.getElementById("hidden_profile").innerHTML = stud_rd[i].value;
      				
      				start_stud_teacher_scanning();			
      			}		
      				
	
      		}          	
		}

    	
    	
    	  	
    	function start_stud_teacher_scanning() {
    		
		var stud_rd = document.getElementsByName("radio_student");     	
   		
      		let scanner = new Instascan.Scanner({ video: document.getElementById('preview') });	
    
	      	scanner.addListener('scan', function (content) {
        	//alert('Scanned QR code: ' + content);
        	
        	document.getElementById("disply").innerHTML  = content;
        	document.getElementById("hidden_display").value  = content;
        	//document.getElementById("hidden_profile").value  = stud_rd;
        	
        	
        	
        	var i;
      		for(i=0;i<=stud_rd.length; i++){
      			if(stud_rd[i].checked){
      					
      				document.getElementById("hidden_profile").innerHTML = stud_rd[i].value;      
      				
      				if(stud_rd[i].value == "student"){
      					document.getElementById("asdf").value = "student";		
      					
      				}else{
      					document.getElementById("asdf").value = "teacher";
      					
      				}
      				      	    		
      			}		
      			//var a = document.getElementById("hidden_profile");
      				
      		
      			
          		
          		
      		}     
      		
      		
        	
        	
        	
      	});
	      	
      	Instascan.Camera.getCameras().then(function (cameras) {
        	if (cameras.length > 0) {
          	scanner.start(cameras[0]);
        	} else {
          	console.error('No cameras found.');
        	}
    		
      	}).catch(function (e) {
        	console.error(e);
      	});
		}
    	
      	

      	
      	
    	</script>
    </div>
    
    
    
    
    
  </body>
</html>