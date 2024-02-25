package DataLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.ProjectModel;
import Models.Service;
import Models.Tache;
import Models.Technologie;

public class DeveloperManager implements DeveloperManagerInterface{
	
	private Connexion con ;
	
	public DeveloperManager() {
		con=new Connexion();
		con.connect();
	}

	@Override
	public ArrayList<ProjectModel> listProjetDev(int idDeveloper) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ProjectModel> listeProjet = new ArrayList<>();
		try {

		    String sqlQuery = "SELECT * FROM projet WHERE ProjetID IN (SELECT e.ProjetID FROM equipe e WHERE EquipeID IN (SELECT eq.EquipeID FROM equipedevelopement eq WHERE DeveloppeurID = ? ) )";
		    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
		    preparedStatement.setInt(1, idDeveloper);
		    resultSet = preparedStatement.executeQuery();

		    // Traiter les résultats
		    while (resultSet.next()) {
		        int idProjet = resultSet.getInt("ProjetID");
		        String nomProjet = resultSet.getString("NomProjet");
		        String descProjet = resultSet.getString("Description");
		        String dateDebut = resultSet.getString("DateDebut");
		        String dateLivraison = resultSet.getString("DateLivraison");
		        int idChef = resultSet.getInt("ChefDeProjetID");
		        int idClient = resultSet.getInt("ClientID");
		        int nbrJours = resultSet.getInt("joursDeveloppement");
		        
		        ProjectModel projet = new ProjectModel();
		        projet.setProjetId(idProjet);
		        projet.setNomProjet(nomProjet);
		        projet.setDescProjet(descProjet);
		        projet.setDateDebutProjet(dateDebut);
		        projet.setDateLivraisonProjet(dateLivraison);
		        projet.setChefId(idChef);
		        projet.setJoursDeveloppementProjet(nbrJours);
		        projet.setClientId(idClient);
		        
		        listeProjet.add(projet);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listeProjet;
		
	}

	@Override
	public ArrayList<Service> recupererServiceDev(int idDeveloper) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Service> listeService = new ArrayList<>();
		try {

		    String sqlQuery = "SELECT * FROM service WHERE ServiceID IN (SELECT s.ServiceID FROM developpeurservice s WHERE UserID = ? )";
		    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
		    preparedStatement.setInt(1, idDeveloper);
		    resultSet = preparedStatement.executeQuery();

		    // Traiter les résultats
		    while (resultSet.next()) {
		        int idService = resultSet.getInt("ServiceID");
		        String descService = resultSet.getString("Description");
		        int dureeJoursService = resultSet.getInt("DureeJours");
		        int idProjet = resultSet.getInt("ProjetID");

		        
		        Service service = new Service();
		        service.setIdService(idService);
		        service.setDescService(descService);
		        service.setDureeJoursService(dureeJoursService);
		        service.setIdProjet(idProjet);
		        
		        listeService.add(service);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listeService;
	}

	@Override
	public Boolean ajouterTacheDeveloper(String desc, String date, String avanc, int idDeveloper, int idService) {
		
		String query = "INSERT INTO tache (Description,Avancement,Date,DeveloppeurID,ServiceID) VALUES (?,?,?,?,?)";
       boolean inserted = false;

       try {
           PreparedStatement st = con.Cnx.prepareStatement(query);
           st.setString(1, desc);
           st.setString(2, avanc);
           st.setString(3, date);
           st.setInt(4, idDeveloper);
           st.setInt(5, idService);

       	st.executeUpdate();
           inserted = true;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return inserted;
       
	}

	@Override
	public ArrayList<Technologie> recupererTechno(int idDeveloper) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Technologie> listeTechno = new ArrayList<>();
		try {

		    String sqlQuery = "SELECT * FROM technologie WHERE TechnologieID NOT IN (SELECT t.TechnologieID FROM developpeurtechnologie t WHERE UserID = ?);";
		    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
		    preparedStatement.setInt(1, idDeveloper);
		    resultSet = preparedStatement.executeQuery();

		    // Traiter les résultats
		    while (resultSet.next()) {
		        int idTechno = resultSet.getInt("TechnologieID");
		        String nomTechno = resultSet.getString("NomTechnologie");
		      
		         Technologie techno = new Technologie();
		         techno.setIdTechno(idTechno);
		         techno.setNomTechno(nomTechno);
		        
		        listeTechno.add(techno);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listeTechno;
	}

	@Override
	public Boolean ajouterTechnoDev(int idTechno, int idDeveloper) {
		   String query = "INSERT INTO developpeurtechnologie VALUES (?,?)";
	       boolean inserted = false;

	       try {
	           PreparedStatement st = con.Cnx.prepareStatement(query);
	           st.setInt(1, idDeveloper);
	           st.setInt(2, idTechno);

	       	st.executeUpdate();
	           inserted = true;
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	       return inserted;
	}

	@Override
	public ArrayList<Tache> recupererListeTaches(int idDeveloper) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Tache> listeTache = new ArrayList<>();
		try {

		    String sqlQuery = "SELECT * FROM tache WHERE DeveloppeurID = ?";
		    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
		    preparedStatement.setInt(1, idDeveloper);
		    resultSet = preparedStatement.executeQuery();

		    // Traiter les résultats
		    while (resultSet.next()) {
		    
		    	Tache tache = new Tache();
		    	tache.setIdTache(resultSet.getInt("TacheID"));
		    	tache.setDescTache(resultSet.getString("Description"));
		    	tache.setDateTache(resultSet.getString("Date"));
		    	tache.setAvancement(resultSet.getString("Avancement"));
		    	tache.setIdDeveloper(idDeveloper);
		    	tache.setIdService(resultSet.getInt("ServiceID"));
		        listeTache.add(tache);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listeTache;
	}

	

	

}
