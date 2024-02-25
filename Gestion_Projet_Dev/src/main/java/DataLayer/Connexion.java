package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	Connection Cnx;
	String url,pilote;
	public Connexion() {
		try {

			pilote=new String("com.mysql.cj.jdbc.Driver");
			Class c=Class.forName(pilote);
			url = new String("jdbc:mysql://127.0.0.1:3306/gerer_projet_dev");
			} 
		catch( ClassNotFoundException e) {
				System.err.println("Erreur lors du chargement du pilote : " + e.getMessage()); 
			}
		
		}
	public void connect(){
		try {
			Cnx = DriverManager.getConnection(url,"root","");
			System.out.println("ok");
	
		} catch (SQLException e) {
			System.err.println("connexion n'est pas etablie");
		} 
	}
	
		public void disconnect() {
			
			try {
				Cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
		}

// La fonction d'authentification pour les trois Users (Directeur, ChefProjet, Developpeur)
//    public ResultSet authenticationUser(String email, String motDePasse, String role) {
//    	
//		ResultSet res = null;
//		String req = "SELECT * FROM user WHERE Email = ? AND MotDepasse = ? AND Role = ?";
//		try {
//	        PreparedStatement st = Cnx.prepareStatement(req);
//	        st.setString(1, email);  
//	        st.setString(2, motDePasse); 
//	        st.setString(3, role); 
//	        res = st.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		      return res;
//    }
//
//// La fonction existence pour les trois Users (Directeur, ChefProjet, Developpeur)
//    //	 public ResultSet UserExiste(String login, String userType) {
    //		ResultSet res = null;
		// String req = "SELECT * FROM " + userType + " WHERE login = " + login;
    //	String req = "SELECT * FROM " + userType + " WHERE login = ?";
    //	try {
			// Statement st=myCnx.createStatement();
			// res=st.executeQuery(req);
    //      PreparedStatement st = myCnx.prepareStatement(req);
    //     st.setString(1, login);
    //      res = st.executeQuery();
    //	} catch (SQLException e) {
    //		e.printStackTrace();
    //	}
    //	      return res;
    // }


}