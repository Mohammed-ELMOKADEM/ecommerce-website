package BusinessLayer;


import java.util.ArrayList;

import DataBase.DataCommande;
import Models.Commande;

public class GestionCommande implements GestionCommandeInterface {
	DataCommande DC = new DataCommande();

	@Override
	public void ajouterAuPanier(Commande c,Integer idProd) {
		DC.ajouterAuPanier(c,idProd);
	}
	@Override
	public ArrayList<Integer> getCart(Integer id) {
		return DC.getCart(id.toString());
	}
	@Override
	public void updateQte(String id,String idClient) {
		DC.updateQte(id,idClient);
	}
	@Override
	public ArrayList<Integer> topSelling() {
		return DC.topSelling();
	}
	@Override
	public void removeFromCart(String id,String client) {
		// TODO Auto-generated method stub
		DC.removeFromCart(id, client);
		
	}
	@Override
	public void ConfirmerCommande(String id,String add) {
		DC.ConfirmerCommande(id,add);
	}
	@Override
	public ArrayList<Commande> getAllCommandes() {
		return DC.getAllCommandes();
		
	}
	@Override
	public int annuleCommandes(String id) {
		return DC.annuleCommandes(id);
		
	}
	@Override
	public Integer getIdCommande(String id) {
		return DC.getIdCommande(id);
	}
	@Override
	public int livrerCommande(String id) {
		return DC.livrerCommande(id);
	}

}
