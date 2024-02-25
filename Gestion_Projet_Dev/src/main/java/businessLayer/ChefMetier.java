package businessLayer;

import java.util.ArrayList;

import DataLayer.ChefManager;
import Models.Methodologie;
import Models.ProjectModel;
import Models.Technologie;
import Models.User;

public class ChefMetier implements ChefMetierInterface{
	static ChefManager CM = new ChefManager();
	@Override
	public ArrayList<ProjectModel> RecupererListeProjetChef(int idChef) {
		try {
			
			  return CM.RecupererListeProjetChef(idChef);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}
	@Override
	public ArrayList<Methodologie> RecupererMethodologie() {
		
		try {
			
			  return CM.RecupererMethodologie();
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}
	@Override
	public ArrayList<Technologie> RecupererTechnologie() {
		try {
			
			  return CM.RecupererTechnologie();
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}
	
	public boolean ajouterTechnologiesAuProjet(int idProjet, ArrayList<Integer> idTechnologies) {
		try {
			if(CM.ajouterTechnologiesAuProjet(idProjet, idTechnologies))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
}
	public boolean AjouterMeth(int idProjet, int idMeth) {
		try {
			if(CM.AjouterMeth(idProjet, idMeth))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
}
	@Override
	public ArrayList<User> AfficherListeDev(ArrayList<Integer> idTechnologies) {
		try {
			return CM.AfficherListeDev(idTechnologies);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;	
	}
	@Override
	public boolean ajouterDevEquipe(int idProjet, ArrayList<Integer> idDev) {
		try {
			if(ajouterDevEquipe(idProjet,idDev))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
}
	@Override
	public Boolean AjouterDateReunion(int idProjet, String DateReunion) {
		try {
			if(AjouterDateReunion(idProjet,DateReunion))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
	}
	}