<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EcoMo - <c:out value="${categorie}"></c:out></title>
<%@include file="jspf/links.jspf" %>
<style>
	.product-image{
		width:277px !important;
		height:277px !important;
	}
</style>
</head>
<body>
	<%@include file="jspf/header.jspf" %>
	
	<div class="page-content">
                <div class="container">
                    <div class="products">
                        <div class="row">
                        <c:if test="${!empty produits}">
                         <c:forEach var="produit" items="${produits}"  varStatus="status">
   
                        	<div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product">
                                    <figure class="product-media">
                                        <a href="Produit?id=${ produit.getId() }">
                                            <img src="images/${ produit.getImageName()}" alt="Product image" class="product-image">
                                        </a>
                                        <div class="product-action action-icon-top">
                                            <a href="Cart?addTocart=${ produit.getId() }" class="btn-product btn-cart"><span>add to cart</span></a>
                                            
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
                        </div><!-- End .row -->
                    </div><!-- End .products -->
                </div><!-- End .container -->
            </div><!-- End .page-content -->
	
	
		<%@include file="jspf/mobile.jspf" %>
       <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>
       <%@include file="jspf/footer.jspf" %>
</body>
</html>