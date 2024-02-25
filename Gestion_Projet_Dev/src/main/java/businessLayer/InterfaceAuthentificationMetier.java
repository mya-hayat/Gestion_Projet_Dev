package businessLayer;

import Models.User;

public interface InterfaceAuthentificationMetier {

	public Boolean ValidateAccount(String userName, String password);
}
