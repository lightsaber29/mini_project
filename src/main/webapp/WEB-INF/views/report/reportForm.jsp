<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/png">
    <title>Favison SAAS</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/animate-css/animate.css">
    <!-- main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
</head>
<body>

    <!--================Header Menu Area =================-->
    <header class="header_area">    
        <div class="main_menu">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                            <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li> 
                            <li class="nav-item"><a class="nav-link" href="feature.html">Features</a></li> 
                            <li class="nav-item"><a class="nav-link" href="price.html">Price</a></li>     
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="feature.html">Features</a></li> 
                                    <li class="nav-item"><a class="nav-link" href="price.html">Price</a></li>
                                    <li class="nav-item"><a class="nav-link" href="element.html">Element</a></li>
                                </ul>
                            </li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Blog</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
                                    <li class="nav-item"><a class="nav-link" href="single-blog.html">Blog Details</a></li>
                                </ul>
                            </li> 
                            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                        </ul>
                    </div>
                    <div class="right-button">
                        <ul>
                            <li class="shop-icon"><a href="#"><i class="ti-shopping-cart-full"></i><span>0</span></a></li>
                            <li><a class="sign_up" href="">Sign Up</a></li>
                        </ul>
                    </div> 
                </div>
            </nav>
        </div>
    </header>
    <!--================Header Menu Area =================-->


    <!--================Hero Banner Area Start =================-->
    <section class="hero-banner d-flex align-items-center">
        <div class="container text-center">
            <h2>Report Form</h2>
            <nav aria-label="breadcrumb" class="banner-breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Contact</li>
                </ol>
            </nav>
        </div>
    </section>
    <!--================Hero Banner Area End =================-->


  <!-- ================ contact section start ================= -->
  <section class="contact-section area-padding">
    <div class="container">


      <div class="row">
        <div class="col-12">
          <h2 class="contact-title">????????????</h2>
        </div>
        <div class="col-lg-12">
          <form class="form-contact contact_form" action="${pageContext.request.contextPath}/report/insert/${board.bno}" method="post" id="Form" >
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
              <div class="col-6">
              	<h5>??????</h5>
                <div class="form-group">
                  <input class="form-control" name="subject" id="subject" type="text" placeholder="${board.subject}">
                </div>
              </div>
              <div class="col-6">
                <div class="form-group">
                <h5>?????????</h5>
                	<input class="form-control" name="mem" id="mem" type="text" placeholder="${board.member.mname} / (${board.member.mid})">
                </div>
              </div>
              <hr>
              <div class="col-12">
                <h3 class="mb-20 title_color">?????? ??????</h3>
					<h5 class="mb-3">?????? ????????? ???????????? ??????, ???????????? ?????? 1?????? ????????? ?????????</h5>                	
                	<input type="radio" id="ad" name="reportContent" value="???????????? ?????? ?????????" class="primary-radio" checked="checked">
				?? 	<label for="html">???????????? ?????? ?????????</label><br>
					<input type="radio" id="forYouth" name="reportContent" value="????????? ?????? ??????????????? ???????????? ??????" class="primary-radio">
				?? 	<label for="css">????????? ?????? ??????????????? ???????????? ??????</label><br>
					<input type="radio" id="usurpation" name="reportContent" value="????????????/????????? ?????? ??? ??????????????? ???" class="primary-radio">
				?? 	<label for="css">????????????/????????? ?????? ??? ??????????????? ???</label><br>
					<input type="radio" id="hiddenCam" name="reportContent" value="??????????????? ??? ??????" class="primary-radio">
				?? 	<label for="html">??????????????? ??? ??????</label><br>
					<input type="radio" id="etc" name="reportContent" value="??????" class="primary-radio">
				?? 	<label for="etc">??????</label><br>
					<!-- <div style="display:none;" id="show">
				    <input class="form-control" name="content" id="content" type="text">
					</div> -->
              		
              </div>
            </div>
            <div class="form-group mt-3 d-flex justify-content-end col-12">
              <button type="submit" class="genric-btn danger-border radius e-large" id="reportBtn">????????????</button>
              &nbsp&nbsp&nbsp
              <a href="javascript:history.back();" class="genric-btn danger-border radius e-large">??????</a>
            </div>
          </form>


        </div>
      </div>
    </div>
  </section>
  <!-- ================ contact section end ================= -->

 <!-- ================ start footer Area ================= -->
    <footer class="footer-area">
        <div class="container">
            <div class="row">

                <div class="col-lg-3 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                    <h4>About Us</h4>
                    <p>Heaven fruitful doesn't over lesser days appear creeping seasons so behold bearing days open</p>
                    <div class="footer-logo">
                        <img src="img/logo.png" alt="">
                    </div>
                </div>

                <div class="col-lg-3 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                    <h4>Contact Info</h4>
                    <div class="footer-address">
                        <p>Address :Your address goes
                        here, your demo address.</p>
                        <span>Phone : +8880 44338899</span>
                        <span>Email : info@colorlib.com</span>
                    </div>
                </div>

                <div class="col-lg-3 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                    <h4>Important Link</h4>
                    <ul>
                        <li><a href="#">WHMCS-bridge</a></li>
                        <li><a href="#">Search Domain</a></li>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Shopping Cart</a></li>
                        <li><a href="#">Our Shop</a></li>
                    </ul>
                </div>

                <div class="col-lg-3 col-md-8 mb-4 mb-xl-0 single-footer-widget">
                    <h4>Newsletter</h4>
                    <p>Heaven fruitful doesn't over lesser in days. Appear creeping seasons deve behold bearing days open</p>

                    <div class="form-wrap" id="mc_embed_signup">
                        <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                        method="get">
                        <div class="input-group">
                            <input type="email" class="form-control" name="EMAIL" placeholder="Your Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Email Address '">
                            <div class="input-group-append">
                                <button class="btn click-btn" type="submit">
                                    <i class="fab fa-telegram-plane"></i>
                                </button>
                            </div>
                        </div>
                        <div style="position: absolute; left: -5000px;">
                            <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                        </div>

                        <div class="info"></div>
                    </form>
                </div>

            </div>
        </div>
        <div class="footer-bottom row align-items-center text-center text-lg-left no-gutters">
            <p class="footer-text m-0 col-lg-8 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            <div class="col-lg-4 col-md-12 text-center text-lg-right footer-social">
                <a href="#"><i class="ti-facebook"></i></a>
                <a href="#"><i class="ti-twitter-alt"></i></a>
                <a href="#"><i class="ti-dribbble"></i></a>
                <a href="#"><i class="ti-linkedin"></i></a>
            </div>
        </div>
    </div>
</footer>
<!-- ================ End footer Area ================= -->


<!--================Contact Success and Error message Area =================-->
    <div id="success" class="modal modal-message fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="fas fa-times"></i>
                    </button>
                    <h2>Thank you</h2>
                    <p>Your message is successfully sent...</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Modals error -->

    <div id="error" class="modal modal-message fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="fas fa-times"></i>
                    </button>
                    <h2>Sorry !</h2>
                    <p> Something went wrong </p>
                </div>
            </div>
        </div>
    </div>
    <!--================End Contact Success and Error message Area =================-->




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>
<script src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mail-script.js"></script>
<script src="${pageContext.request.contextPath}/js/contact.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mail-script.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
</body>
</html>