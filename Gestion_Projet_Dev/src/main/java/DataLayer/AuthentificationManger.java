package DataLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.User;

public class AuthentificationManger implements InterfaceAuthentification{

	// ETABLIR LA CONNEXION
	private Connexion con ;
	
	
	
	public AuthentificationManger() {
		con=new Connexion();
		con.connect();
		
	}

	@Override
	public Boolean ValidateAccount(String email, String password) {
        String query = "SELECT COUNT(*) AS count FROM user WHERE Email = ? AND MotDePasse = ?";
        boolean exists = false;

        try {
            PreparedStatement st = con.Cnx.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, password);

        	ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if(count>0)
                	exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
	}
	

}
