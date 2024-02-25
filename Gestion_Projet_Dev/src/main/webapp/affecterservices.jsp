<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affecter services</title>
<link href="css/directeur.css" rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/46a02c0f3f.js" crossorigin="anonymous"></script>
<style type="text/css">
:root {
  --theme-color: #ff7f27;
  --theme-color-hover: #fc914a;
  --theme-color2: #000c7b;
}
/* Modal Box  */

.modal-box {
  width: 100%;
  max-width: 500px;
  margin: 100px auto;
}

/* Custom Multi Select */
.sd-multiSelect {
  position: relative;
}
.sd-multiSelect .placeholder {
  opacity: 1;
  background-color: transparent;
  cursor: pointer;
}
.sd-multiSelect .ms-offscreen {
  height: 1px;
  width: 1px;
  opacity: 0;
  overflow: hidden;
  display: none;
}

.sd-multiSelect .sd-CustomSelect {
  width: 100% !important;
}

.sd-multiSelect .ms-choice {
  position: relative;
  text-align: left !important;
  width: 100%;
  border: 1px solid #e3e3e3;
  background: #ffff;
  box-shadow: none;
  font-size: 15px;
  height: 44px;
  font-weight: 500;
  color: #212529;
  line-height: 1.5;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  border-radius: 0.25rem;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.sd-multiSelect .ms-choice:after {
  content: "\f107 ";
  font-family: "FontAwesome";
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 18px;
}

.sd-multiSelect .ms-choice:focus {
  border-color: var(--theme-color);
}

.sd-multiSelect .ms-drop.bottom {
  display: none;
  background: #fff;
  border: 1px solid #e5e5e5;
  padding: 10px;
}

.sd-multiSelect .ms-drop li {
  position: relative;
  margin-bottom: 10px;
}

.sd-multiSelect .ms-drop li input[type="checkbox"] {
  padding: 0;
  height: initial;
  width: initial;
  margin-bottom: 0;
  display: none;
  cursor: pointer;
}

.sd-multiSelect .ms-drop li label {
  cursor: pointer;
  user-select: none;
  -ms-user-select: none;
  -moz-user-select: none;
  -webkit-user-select: none;
}

.sd-multiSelect .ms-drop li label:before {
  content: "";
  -webkit-appearance: none;
  background-color: transparent;
  border: 2px solid var(--theme-color);
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05),
    inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05);
  padding: 8px;
  display: inline-block;
  position: relative;
  vertical-align: middle;
  cursor: pointer;
  margin-right: 5px;
}

.sd-multiSelect .ms-drop li input:checked + span:after {
  content: "";
  display: block;
  position: absolute;
  top: 9px;
  left: 5px;
  width: 10px;
  height: 10px;
  background: var(--theme-color);
  border-width: 0 2px 2px 0;
}
</style>

</head>
<body>
    <div class="wrapper">
        <%@ include file="DashboardChef.jsp" %>

        <div class="container rounded bg-white mt-0 mb-0" style="height: 87%; width: 610px;">
            <div class="col-md-12 row">
                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 column col-sm-offset-0 col-md-offset-2 col-lg-offset-3">
<!--                     <form class="form-horizontal" action="ChefServlet" method="post" style="width: 700px; margin-top: 30px;">
 -->                        <p>Choisir Projet </p>
 					<form action="ChefServlet" method="post">
	                    <div class="modal-box">
	                        <div class="sd-multiSelect form-group">
	                            <label for="selectTechnologies">Les developpeurs du projet sont : </label>
	                            <select  id="selectDev" name="id" class="sd-CustomSelect">
	                                <c:forEach var="projet" items="${ProjetList}">
	                                    <option value="${projet.getProjetId()}">${projet.getNomProjet()}</option>
	                                </c:forEach>
	                            </select>
	                        </div>
	                    </div>
	                        <input type="hidden" name="action" value="chercherDev">
	                        <input type="submit" value="chercherDev" class="btn btn-success">
                    </form> 

                    <p>Ajouter service: </p>
                    <!-- Form Name -->
                    <!-- Text input-->
                    <form action="ChefServlet" method="post">
                    	<input type="hidden" name="action" value="affecterService">
	                    <div class="form-group">
	                        <label class="col-md-6 control-label" for="textinput">Description du service </label>
	                        <div class="col-md-9">
	                            <input id="nomProjet" name="descriptionService" type="text" placeholder="Description" class="form-control input-md">
	                        </div>
	                    </div>
	
	                    <div class="form-group">
	                        <label class="col-md-6 control-label" for="textinput">Durée du Service (en jours)</label>
	                        <div class="col-md-9">
	                            <input id="dureeService" name="dureeService" type="number" placeholder="Nombre de jours" class="form-control input-md" >
	                        </div>
	                    </div>
	
	                    <p>Affecter service aux developpeurs :</p>
	                    <div class="modal-box">
	                        <div class="sd-multiSelect form-group">
	                            <label for="selectTechnologies">Les developpeurs du projet sont : </label>
	                            <select multiple id="selectDev" name="developpeur" class="sd-CustomSelect">
	                                <c:forEach var="develop" items="${listDev}">
	                                    <option value="${develop.getIdUser()}">${develop.getNomUser()} ${develop.getPrenomUser()}</option>
	                                </c:forEach>
	                            </select>
	                        </div>
	                        <input type="submit" value="EnregistrerService" class="btn btn-success">
	                    </div>
                   </form>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://bsite.net/savrajdutta/cdn/multi-select.js"></script>
        <script>
            $(document).ready(function() {
                $(".sd-CustomSelect").multipleSelect({
                    selectAll: false,
                    onOptgroupClick: function(view) {
                        $(view).parents("label").addClass("selected-optgroup");
                    }
                });
            });
        </script>
    </div>
</body>
</html>