package DataBase;

import java.sql.ResultSet;
import java.util.ArrayList;

import Models.Produit;

public interface InterfaceProduit {

	
	public int addProduit(Produit p);
	public ResultSet getCategorie(String cate);
	public Produit getProduit(String id);
	public ArrayList<Produit> getAllProduits();
	public Produit getProduitForCart(String id);
	public void updateProduit(String id, Produit p);
	public String getProduitCategory(String id);
	public int deleteProduit(String id);
}
