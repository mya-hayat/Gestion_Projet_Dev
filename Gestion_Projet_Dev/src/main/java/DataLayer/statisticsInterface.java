package DataLayer;

import jakarta.servlet.http.HttpSession;

public interface statisticsInterface {

	public int nombreProjet();
	public int nombreUser();
	public int nombreClient();
	public int nombreChef();
	public int nombreDeveloppeur();
	int nombreProjetChef(int idChefProjet);
	public int nombreNewProjet();
	public int nombreNewProjetChef(int idChefProjet);
	public int nombreDeveloppeurChef();


}
