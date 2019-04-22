<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>USER-entries</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/myicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">

  <!-- =======================================================
    Theme Name: DevFolio
    Theme URL: https://bootstrapmade.com/devfolio-bootstrap-portfolio-html-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
  
</head>

<body id="page-top">

  <!--/ Nav Star /-->
  <nav class="navbar navbar-b navbar-trans navbar-expand-md fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll" href="#page-top">PickPack</a>
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarDefault"
        aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <div class="navbar-collapse collapse justify-content-end" id="navbarDefault">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link js-scroll active" href="${pageContext.request.contextPath}/index" >Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll" href="${pageContext.request.contextPath}/index#about" >About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll" href="${pageContext.request.contextPath}/index#contact" >Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!--/ Nav End /-->

  <!--/ Intro Skew Star /-->
  <div id="home" class="intro route bg-image" style="background-image: url(img/intro-bg.jpg)">
    <div class="overlay-itro"></div>







    <div class="container " style="text-align: center;" >
        
        <div class="col-sm-6" style="display: inline-block; margin-top: 180px;">
              <div class="row" >
                <div class="col-md-12" >
                  <div class="title-box-2">
                    <h1 >
                      <span style="color: #ffffff">User Entries</span>
                    </h1>
                  </div>
                  <div>
                  
                  
                      <form:form action="/user" id="userform" method="post" modelAttribute="usertable">
							
							<div style="color:red"> ${failure}</div>
							<div style="color:#00ff43"> ${success}</div>
							<div class="col-md-12 mb-3">
                            	<form:input path="name" placeholder="Enter Full Name" class="form-control" required="true"/>
	                        </div>
	                        
	                        <div class="col-md-12 mb-3">
	                            <form:input path="trackid" placeholder="Enter Tracking Id" class="form-control" data-rule="minlen:8" data-msg="Please enter at least 8 chars of password" required="true"/>
								<div class="validation"></div>
	                        </div>
	                        <div class="col-md-12 mb-3">
	                            <input class="button button-a button-fixsize button-rouded" type="submit" value="submit" />
	                        </div>
	                        	
						</form:form>
                    
                    
                    
                    
                  </div>
                </div>
           </div>
        </div>
          



    
  </div>
  <!--/ Intro Skew End /-->

 

















  <!--/ Section Contact-footer End /-->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  <div id="preloader"></div>

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/popper/popper.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/counterup/jquery.waypoints.min.js"></script>
  <script src="lib/counterup/jquery.counterup.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/lightbox/js/lightbox.min.js"></script>
  <script src="lib/typed/typed.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>
  
	<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
	</script>
	

</body>
</html>
