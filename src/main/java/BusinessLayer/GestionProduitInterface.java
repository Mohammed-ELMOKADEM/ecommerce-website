package BusinessLayer;

import Models.Produit;

public interface GestionProduitInterface {
	public int deleteProduit(String id);
	public String getCategory(String id);
	void updateProduit(String id, Produit p);
	
}
