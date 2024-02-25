package Controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DataLayer.Connexion;
import DataLayer.DeveloperManager;
import businessLayer.DeveloperManagerMetier;

/**
 * Servlet implementation class DevelopperServelet
 */
public class DevelopperServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connexion conx = new Connexion();
	DeveloperManagerMetier devManager = new DeveloperManagerMetier();
	DeveloperManager d = new DeveloperManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevelopperServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		req.setAttribute("listeTache", d.recupererListeTaches(3));
//		req.getRequestDispatcher("AcceuilDeveloper.jsp").forward(req, resp);
		//req.getRequestDispatcher("ConsulterProjetDev.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		int idDeveloper = (int) session.getAttribute("idUser");

		if (action.equals("homeDev")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
			   req.getRequestDispatcher("login.jsp").forward(req, resp);
				
	        } else {

	        	req.setAttribute("listeTache", d.recupererListeTaches(idDeveloper));
       		    req.getRequestDispatcher("AcceuilDeveloper.jsp").forward(req, resp);

	        }
		}
		
		if (action.equals("consulterP")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
				   req.getRequestDispatcher("login.jsp").forward(req, resp);

	        } else {
	        	req.setAttribute("listeProjet", d.listProjetDev(idDeveloper));
				req.getRequestDispatcher("ConsulterProjetDev.jsp").forward(req, resp);
	        }
		}
		
		if (action.equals("consulterS")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
				   req.getRequestDispatcher("login.jsp").forward(req, resp);

	        } else {
	        	req.setAttribute("listeService", d.recupererServiceDev(idDeveloper));
				req.getRequestDispatcher("ConsulterServiceDeveloper.jsp").forward(req, resp);
	        }
		}
		
		if (action.equals("profilUser")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {

				   req.getRequestDispatcher("login.jsp").forward(req, resp);

	        } else {
				req.setAttribute("listeTechno", d.recupererTechno(idDeveloper));
			    req.getRequestDispatcher("ProfilDeveloper.jsp").forward(req, resp);	        }
		}
		
		if (action.equals("ajouterTache")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
				   req.getRequestDispatcher("login.jsp").forward(req, resp);
				
	        } else {
	        	int idService = Integer.parseInt(req.getParameter("idService"));
				req.setAttribute("idService", idService);
			    req.getRequestDispatcher("AjouterTacheDeveloper.jsp").forward(req, resp);	        }
		}
		
		if (action.equals("ajouterTechno")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
	            // Rediriger vers la page de connexion s'il n'est pas connecté
				   req.getRequestDispatcher("login.jsp").forward(req, resp);

	        } else {
	        	int idTechno = Integer.parseInt(req.getParameter("techno"));
				if(d.ajouterTechnoDev(idTechno, idDeveloper)) {
				    req.getRequestDispatcher("AcceuilDeveloper.jsp").forward(req, resp);
				}	        }
		}
		
		if (action.equals("ajouterTacheServ")) {
			session = req.getSession(false);
			if (session == null || session.getAttribute("nomUser") == null) {
				   req.getRequestDispatcher("login.jsp").forward(req, resp);
	        } else {
	        	String avanc = req.getParameter("progress");
				String desc = req.getParameter("desc");
				String date = req.getParameter("date");
				int idService = Integer.parseInt(req.getParameter("idService"));
				if(d.ajouterTacheDeveloper(desc, date, avanc, 3,idService )) {
					
	       		    req.getRequestDispatcher("AcceuilDeveloper.jsp").forward(req, resp);					
				}
				else {
	       		    req.getRequestDispatcher("faild.jsp").forward(req, resp);					

				}	        
			}
		}
	}

}
