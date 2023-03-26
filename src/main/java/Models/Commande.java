package Models;

public class Commande {
	private int idCommande;
	private String idClient;
	private int annulée;
	private int payée;
	private String adresse;
	private float total;
	private int livrée;
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	public int getAnnulée() {
		return annulée;
	}
	public void setAnnulée(int annulée) {
		this.annulée = annulée;
	}
	public int getPayée() {
		return payée;
	}
	public void setPayée(int payée) {
		this.payée = payée;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getLivrée() {
		return livrée;
	}
	public void setLivrée(int livrée) {
		this.livrée = livrée;
	}
	
	
}
