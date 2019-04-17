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
	            <% String username=request.getParameter("username");
	     		if(username==null)
	            username=(String)session.getAttribute("username");
	            out.print("Welcome "+username);
	            session.setAttribute("username",username);%>
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
					    <th>Action</th>
					  </tr >
					  <tr >
					    <td>Alfreds</td>
					    <td>Maria Anders</td>
					    <td><img src="./img/tick_mark_icon.png" width="25" height="25"></td>
					  </tr>
					  
					 
					  
					  <c:forEach var="dat" items="${returnedlist}">
						<tr>
							<td>${dat.name}</td>
							<td>${dat.trackid}</td>
							<td><img src="./img/tick_mark_icon.png" width="25" height="25"></td>
						</tr>
					   </c:forEach>
	
					 
				</table>
				
				
				
				
				

			  </div>
			</div>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll active" href="${pageContext.request.contextPath}/login" style="color: #0078ff" >Logout</a>
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
			 <button onclick="newenteryFunc()" class="dropbtn" style="width : 40px; text-align: center; border-radius: 50%;"><b>+</b></button>
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
		<th>status</th>
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
                            txt += "<tr><td>"+result[i].name+"</td><td>"+result[i].trackid+"</td><td><img src="+"'./img/tick_mark_icon.png'"+" width="+"'25'"+" height="+"'25'"+"></td></tr>";
                            
                            
                            //test += "<tr id="+result[i].Id+"+"><td>"+result[i].name+"</td><td>"+result[i].trackid+"</td><td><img src="+"'./img/tick_mark_icon.png'"+" width="+"'25'"+" height="+"'25'"+"></td></tr>";
                           // <td><img src="+"'./img/tick_mark_icon.png'"+" width="+"'25'"+" height="+"'25'"+  +"></td>
                        //}
                    }
                   
                    //if(txt != ""){
                        $("#reqtab").append(txt);
                    //}
                      
                //}
            }
	    	
	
		    	
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
	    
	    
	    
	  });
	  }
	</script>
	
	

</body>
</html>