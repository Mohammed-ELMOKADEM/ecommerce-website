package BusinessLayer;

import java.util.ArrayList;

import Models.Commande;

public interface GestionCommandeInterface {
	public ArrayList<Integer> topSelling();
	void removeFromCart(String id, String client);
	ArrayList<Commande> getAllCommandes();
	int annuleCommandes(String id);
	void ajouterAuPanier(Commande c, Integer idProd);
	ArrayList<Integer> getCart(Integer id);
	void updateQte(String id, String idClient);
	void ConfirmerCommande(String id, String add);
	Integer getIdCommande(String id);
	int livrerCommande(String id);
}
