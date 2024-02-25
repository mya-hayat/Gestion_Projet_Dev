package businessLayer;

import java.util.ArrayList;

import Models.ProjectModel;
import Models.Service;
import Models.Tache;
import Models.Technologie;

public class DeveloperManagerMetier implements DeveloperManagerInterface{

	static DeveloperManagerMetier devManager = new DeveloperManagerMetier();
	
	@Override
	public ArrayList<ProjectModel> listProjetDev(int idDeveloper) {
		try {
			
			  return devManager.listProjetDev(idDeveloper);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
		
	}

	@Override
	public ArrayList<Service> recupererServiceDev(int idDeveloper) {
		try {
			
			  return devManager.recupererServiceDev(idDeveloper);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Boolean ajouterTacheDeveloper(String desc, String date, int avanc, int idDeveloper, int idService) {
		try {
			if(devManager.ajouterTacheDeveloper(desc, date, avanc, idDeveloper, idService))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
	}

	@Override
	public ArrayList<Technologie> recupererTechno(int idDeveloper) {
		try {
			
			  return devManager.recupererTechno(idDeveloper);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Boolean ajouterTechnoDev(int idTechno, int idDeveloper) {
		try {
			if(devManager.ajouterTechnoDev(idTechno, idDeveloper))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
	}

	@Override
	public ArrayList<Tache> recupererListeTaches(int idDeveloper) {
		try {
			
			  return devManager.recupererListeTaches(idDeveloper);
			  
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return null;
	}

}
