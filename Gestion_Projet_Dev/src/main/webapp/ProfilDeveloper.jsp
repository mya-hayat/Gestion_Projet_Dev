<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
<link href="css/directeur.css" rel="stylesheet" >
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
 	<%@ include file="dashboardDeveloper.jspf" %>
 	
 	<div class="container rounded bg-white mt-0 mb-0" style="height: 620px;width: 800px;">
	    <div class="row">
	      
	        <div class="col-md-12 border-right" >
	            <div class="p-3 py-5">
	        	  <form action="" method="post">
	          			<input type="hidden" name="action" value="editProfil">
		                <div class="row mt-0">
		                    <div class="col-md-6">
			                    <label class="labels">Name</label>
			                    <input type="text" class="form-control" name="nomUser" value="" >
		                    </div>
		                    <div class="col-md-6">
			                    <label class="labels">Prenom</label>
			                    <input type="text" class="form-control" name="prenomUser" value=" ">
		                    </div>
		                </div>
		                <div class="row mt-2">
		                    <div class="col-md-12">
		                    	<label class="labels">Email</label>
		                    	<input type="email" class="form-control" name="email" value=" ">
		                    </div>
		                 
		                </div>
		                <div class="row mt-2">
		                    <div class="col-md-6">
			                    <label class="labels">Password</label>
			                    <input type="password" class="form-control" name="firstPassword"  placeholder="Nouvrau Password" ></div>
		                    <div class="col-md-6">
			                    <label class="labels">Confirm Password</label>
			                    <input type="password" class="form-control" name="comfirmedPassword" placeholder="Confirm Password">
		                    </div>
		                </div> 
		           
		                <div class="mt-3 text-center">
		                	<input class="btn btn-primary profile-button" value="Save Profile" type="submit">		                	
		                </div>
	                </form>
	                <hr>
	                <div class="form-group">
			              <label class="col-md-5 mt-2 control-label" for="selectbasic">Ajouter Competences</label>
			              
			              <form action="DevelopperServelet" method="post" >
			              
				              <div class=" row mt-1 col-md-12">
				                <select id="selectbasic" name="techno" class="form-control col-md-10">
				                  <c:forEach var="techno" items="${listeTechno}">
			       					 <option value="${techno.getIdTechno()}">${techno.getNomTechno()} </option>
			    				  </c:forEach>
				                </select>
				                
				                <div class="col-md-2">
				                	<input type="hidden" name="action" value="ajouterTechno">
				                  	<input type="submit" value="+" class="btn btn-primary profile-button">
				                </div>
				              </div> 	
	                  	   </form> 
			            </div>
	            </div>
	        </div>
	        
	    </div>
</div>
</div>
</div>
    </div>
</body>
</html>