<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil Developpeur</title>
<link href="css/directeur.css" rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/46a02c0f3f.js" crossorigin="anonymous"></script>
<style type="text/css">

@use postcss-preset-env {
  stage: 0;
}


/* ---------- GENERAL ---------- */


h2 {
  margin: 0;
}

hr {
	background: #5e5e5e;
	border: none;
	height: 1px;
	margin: 0;
	min-height: 1px;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

/* ---------- To-Do-List ---------- */

.to-do-list {
	background: #EEF0F7;
	background-size: 100% 40px;
	border-radius: 5px;
	box-shadow: 0 1px   0 rgba(0,   0,   0,   0.200), 
	0 3px   0 rgba(255, 255, 255, 1.0), 
	0 4px   0 rgba(0,   0,   0,   0.15),
	0 6px   0 rgba(255, 255, 255, 1.0);
	font-size: 14px;
	padding: 40px 32px;
	width: 300px;
}

.to-do-list h2 {
	color: #5e5e5e;
	font-size: 28px;
	font-weight: bold;
}

.to-do-list input[type=checkbox] {
	cursor: pointer;
	position: relative;
	visibility: hidden;
}

.to-do-list input[type="checkbox"]:after {
	border: 1px solid #166B94;
	border-radius: 3px;
	color: #fff;
	content: "";
	display: block;
	height: 16px;
	line-height: 16px;
	position: absolute;
	text-align: center;
	visibility: visible;
	width: 16px;
}

.to-do-list input[type=checkbox]:checked:after {
	border: 1px solid #979797;
	color: #979797;
	content: "✓";
}

.to-do-list input[type=checkbox]:checked + label {
	color: #979797;
	font-weight: normal;
	text-decoration: line-through;
}

.to-do-list label {
	color: #166B94;
	font-weight: bold;
	margin-left: 12px;
}


	#calender{
    position: absolute;
    top: 33%;
    left: 30%;
    transform: translate(-50%,-50%);
    width: 150px;
    height: 220px;
    background-color: cornflowerblue;
    border:#fff;
    border-radius: 5%;
    box-shadow: 0 4px 4px 0 rgba(50,50,50,0.4);
}
#calender>p{
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    padding: 10px 0;
    margin: 0;
    color:#fff;
    text-align: center;
}

#calender-day{
    font-size:16px;
}

#calender-month-year{
    font-size: 14px;
}

#calender-date{
    font-size:64px;
    padding-top:10px;
    padding-bottom: 0;
}
</style>
</head>
<body>
    <div class="wrapper">
	 	<%@ include file="dashboardDeveloper.jspf" %>

		<script type="text/javascript">
		function calender(){
		    var day=['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
		    var month= ["January","February","March","April","May","June","July",
		            "August","September","October","November","December"];
		    var d=new Date();
		    setText('calender-day',day[d.getDay()]);
		    setText('calender-date',d.getDate());
		    setText('calender-month-year',month[d.getMonth()]+' '+(1900+d.getYear()));
		};
		
		function setText(id, val){
		    if(val<10){
		        val='0'+val;
		    }
		    document.getElementById(id).innerHTML=val;  
		};
		
		// call calender()
		
		window.onload=calender;
		</script>
		
		<div id="calender">
		        <p id="calender-day">
		
		        </p>
		
		        <p id="calender-date">
		
		        </p>
		
		        <p id="calender-month-year">
		        
		        </p>
		</div>
		
		<div id="calender" style="margin-left: 350px;">
		
			<h5 style="margin: 10%;font-family: Verdana, Geneva, Tahoma, sans-serif;padding: 10px 0;margin: 0;color:#fff;text-align: center;"> Projets</h5>
		    <p style="margin: 10%;font-family: Verdana, Geneva, Tahoma, sans-serif;padding: 10px 0;margin: 0;color:#fff;text-align: center;font-size:70px;">20</p>
		    <p id="calender-month-year">Réalisés</p>
		   
		</div>
		
		<div id="calender" style="margin-left: 700px;">
		       
		    <h5 style="margin: 10%;font-family: Verdana, Geneva, Tahoma, sans-serif;padding: 10px 0;margin: 0;color:#fff;text-align: center;"> Services</h5>
		    <p style="margin: 10%;font-family: Verdana, Geneva, Tahoma, sans-serif;padding: 10px 0;margin: 0;color:#fff;text-align: center;font-size:70px;">56</p>
		    <p id="calender-month-year">Affectés</p>
		    
		</div>
		
		
		<div class="to-do-list" style="margin-top: 260px;margin-left: 50px;width: 80%">
		  <h2>Taches</h2>
		  <hr>
		  <ul style="margin-top: 20px;">
		  
		  	 <c:forEach var="tache" items="${listeTache}">    
		  		<li>
			      <input id="checkbox4" type="checkbox" >
			      <label for="checkbox4">${tache.getDescTache()}</label>
			    </li>		    
		  	</c:forEach> 
		
		  </ul>
		</div>
    </div>
</body>
</html>