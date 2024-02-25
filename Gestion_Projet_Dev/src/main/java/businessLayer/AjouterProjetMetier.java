package businessLayer;

import java.util.ArrayList;

import DataLayer.ProjectManager;
import Models.Client;
import Models.ProjectModel;
import Models.User;

public class AjouterProjetMetier implements AjouterProjetInterfaceMetier{

	static ProjectManager ajoutProjet = new ProjectManager();

	@Override
	public Boolean AjouterProjet(String nomProjet, String descProjet,int clientId, String dateDebutProjet, String dateLivraisonProjet, int chefId) {

		try {
			if(ajoutProjet.AjouterProjet(nomProjet, descProjet, clientId, dateDebutProjet, dateLivraisonProjet,chefId))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
	}

	@Override
	public ArrayList<Client> RecupererClient() {
		
		try {
			
			  return ajoutProjet.RecupererClient();
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<User> RecupererChef() {
		
		try {
			
			  return ajoutProjet.RecupererChef();
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public ArrayList<ProjectModel> RecupererListeProjet() {
		try {
			
			  return ajoutProjet.RecupererListeProjet();
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Boolean ModifierProjet(String nomProjet, String descProjet, int clientId, String dateDebutProjet,String dateLivraisonProjet, int chefId, int idProjet) {
		try {
			if(ajoutProjet.ModifierProjet(nomProjet, descProjet, clientId, dateDebutProjet, dateLivraisonProjet,chefId,idProjet))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public ProjectModel ChercherProjet(int idProjet) {

		try {
			
			  return ajoutProjet.ChercherProjet(idProjet);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Boolean supprimerProjet(int idProjet) {
		try {
			if(ajoutProjet.supprimerProjet(idProjet))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;
	}
	
	

}
