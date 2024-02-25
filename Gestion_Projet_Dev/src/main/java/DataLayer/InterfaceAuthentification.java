package DataLayer;

import Models.User;

public interface InterfaceAuthentification {

	public Boolean ValidateAccount(String email, String password);
}
