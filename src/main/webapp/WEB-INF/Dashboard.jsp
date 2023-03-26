<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EcoMo - Admin Panel</title>
<%@include file="jspf/links.jspf" %>
<style>
	.product-image{
		width:190px !important;
		height:190px !important;
	}
	.iconProd{
		border-radius:50%;
		padding:3px;
	}

</style>
</head>
<body>
	<c:if test="${!empty success }">
    	<div class="alert alert-success" role="alert">  		
    			<c:out value="${ success }"></c:out>
    			<button type="button" class="close" onClick="parent.location='Dashboard'" aria-label="Close">
   						<span aria-hidden="true">&times;</span>
 					</button>
    	</div>
    </c:if>
    <c:if test="${!empty errorMessage }">
    	<div class="alert alert-danger" role="alert">  		
    			<c:out value="${ errorMessage }"></c:out>
    			<button type="button" class="close" onClick="parent.location='Dashboard'" aria-label="Close">
   						<span aria-hidden="true">&times;</span>
 					</button>
    	</div>
    </c:if>
	<c:choose>  
		<c:when test='${sessionScope.id == "admin@gmail.com"}'>  
		 	<main class="main">
        	<div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        		<div class="container">
        			<h1 class="page-title">Admin Panel<span>EcoMo</span></h1>
        		</div><!-- End .container -->
        	</div><!-- End .page-header -->
            <div class="page-content" style="margin-top:5px;">
            	<div class="dashboard">
	                <div class="container">
	                	<div class="row">
	                		<aside class="col-md-4 col-lg-3">
	                			<ul class="nav nav-dashboard flex-column mb-3 mb-md-0" role="tablist">
								    <li class="nav-item">
								        <a class="nav-link active" id="tab-dashboard-link" data-toggle="tab" href="#tab-dashboard" role="tab" aria-controls="tab-dashboard" aria-selected="true">Dashboard</a>
								    </li>
								    <li class="nav-item">
								        <a class="nav-link" id="tab-clients-link" data-toggle="tab" href="#tab-clients" role="tab" aria-controls="tab-clients" aria-selected="false">Les Clients</a>
								    </li>
								    <li class="nav-item">
								        <a class="nav-link" id="tab-produits-link" data-toggle="tab" href="#tab-produits" role="tab" aria-controls="tab-produits" aria-selected="false">Les Produits</a>
								    </li>
								    <li class="nav-item">
								        <a class="nav-link" id="tab-commandes-link" data-toggle="tab" href="#tab-commandes" role="tab" aria-controls="tab-commandes" aria-selected="false">Les Commandes</a>
								    </li>
								    <li class="nav-item">
								        <a class="nav-link" href="Home?logout=1">Se déconnecter</a>
								    </li>
								    <li class="nav-item">
								        <a class="nav-link" href="Home">Accueil</a>
								    </li>
								</ul>
	                		</aside><!-- End .col-lg-3 -->

	                		<div class="col-md-8 col-lg-9">
	                			<div class="tab-content">
								    <div class="tab-pane fade show active" id="tab-dashboard" role="tabpanel" aria-labelledby="tab-dashboard-link">
								    	<p>Bonjour <span class="font-weight-normal text-dark">Admin</span>
								    	<br>
								    	D'après l'admin panel vous pouvez <a href="#tab-clients" class="tab-trigger-link link-underline">gérer les clients</a>, <a href="#tab-produits" class="tab-trigger-link">gérer les produits</a>, et <a href="#tab-commandes" class="tab-trigger-link">les commandes</a>.</p>
								    </div><!-- .End .tab-pane -->

								    <div class="tab-pane fade" id="tab-clients" role="tabpanel" aria-labelledby="tab-clients-link">
								    	<p>Clients</p>
								    	<table id="dtBasicExample" class="table table-striped table-bordered text-center table-sm" cellspacing="0" width="100%">
											  <thead>
											    <tr>
											      <th class="th-sm">Nom et prénom
											
											      </th>
											      <th class="th-sm">E-mail
											
											      </th>
											      <th class="th-sm">Adresse
											
											      </th>
											      <th class="th-sm">Téléphone
											
											      </th>
											      <th class="th-sm">
											
											      </th>
											    </tr>
											  </thead>
											  <tbody>
											  	<c:if test="${!empty users }">
											  		 <c:forEach var="user" items="${users}">
											  		 <tr>
													    <td><c:out value="${user.getNom()}"/></td> 
													    <td><c:out value="${user.getEmail()}"/></td> 
													    <td><c:out value="${user.getAdresse()}"/></td> 
													    <td><c:out value="${user.getTelephone()}"/></td>
													    <td><a href="Dashboard?delete=${ user.getId() }">Supprimer</a></td>
												    </tr> 
													</c:forEach>
											  	</c:if>
											  </tbody>
  									    </table>
											  									    
								    </div><!-- .End .tab-pane -->

								    <div class="tab-pane fade" id="tab-produits" role="tabpanel" aria-labelledby="tab-produits-link">
										<div class="d-flex justify-content-between">
											<p>Produits</p>
								    		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ajouterProd">
											  Ajouter un produit
											</button>
										</div>
							    		<div class="row">
							    			<c:if test="${ !empty produits }">
							    				<c:forEach var="produit" items="${produits}"> 
			                                    <div class="col-6 col-md-4 col-xl-3">
			                                        <div class="product">
			                                            <figure class="product-media">
			                                                <a>
			                                                    <img src="./images/${ produit.getImageName() }" alt="Product image" class="product-image">
			                                                </a>
			
			                                                <div class="product-action-vertical">
			                                                	<input type="hidden" name="idProd" value="${ produit.getId()}">
			                                                	<a href="Dashboard?idEdit=${ produit.getId() }" class="btn-product-icon" id="btnEdit" title="Edit"><img class="iconProd" src="./images/icons8-pencil-32.png"/><span>Edit</span></a>
			                                                    <a href="" class="btn-product-icon" id="btnDelete" title="Delete" data-id="${ produit.getId() }" data-toggle="modal" data-target="#Delete"><img class="iconProd" src="./images/icons8-trash-32.png"/><span>Delete</span></a>
			                                                </div><!-- End .product-action-vertical -->
			                                            </figure><!-- End .product-media -->
			
			                                            <div class="product-body">
			                                                <div class="product-cat">
			                                                    <a href="#">${ produit.getCategorie() }</a>
			                                                </div><!-- End .product-cat -->
			                                                <h3 class="product-title"><a href="">${ produit.getName() }</a></h3><!-- End .product-title -->
			                                                <div class="product-price">
			                                                    $${ produit.getPrix() }
			                                                </div><!-- End .product-price -->
			                                                <div class="ratings-container">
			                                                    <div class="ratings">
			                                                        <div class="ratings-val" style="width: 80%;"></div><!-- End .ratings-val -->
			                                                    </div><!-- End .ratings -->
			                                                    <span class="ratings-text">( 12 Reviews )</span>
			                                                </div><!-- End .rating-container -->
			                                            </div><!-- End .product-body -->
			                                        </div><!-- End .product -->
			                                    </div><!-- End .col-sm-6 col-md-4 col-xl-3 -->
			                                    </c:forEach>
                                    		</c:if>
                                    	</div>
							    	</div><!-- .End .tab-pane -->
								    
								     <div class="tab-pane fade" id="tab-commandes" role="tabpanel" aria-labelledby="tab-commandes-link">
								    	<p>Commandes</p>
								    	<table id="dtBasicExample" class="table table-striped table-bordered text-center table-sm" cellspacing="0" width="100%">
											  <thead>
											    <tr>
											      <th class="th-sm">Nom de client
											
											      </th>
											      <th class="th-sm">Numéro de commande
											
											      </th>
											      <th class="th-sm">Adresse
											
											      </th>
											      <th class="th-sm">Total à payer
											
											      </th>
											      <th class="th-sm">Status
											
											      </th>
											      <th class="th-sm">
											
											      </th>
											      <th class="th-sm">
											
											      </th>
											    </tr>
											  </thead>
											  <tbody>
											  <c:forEach items="${ commandes }" var="commande">
											    <tr>
											      <td>${ commande.getIdClient() }</td>
											      <td>${ commande.getIdCommande() }</td>
											      <td>${ commande.getAdresse() }</td>
											      <td>${ commande.getTotal() }</td>
											      <td>
											      <c:choose>
											      	<c:when test="${ commande.getPayée() > 0}">
											      		Payée
											      	</c:when>
											      	<c:when test="${ commande.getAnnulée() > 0}">
											      		Annulée
											      	</c:when>
											      	<c:otherwise>
											      		Non Payée
											      	</c:otherwise>
											      </c:choose></td>
											      	<td>
											      		<c:choose>
											   				<c:when test="${ commande.getAnnulée() == 0}">
											   					<a href="Dashboard?annule=${ commande.getIdCommande() }">Annuler</a>
											   				</c:when>
											   				<c:otherwise>
											   					Déjà annulée
											   				</c:otherwise>
											   			</c:choose>	
											      		
											      	</td>
											   		<td>
											   			<c:choose>
											   				<c:when test="${ commande.getLivrée() == 0}">
											   					<a href="Dashboard?livrer=${ commande.getIdCommande() }">Livrer</a>
											   				</c:when>
											   				<c:otherwise>
											   					Déjà livrée
											   				</c:otherwise>
											   			</c:choose>		
											   		</td>
											    </tr>
											  </c:forEach>
										    </tbody>
									    </table>
								    </div><!-- .End .tab-pane -->

								</div>
	                		</div><!-- End .col-lg-9 -->
	                	</div><!-- End .row -->
	                </div><!-- End .container -->
                </div><!-- End .dashboard -->
            </div><!-- End .page-content -->
        </main><!-- End .main -->
		</c:when>  
		<c:otherwise>
		<jsp:forward page="/Home" >
			<jsp:param value="Seul l'administrateur peut accéder" name="errorMessage"/>
		</jsp:forward>
		</c:otherwise>
	</c:choose>
     
     <!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="Edit" tabindex="-1" role="dialog" aria-labelledby="Edit" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modifier ce produit</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
	        <form action="Categories" method="POST" enctype="multipart/form-data" style="padding:10px;">
	        	<input type="hidden" name="action" value="modifier">
	        	<div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="nomE">Nom</label>
				      <input type="text" class="form-control" id="nomE" name="nom" placeholder="Nom produit" value="">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="categorieE">Categorie</label>
				      <input type="text" class="form-control" id="categorieE" name="categorie" placeholder="Categorie">
				    </div>
				 </div>
				 <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="prixE">Prix</label>
				      <input type="text" class="form-control" id="prixE" name="prix" placeholder="Prix de produit">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="quantiteE">Quantité</label>
				      <input type="number" class="form-control" id="quantiteE" name="quantite" placeholder="Quantité">
				    </div>
				 </div>
				  <div class="form-group">
				    <label for="inputDescripE">Description</label>
				    <textarea rows="3" class="form-control" id="inputDescripE" name="description" placeholder="Description"></textarea>
				  </div>
				  <div class="form-group">
				    <label for="imageE">Image de produit</label>
				    <img src="" style="width:100px;height:100px" id="imageE" >
				    <input type="file" class="form-control-file" name="imageEdit" id="imageEdit">
				  </div>
				  <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
			        <button type="submit" class="btn btn-primary">Modifier</button>
			      </div>
	        </form>
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="Delete" tabindex="-1" role="dialog" aria-labelledby="Delete" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Confirmation</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="Dashboard" method="POST" style="padding:10px;">
        	<input type="hidden" name="idHolder" id="idHolder" value="">
        	Voulez-vous vraiment supprimer ce produit?
        	<div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
		        <button type="submit" class="btn btn-danger" >Confirmer</button>
		      </div>
        </form>
      </div>
      
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="ajouterProd" tabindex="-1" role="dialog" aria-labelledby="ajouterProd" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Ajouter Produit</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="Categories" method="post"  enctype="multipart/form-data" style="padding:10px;">
        	<input type="hidden" name="action" value="produit">
        	<div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="nom">Nom</label>
			      <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom produit">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="categorie">Categorie</label>
			      <input type="text" class="form-control" id="categorie" name="categorie" placeholder="Categorie">
			    </div>
			 </div>
			 <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="prix">Prix</label>
			      <input type="text" class="form-control" id="prix" name="prix" placeholder="Prix de produit">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="quantite">Quantité</label>
			      <input type="number" class="form-control" id="quantite" name="quantite" placeholder="Quantité">
			    </div>
			 </div>
			  <div class="form-group">
			    <label for="inputDescrip">Description</label>
			    <textarea rows="3" class="form-control" id="inputDescrip" name="description" placeholder="Description"></textarea>
			  </div>
			  <div class="form-group">
			    <label for="image">Image de produit</label>
			    <input type="file" class="form-control-file" name="image" id="image">
			  </div>
			  <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
		        <button type="submit" class="btn btn-primary">Ajouter</button>
		      </div>
        </form>
      </div>
      
    </div>
  </div>
</div>
     
    
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
    
    <script>
	        $(document).ready(function () {
	        	  $('#dtBasicExample').DataTable();
	        	  $('.dataTables_length').addClass('bs-select');
	        	});
	        $(document).on("click", "#btnDelete", function () {
	            var id = $(this).data('id');
	            $("#idHolder").val(id);
	       });
	       /* $(document).ready(function(){
	        	  $("#btnEdit").click(function(e){
	        		var idProd = $("input[name='idProd']").val();
	        		$.ajax({
	        	        type: "GET",
	        	        url: "Dashboard?idEdit="+idProd,
	        	        dataType : 'json',
	    				error : function(ts) {
	    					alert(ts.responseText);
	    	            },
	    	            data:{idProd},
	    	            async:false,
	        	        success:function(response){
	        	        	alert(idProd);
	        	        	console.log(response);
	        	        	$("#nomE").val(response.name);
	        	        	$("#categorieE").val(response.categorie);
	        	        	$("#prixE").val(response.prix);
	        	        	$("#quantiteE").val(response.quantite);
	        	        	$("#inputDescripE").val(response.description);
	        	        	$("#imageE").attr("src","./images/"+response.imageName);
	        	        }
	        	    });
	        	  });
	        });*/

    </script>
    
</body>
</html>