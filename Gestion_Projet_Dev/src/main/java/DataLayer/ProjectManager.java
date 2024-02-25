package DataLayer;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Client;
import Models.ProjectModel;
import Models.User;

public class ProjectManager implements ProjectManagerInterface {
	
	// ETABLIR LA CONNEXION
		private Connexion con ;
	
		public ProjectManager() {
			con=new Connexion();
			con.connect();
		}

		@Override
		public Boolean AjouterProjet(String nomProjet, String descProjet,int clientId, String dateDebutProjet,String dateLivraisonProjet, int chefId) {
			
			 LocalDate date1 = LocalDate.parse(dateDebutProjet);
		     LocalDate date2 = LocalDate.parse(dateLivraisonProjet);
		     
		     long differenceInDays = ChronoUnit.DAYS.between(date1, date2);
		     int joursDeveloppement = (int) differenceInDays;
			
			String query = "INSERT INTO projet (NomProjet,Description,ClientID,DateDebut,DateLivraison,JoursDeveloppement,ChefDeProjetID) VALUES (?,?,?,?,?,?,?)";
	        boolean inserted = false;

	        try {
	            PreparedStatement st = con.Cnx.prepareStatement(query);
	            st.setString(1, nomProjet);
	            st.setString(2, descProjet);
	            st.setInt(3, clientId);
	            st.setString(4, dateDebutProjet);
	            st.setString(5, dateLivraisonProjet);
	            st.setInt(6, joursDeveloppement);
	            st.setInt(7, chefId);

	        	st.executeUpdate();
	            inserted = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return inserted;
			
		}
		
		public ArrayList<Client> RecupererClient(){
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ArrayList<Client> clientList = new ArrayList<>();
			try {

			    String sqlQuery = "SELECT ClientID, Nom, Prenom FROM Client";
			    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
			    resultSet = preparedStatement.executeQuery();

			    // Traiter les résultats
			    while (resultSet.next()) {
			        int idClient = resultSet.getInt("ClientID");
			        String nomClient = resultSet.getString("Nom");
			        String prenomClient = resultSet.getString("Prenom");

			        
			        Client client = new Client();
			        client.setIdClient(idClient);
			        client.setNomClient(nomClient);
			        client.setPrenomClient(prenomClient);
			        clientList.add(client);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			return clientList;
		}
		
		@Override
		public ArrayList<User> RecupererChef() {
			
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ArrayList<User> chefList = new ArrayList<>();
			try {

			    String sqlQuery = "SELECT * FROM user WHERE TypeUser = 'chef' ";
			    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
			    resultSet = preparedStatement.executeQuery();

			    // Traiter les résultats
			    while (resultSet.next()) {
			        int idChef = resultSet.getInt("UserID");
			        String nomChef = resultSet.getString("Nom");
			        String prenomChef = resultSet.getString("Prenom");
			        String emailChef = resultSet.getNString("Email");
			        String passwordChef = resultSet.getNString("MotDePasse");
			        
			        User chef = new User();
			        chef.setIdUser(idChef);
			        chef.setNomUser(nomChef);
			        chef.setPrenomUser(prenomChef);
			        chef.setEmailUser(emailChef);
			        chef.setPasswordUser(passwordChef);
			        chefList.add(chef);
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			return chefList;
		}

		@Override
		public ArrayList<ProjectModel> RecupererListeProjet() {
			
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ArrayList<ProjectModel> listeProjet = new ArrayList<>();
			try {

			    String sqlQuery = "SELECT * FROM projet";
			    preparedStatement = con.Cnx.prepareStatement(sqlQuery);
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
		public Boolean ModifierProjet(String nomProjet, String descProjet, int clientId, String dateDebutProjet, String dateLivraisonProjet, int chefId, int idProjet) {
		    LocalDate date1 = LocalDate.parse(dateDebutProjet);
		    LocalDate date2 = LocalDate.parse(dateLivraisonProjet);
		    long differenceInDays = ChronoUnit.DAYS.between(date1, date2);
		    int joursDeveloppement = (int) differenceInDays;

		    String query = "UPDATE projet SET NomProjet = ?, Description = ?, ClientID =? , DateDebut = ?, DateLivraison = ?, JoursDeveloppement = ?, ChefDeProjetID = ? WHERE ProjetID = ?";
		    boolean updated = false;

		    try (PreparedStatement st = con.Cnx.prepareStatement(query)) {
		        st.setString(1, nomProjet);
		        st.setString(2, descProjet);
		        st.setInt(3, clientId);
		        st.setString(4, dateDebutProjet);
		        st.setString(5, dateLivraisonProjet);
		        st.setInt(6, joursDeveloppement);
		        st.setInt(7, chefId);
		        st.setInt(8, idProjet);
		        st.executeUpdate();
		        updated = true;
		    } catch (SQLException e) {
		        // Gérez l'erreur de manière appropriée, par exemple, en enregistrant dans les journaux.
		        e.printStackTrace();
		    }
		    return updated;
		}

		@Override
		public ProjectModel ChercherProjet(int idProjet) {
		    PreparedStatement st = null;
		    ResultSet resultSet = null;
		    ProjectModel projet = new ProjectModel();

		    try {
		        String sqlQuery = "SELECT * FROM projet WHERE ProjetID = ?";
		        st = con.Cnx.prepareStatement(sqlQuery);
		        
		        // Définir la valeur du paramètre avant d'exécuter la requête
		        st.setInt(1, idProjet);
		        resultSet = st.executeQuery();
		        
		        // Traiter les résultats
		        while (resultSet.next()) {
		            int projetId = resultSet.getInt("ProjetID");
		            String nomProjet = resultSet.getString("NomProjet");
		            String descProjet = resultSet.getString("Description");
		            String dateDebut = resultSet.getString("DateDebut");
		            String dateLivraison = resultSet.getString("DateLivraison");
		            int idChef = resultSet.getInt("ChefDeProjetID");
		            int idClient = resultSet.getInt("ClientID");
		            int nbrJours = resultSet.getInt("joursDeveloppement");
		            
		            projet.setProjetId(projetId);
		            projet.setNomProjet(nomProjet);
		            projet.setDescProjet(descProjet);
		            projet.setDateDebutProjet(dateDebut);
		            projet.setDateLivraisonProjet(dateLivraison);
		            projet.setChefId(idChef);
		            projet.setJoursDeveloppementProjet(nbrJours);
		            projet.setClientId(idClient);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        // Assurez-vous de fermer les ressources (ResultSet, PreparedStatement, etc.) dans le bloc finally
		        try {
		            if (resultSet != null) resultSet.close();
		            if (st != null) st.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return projet;
		}

		@Override
		public Boolean supprimerProjet(int idProjet) {
			String query = "DELETE FROM projet WHERE ProjetID = ?";
		    boolean deleted = false;

		    try (PreparedStatement st = con.Cnx.prepareStatement(query)) {
		        st.setInt(1, idProjet);
		        st.executeUpdate();
		        deleted = true;
		    } catch (SQLException e) {
		        // Gérez l'erreur de manière appropriée, par exemple, en enregistrant dans les journaux.
		        e.printStackTrace();
		    }

		    return deleted;
		}

		
		
		
		

}
