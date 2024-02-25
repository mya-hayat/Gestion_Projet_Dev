package Controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DataLayer.Connexion;
import DataLayer.DeveloperManager;
import DataLayer.Statistics;
import Models.AuthentificationModel;
import Models.User;
import businessLayer.AuthentificationMetier;
import businessLayer.DeveloperManagerMetier;
import businessLayer.UserMetier;

/**
 * Servlet implementation class AuthentificationServelet
 */
public class AuthentificationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connexion conx = new Connexion();
	AuthentificationModel authModel = new AuthentificationModel();
	AuthentificationMetier authMetier = new AuthentificationMetier();
	UserMetier userMetier= new UserMetier();
	DeveloperManager d = new DeveloperManager();
	
	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

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
			    
			    if(user.getTypeUser().equals("directeur")) {
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
			    	if(user.getTypeUser().equals("developpeur")) {
			    		int idDeveloper = (int) session.getAttribute("idUser");
						req.setAttribute("listeTache", d.recupererListeTaches(idDeveloper));
			    		req.getRequestDispatcher("AcceuilDeveloper.jsp").forward(req, resp);
			    	}else {
			    		if(user.getTypeUser().equals("chef")) {
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
			    			req.getRequestDispatcher("AcceuilChef.jsp").forward(req, resp);
			    		}else {
			    			req.getRequestDispatcher("faild.jsp").forward(req, resp);

			    		}
			    		}
			    	}
				}
			    // Redirection vers la page souhaitée
			    
			} else {
			    // Validation échouée, gérer en conséquence
			    // Par exemple, rediriger vers une page d'erreur ou afficher un message
			    req.getRequestDispatcher("faild.jsp").forward(req, resp);
			}
		}

}
