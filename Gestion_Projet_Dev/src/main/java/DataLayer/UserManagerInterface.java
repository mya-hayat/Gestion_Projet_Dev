package DataLayer;

import Models.User;

public interface UserManagerInterface {
	public int getUserByEmail(String email);
	public User getUser(int idUser);
	public Boolean modifierProfil(int idUser,String nomUser, String prenmUser, String email, String password);
}
