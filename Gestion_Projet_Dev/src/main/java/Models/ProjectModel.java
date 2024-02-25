package Models;

public class ProjectModel {

	private int projetId;
	private String nomProjet;
	private String descProjet;
	private String dateDebutProjet;
	private String dateLivraisonProjet;
	private int clientId;
	private int chefId;
	private int joursDeveloppementProjet;
	
	public int getChefId() {
		return chefId;
	}
	public void setChefId(int chefId) {
		this.chefId = chefId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getProjetId() {
		return projetId;
	}
	public void setProjetId(int projetId) {
		this.projetId = projetId;
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public String getDescProjet() {
		return descProjet;
	}
	public void setDescProjet(String descProjet) {
		this.descProjet = descProjet;
	}
	public String getDateDebutProjet() {
		return dateDebutProjet;
	}
	public void setDateDebutProjet(String dateDebutProjet) {
		this.dateDebutProjet = dateDebutProjet;
	}
	public String getDateLivraisonProjet() {
		return dateLivraisonProjet;
	}
	public void setDateLivraisonProjet(String dateLivraisonProjet) {
		this.dateLivraisonProjet = dateLivraisonProjet;
	}
	public int getJoursDeveloppementProjet() {
		return joursDeveloppementProjet;
	}
	public void setJoursDeveloppementProjet(int joursDeveloppementProjet) {
		this.joursDeveloppementProjet = joursDeveloppementProjet;
	}
	
	
}
