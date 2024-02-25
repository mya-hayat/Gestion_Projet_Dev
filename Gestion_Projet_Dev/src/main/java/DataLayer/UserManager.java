package DataLayer;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.User;

public class UserManager implements UserManagerInterface {
	private Connexion con ;
	
	public UserManager() {
		con=new Connexion();
		con.connect();
	}
	public int getUserByEmail(String email) {
		
       User user= new User();

            // Préparez la requête SQL pour récupérer l'utilisateur par ID
            String sql = "SELECT UserID FROM user WHERE email = ?";
            try (PreparedStatement statement = con.Cnx.prepareStatement(sql)) {
                statement.setString(1, email);

                // Exécutez la requête
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Construisez un objet User à partir des résultats de la requête
                       
                        user.setIdUser(resultSet.getInt("UserID"));
                      
                        // Ajoutez d'autres champs si nécessaire

                        return user.getIdUser();
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace(); // Gérer les erreurs SQL ici
            }
            return 0;
        }
	@Override
	public User getUser(int idUser) {
		
		PreparedStatement st = null;
	    ResultSet resultSet = null;
	    User user = new User();

	    try {
	        String sqlQuery = "SELECT * FROM user WHERE UserID = ?";
	        st = con.Cnx.prepareStatement(sqlQuery);
	        
	        // Définir la valeur du paramètre avant d'exécuter la requête
	        st.setInt(1, idUser);
	        resultSet = st.executeQuery();
	        
	        // Traiter les résultats
	        while (resultSet.next()) {
	            String nomUser = resultSet.getString("Nom");
	            String prenomUser = resultSet.getString("Prenom");
	            String email = resultSet.getString("Email");
	            String password = resultSet.getString("MotDePasse");
	            String typeUser = resultSet.getString("TypeUser");

	            user.setIdUser(idUser);
	            user.setNomUser(nomUser);
	            user.setPrenomUser(prenomUser);
	            user.setEmailUser(email);
	            user.setPasswordUser(password);
	            user.setTypeUser(typeUser);
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

	    return user;
	}
	public Boolean modifierProfil(int idUser, String nomUser, String prenomUser, String email, String password) {
	    String query = "UPDATE user SET Nom = ?, Prenom = ?, Email = ?, MotDePasse = ? WHERE UserID = ?";
	    boolean updated = false;

	    try (PreparedStatement st = con.Cnx.prepareStatement(query)) {
	        st.setString(1, nomUser);
	        st.setString(2, prenomUser);
	        st.setString(3, email);
	        st.setString(4, password);
	        st.setInt(5, idUser);  // Correction de l'index pour l'identifiant de l'utilisateur
	        st.executeUpdate();
	        updated = true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return updated;
	}

	

     
	
	

}
