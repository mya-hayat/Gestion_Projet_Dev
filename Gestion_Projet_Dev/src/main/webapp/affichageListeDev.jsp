<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste developpeurs</title>
<script src="https://kit.fontawesome.com/46a02c0f3f.js" crossorigin="anonymous"></script>
<link href="css/directeur.css" rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
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
        
        <div class="container rounded bg-white mt-0 mb-0" style="height: 480px;width: 800px;">
	    <div class="row">
	      
	        <div class="col-md-12 border-right" >
	            <div class="p-3 py-5">
	            <form action="ChefServlet" method="post">
	            
	          			<input type="hidden" name="idProjet" value="${idProjet}">
	          			
	          			   	
   <div class="modal-box">
	
	  	             <p>Projet ${idProjet}</p>
    <div class="sd-multiSelect form-group">
        <label for="selectTechnologies">Les developpeurs qui maitrisent les technologies choisies sont : </label>
        <select multiple id="selectDev" name="develop" class="sd-CustomSelect">
            <c:forEach var="develop" items="${listDev}">
                <option value="${develop.getIdUser()}">${develop.getNomUser()} ${develop.getPrenomUser()}</option>
            </c:forEach>
        </select>
    </div>


<label class="col-md-4	 control-label" for="textinput">Date Réunion : : </label>
 <div class="col-md-4">
				  	<input id="dateDebutProjet" name="dateReunion" type="date" placeholder="placeholder" class="form-control input-md">
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
        
		                <div class="mt-3 text-center">
		                    
		               <input type="hidden" name="action" value="EnregistrerDev">
                       <input class="btn btn-primary profile-button" value="Enregistrer" type="submit">
		                		                	
		                </div>
	                </form>
	            </div>
	        </div>
	        	</div>	
	    </div>
</div>
        
        </body>
</html>