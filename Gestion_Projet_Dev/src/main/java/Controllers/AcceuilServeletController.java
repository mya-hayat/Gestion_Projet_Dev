package Controllers;

import java.io.IOException;


import DataLayer.Connexion;
import DataLayer.Statistics;
import Models.AuthentificationModel;
import Models.ProjectModel;
import Models.User;
import businessLayer.AjouterProjetMetier;
import businessLayer.AuthentificationMetier;
import businessLayer.UserMetier;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class AcceuilServeletController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	Connexion conx = new Connexion();
	AuthentificationModel authModel = new AuthentificationModel();
	AuthentificationMetier authMetier = new AuthentificationMetier();
	ProjectModel projectModel = new ProjectModel();
	AjouterProjetMetier ajouProjetMetier = new AjouterProjetMetier();
	UserMetier userMetier= new UserMetier();

	@Override
	public void init() throws ServletException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setAttribute("clientList", ajouProjetMetier.RecupererClient());
		//req.setAttribute("chefList", ajouProjetMetier.RecupererChef());
		//req.getRequestDispatcher("AjouterProjet.jsp").forward(req, resp);
		//req.setAttribute("listeProjet", ajouProjetMetier.RecupererListeProjet());
		//req.getRequestDispatcher("ConsulterProjet.jsp").forward(req, resp);
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		authModel.setEmail(email);
		authModel.setPassword(password);
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		
		//Authentification

		if (action.equals("Login")) {
			
			if (authMetier.ValidateAccount(email, password)) {
			    // Validation réussie
			    
			    // Récupérer l'ID de l'utilisateur
			    int idUser = userMetier.getUserByEmail(email);
			    User user = new User();
			    user = userMetier.getUser(idUser);
			    // Créer une session et définir l'attribut
			    session = req.getSession();
			    session.setAttribute("idUser", idUser);
			    session.setAttribute("nomUser", user.getNomUser());
			    session.setAttribute("prenomUser", user.getPrenomUser());
			    session.setAttribute("email", user.getEmailUser());
			    session.setAttribute("password", user.getPasswordUser());
			    session.setAttribute("typeUser", user.getTypeUser());
			    
			    // Redirection vers la page souhaitée
			    Statistics stat = new Statistics();
			    int nbrProjet = stat.nombreProjet();
			    req.setAttribute("nbrProjet", nbrProjet);
			    req.setAttribute("nbrUser", stat.nombreUser());
			    req.setAttribute("nbrClient", stat.nombreClient());
			    req.setAttribute("nbrUser", stat.nombreUser());
			    req.setAttribute("nbrChef", stat.nombreChef());
			    req.setAttribute("nbrDev", stat.nombreDeveloppeur());
			    req.setAttribute("nbrNewProjet", stat.nombreNewProjet());
			    req.getRequestDispatcher("AcceuilDirecteur.jsp").forward(req, resp);
			} else {
			    // Validation échouée, gérer en conséquence
			    // Par exemple, rediriger vers une page d'erreur ou afficher un message
			    req.getRequestDispatcher("fail.jsp").forward(req, resp);
			}
		}
		
		if(action.equals("editProfil")) {
			
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
	        	String nomUser = req.getParameter("nomUser");
	        	String prenomUser = req.getParameter("prenomUser");
	        	String emailUser = req.getParameter("email");
	        	int idUser = (int) session.getAttribute("idUser");
	        	//String newPassword = req.getParameter("firstPassword");
	        	String confPassword = req.getParameter("comfirmedPassword");
	        	
	        	if(userMetier.modifierProfil(idUser, prenomUser, nomUser, emailUser, confPassword)) {
	        		Statistics stat = new Statistics();
				    int nbrProjet = stat.nombreProjet();
				    req.setAttribute("nbrProjet", nbrProjet);
				    req.setAttribute("nbrUser", stat.nombreUser());
				    req.setAttribute("nbrClient", stat.nombreClient());
				    req.setAttribute("nbrUser", stat.nombreUser());
				    req.setAttribute("nbrChef", stat.nombreChef());
				    req.setAttribute("nbrDev", stat.nombreDeveloppeur());
				    req.setAttribute("nbrNewProjet", stat.nombreNewProjet());
	       		    req.getRequestDispatcher("AcceuilDirecteur.jsp").forward(req, resp);
	       		}else {
	       		  req.getRequestDispatcher("faild.jsp").forward(req, resp);
	       		  
	       		  }
	        	
	        }

		}
		// Logout 
		
		if(action.equals("logout")) {
			if (action.equals("logout")) {
				session = req.getSession(false);

			    // Si la session existe, l'invalider
			    if (session != null) {
			        session.invalidate();
			    }

			    // Rediriger vers la page de connexion
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
		
		
		
		// ajouter Projet + consulter redirect
		
		if (action.equals("ajouterP")) {
		    session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				req.setAttribute("clientList", ajouProjetMetier.RecupererClient());
				req.setAttribute("chefList", ajouProjetMetier.RecupererChef());
				req.getRequestDispatcher("AjouterProjet.jsp").forward(req, resp);
	        }
		}
		if (action.equals("consulterP")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				req.setAttribute("listeProjet", ajouProjetMetier.RecupererListeProjet());
				req.getRequestDispatcher("ConsulterProjet.jsp").forward(req, resp);
	        }
		}
		
		if (action.equals("home")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
        		Statistics stat = new Statistics();
			    int nbrProjet = stat.nombreProjet();
			    req.setAttribute("nbrProjet", nbrProjet);
			    req.setAttribute("nbrUser", stat.nombreUser());
			    req.setAttribute("nbrClient", stat.nombreClient());
			    req.setAttribute("nbrUser", stat.nombreUser());
			    req.setAttribute("nbrChef", stat.nombreChef());
			    req.setAttribute("nbrDev", stat.nombreDeveloppeur());
			    req.setAttribute("nbrNewProjet", stat.nombreNewProjet());
       		    req.getRequestDispatcher("AcceuilDirecteur.jsp").forward(req, resp);
	        }
		}
		
		if (action.equals("profilUser")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				req.getRequestDispatcher("Profil.jsp").forward(req, resp);
	        }
		}
		
		
		if (action.equals("modifier")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				int idProjet = Integer.parseInt(req.getParameter("idProjet"));
				req.setAttribute("chefList", ajouProjetMetier.RecupererChef());
				req.setAttribute("clientList", ajouProjetMetier.RecupererClient());
				req.setAttribute("projet", ajouProjetMetier.ChercherProjet(idProjet));
				req.setAttribute("idProjet", idProjet);
				req.getRequestDispatcher("ModifierProjet.jsp").forward(req, resp);
	        }
		}
		
		if (action.equals("supprimer")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				int idProj = Integer.parseInt(req.getParameter("idProjet"));
				if(ajouProjetMetier.supprimerProjet(idProj)) {
					req.setAttribute("listeProjet", ajouProjetMetier.RecupererListeProjet());
					req.getRequestDispatcher("ConsulterProjet.jsp").forward(req, resp);
				}
				else
					req.getRequestDispatcher("faild.jsp").forward(req, resp);
	        }
			
		}
				
		 // Ajouter Projet
		
		String nomProjet = req.getParameter("nomProjet");
		String descProjet = req.getParameter("descProjet");
		String dateLivraisonProjet = req.getParameter("dateLivraisonProjet");
		String dateDebutProjet = req.getParameter("dateDebutProjet");
		int clientId =Integer.parseInt(req.getParameter("client"));
		int chefId =Integer.parseInt(req.getParameter("chefProjet"));
		
		projectModel.setNomProjet(nomProjet);
		projectModel.setDescProjet(descProjet);
		projectModel.setDateLivraisonProjet(dateLivraisonProjet);
		projectModel.setDateDebutProjet(dateDebutProjet);
		projectModel.setClientId(clientId);
		projectModel.setClientId(chefId);
		
		if (action.equals("AjouterProjet")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				if(ajouProjetMetier.AjouterProjet(nomProjet, descProjet,clientId, dateDebutProjet, dateLivraisonProjet,chefId)) {
					req.setAttribute("listeProjet", ajouProjetMetier.RecupererListeProjet());
					req.getRequestDispatcher("ConsulterProjet.jsp").forward(req, resp);
				}
				else
					req.getRequestDispatcher("faild.jsp").forward(req, resp);
	        }
			
		}
		
		// Modifier Projet
		
		if (action.equals("ModifierProjet")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
				String nom = req.getParameter("nomProjet");
				String desc= req.getParameter("descProjet");
				String dateD = req.getParameter("dateDebutProjet");
				String dateL = req.getParameter("dateLivraisonProjet");
				int idCli = Integer.parseInt(req.getParameter("client"));
				int idChef = Integer.parseInt(req.getParameter("chefProjet"));
				int idProj = Integer.parseInt(req.getParameter("idProjet"));
				
				projectModel.setNomProjet(nom);
				projectModel.setDescProjet(desc);
				projectModel.setDateLivraisonProjet(dateL);
				projectModel.setDateDebutProjet(dateD);
				projectModel.setClientId(idCli);
				projectModel.setClientId(idChef);
				
				if(ajouProjetMetier.ModifierProjet(nom, desc, idCli, dateD, dateL, idChef, idProj)) {
					req.setAttribute("listeProjet", ajouProjetMetier.RecupererListeProjet());
					req.getRequestDispatcher("ConsulterProjet.jsp").forward(req, resp);
	       		    }else {
					req.getRequestDispatcher("faild.jsp").forward(req, resp);
	
				}
	        }
		}
		
		
		// Modifier Profil 
		
		/*
		 * if (action.equals("ModifierProfil")) { session = req.getSession(false); if
		 * (session == null || session.getAttribute("nomUser") == null) { // Rediriger
		 * vers la page de connexion s'il n'est pas connecté
		 * req.getRequestDispatcher("login.jsp").forward(req, resp); } else { User user
		 * = new User(); String nomUser = req.getParameter("nomUser"); String
		 * prenomUser= req.getParameter("prenomUser"); String emailUser =
		 * req.getParameter("email"); String firstPass =
		 * req.getParameter("firstPassword"); String confPass =
		 * req.getParameter("comfirmedPassword"); int idUser = 1;
		 * user.setNomUser(nomUser); user.setPrenomUser(prenomUser);
		 * user.setEmailUser(emailUser); user.setPasswordUser(confPass);
		 * user.setIdUser(idUser);
		 * 
		 * if(userMetier.modifierProfil(idUser, prenomUser, nomUser, email, confPass)) {
		 * req.getRequestDispatcher("AcceuilDirecteur.jsp").forward(req, resp); }else {
		 * req.getRequestDispatcher("faild.jsp").forward(req, resp);
		 * 
		 * } } }
		 */
		
	}
	
	
}
