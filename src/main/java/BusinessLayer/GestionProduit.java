package BusinessLayer;

import DataBase.DataProduit;
import Models.Produit;

public class GestionProduit implements GestionProduitInterface {

	DataProduit DP=new DataProduit();
	@Override
	public int deleteProduit(String id) {
		return DP.deleteProduit(id);
	}

	@Override
	public String getCategory(String id) {
		return DP.getProduitCategory(id);
	}

	@Override
	public void updateProduit(String id, Produit p) {
		DP.updateProduit(id, p);
	}

	
	

}
