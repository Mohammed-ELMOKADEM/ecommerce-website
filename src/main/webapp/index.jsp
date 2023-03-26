
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>EcoMo - Accueil</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Molla - Bootstrap eCommerce Template">
    <meta name="author" content="p-themes">
    <%@include file="WEB-INF/jspf/links.jspf" %>
   
    <style>
    
    	.product{
    		width:200px !important;
    	}
    </style>
</head>

<body>
    <%@include file="WEB-INF/jspf/header.jspf" %>
    	<c:if test="${!empty errorMessage }">
	    	<div class="alert alert-danger" role="alert">  		
	    			<c:out value="${ errorMessage }"></c:out>
	    			<button type="button" class="close" onClick="parent.location='Home'" aria-label="Close">
    						<span aria-hidden="true">&times;</span>
  					</button>
	    			
	    	</div>
    	</c:if>
    	<c:if test="${!empty Success }">
	    	<div class="alert alert-success" role="alert">  		
	    			<c:out value="${ Success }"></c:out>
	    			<button type="button" class="close" onClick="parent.location='Home'" aria-label="Close">
    						<span aria-hidden="true">&times;</span>
  					</button>
	    	</div>
    	</c:if>
    	<c:if test="${!empty param['errorMessage'] }">
	    	<div class="alert alert-danger" role="alert">  		
	    			<c:out value="${param['errorMessage']}"></c:out>
	    			<button type="button" class="close" onClick="parent.location='Home'" aria-label="Close">
    						<span aria-hidden="true">&times;</span>
  					</button>
	    	</div>
    	</c:if>
    	<div class="page-wrapper">
    	<div class="col-lg-8" style="margin:20px auto;">
            <div class="intro-slider-container slider-container-ratio slider-container-1 mb-2 mb-lg-0">
                <div class="intro-slider intro-slider-1 owl-carousel owl-simple owl-light owl-nav-inside" data-toggle="owl" data-owl-options='{
                        "nav": false, 
                        "responsive": {
                            "768": {
                                "nav": true
                            }
                        }
                    }'>
                    <div class="intro-slide">
                        <figure class="slide-image">
                            <picture>
                                <source media="(max-width: 480px)" srcset="images/Laptops.jpg">
                                <img src="images/Laptops.jpg" alt="Image Desc">
                            </picture>
                        </figure><!-- End .slide-image -->

                        <div class="intro-content">
                            <h3 class="intro-subtitle">Topsale Collection</h3><!-- End .h3 intro-subtitle -->
                            <h1 class="intro-title" style="color:white !important;">Latest<br>Laptops</h1><!-- End .intro-title -->

                            <a href="Categories?categorie=Laptop" class="btn btn-outline-white">
                                <span>Acheter maintenant</span>
                                <i class="icon-long-arrow-right"></i>
                            </a>
                        </div><!-- End .intro-content -->
                    </div><!-- End .intro-slide -->
					<div class="intro-slide">
                        <figure class="slide-image">
                            <picture>
                                <source media="(max-width: 480px)" srcset="images/accessories.jpg">
                                <img src="images/accessories.jpg" alt="Image Desc">
                            </picture>
                        </figure><!-- End .slide-image -->

                        <div class="intro-content">
                            <h3 class="intro-subtitle">Topsale Collection</h3><!-- End .h3 intro-subtitle -->
                            <h1 class="intro-title" style="color:white !important;">Latest<br>Accessories</h1><!-- End .intro-title -->

                            <a href="Categories?categorie=Accessoires" class="btn btn-outline-white">
                                <span>Acheter maintenant</span>
                                <i class="icon-long-arrow-right"></i>
                            </a>
                        </div><!-- End .intro-content -->
                    </div><!-- End .intro-slide -->
                    <div class="intro-slide">
                        <figure class="slide-image">
                            <picture>
                                <source media="(max-width: 480px)" srcset="images/phones.jpg">
                                <img src="images/phones.jpg" alt="Image Desc">
                            </picture>
                        </figure><!-- End .slide-image -->

                        <div class="intro-content">
                            <h3 class="intro-subtitle">Topsale Collection</h3><!-- End .h3 intro-subtitle -->
                            <h1 class="intro-title" >Latest<br>Phones</h1><!-- End .intro-title -->

                            <a href="Categories?categorie=Smartphones" class="btn btn-outline-white">
                                <span>Acheter maintenant</span>
                                <i class="icon-long-arrow-right"></i>
                            </a>
                        </div><!-- End .intro-content -->
                    </div><!-- End .intro-slide -->
                    <div class="intro-slide">
                        <figure class="slide-image">
                            <picture>
                                <source media="(max-width: 480px)" srcset="images/cameras.jpg">
                                <img src="images/cameras.jpg" alt="Image Desc">
                            </picture>
                        </figure><!-- End .slide-image -->

                        <div class="intro-content">
                            <h3 class="intro-subtitle">Topsale Collection</h3><!-- End .h3 intro-subtitle -->
                            <h1 class="intro-title" style="color:white !important;">Latest<br>Cameras</h1><!-- End .intro-title -->

                            <a href="Categories?categorie=Cameras" class="btn btn-outline-white">
                                <span>Acheter maintenant</span>
                                <i class="icon-long-arrow-right"></i>
                            </a>
                        </div><!-- End .intro-content -->
                    </div><!-- End .intro-slide -->
                </div><!-- End .intro-slider owl-carousel owl-simple -->
                
                <span class="slider-loader"></span><!-- End .slider-loader -->
            </div><!-- End .intro-slider-container -->
        </div><!-- End .col-lg-8 -->
        <main class="main">
            <div class="container featured">
                <ul class="nav nav-pills nav-border-anim nav-big justify-content-center mb-3" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="products-featured-link" data-toggle="tab" href="#products-featured-tab" role="tab" aria-controls="products-featured-tab" aria-selected="true">Vous pourriez aussi aimer</a>
                    </li>
                </ul>
				<div class="container">
                    <div class="products">
                        <div class="row">
                		<c:if test="${!empty ProduitsRec}">
                         <c:forEach var="produit" items="${ProduitsRec}"  varStatus="status">
   
                        	<div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product">
                                    <figure class="product-media">
                                        <a href="Produit?id=${ produit.getId() }">
                                            <img src="./images/${ produit.getImageName()}" alt="Product image" class="product-image">
                                        </a>
                                        <div class="product-action action-icon-top">
                                            <a href="Cart?addTocart=${produit.getId() }" class="btn-product btn-cart"><span>Ajouter au panier</span></a>
                                            
                                        </div><!-- End .product-action -->
                                    </figure><!-- End .product-media -->

                                    <div class="product-body">
                                        <div class="product-cat">
                                            <a href="#">${ produit.getCategorie()}</a>
                                        </div><!-- End .product-cat -->
                                        <h3 class="product-title"><a href="product.html">${ produit.getName()}</a></h3><!-- End .product-title -->
                                        <div class="product-price">
                                            $${ produit.getPrix() }
                                        </div><!-- End .product-price -->
                                        <div class="ratings-container">
                                            <div class="ratings">
                                                <div class="ratings-val" style="width: 85%;"></div><!-- End .ratings-val -->
                                            </div><!-- End .ratings -->
                                            <span class="ratings-text">( 4 Reviews )</span>
                                        </div><!-- End .rating-container -->
                                    </div><!-- End .product-body -->
                                </div><!-- End .product -->
                            </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                            </c:forEach>
                        </c:if>
                        </div>
                        </div>
                        </div>
            </div><!-- End .container -->

            <div class="mb-7 mb-lg-11"></div><!-- End .mb-7 -->

            <div class="container">
            </div><!-- End .container -->

            <div class="container">
                <hr class="mt-3 mb-6">
            </div><!-- End .container -->

            <div class="container top">
                <div class="heading heading-flex mb-3">
                    <div class="heading-left">
                        <h2 class="title">Meilleures ventes</h2><!-- End .title -->
                    </div><!-- End .heading-left -->
                </div><!-- End .heading -->
				<div class="products">
                        <div class="row">
                		<c:if test="${!empty TopSelling}">
                         <c:forEach var="produit" items="${TopSelling}"  varStatus="status">
   
                        	<div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product">
                                    <figure class="product-media">
                                        <a href="Produit?id=${ produit.getId() }">
                                            <img src="./images/${ produit.getImageName()}" alt="Product image" class="product-image">
                                        </a>
                                        <div class="product-action action-icon-top">
                                            <a href="Cart?addTocart=${produit.getId() }" class="btn-product btn-cart"><span>Ajouter au panier</span></a>
                                            
                                        </div><!-- End .product-action -->
                                    </figure><!-- End .product-media -->

                                    <div class="product-body">
                                        <div class="product-cat">
                                            <a href="#">${ produit.getCategorie()}</a>
                                        </div><!-- End .product-cat -->
                                        <h3 class="product-title"><a href="product.html">${ produit.getName()}</a></h3><!-- End .product-title -->
                                        <div class="product-price">
                                            $${ produit.getPrix() }
                                        </div><!-- End .product-price -->
                                        <div class="ratings-container">
                                            <div class="ratings">
                                                <div class="ratings-val" style="width: 85%;"></div><!-- End .ratings-val -->
                                            </div><!-- End .ratings -->
                                            <span class="ratings-text">( 4 Reviews )</span>
                                        </div><!-- End .rating-container -->
                                    </div><!-- End .product-body -->
                                </div><!-- End .product -->
                            </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                            </c:forEach>
                        </c:if>
                        </div>
                        </div>
                
            </div><!-- End .container -->

            <div class="container">
                <hr class="mt-5 mb-0">
            </div><!-- End .container -->

            <div class="icon-boxes-container mt-2 mb-2 bg-transparent">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-rocket"></i>
                                </span>
                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">Free Shipping</h3><!-- End .icon-box-title -->
                                    <p>Orders $50 or more</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-rotate-left"></i>
                                </span>

                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">Free Returns</h3><!-- End .icon-box-title -->
                                    <p>Within 30 days</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-info-circle"></i>
                                </span>

                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">Get 20% Off 1 Item</h3><!-- End .icon-box-title -->
                                    <p>when you sign up</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-life-ring"></i>
                                </span>

                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">We Support</h3><!-- End .icon-box-title -->
                                    <p>24/7 amazing services</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->
                    </div><!-- End .row -->
                </div><!-- End .container -->
            </div><!-- End .icon-boxes-container -->

            <div class="container">
                <div class="cta cta-separator cta-border-image cta-half mb-0" style="background-image: url(assets/images/demos/demo-3/bg-2.jpg);">
                    <div class="cta-border-wrapper bg-white">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="cta-wrapper cta-text text-center">
                                    <h3 class="cta-title">Shop Social</h3><!-- End .cta-title -->
                                    <p class="cta-desc">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. </p><!-- End .cta-desc -->
                            
                                    <div class="social-icons social-icons-colored justify-content-center">
                                        <a href="#" class="social-icon social-facebook" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>
                                        <a href="#" class="social-icon social-twitter" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>
                                        <a href="#" class="social-icon social-instagram" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>
                                        <a href="#" class="social-icon social-youtube" title="Youtube" target="_blank"><i class="icon-youtube"></i></a>
                                        <a href="#" class="social-icon social-pinterest" title="Pinterest" target="_blank"><i class="icon-pinterest"></i></a>
                                    </div><!-- End .soial-icons -->
                                </div><!-- End .cta-wrapper -->
                            </div><!-- End .col-lg-6 -->

                            <div class="col-lg-6">
                                <div class="cta-wrapper text-center">
                                    <h3 class="cta-title">Get the Latest Deals</h3><!-- End .cta-title -->
                                    <p class="cta-desc">and <br>receive <span class="text-primary">$20 coupon</span> for first shopping</p><!-- End .cta-desc -->
                            
                                    <form action="#">
                                        <div class="input-group">
                                            <input type="email" class="form-control" placeholder="Enter your Email Address" aria-label="Email Adress" required>
                                            <div class="input-group-append">
                                                <button class="btn btn-primary btn-rounded" type="submit"><i class="icon-long-arrow-right"></i></button>
                                            </div><!-- .End .input-group-append -->
                                        </div><!-- .End .input-group -->
                                    </form>
                                </div><!-- End .cta-wrapper -->
                            </div><!-- End .col-lg-6 -->
                        </div><!-- End .row -->
                    </div><!-- End .bg-white -->
                </div><!-- End .cta -->
            </div><!-- End .container -->
        </main><!-- End .main -->
    </div><!-- End .page-wrapper -->
    <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>
	<%@include file="WEB-INF/jspf/mobile.jspf" %>
	<%@include file="WEB-INF/jspf/footer.jspf" %>
	
</body>
</html>