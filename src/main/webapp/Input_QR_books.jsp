<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>

<title>Scann QR for Books</title>


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



.show_qr .video_for_book{
	
	margin-left: 340px;
	margin-top: -110px;
	height: 400px;
	width: 450px;
	border: 2px solid;
}

.card-2{
	margin-top: 0px;
	width: 1145px;
	height: 585px;
	margin-left: 0px;
	border: 1px solid;
}





.show_qr .card-2 h4{
	
	font-family: initial;
	text-align: center;
	margin-top: 10px;
	
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
			<h3>Book Master</h3>
		</div>
		
	
	
	
	
	<!-- This card-2 is used for display an Book/ Journal Scanning content  -->
    
    
    <div class="card-2">
    	
    	<h4>Scan Book</h4>
  		
  		<div>
  		<br><br>
  		
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="radio_student" value="book" onchange="radio_category_book()"> &nbsp;&nbsp;Books <br>	
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="radio_student" value="magazine" onchange="radio_category_book()"> &nbsp;&nbsp;Magazine <br>
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="radio_student" value="journal" onchange="radio_category_book()"> &nbsp;&nbsp;Journal <br>
  				
  		</div>
  		
    	<video id="preview-2" class="video_for_book"></video>	
    
    	<form action="check_stock_id" class="next_form">
    	
    		<p id="disply" ></p>
    		<input id="hidden_display" name="scann_book_id" hidden >
    		
    		<p id="hidden_profile" hidden></p> 
    		  
    		  <input id="asdf" name="stock_type" hidden>  
    		  
    		  
    		  
    		  
    		  
    		   <%
    		   	//HttpSession session = request.getSession();
    		   String msgget = (String)session.getAttribute("succMsg");
    		   
    		   
    		   %>
    		    		
    	
    		    		
    		<script type="text/javascript">
    		
    		 var msggg = "<%=msgget %>";
    			
    		 	if(msggg=="notavailable"){
    		 		
    		 		swal("Error", "This Stock are already issued by another Candidate or Stock Unavailable ", "error");
    		 	}
    		  
    		</script>
    		
    		<% session.removeAttribute("succMsg"); %>
    		
    		
    		
    		
    		
    		
    		<button class="btn" type="submit" value="Register">Next	</button>
    	</form>
    	
    
    </div>
    
    
    
    </div>
    
    
    <script type="text/javascript">
    
    
  	
  	
    // This Function for display scanner in Book Journal card
     	
     	
 	function radio_category_book() {
			
		
   	 
     		var stud_rd = document.getElementsByName("radio_student");		
     		
     		
     		var i;
     		for(i=0;i<=stud_rd.length; i++){
     			if(stud_rd[i].checked){
     					
     				//document.getElementById("disply").innerHTML = stud_rd[i].value;
     				
     				Book_scanning();
     				
     			}
	
     		}          	
		}
     	
     	
     	
 				
 	
     	function Book_scanning() {
   		let scanner = new Instascan.Scanner({ video: document.getElementById('preview-2') });	
	      	scanner.addListener('scan', function (content) {
       		
	      	
	      	 	document.getElementById("disply").innerHTML  = content;
	        	document.getElementById("hidden_display").value  = content;
	        	//document.getElementById("hidden_profile").value  = stud_rd;
	        	
	        	
	        	var stud_rd = document.getElementsByName("radio_student");		
	        	
	        	var i;
	      		for(i=0;i<=stud_rd.length; i++){
	      			if(stud_rd[i].checked){
	      					
	      				document.getElementById("hidden_profile").innerHTML = stud_rd[i].value;      
	      				
	      				
	      				if(stud_rd[i].value == "book"){
	      					document.getElementById("asdf").value = "book";		
	      					
	      				}else if(stud_rd[i].value == "magazine"){
	      					document.getElementById("asdf").value = "magazine";
	      					
	      				}else if(stud_rd[i].value == "journal"){
	      					document.getElementById("asdf").value = "journal";
	      					
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
	
	
	
</body>
</html>