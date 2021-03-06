<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#deleteBtn").click(function(){
			if(!confirm("삭제하시겠습니까? \n삭제 시 복구되지 않습니다.")){
				$(this).attr("href", "#")
			}else{
				alert("삭제되었습니다.")
				$(this).attr("href", "${pageContext.request.contextPath}/board/delete/${board.bno}")
			}
					
		})
		$("#updateBtn").click(function(){
			if(!confirm("수정하시겠습니까? \n수정 시 등록된 이미지는 삭제됩니다.")){
				$(this).attr("href", "#")
			}else{
				$(this).attr("href", "${pageContext.request.contextPath}/board/updateForm/${board.bno}")
			}
		})
	})
</script>
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
            <h2>Blog Details</h2>
            <nav aria-label="breadcrumb" class="banner-breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Blog Details</li>
                </ol>
            </nav>
        </div>
    </section>
    <!--================Hero Banner Area End =================-->


    <!--================Blog Area =================-->
    <section class="blog_area single-post-area area-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 posts-list">
                    <div class="single-post">
                        <div class="feature-img">
                            <img class="img-fluid" src="img/blog/main-blog/m-blog-1.jpg" alt="">
                        </div>

						<div class="blog_details">
						    <h2>${board.subject}</h2>
						    <ul class="blog-info-link mt-3 mb-4">
						        <li><i class="far fa-user"></i>${board.member.mname}</li>
						        <li><a href="#reply"><i class="far fa-comments"></i> 
						        <fmt:formatNumber value="${fn:length(board.replyList)}" pattern="#,###" />
						        Comments</a></li>
						        <li><i class="far fa-clock"></i>${board.regdate}</li>
						        <li><i class="far fa-eye"></i>${board.readnum} Views</li>
						        <!-- ${board.member.mno}랑 권한이랑 같을때 -->
						        <li><a href="${pageContext.request.contextPath}/board/updateForm/${board.bno}" id="updateBtn"><i class="far fa-edit"></i>Update</a></li>
						        <li><a href="${pageContext.request.contextPath}/board/delete/${board.bno}" id="deleteBtn"><i class="far fa-trash-alt"></i>Delete</a></li>
						    	<!-- ${board.member.mno}랑 권한이랑 다를때 -->
						    	<li><a href="${pageContext.request.contextPath}/report/reportForm/${board.bno}"><i class="far fa-flag"></i>신고</a></li>
						    </ul>
						    <div class="quote-wrapper">
						    <c:forEach items="${board.imageList}" var="image">
						    	<img alt="" src="${pageContext.request.contextPath}/save/${image.imagePath}"><p>
						    </c:forEach>
								${board.content}			       
						    </div>
						</div>
					</div>
					
					
<div class="navigation-top">
    <div class="d-sm-flex justify-content-evenly text-center">
        <c:choose>
        	<c:when test="${board.recommend==0}">
        		<p class="like-info"><span class="align-middle">
		        <i class="far fa-heart"></i></span>
		        no one likes this yet</p>
        	</c:when>
        	<c:otherwise>
        		<p class="like-info"><span class="align-middle">
		        <a href="#"><i class="fas fa-heart"></i></a></span>
		        ${board.recommend} people likes this</p>
        	</c:otherwise>
        </c:choose>
        
        <div class="col-sm-4 text-center my-2 my-sm-0">
            <p class="comment-count"><span class="align-middle"><i class="far fa-comment"></i></span> 
          	<fmt:formatNumber value="${fn:length(board.replyList)}" pattern="#,###" />  Comments</p>
        </div>
    </div>
    <div class="d-flex justify-content-end text-center">
    	<div class="col-sm-2 text-center my-2 my-sm-0">
          	<a href="${pageContext.request.contextPath}/recommend/insert/${board.bno}" class="genric-btn primary-border small">Like</a>
        </div>
        <div class="col-sm-2 text-center my-2 my-sm-0">
          	<a href="${pageContext.request.contextPath}/recommend/delete/${board.bno}" class="genric-btn success-border small">Like Cancle</a>
        </div>
    </div>

</div>

<c:choose>
	<c:when test="${empty board.replyList}">
		<div class="comments-area">
			    <h4><fmt:formatNumber value="${fn:length(board.replyList)}" pattern="#,###" /> Comments</h4>
			    <div class="comment-list">
			        <div class="single-comment justify-content-between d-flex">
			            <div class="user justify-content-between d-flex">
			            	<div class="desc">
			                    <p class="comment">등록된 댓글이 없습니다.</p>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
	</c:when>
	<c:otherwise>
		<div class="comments-area">
			<h4><fmt:formatNumber value="${fn:length(board.replyList)}" pattern="#,###" /> Comments</h4>
			<c:forEach items="${board.replyList}" var="reply">
			    <div class="comment-list">
			        <div class="single-comment justify-content-between d-flex">
			            <div class="user justify-content-between d-flex">
			            	<div class="desc">
			                    <p class="comment">${reply.replyContent} </p>
			                    <div class="d-flex justify-content-between">
			                        <div class="d-flex align-items-center">
			                            <h5>${reply.member.mname}</h5>
			                            <p class="date">
			                            <fmt:parseDate var="parseDate" pattern="yyyy-MM-dd'T'HH:mm:ss" value="${reply.replyRegdate}" type="both" /> 
				                        <fmt:formatDate value="${parseDate}" pattern="yyyy.MM.dd" /></p>
			                        </div>
			                        <div class="reply-btn">
			                            <a href="${pageContext.request.contextPath}/reply/updateForm/${reply.rno}" class="btn-reply text-uppercase">edit</a>
			                        </div>
			                        
			                        <div class="reply-btn">
			                            <a href="${pageContext.request.contextPath}/reply/delete/${reply.rno}/${reply.board.bno}" class="btn-reply text-uppercase">delete</a>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			</c:forEach>
			</div>
	</c:otherwise>
</c:choose>


<div class="comment-form" id="replyForm">
    <h4>Leave a Reply</h4>
    <form class="form-contact comment_form" action="${pageContext.request.contextPath}/reply/insert" id="commentForm">
        <input type="hidden" name="bno" value="${bno}" />
        <div class="row">
            <div class="col-12">
                <div class="form-group">
                    <textarea class="form-control w-100" name="replyContent" id="replyContent" cols="30" rows="9" placeholder="Write Comment"></textarea>
                </div>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="button button-contactForm">Send Message</button>
        </div>
    </form>
</div>
</div>

</div>
</div>
</section>
<!--================Blog Area end =================-->

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