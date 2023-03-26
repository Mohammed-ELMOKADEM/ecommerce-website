<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EcoMo - La caisse</title>
<%@include file="jspf/links.jspf" %>
</head>
<body>
	<%@include file="jspf/header.jspf" %>
	<main class="main">
        	<div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        		<div class="container">
        			<h1 class="page-title">La caisse<span>Shop</span></h1>
        		</div><!-- End .container -->
        	</div><!-- End .page-header -->
            <div class="page-content">
            	<div class="checkout">
	                <div class="container">
            			<form action="Checkout" method="POST">
		                	<div class="row">
		                		<div class="col-lg-9">
		                			<h2 class="checkout-title">Détails de la facturation</h2><!-- End .checkout-title -->
	            						<label>Pays </label>
	            						<input type="text" class="form-control">

	            						<label>Address *</label>
	            						<textarea name="adresse" class="form-control" required></textarea>

	            						<div class="row">
		                					<div class="col-sm-6">
		                						<label>Ville *</label>
		                						<input name="ville" type="text" class="form-control" required>
		                					</div><!-- End .col-sm-6 -->
		                				</div><!-- End .row -->

		                				<div class="row">
		                					<div class="col-sm-6">
		                						<label>Code Postal </label>
		                						<input type="text" class="form-control">
		                					</div><!-- End .col-sm-6 -->

		                					<div class="col-sm-6">
		                						<label>Telephone </label>
		                						<input type="tel" class="form-control">
		                					</div><!-- End .col-sm-6 -->
		                				</div><!-- End .row -->
		                		</div><!-- End .col-lg-9 -->
		                		<aside class="col-lg-3">
		                			<div class="summary">
		                				<h3 class="summary-title">Votre Commande</h3><!-- End .summary-title -->
			
		                				<table class="table table-summary">
		                					<thead>
		                						<tr>
		                							<th>Produits</th>
		                							<th>Total</th>
		                						</tr>
		                					</thead>
										<c:if test="${!empty cart }">
		                					<tbody>
		                					<c:forEach var="produit" items="${cart}"  varStatus="status">
		                						<tr>
		                							<td>${ produit.getName() }</td>
		                							<td>$${ produit.getPrix() }</td>
		                						</tr>
		                						<div style="display:none">${ total = total+(produit.getPrix() * produit.getQuantite())}</div>
		                					</c:forEach>
		                				</c:if>
			                				<tr class="summary-total">
	                							<td>SubTotal:</td>
	                							<td>$${ total }</td>
			                				</tr>
			                				<tr>
	                							<td>Expédition:</td>
	                							<td>$10.00</td>
		                					</tr>
			                				<tr class="summary-total">
	                							<td>Total:</td>
	                							<td>$${ total+10.0 }</td>
			                				</tr>
		                					</tbody>
		                				</table><!-- End .table table-summary -->
										
		                				<div class="accordion-summary" id="accordion-payment">
										    <div class="card">
										        <div class="card-header" id="heading-3">
										            <h2 class="card-title">
										                <a>
										                    Cash on delivery
										                </a>
										            </h2>
										        </div><!-- End .card-header -->
										    </div><!-- End .card -->
										</div><!-- End .accordion -->

		                				<button type="submit" class="btn btn-outline-primary-2 btn-order btn-block">
		                					<span class="btn-text">Confirmer La Commande</span>
		                					<span class="btn-hover-text">Confirmer La Commande</span>
		                				</button>
		                			</div><!-- End .summary -->
		                		</aside><!-- End .col-lg-3 -->
		                	</div><!-- End .row -->
            			</form>
	                </div><!-- End .container -->
                </div><!-- End .checkout -->
            </div><!-- End .page-content -->
        </main><!-- End .main -->
        
    <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>
	<%@include file="jspf/mobile.jspf" %>
	<%@include file="jspf/footer.jspf" %>
</body>
</html>