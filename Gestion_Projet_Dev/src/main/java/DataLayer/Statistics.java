package DataLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;

public class Statistics implements statisticsInterface{
	private Connexion con ;

	public Statistics() {
		con=new Connexion();
		con.connect();
	}
	@Override
	public int nombreProjet() {
		
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrProjet = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM projet ";
	        st = con.Cnx.prepareStatement(sqlQuery);
	      
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrProjet = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrProjet;
	}
	@Override
	public int nombreUser() {

		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrUser = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM user ";
	        st = con.Cnx.prepareStatement(sqlQuery);
	      
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrUser = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrUser;
	}
	@Override
	public int nombreClient() {
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrClient = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM client ";
	        st = con.Cnx.prepareStatement(sqlQuery);
	      
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrClient = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrClient;
	}
	@Override
	public int nombreChef() {
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrChef = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM user WHERE TypeUser='chef' ";
	        st = con.Cnx.prepareStatement(sqlQuery);
	      
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrChef = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrChef;
	}
	@Override
	public int nombreDeveloppeur() {
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrDev = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM user WHERE TypeUser='developpeur' ";
	        st = con.Cnx.prepareStatement(sqlQuery);
	      
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrDev = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrDev;
	}
	
	@Override
	public int nombreNewProjet() {
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrProjet = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM projet WHERE DATE(DateDebut) = CURRENT_DATE";
	        st = con.Cnx.prepareStatement(sqlQuery);
	      
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrProjet = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrProjet;
	}
	
	
	//nbre de projets pour Chef 
	@Override
	public int nombreProjetChef(int idChefProjet) {
	    PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrProjet = 0;
	    
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM projet WHERE ChefDeProjetID = ?";
	        st = con.Cnx.prepareStatement(sqlQuery);
	        st.setInt(1, idChefProjet);
	        resultSet = st.executeQuery();
	        while (resultSet.next()) {
	            nbrProjet = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return nbrProjet;
	}
	
	//nbre_new_projet_de_chef
	@Override
	public int nombreNewProjetChef(int idChefProjet) {
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrProjet = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM projet WHERE DATE(DateDebut) = CURRENT_DATE and ChefDeProjetID = ?";
	        st = con.Cnx.prepareStatement(sqlQuery);
	        st.setInt(1, idChefProjet);
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrProjet = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return nbrProjet;
	}
	
	//nbr_dev_chef
	
	@Override
	public int nombreDeveloppeurChef() {
	    PreparedStatement st = null;
	    ResultSet resultSet = null;
	    int nbrDev = 0;
	    try {
	        String sqlQuery = "SELECT COUNT(*) AS 'nbr' FROM user WHERE TypeUser='developpeur'";
	        st = con.Cnx.prepareStatement(sqlQuery);
	        
	        resultSet = st.executeQuery();
	      
	        // Traiter les résultats
	        while (resultSet.next()) {
	            nbrDev = resultSet.getInt("nbr");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Assurez-vous de fermer les ressources (PreparedStatement, ResultSet, etc.) dans le bloc finally
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return nbrDev;
	}

	
}
