<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EcoMo - Categories</title>

<%@include file="jspf/links.jspf" %>
</head>
<body>
	<%@include file="jspf/header.jspf" %>
	<main class="main">
        	<div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        		<div class="container">
        			<h1 class="page-title">Categories<span>EcoMo</span></h1>
        		</div><!-- End .container -->
        	</div><!-- End .page-header -->
            <div class="page-content">
            	<div class="categories-page">
	                <div class="container">
	                	<div class="row">
	                		<div class="col-md-6">
	                			<div class="banner banner-cat banner-badge">
		                			<a href="Categories?categorie=Laptop">
		                				<img src="images/Laptops.jpg" alt="Banner">
		                			</a>
		                			<a class="banner-link" href="Categories?categorie=Laptop">
		                				<h3 class="banner-title">Ordinateurs portables</h3><!-- End .banner-title -->
		                				<span class="banner-link-text">Achetez maintenant</span>
		                			</a><!-- End .banner-link -->
	                			</div><!-- End .banner -->
	                		</div><!-- End .col-md-6 -->

	                		<div class="col-md-6">
	                			<div class="row">
	                				<div class="col-sm-6">
	                					<div class="banner banner-cat banner-badge">
				                			<a href="Categories?categorie=Accessoires">
				                				<img style="width:277px;height:277px" src="images/accessories.jpg" alt="Banner">
				                			</a>

				                			<a class="banner-link" href="Categories?categorie=Accessoires">
				                				<h3 class="banner-title">Accessoires</h3><!-- End .banner-title -->
				                				<span class="banner-link-text">Achetez maintenant</span>
				                			</a><!-- End .banner-link -->
			                			</div><!-- End .banner -->
	                				</div><!-- End .col-sm-6 -->

	                				<div class="col-sm-6">
	                					<div class="banner banner-cat banner-badge">
				                			<a href="Categories?categorie=Cameras">
				                				<img style="width:277px;height:277px" src="images/cameras.jpg" alt="Banner">
				                			</a>

				                			<a class="banner-link" href="Categories?categorie=Cameras">
				                				<h3 class="banner-title">Caméras</h3><!-- End .banner-title -->
				                				<span class="banner-link-text">Achetez maintenant</span>
				                			</a><!-- End .banner-link -->
			                			</div><!-- End .banner -->
	                				</div><!-- End .col-sm-6 -->
	                			</div><!-- End .row -->

	                			<div class="banner banner-cat banner-badge">
		                			<a href="Categories?categorie=Smartphones">
		                				<img style="width:574px;height:277.1px" src="images/phones.jpg" alt="Banner">
		                			</a>

		                			<a class="banner-link" href="Categories?categorie=Smartphones">
		                				<h3 class="banner-title">Smartphones</h3><!-- End .banner-title -->
		                				<span class="banner-link-text">Achetez maintenant</span>
		                			</a><!-- End .banner-link -->
	                			</div><!-- End .banner -->
	                		</div><!-- End .col-md-6 -->
	                	</div><!-- End .row -->
	                </div><!-- End .container -->
                </div><!-- End .categories-page -->
            </div><!-- End .page-content -->
        </main><!-- End .main -->
        <%@include file="jspf/mobile.jspf" %>
        <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>
        <%@include file="jspf/footer.jspf" %>
</body>
</html>