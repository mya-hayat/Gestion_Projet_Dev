package DataLayer;

import java.util.ArrayList;

import Models.ProjectModel;
import Models.Service;
import Models.Tache;
import Models.Technologie;

public interface DeveloperManagerInterface {
	
	public ArrayList<ProjectModel> listProjetDev(int idDeveloper);
	public ArrayList<Service> recupererServiceDev(int idDeveloper);
	public Boolean ajouterTacheDeveloper(String desc, String date, String avanc, int idDeveloper, int idService);
	public ArrayList<Technologie> recupererTechno(int idDeveloper);
	public Boolean ajouterTechnoDev(int idTechno, int idDeveloper);
	public ArrayList<Tache> recupererListeTaches(int idDeveloper);
}
