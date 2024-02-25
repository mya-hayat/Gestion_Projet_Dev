package businessLayer;

import java.util.ArrayList;


import Models.Methodologie;
import Models.ProjectModel;
import Models.Technologie;
import Models.User;

public interface ChefMetierInterface {

	public ArrayList<ProjectModel> RecupererListeProjetChef(int idChef);
	public ArrayList<Methodologie> RecupererMethodologie();
	public ArrayList<Technologie> RecupererTechnologie();
	public boolean AjouterMeth(int idProjet, int idMeth);
	public boolean ajouterTechnologiesAuProjet(int idProjet, ArrayList<Integer> idTechnologies);
	
	public ArrayList<User> AfficherListeDev(ArrayList<Integer> idTechnologies);
	public boolean ajouterDevEquipe(int idProjet, ArrayList<Integer> idDev);
	
	public Boolean AjouterDateReunion(int idProjet,String DateReunion);
}
