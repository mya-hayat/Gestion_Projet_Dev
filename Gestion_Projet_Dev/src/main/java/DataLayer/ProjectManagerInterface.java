package DataLayer;

import java.util.ArrayList;

import Models.Client;
import Models.ProjectModel;
import Models.User;

public interface ProjectManagerInterface {

	public Boolean AjouterProjet(String nomProjet, String descProjet,int clientId, String dateDebutProjet, String dateLivraisonProjet, int chefId);
	public ArrayList<Client> RecupererClient();
	public ArrayList<User> RecupererChef();
	public ArrayList<ProjectModel> RecupererListeProjet();    
	public Boolean ModifierProjet(String nomProjet, String descProjet,int clientId, String dateDebutProjet, String dateLivraisonProjet, int chefId, int idProjet);
	public ProjectModel ChercherProjet(int idProjet);
	public Boolean supprimerProjet(int idProjet);
}
