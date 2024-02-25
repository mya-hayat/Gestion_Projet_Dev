package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Client;
import Models.Methodologie;
import Models.ProjectModel;
import Models.Technologie;
import Models.User;

public class ChefManager implements ChefManagerInterface {
	// ETABLIR LA CONNEXION
			private Connexion con ;
		
			public ChefManager() {
				con=new Connexion();
				con.connect();
			}
	@Override
	public ArrayList<ProjectModel> RecupererListeProjetChef(int idChefProjet) {

			
			PreparedStatement st = null;
			ResultSet resultSet = null;
			ArrayList<ProjectModel> listeProjet = new ArrayList<>();
			try {

			    String sqlQuery = "SELECT * FROM projet where ChefDeProjetID = ?";
			    st= con.Cnx.prepareStatement(sqlQuery);
			    st.setInt(1, idChefProjet);
			    resultSet = st.executeQuery();

			    // Traiter les résultats
			    while (resultSet.next()) {
			        int idProjet = resultSet.getInt("ProjetID");
			        String nomProjet = resultSet.getString("NomProjet");
			        String descProjet = resultSet.getString("Description");
			        String dateDebut = resultSet.getString("DateDebut");
			        String dateLivraison = resultSet.getString("DateLivraison");
			        int nbrJours = resultSet.getInt("joursDeveloppement");
			        
			        ProjectModel projet = new ProjectModel();
			        projet.setProjetId(idProjet);
			        projet.setNomProjet(nomProjet);
			        projet.setDescProjet(descProjet);
			        projet.setDateDebutProjet(dateDebut);
			        projet.setDateLivraisonProjet(dateLivraison);
			        projet.setJoursDeveloppementProjet(nbrJours);
			        listeProjet.add(projet);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			return listeProjet;
		
	}
	
	//liste Methdologies
	@Override
	public ArrayList<Methodologie> RecupererMethodologie() {
		
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ArrayList<Methodologie> MethList = new ArrayList<>();
			try {

			    String sqlQuery = "SELECT MethodologieID,NomMethodologie FROM methodologie";
			    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
			    resultSet = preparedStatement.executeQuery();

			    // Traiter les résultats
			    while (resultSet.next()) {
			        int idMth = resultSet.getInt("MethodologieID");
			        String nomMth= resultSet.getString("NomMethodologie");
			        

			        
			        Methodologie mth = new Methodologie();
			        mth.setMethodologieID(idMth);
			        mth.setNomMethodologie(nomMth);
			        MethList.add(mth);
			       
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			return MethList;
		}
	
	
	//recuperer methodologies
	@Override
	public ArrayList<Technologie> RecupererTechnologie() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Technologie> TechList = new ArrayList<>();
		try {

		    String sqlQuery = "SELECT TechnologieID,NomTechnologie FROM technologie";
		    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
		    resultSet = preparedStatement.executeQuery();

		    // Traiter les résultats
		    while (resultSet.next()) {
		        int idTech = resultSet.getInt("TechnologieID");
		        String nomTech= resultSet.getString("NomTechnologie");
		        

		        
		        Technologie tech = new Technologie();
		        tech.setIdTechno(idTech);
		        tech.setNomTechno(nomTech);;
		        TechList.add(tech);
		       
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return TechList;
	}
	@Override
	 public boolean ajouterTechnologiesAuProjet(int idProjet, ArrayList<Integer> idTechnologies) {
          
            String query = "INSERT INTO ProjetTechnologie (ProjetID, TechnologieID) VALUES (?, ?)";
            boolean inserted = false;
            try {
            	
            	PreparedStatement st = con.Cnx.prepareStatement(query);

            // Définissez les paramètres pour chaque technologie
            for (int idTechno : idTechnologies) {
                st.setInt(1, idProjet);
                st.setInt(2, idTechno);
                st.addBatch();}
            int[] result = st.executeBatch();

            // Vérifiez si toutes les requêtes ont été exécutées avec succès
            for (int i : result) {
                if (i <= 0) {
                    inserted = false;
                    break;
                }
            }

            inserted = true;
        } catch (SQLException e) {
            e.printStackTrace();
            inserted = false;
        }
        
        return inserted;
    }
	//Ajouter methodologie
	@Override
	public Boolean AjouterMeth(int idProjet,int idMeth) {
		  String query = "UPDATE projet SET MethodologieID = ? WHERE ProjetID = ?";
          boolean updated = false;
          try {
          	
          	PreparedStatement st = con.Cnx.prepareStatement(query);
            st.setInt(1, idMeth);
	        st.setInt(2, idProjet);
	        st.executeUpdate();
	        updated = true;
      }  catch (SQLException e) {
	       
	        e.printStackTrace();
	    }
	    return updated;
	}
	
	
	//liste developpeurs 
	@Override
	public ArrayList<User> AfficherListeDev(ArrayList<Integer> idTechnologies) {
		
		ArrayList<User> devList = new ArrayList<>();
		String query = "SELECT DISTINCT U.UserID, U.Nom, U.Prenom " +
	               "FROM User U " +
	               "JOIN DeveloppeurTechnologie DT ON U.UserID = DT.UserID " +
	               "WHERE U.TypeUser = 'developpeur' " +
	               "AND DT.TechnologieID IN (";

	// Ajouter les ID de technologies à la requête
	for (int i = 0; i < idTechnologies.size(); i++) {
	    query += idTechnologies.get(i);
	    if (i < idTechnologies.size() - 1) {
	        query += ", ";
	    }
	}

	query += ")";

	try {
	    PreparedStatement preparedStatement = con.Cnx.prepareStatement(query);

	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
	        int userID = resultSet.getInt("UserID");
	        String nom = resultSet.getString("Nom");
	        String prenom = resultSet.getString("Prenom");

	        User dev = new User();
	        dev.setIdUser(userID);
	        dev.setNomUser(nom);
	        dev.setPrenomUser(prenom);

	        devList.add(dev);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return devList;

	}
	public boolean ajouterDevEquipe(int idProjet,ArrayList<Integer> idDev) {
	    String query1 = "INSERT INTO equipe (ProjetID) VALUES (?)";
	    String query2 = "INSERT INTO equipedevelopement (DeveloppeurID, EquipeID) VALUES (?,?)";
	    String query3 = "SELECT EquipeID FROM equipe WHERE ProjetID=?";
	    int equipeID = 0; // Initialisez equipeID à une valeur par défaut
	    boolean inserted = false;

	    try {
	        PreparedStatement st = con.Cnx.prepareStatement(query1);
	        st.setInt(1,idProjet);
	        st.executeUpdate();

	        st = con.Cnx.prepareStatement(query3);
	        st.setInt(1, idProjet);
	        ResultSet resultSet2 = st.executeQuery();

// Assurez-vous que la boucle while est exécutée au moins une fois
	        while (resultSet2.next()) {
	            equipeID = resultSet2.getInt("EquipeID");
	        }
	            st = con.Cnx.prepareStatement(query2);
	            for (int iddev : idDev) {
	                st.setInt(2, equipeID);
	                st.setInt(1, iddev);
	                st.addBatch();
	            }
	            int[] result = st.executeBatch();

	            for (int i : result) {
	                if (i <= 0) {
	                    inserted = false;
	                    break;
	                }
	            }

	            inserted = true;
	      
	        inserted = true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        inserted = false;
	    }

	    return inserted;
	}
	//ajouter date de reunion
	@Override
	public Boolean AjouterDateReunion(int idProjet,String DateReunion) {
		  String query = "INSERT INTO reunion (Date,ProjetID) VALUES (?,?)";
          boolean updated = false;
          try {
          	
          	PreparedStatement st = con.Cnx.prepareStatement(query);
          	st.setString(1, DateReunion);
          	st.setInt(2, idProjet);
	        
	        st.executeUpdate();
	        updated = true;
      }  catch (SQLException e) {
	       
	        e.printStackTrace();
	    }
	    return updated;
	}
	public ArrayList<User> RecupererListeDev(int idProjet) {
		
		PreparedStatement st = null;
		ResultSet resultSet = null;
	    String sqlQuery = "SELECT * FROM user u WHERE u.UserID IN ( SELECT DeveloppeurID FROM equipedevelopement e WHERE e.EquipeID IN (SELECT eq.EquipeID FROM equipe eq WHERE ProjetID = ?) )";
		ArrayList<User> DevList = new ArrayList<>();
		try {

		   st = con.Cnx.prepareStatement(sqlQuery);
		    st.setInt(1, idProjet);
		    resultSet = st.executeQuery();
		    // Traiter les résultats
		    while (resultSet.next()) {
		        int idDev = resultSet.getInt("UserID");
		        String nomDev= resultSet.getString("Nom");
		        

		        
		        User dev = new User();
		        dev.setIdUser(idDev);
		        dev.setNomUser(nomDev);;
		        DevList.add(dev);
		       
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return DevList;
	}
	
	
}