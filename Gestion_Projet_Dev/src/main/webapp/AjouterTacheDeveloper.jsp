<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Tache</title>
<link href="css/directeur.css" rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/46a02c0f3f.js" crossorigin="anonymous"></script>
<style type="text/css">
	.container .progress {
  margin: 0 auto;
  width: 400px;
}

.progress {
  padding: 4px;
  background: rgba(0, 0, 0, 0);
  border-radius: 6px;
  -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.25), 0 1px rgba(255, 255, 255, 0.08);
  box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.25), 0 1px rgba(255, 255, 255, 0.08);
}

.progress-bar {
  height: 16px;
  border-radius: 4px;
  background-image: -webkit-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.05));
  background-image: -moz-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.05));
  background-image: -o-linear-gradient(top, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.05));
  background-image: linear-gradient(to bottom, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.05));
  -webkit-transition: 0.4s linear;
  -moz-transition: 0.4s linear;
  -o-transition: 0.4s linear;
  transition: 0.4s linear;
  -webkit-transition-property: width, background-color;
  -moz-transition-property: width, background-color;
  -o-transition-property: width, background-color;
  transition-property: width, background-color;
  -webkit-box-shadow: 0 0 1px 1px rgba(0, 0, 0, 0.25), inset 0 1px rgba(255, 255, 255, 0.1);
  box-shadow: 0 0 1px 1px rgba(0, 0, 0, 0.25), inset 0 1px rgba(255, 255, 255, 0.1);
}


#five:checked ~ .progress > .progress-bar {
  width: 5%;
  background-color: #f63a0f;
}

#twentyfive:checked ~ .progress > .progress-bar {
  width: 25%;
  background-color: #B6E2D9;
}

#fifty:checked ~ .progress > .progress-bar {
  width: 50%;
  background-color: #6EDDC7;
}

#seventyfive:checked ~ .progress > .progress-bar {
  width: 75%;
  background-color: #33DBB9;
}

#onehundred:checked ~ .progress > .progress-bar {
  width: 100%;
  background-color: #11D4AD;
}

.radio {
  display: none;
}

.label {
  display: inline-block;
  margin: 0 5px 20px;
  padding: 3px 8px;
  color: #aaa;
  text-shadow: 0 1px black;
  border-radius: 3px;
  cursor: pointer;
}

.radio:checked + .label {
  color: white;
  background: #11D4AD;
}
</style>
</head>
<body>
    <div class="wrapper">
 	<%@ include file="dashboardDeveloper.jspf" %>
 	
 	<div class="container rounded bg-white mt-0 mb-0" style="height: 480px;width: 800px;">
	    <div class="row">
	      
	        <div class="col-md-12 border-right" >
	            <div class="p-3 py-5">
	        	  <form action="DevelopperServelet" method="post">
	          			<input type="hidden" name="action" value="ajouterTacheServ">
	          			<input type="hidden" name="idService" value="${idService}">

		                <div class="row mt-0">
		                    <div class="col-md-12">
		                    	<label class="labels">Description</label>
		                    	<input type="text" class="form-control" name="desc" placeholder="Decrivez la tache a developpee">
		                    </div>
		                </div>
		                 
		                <!-- <div class="row mt-2">
		                    <div class="col-md-12">
		                    	<label class="labels">Avancement</label>
		                    	<input type="email" class="form-control" name="email" value=" ">
		                    </div>
		                 
		                </div> -->
		                										
		                <div class="row mt-1">
		                    <div class="col-md-12">
		                    	<label class="labels">Date</label>
				  				<input id="date" name="date" type="date" placeholder="placeholder" class="form-control input-md">
		                    </div>
		                 </div>
		                 
		                  <label class="labels mt-1">Avancement</label>
		                 
		                  <div class="container row mt-2 ml-5" >
								
							  <input type="radio" class="radio" name="progress" value=5% id="five">
							  <label for="five" class="label" style="margin-left: 100px;">5%</label>
							
							  <input type="radio" class="radio" name="progress" value="25%" id="twentyfive" checked>
							  <label for="twentyfive" class="label">25%</label>
							
							  <input type="radio" class="radio" name="progress" value="50%" id="fifty">
							  <label for="fifty" class="label">50%</label>
							
							  <input type="radio" class="radio" name="progress" value="75%" id="seventyfive">
							  <label for="seventyfive" class="label">75%</label>
							
							  <input type="radio" class="radio" name="progress" value="100%" id="onehundred">
							  <label for="onehundred" class="label">100%</label>
							
							  <div class="progress" style="margin-left: 50px;">
							    <div class="progress-bar"></div>
							  </div>
						</div>
						
		                <div class="mt-3 text-center">
		                	<input class="btn btn-primary profile-button" value="Enregistrer" type="submit">		                	
		                </div>
	                </form>
	            </div>
	        </div>
	        
	    </div>
</div>

</div>
</div>
    </div>
</body>
</html>