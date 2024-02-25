<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Projet</title>
<link href="css/directeur.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/46a02c0f3f.js" crossorigin="anonymous"></script>

</head>
<body>
    <div class="wrapper">
        <%@ include file="dashboard.jspf" %>
		  <div class="container rounded bg-white mt-0 mb-0">
	      <div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-8 col-lg-6  column col-sm-offset-0 col-md-offset-2 col-lg-offset-3" style="margin-left: 100px;width: 100%">
	          <form class="form-horizontal" action="AcceuilServeletController" method="post" style="width: 700px">
	          	<input type="hidden" name="action" value="ModifierProjet">
	          	<input id="idProjet" name="idProjet" value="${idProjet}" type="hidden">
	          
	            <fieldset>
	
	            <!-- Form Name -->
	            <legend>Modifier Projet</legend>    
	            <!-- Text input-->
	            <div class="form-group">
	              <label class="col-md-6 control-label" for="textinput">Nom Projet</label>  
	              <div class="col-md-9">
	                <input id="nomProjet" name="nomProjet" type="text" value="${projet.getNomProjet()}" class="form-control input-md">
	              </div>
				</div>
				  <!-- Textarea -->
				<div class="form-group">
				  <label class="col-md-3 control-label" for="textarea">Description</label>
				  <div class="col-md-9">                     
				    <textarea class="form-control" id="descProjet" name="descProjet" placeholder ="">${projet.getDescProjet()}</textarea>
				  </div>
				</div>
				<label class="col-md-4	 control-label" for="textinput">Date Debut : </label>
				<label class="col-md-4 control-label" for="textinput">Date Livraison: </label>  
				<div class="form-group row mt-1">
					<div class="col-md-4">
					    <input id="dateDebutProjet" name="dateDebutProjet" type="date" class="form-control input-md"
					           value="<c:out value="${projet.dateDebutProjet}" />">
					</div>
				 
				              
					<div class="col-md-4">
					    <input id="dateLivraisonProjet" name="dateLivraisonProjet" type="date" class="form-control input-md"
					           value="<c:out value="${projet.dateLivraisonProjet}" />">
					</div>
				</div>
				
	               	            
	            <!-- Select Basic -->
	            <div class="form-group">
				    <label class="col-md-3 control-label" for="selectbasic">Choisir Le Client</label>
				    <div class="col-md-9">
				        <select id="selectbasic" name="client" class="form-control">
				            <c:forEach var="client" items="${clientList}">
				                <option value="${client.getIdClient()}"
				                        ${client.getIdClient() == projet.getClientId() ? 'selected' : ''}>
				                    ${client.getNomClient()} ${client.getPrenomClient()}
				                </option>
				            </c:forEach>
				        </select>
				    </div>
				</div>

	            
	            <div class="form-group">
				    <label class="col-md-3 control-label" for="selectbasic">Affecter Le Chef</label>
				    <div class="col-md-9">
				        <select id="selectbasic" name="chefProjet" class="form-control">
				            <c:forEach var="chef" items="${chefList}">
				                <option value="${chef.getIdUser()}"
				                        ${chef.getIdUser() == projet.getChefId() ? 'selected' : ''}>
				                    ${chef.getNomUser()} ${chef.getPrenomUser()}
				                </option>
				            </c:forEach>
				        </select>
				    </div>
				</div>
	            
	            
	            <!-- Select Basic 
	            <div class="form-group">
	              <label class="col-md-3 control-label" for="selectbasic">Affecter Le Chef</label>
	              <div class="col-md-9">
	                <select id="selectbasic" name="chefProjet" class="form-control">
	                  <c:forEach var="chef" items="${chefList}">
       					 <option value="${chef.getIdUser()}">${chef.getNomUser()} ${chef.getPrenomUser()} </option>
    				  </c:forEach>
	                </select>
	              </div>
	            </div>
				 -->
				<!-- Button (Double) -->
				<div class="form-group">
				  <label class="col-md-3 control-label" for="button1id"></label>
				  <div class="col-md-8">
				  	<input type="submit" value="Enregistrer" class="btn btn-success">
				  </div>
				</div>
				
				</fieldset>
				</form>
				</div>
					
				</div>
			</div>
      </div>
</body>
</html>