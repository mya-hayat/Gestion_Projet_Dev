package Controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import DataLayer.ChefManager;
import DataLayer.Connexion;
import DataLayer.Statistics;
import Models.AuthentificationModel;
import Models.Methodologie;
import Models.ProjectModel;
import Models.Reunion;
import Models.Technologie;
import Models.User;
import businessLayer.AjouterProjetMetier;
import businessLayer.AuthentificationMetier;
import businessLayer.ChefMetier;
import businessLayer.UserMetier;


public class ChefServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connexion conx = new Connexion();
	AuthentificationModel authModel = new AuthentificationModel();
	AuthentificationMetier authMetier = new AuthentificationMetier();
	ProjectModel projectModel = new ProjectModel();
	ChefMetier chefM = new ChefMetier();
	ChefManager chefman=new ChefManager();
	UserMetier userMetier= new UserMetier();
	Reunion reunion=new Reunion();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		authModel.setEmail(email);
		authModel.setPassword(password);
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		
		
	//clique Home
		
		if (action.equals("home")) {
			
	
				session = req.getSession(false);
				if (session == null || session.getAttribute("nomUser") == null) {
		            // Rediriger vers la page de connexion s'il n'est pas connecté
				    req.getRequestDispatcher("login.jsp").forward(req, resp);
		        } else {
		        	
		    		Statistics stat = new Statistics();
		    		int idChef=(int)session.getAttribute("idUser");
				    int nbrProjet = stat.nombreProjetChef(idChef);
				    
				    req.setAttribute("nbrProjet", nbrProjet);
				    req.setAttribute("nbrDevChef", stat.nombreDeveloppeurChef());
				    req.setAttribute("nbrNewProjetChef", stat.nombreNewProjetChef(idChef));
		   		    req.getRequestDispatcher("AcceuilChef.jsp").forward(req, resp);
		      
			}
			}
	
   
	//Bouton consulter Projet
	if (action.equals("Consulter Projets")) {
	
		session = req.getSession(false);
		int idChef=(int)session.getAttribute("idUser");
		
		if (session == null || session.getAttribute("nomUser") == null) {
            // Rediriger vers la page de connexion s'il n'est pas connecté
		    req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
			req.setAttribute("listeProjet",chefM.RecupererListeProjetChef(idChef));
			req.getRequestDispatcher("ConsultPrjChef.jsp").forward(req, resp);
        }
     }
	
	//Bouton Ajouter Technologie
	if (action.equals("ajouterTech")) {
		session = req.getSession(false);
		if (session == null || session.getAttribute("nomUser") == null) {
			   req.getRequestDispatcher("login.jsp").forward(req, resp);
			
        } else {
        	int idProjet = Integer.parseInt(req.getParameter("idProjet"));
			req.setAttribute("idProjet", idProjet);
        	ArrayList<Methodologie> methList = chefM.RecupererMethodologie();
        	ArrayList<Technologie> techList = chefM.RecupererTechnologie();
        	System.out.println("Nombre de méthodologies récupérées : " + techList.size());
        	
			req.setAttribute("MethList", methList);
			req.setAttribute("TechList",techList);
	    req.getRequestDispatcher("AjouterTechChef.jsp").forward(req, resp);	        }
	}
	
	//Bouton Enregistrer methodologi _technologie au projet
	if (action.equals("Enregistrer")){
		session = req.getSession(false);
		if (session == null || session.getAttribute("nomUser") == null) {
			   req.getRequestDispatcher("login.jsp").forward(req, resp);
			
        } else {
            int idProjet = Integer.parseInt(req.getParameter("idProjet"));
            req.setAttribute("idProjet", idProjet);
            int idMeth = Integer.parseInt(req.getParameter("meth"));
            
            
            System.out.println(idProjet);
           
			
			
			  String[] technologiesArray = req.getParameterValues("technologies");
		        ArrayList<Integer> idTechnologies = new ArrayList<>();

		        if (technologiesArray != null) {
		            for (String techId : technologiesArray) {
		                idTechnologies.add(Integer.parseInt(techId));
		            }
		        }
		        boolean enregistrementReussi = chefM.ajouterTechnologiesAuProjet(idProjet, idTechnologies);
		        boolean mettreAjour = chefM.AjouterMeth(idProjet, idMeth);
		        ArrayList<User> listDev = chefM.AfficherListeDev(idTechnologies);
		        System.out.println("Nombre de developpeurs récupérées : " +listDev.size());
		       session.setAttribute("idProjet", idProjet);
		       req.setAttribute("listDev", listDev);
		        
		       req.getRequestDispatcher("affichageListeDev.jsp").forward(req, resp);
		        
		        
        }
	}
	
	String dateReunion = req.getParameter("dateReunion");
	reunion.setDate(dateReunion);
	//Bouton Enregistrer developpeurs
	if (action.equals("EnregistrerDev")) {
		session = req.getSession(false);
		if (session == null || session.getAttribute("nomUser") == null) {
			   req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		 } else {
			 int idProjet = Integer.parseInt(req.getParameter("idProjet"));
		     
		     String[] DevArray = req.getParameterValues("develop");
		     ArrayList<Integer> idDev = new ArrayList<>();
		     System.out.println(DevArray.length);
		     if (DevArray != null) {
		    	 for (String DevID : DevArray) {
		    		 idDev.add(Integer.parseInt(DevID));
		            }
		     }
           // boolean reussi = chefman.ajouterTechnologiesAuProjet(idProjet, idDev);
		     if(chefman.AjouterDateReunion(idProjet,dateReunion) && chefman.ajouterDevEquipe(idProjet, idDev))
           
                 req.getRequestDispatcher("AcceuilChef.jsp").forward(req, resp);
            else
            	req.getRequestDispatcher("faild.jsp").forward(req, resp);
		 }
		
		
	}
	//Bouton Affecter services
	
	if (action.equals("affecter services")) {
		session = req.getSession(false);
		
		if (session == null || session.getAttribute("nomUser") == null) {
	        req.getRequestDispatcher("login.jsp").forward(req, resp);
	    } else {
	    	int idChef=(int)session.getAttribute("idUser");
	       req.setAttribute("ProjetList",chefman.RecupererListeProjetChef(idChef));
	        req.getRequestDispatcher("affecterservices.jsp").forward(req, resp);
	    }
	}
	
	if (action.equals("chercherDev")) {
		
		session = req.getSession(false);
		
		if (session == null || session.getAttribute("nomUser") == null) {
	        req.getRequestDispatcher("login.jsp").forward(req, resp);
	       
		}else {
			 int idProjet = Integer.parseInt(req.getParameter("id"));
			 int idChef=(int)session.getAttribute("idUser");
		     req.setAttribute("ProjetList",chefman.RecupererListeProjetChef(idChef));
			 req.setAttribute("listDev",chefman.RecupererListeDev(idProjet));
			 req.getRequestDispatcher("affecterservices.jsp").forward(req, resp);
			
		}
	}
	
	if(action.equals("affecterService")) {
session = req.getSession(false);
		
		if (session == null || session.getAttribute("nomUser") == null) {
	        req.getRequestDispatcher("login.jsp").forward(req, resp);
	       
		}else {
			String desc = req.getParameter("descriptionService");
			int durre=Integer.parseInt(req.getParameter("dureeService"));
			
			
		}
		
	}
	}
}