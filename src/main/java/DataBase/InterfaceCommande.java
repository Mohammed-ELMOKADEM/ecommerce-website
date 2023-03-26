package DataBase;

import java.util.ArrayList;

import Models.Commande;

public interface InterfaceCommande {
	public ArrayList<Integer> topSelling();
	void removeFromCart(String id, String client);
	ArrayList<Commande> getAllCommandes();
	int annuleCommandes(String id);
	Integer getCommandeId(int id);
	void ajouterAuPanier(Commande c, Integer idProd);
	ArrayList<Integer> getCart(String id);
	void updateQte(String id, String idClient);
	void ConfirmerCommande(String id, String add);
	Integer getIdCommande(String id);
	int livrerCommande(String id);
}
