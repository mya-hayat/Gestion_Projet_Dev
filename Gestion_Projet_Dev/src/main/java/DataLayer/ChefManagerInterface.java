package DataLayer;

import java.util.ArrayList;

import Models.Methodologie;
import Models.ProjectModel;
import Models.Technologie;
import Models.User;

public interface ChefManagerInterface {
	
	public ArrayList<ProjectModel> RecupererListeProjetChef(int idChefProjet); 
	public ArrayList<Methodologie> RecupererMethodologie();
	public ArrayList<Technologie> RecupererTechnologie();

	public boolean ajouterTechnologiesAuProjet(int idProjet, ArrayList<Integer> idTechnologies);

	public Boolean AjouterMeth(int idProjet, int idMeth);
	public ArrayList<User> AfficherListeDev(ArrayList<Integer> idTechnologies);
	public boolean ajouterDevEquipe(int idProjet, ArrayList<Integer> idDev);
	public Boolean AjouterDateReunion(int idProjet, String DateReunion);

}
