package businessLayer;

import DataLayer.AuthentificationManger;
import Models.User;

public class AuthentificationMetier implements InterfaceAuthentificationMetier{

	static AuthentificationManger auth_conn = new AuthentificationManger();

	@Override
	public Boolean ValidateAccount(String email, String password) {
		
		try {
			if(auth_conn.ValidateAccount(email, password))
			  return true;
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return false;	
	}

}
