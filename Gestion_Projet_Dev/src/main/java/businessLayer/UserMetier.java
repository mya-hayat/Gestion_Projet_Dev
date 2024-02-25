package businessLayer;

import DataLayer.UserManager;
import Models.User;

//UserMetier.java
public class UserMetier implements InterfaceUserMetier {
 private UserManager userManager=new UserManager();
 
		 @Override
		 public int getUserByEmail(String email) {
		     return userManager.getUserByEmail(email);
		     
		 }
		
		
		
		@Override
		public User getUser(int idUser) {
			
			User user = new User();
			user = userManager.getUser(idUser);
			return user;
		}



		@Override
		public Boolean modifierProfil(int idUser, String nomUser, String prenmUser, String email, String password) {
			try {
				if(userManager.modifierProfil(idUser, nomUser, prenmUser, email, password))
				  return true;
			} catch (Exception e) {

				e.printStackTrace();
				
			}
			return false;
		}
}
