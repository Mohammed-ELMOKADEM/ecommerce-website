<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EcoMo - Cart</title>
<%@include file="jspf/links.jspf" %>
</head>
<body>
	<%@include file="jspf/header.jspf" %>
	<c:choose>  
		<c:when test="${sessionScope.id != null}"> 
			<main class="main">
        	<div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        		<div class="container">
        			<h1 class="page-title">Shopping Cart<span>Shop</span></h1>
        		</div><!-- End .container -->
        	</div><!-- End .page-header -->

            <div class="page-content">
            	<div class="cart">
	                <div class="container">
	                	<div class="row">
	                		<div class="col-lg-9">
										<c:if test="${!empty cart }">
											<table class="table table-cart table-mobile">
												<thead>
													<tr>
														<th>Produit</th>
														<th>Prix</th>
														<th>Quantité</th>
														<th>Total</th>
														<th></th>
													</tr>
												</thead>
				
												<tbody>
													<c:forEach var="produit" items="${cart}"  varStatus="status">
														<tr>
															<td class="product-col">
																<div class="product">
																	<figure class="product-media">
																		<a href="#">
																			<img src="images/${ produit.getImageName()}" alt="Product image">
																		</a>
																	</figure>
				
																	<h3 class="product-title">
																		<a href="#">${ produit.getName() }</a>
																	</h3><!-- End .product-title -->
																</div><!-- End .product -->
															</td>
															<td class="price-col">$${produit.getPrix()}</td>
															<td class="quantity-col">
				                                                <div class="cart-product-quantity">
				                                                    <input type="number" class="form-control" value="${ produit.getQuantite() }" min="1" max="10" step="1" data-decimals="0" required>
				                                                </div><!-- End .cart-product-quantity -->
				                                            </td>
															<td class="total-col">$${ produit.getPrix() * produit.getQuantite() }</td>
															<td class="remove-col"><button class="btn-remove" onClick="parent.location='Cart?delCart=${ produit.getId()}'"><i class="icon-close"></i></button></td>
														</tr>
														${ total = total+(produit.getPrix() * produit.getQuantite())}
													</c:forEach>
												</tbody>
											</table><!-- End .table table-wishlist -->
										</c:if>
										<c:if test="${empty cart }">
											<h1>
												Aucun produit acheté, veuillez effectuer vos achats !!
											</h1>
										</c:if>
	                		</div><!-- End .col-lg-9 -->
	                		<c:if test="${!empty cart }">
	                		<aside class="col-lg-3">
	                			<div class="summary summary-cart">
	                				<h3 class="summary-title">Total</h3><!-- End .summary-title -->

	                				<table class="table table-summary">
	                					<tbody>
	                						<tr class="summary-subtotal">
	                							<td>Total:</td>
	                							<td>$${total }</td>
	                						</tr><!-- End .summary-subtotal -->
	                						<tr class="summary-shipping">
	                							<td>Expédition:</td>
	                							<td>&nbsp;</td>
	                						</tr>

	                						<tr class="summary-shipping-row">
	                							<td>
													<div class="custom-control">
														<label>Expédition</label>
													</div><!-- End .custom-control -->
	                							</td>
	                							<td>$10.00</td>
	                						</tr><!-- End .summary-shipping-row -->
	                						<tr class="summary-total">
	                							<td>Total:</td>
	                							<td>$${ total+10.00 }</td>
	                						</tr><!-- End .summary-total -->
	                					</tbody>
	                				</table><!-- End .table table-summary -->

	                				<a href="Checkout?id=${ sessionScope.id }" class="btn btn-outline-primary-2 btn-order btn-block">Passer à la caisse</a>
	                			</div><!-- End .summary -->
	                		</aside><!-- End .col-lg-3 -->
	                		</c:if>
	                	</div><!-- End .row -->
	                </div><!-- End .container -->
                </div><!-- End .cart -->
            </div><!-- End .page-content -->
        </main><!-- End .main -->
        </c:when>
        <c:otherwise>
        	<jsp:forward page="/Home" >
				<jsp:param name="errorMessage" value="Vous devez être connectez à votre compte !"/>
        	</jsp:forward>
        </c:otherwise>
        </c:choose>

 	<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>
	<%@include file="jspf/mobile.jspf" %>
	<%@include file="jspf/footer.jspf" %>
</body>
</html>