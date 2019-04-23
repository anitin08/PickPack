<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>table</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/myicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
  
  <!-- table wali css -->
  <link rel="stylesheet" href="./css/tab_style.css">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">



</head>


<!-- Body starts -->

<body>

<div style="background-color: #F5DEB3">
    <!div class="overlay-itro"><!/div>

<!--/ Nav Star /-->
  <nav class="navbar navbar-b navbar-trans navbar-expand-md fixed-top" id="mainNav" style="background-color: white; padding: 10px;">
    <div class="container">
      <a class="navbar-brand js-scroll" href="#page-top" style="color:#0078ff ">PickPack</a>
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarDefault"
        aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <div class="navbar-collapse collapse justify-content-end" id="navbarDefault">
        <ul class="navbar-nav">
	        <li class="nav-item">
	            <div class="nav-link js-scroll" id="latestuser" style="color: #0078ff " >
	            
	            
	            
	            <% 
	            if (session != null) {
	    			if (session.getAttribute("username") != null) {
	    				String name = (String) session.getAttribute("username");
	    				out.print("Welcome, " + name);
	    			} else {
	    				response.sendRedirect("/login");
	    			}
	    		}
	            else {										//
    				response.sendRedirect("/login");		//why it is not needed?
    			}											//										
	            %>
	            
	            
	            
	            </div>
          </li>
          <li>
          	<div class="dropdown">
			  <button onclick="myDropFunc(); myAjax()" class="dropbtn" style="border-radius: 4px;">REQUESTS</button>
			  <div id="myDropdown" class="dropdown-content">
			  
			  
			  
			  
			  
			    <table id="reqtab" style="width: 100%">
					  <tr>
					    <th>Name</th>
					    <th>TrackId</th>
					    <th>Check</th>
					    <th>Picked</th>
					  </tr >
					  
					 
				</table>
				
				
				
				
				

			  </div>
			</div>
          </li>
          <li class="nav-item">
           <form action="/logout" method="get"> <button class="nav-link js-scroll active" type="submit" style="color: #0078ff; border: none;
  background-color: inherit;" >Logout</button></form>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
  <!--/ Nav End /-->





  <div class="container" >
      <div class="header_wrap" style="margin-top: 65px;" >
        <div class="num_rows" >
		
				<div class="form-group"> 	<!--		Show Numbers Of Rows 		-->
			 		<select class  ="form-control" name="state" id="maxRows">
						 
						 
						 <option value="10">10</option>
						 <option value="15">15</option>
						 <option value="20">20</option>
						 <option value="50">50</option>
						 <option value="70">70</option>
						 <option value="100">100</option>
            			<option value="5000">Show ALL Rows</option>
					</select>	
			  	</div>
        </div>
        	  
		
		<div class="dropdown">
			<div class="row" style="margin-left: 5px">
				<form action="/fulltable" method="get"><button class="dropbtn" type="submit"  style="width : 40px; text-align: center; border-radius: 50%;"><b>F</b></button></form>
				<form action="/table" method="get"><button class="dropbtn" type="submit"  style="width : 40px; text-align: center; border-radius: 50%;"><b>U</b></button></form>
				 <button onclick="newenteryFunc()" class="dropbtn" style="width : 40px; text-align: center; border-radius: 50%;"><b>+</b></button>
			</div>
			
			  <div id="mynewentry" class="dropdown-content" style="background-color: #000000">

				    <form:form action="/createrecord" method="post" role="form" modelAttribute="addrecordform" >
				    		
						  <form:input type="text"  path="track_id" placeholder="TrackingId" style="width: 100%" required="required"/>
						  <form:input type="text"  path="name" placeholder="Name" style="width: 100%" required="required"/>
						  <form:input list="hosting-plan" type="text" path="comp_name" placeholder="Company" style="width: 100%" required="required"/>
							<datalist id="hosting-plan">
							    <option value="flipkart"/>
							    <option value="amazon"/>
							    <option value="myntra"/>
							</datalist><br>
						  <input type="submit" value="Submit" style="width: 100%; color: blue;">
	                </form:form>



			  </div>
			  <div style="color:red"> ${ans}</div>
			  <div style="color:red"> ${noitem}</div>
		</div>
		
			
		 
        <div class="tb_search">

               <input type="text" id="search_input_all" onkeyup="FilterkeyWord_all_table()" placeholder="Search.." class="form-control">
        </div>
      </div>
<table class="table table-striped table-class" id= "table-id" name="table-nm " style="margin-top: -20px;">
  	
<thead>
<tr>
		<th>Item_No</th>
		<th>Tracking Id</th>
		<th>Name</th>
		<th>Company</th>
		<th>Date</th>
		<th>Status</th>
		<th>Remark</th>
	</tr>
</thead>
<tbody >
	
	<c:forEach var="dat" items="${recordlist}">
		<tr>
			<td>${dat.item_no}</td>
			<td>${dat.track_id}</td>
			<td>${dat.name}</td>
			<td>${dat.comp_name}</td>
			<td>${dat.date}</td>
			<td>${dat.status}</td>
			<td>${dat.remark}</td>
			
		</tr>
	</c:forEach>
	
	
  
    </tbody>
</table>

<!--		Start Pagination -->
			<div class='pagination-container'>
				<nav>
				  <ul class="pagination">
				   <!--	Here the JS Function Will Add the Rows -->
				  </ul>
				</nav>
			</div>
      <div class="rows_count"></div>

</div> <!-- 		End of Container -->


</div><!-- end of background-->



  <script src='./js/pagin_js.js'></script>
<script src='./js/pagin1_js.js'></script>

  
<!-- Js of table wali -->
 <script  src="./js/tab_js.js"></script>


	<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
	</script>
	
	
	<script >
	function myAjax() {
	    $.ajax({
	    dataType: "json",
	    method: "GET",
	    url: '/getrequests',
	    success: function (result) {
	    	//alert(result);
	    	//var newres = JSON.parse(result);
	    	
	    	//result=JSON.parse(resul);
	    	
	    	if(result!=null){
	    		//alert(result);
	    		$('#reqtab tr:gt(0)').remove();
                var len = result.length;
                var txt = "";
                var test= "";
                //if(len > 0){
                    for(var i=0;i<len;i++){
                        //if(result[i].name && data[i].trackid){
                        	var name=result[i].name;
                        	//console.log(result[i]);
                        	var id=result[i].id;
                        	var trackId=result[i].trackid;
                        	
                        	
                            txt += "<tr><td>"+result[i].name+"</td><td>"+result[i].trackid+"</td><td><button  onclick='trackidsearch(\""+trackId+"\")' ><img src='./img/tick_mark_icon.png' width='25' height='25' /></button></td><td>"
                            +"<form action='/searchByTrack' method=get><input type='hidden' name='name' value='"+name+"'/><input type='hidden' name='trackId' value='"+trackId+"'/><input type='hidden' name='id' value='"+id+"'/><button type='submit'><img src='./img/tick_mark_icon.png' width='25' height='25' /></button></form></td></tr>";
                            
                           
                            
                            
                           //2   txt += "<tr><td>"+result[i].name+"</td><td>"+result[i].trackid+"</td><td><button ><img src='./img/tick_mark_icon.png' width='25' height='25' /></button></td><td>"
                           // +"<form action='/searchByName' method=get><input type='hidden' name='name' value='"+name+"'/><input type='hidden' name='trackId' value='"+trackId+"'/><input type='hidden' name='id' value='"+id+"'/><button type='submit'><img src='./img/tick_mark_icon.png' width='25' height='25' /></button></form></td></tr>";
                            
                            
                            //1  txt += "<tr><td>"+result[i].name+"</td><td>"+result[i].trackid+"</td><td><img src='./img/tick_mark_icon.png' width='25' height='25' /></td><td>"
                            //+"<form action='/searchByName' method=get><input type='hidden' name='name' value='"+name+"'/><input type='hidden' name='trackId' value='"+trackId+"'/><input type='hidden' name='id' value='"+id+"'/><input type='submit' value='submit'/></form></td></tr>";
                            
                            
                    }
                        
                        //txt += "<tr><td><form action='/addRemark' method=get><input  type='number' name='id' style='width:70%' /><input  type='text' name='remark' style='width:70%' /><button type='submit' style='width:95px'><img src='./img/tick_mark_icon.png' width='25' height='25' /></button></form><td></tr>"
                   		
                        
                        txt += "<tr><td colspan='4'><form action='/addRemark' method=get><input  type='number' placeholder='Item Number..' name='id' style='width:140px' required='true' /><input  type='text' name='remark' placeholder='Add Remark..' style='width:140px;margin-left: 2px' /><button type='submit' style='width:100px;margin-left: 2px'><img src='./img/tick_mark_icon.png' width='25' height='25' /></button></form><td></tr>" 
          				//appending
                        $("#reqtab").append(txt);
                        
                  
            }
	    	
	
		    	
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
	    
	    
	    
	  });
	  }
	    
	    
	    
	    
	    
	    
	    function trackidsearch(stid){
	    	
	    	// Count td if you want to search on all table instead of specific column

	    	  var count = $('.table').children('tbody').children('tr:first-child').children('td').length; 

	    	        // Declare variables
	    	  var input, filter, table, tr, td, i;
	    	        
	    	  //input = document.getElementById("search_input_all");
	    	  var input_value =   stid; //document.getElementById("search_input_all").value;
	    	        filter = input_value.toLowerCase();//input.value.toLowerCase();
	    	  if(input_value !=''){
	    	        table = document.getElementById("table-id");
	    	        tr = table.getElementsByTagName("tr");

	    	        // Loop through all table rows, and hide those who don't match the search query
	    	        for (i = 1; i < tr.length; i++) {
	    	          
	    	          var flag = 0;
	    	           
	    	          for(j = 0; j < count; j++){
	    	            td = tr[i].getElementsByTagName("td")[j];
	    	            if (td) {
	    	             
	    	                var td_text = td.innerHTML;  
	    	                if (td.innerHTML.toLowerCase().indexOf(filter) > -1) {
	    	                //var td_text = td.innerHTML;  
	    	                //td.innerHTML = 'shaban';
	    	                  flag = 1;
	    	                } else {
	    	                  //DO NOTHING
	    	                }
	    	              }
	    	            }
	    	          if(flag==1){
	    	                     tr[i].style.display = "";
	    	          }else {
	    	             tr[i].style.display = "none";
	    	          }
	    	        }
	    	    }else {
	    	      //RESET TABLE
	    	      $('#maxRows').trigger('change');
	    	    }
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    function logmeout() {
		    $.ajax({
		    dataType: "json",
		    method: "GET",
		    url: '/logout',
		    success: function (result) {

			    	
		    },
		    error: function(jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
		    
		  });
		  } 
	    
	    
	    

	
	</script>
	
	

</body>
</html>