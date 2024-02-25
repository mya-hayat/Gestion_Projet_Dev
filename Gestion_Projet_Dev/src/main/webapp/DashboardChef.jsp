<%@ page import="java.util.*" %>
<%
	session = request.getSession();
	
	// Récupérer le nom d'utilisateur depuis la session
 	String nomUser = (String) session.getAttribute("nomUser");
	String prenomUser = (String) session.getAttribute("prenomUser");
	String email = (String) session.getAttribute("email");
%>

<!-- Sidebar  -->

        <nav id="sidebar" style="">
            <div class="sidebar-header">
              <div class="d-flex flex-column align-items-center text-center p-0 py-0">
              	<img class="rounded-circle mt-2" width="100px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
              	<span class="" style="font-size: 15px">
              		<%=email%> 
              	</span>
              </div>
            </div>

			<ul class="list-unstyled CTAs">
			
				 <li>
                	<form action="ChefServlet" method="post">
	                  <!--	<i class="fa-solid fa-pen-to-square" style="color: #63d97b;"></i> -->
	                  	<input type="hidden" name="action" value="home">
	                    <!--<a href="/Gerer_Projet_Dev/AcceuilServeletController">Home</a>-->
						<i class="fa-solid fa-house"></i>
	                  	<input type="submit" value="Home" class="btn " style="background-color: transparent; color:white ; font-size: 1em !important;text-align: center;">
                  	</form>
                </li>
                
                <li>
                	<form action="ChefServlet" method="post">
	                  <!--	<i class="fa-solid fa-pen-to-square" style="color: #63d97b;"></i> -->
	                  	<input type="hidden" name="action" value="Consulter Projets">
	                    <!--<a href="/Gerer_Projet_Dev/AcceuilServeletController">Consulter Projets</a>-->
	                  	<i class="fa-solid fa-diagram-project"></i>
	                  	<input type="submit" value="Consulter Projets " class="btn " style="background-color: transparent; color:white ; font-size: 1em !important;text-align: center;">
                  	</form>
                </li>
                <li>
                	<form action="ChefServlet" method="post">
	                  <!--	<i class="fa-solid fa-pen-to-square" style="color: #63d97b;"></i> -->
						<i class="fa-solid fa-table-list"></i>
	                  	<input type="hidden" name="action" value="affecter services">
	                    <!--<a href="/Gerer_Projet_Dev/AcceuilServeletController">Affecter services</a>-->
	                  	
	                  	<input type="submit" value="affecter services " class="btn " style="background-color: transparent; color:white ; font-size: 1em !important;text-align: center;">
                  	</form>
                </li>
                <li>
                	<form action="AcceuilServeletController" method="post">
	                  <!--	<i class="fa-solid fa-pen-to-square" style="color: #63d97b;"></i> -->
	                  	<input type="hidden" name="action" value="profilUser">
	                    <!--<a href="/Gerer_Projet_Dev/AcceuilServeletController">Ajouter Projet</a>-->
	                  	<i class="fa-solid fa-address-card"></i>
	                  	<input type="submit" value="Profil User" class="btn " style="background-color: transparent; color:white ; font-size: 1em !important;text-align: center;">
                  	</form>
                </li>
               
            </ul>
            <div class="formgroup">
            	<form action="AcceuilServeletController" method="post" >
	                  <!--	<i class="fa-solid fa-pen-to-square" style="color: #63d97b;"></i> -->
	                  <div style="margin-left: 20px;margin-top: 100px;">
	                  	<input type="hidden" name="action" value="logout">
                    	<i class="fa-solid fa-arrow-right-from-bracket" style="color: #d1232c;"></i>
                  		<input type="submit" id="logoutInput" value="Logout"  class="btn " style="background-color: transparent;color:red ; font-size: 1em !important;text-align: center;">
	                  	
	                  </div>
	             </form>
			</div>
        </nav>

        <!-- Page Content  -->
        <div id="content">
			<!-- Navbar  -->
            <nav class="navbar navbar-expand-lg" >
                <div class="container-fluid" >
              
					<div class="container-fluid">
						<p style="color: black;" ><i>Bienvenue <%= nomUser %> <%= prenomUser %></i></p>
						<!--
	                    <button type="button" id="notification" class="btn btn-success">
	                        <span>Notification</span>
	                    </button>
	                    -->
                	</div>
                </div>
            
            </nav>
          