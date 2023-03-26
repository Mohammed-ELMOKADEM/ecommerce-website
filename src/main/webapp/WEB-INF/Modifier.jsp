<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier produit</title>

<%@include file="jspf/links.jspf" %>
</head>
<body>
	<main class="main">
        	<div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        		<div class="container">
        			<h1 class="page-title">Admin Panel<span>EcoMo</span></h1>
        			<h3 class="page-title">Page de modification</h3>
        		</div><!-- End .container -->
        	</div><!-- End .page-header -->
        	<c:if test="${!empty produitEdit }">
				<form action="Categories" method="POST" enctype="multipart/form-data" style="padding:10px;">
		        	<input type="hidden" name="action" value="modifier">
		        	<input type="hidden" name="idPro" value="${ produitEdit.getId() }"> 
		        	<div class="form-row">
					    <div class="form-group col-md-6">
					      <label for="nomE">Nom</label>
					      <input type="text" class="form-control" id="nomE" name="nom" placeholder="Nom produit" value="${ produitEdit.getName() }">
					    </div>
					    <div class="form-group col-md-6">
					      <label for="categorieE">Categorie</label>
					      <input type="text" class="form-control" id="categorieE" name="categorie" placeholder="Categorie" value="${ produitEdit.getCategorie() }">
					    </div>
					 </div>
					 <div class="form-row">
					    <div class="form-group col-md-6">
					      <label for="prixE">Prix</label>
					      <input type="text" class="form-control" id="prixE" name="prix" placeholder="Prix de produit" value="${ produitEdit.getPrix() }">
					    </div>
					    <div class="form-group col-md-6">
					      <label for="quantiteE">Quantité</label>
					      <input type="number" class="form-control" id="quantiteE" name="quantite" placeholder="Quantité" value="${ produitEdit.getQuantite() }">
					    </div>
					 </div>
					  <div class="form-group">
					    <label for="inputDescripE">Description</label>
					    <textarea rows="3" class="form-control" id="inputDescripE" name="description" placeholder="Description">${ produitEdit.getDescription() }</textarea>
					  </div>
					  <div class="form-group">
					    <label for="imageE">Image de produit</label>
					    <img src="./images/${ produitEdit.getImageName()}" style="width:100px;height:100px" id="imageE" >
					    <input type="file" class="form-control-file" name="imageEdit" id="imageEdit">
					  </div>
					  <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" onClick="parent.location='Dashboard'">Fermer</button>
				        <button type="submit" class="btn btn-primary">Modifier</button>
				      </div>
		        </form>
		        </c:if>
	</main>
 	<script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/jquery.hoverIntent.min.js"></script>
    <script src="assets/js/jquery.waypoints.min.js"></script>
    <script src="assets/js/superfish.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/bootstrap-input-spinner.js"></script>
    <script src="assets/js/jquery.plugin.min.js"></script>
    <script src="assets/js/jquery.magnific-popup.min.js"></script>
    <script src="assets/js/jquery.countdown.min.js"></script>
    <!-- Main JS File -->
    <script src="assets/js/main.js"></script>
    <script src="assets/js/demos/demo-3.js"></script>
</body>
</html>