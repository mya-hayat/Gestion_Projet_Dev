<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulter Projets</title>
<script src="https://kit.fontawesome.com/46a02c0f3f.js" crossorigin="anonymous"></script>
<link href="css/directeur.css" rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">


</head>
<body>
    <div class="wrapper">
        <%@ include file="DashboardChef.jsp" %>
        
            <!-- Tableau des projets  -->
            
            <!--  <h2>Tableau des projets </h2>  -->
			<table class="table table-light" id="myTable">
			  <thead >
                 <tr>
                  <th style="background-color: #fafafa;">ID </th>
                  <th style="background-color: #fafafa;">Nom Projet</th>
                  <th style="background-color: #fafafa">Description</th>                  
                  <th style="background-color: #fafafa">Duree de developpement</th>
                  <th style="background-color: #fafafa">Date Debut</th>
                  <th style="background-color: #fafafa">Date Livraison</th>
                   <th style="background-color: #fafafa">Tech/Meth</th>
                  <th style="background-color: #fafafa"></th>           
                  <th style="background-color: #fafafa"></th>                       
               </tr>
              </thead>                                                                
              <tbody>
              	
              	<c:forEach var="projet" items="${listeProjet}">    		    
              	 <tr>
                  <td>${projet.getProjetId()}</td>
                  <td>${projet.getNomProjet()}</td>
                  <td>${projet.getDescProjet()}</td>
                  <td>${projet.getJoursDeveloppementProjet()}</td>
                  <td>${projet.getDateDebutProjet()}</td>
                  <td>${projet.getDateLivraisonProjet()}</td>
                  <td>
	                  	<form action="ChefServlet" method="post">
		                   	<input type="hidden" name="action" value="ajouterTech">
		                  	<input type="hidden" id="idProjet" name="idProjet" value="${projet.getProjetId()}" class="form-control"> 
		                  	<input type="submit" value="+" class="btn btn-success">
	                  	</form>
                  </td>
      			 </tr>
      			 </c:forEach>
         	  </tbody>
            </table> 
        </div>
</body>
</html>