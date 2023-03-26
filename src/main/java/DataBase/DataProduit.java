package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Models.Produit;
import jakarta.servlet.annotation.MultipartConfig;

@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class DataProduit implements InterfaceProduit {

	private static final String sql = "INSERT INTO produit (nomProduit, prix, description,categorie,quantite,imageName,imagePath) values (?, ?, ?, ?, ?, ?, ?)";

	@Override
	public int addProduit(Produit p) {
		int row=0;
		// TODO Auto-generated method stub
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","root");
			con.connectToDB();
			PreparedStatement preparedStatement = con.getConnect().prepareStatement(sql);
			preparedStatement.setString(1, p.getName());
	        preparedStatement.setFloat(2, p.getPrix());
	        preparedStatement.setString(3, p.getDescription());
	        preparedStatement.setString(4, p.getCategorie());
	        preparedStatement.setInt(5, p.getQuantite());
	        preparedStatement.setString(6, p.getImageName());
	        preparedStatement.setString(7, p.getImagePath());
	        
	        row = preparedStatement.executeUpdate();
			return row;
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
			return 0;
		}
	}
	@Override
	public ResultSet getCategorie(String cate) {
		// TODO Auto-generated method stub
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			
			Statement st=con.getConnect().createStatement();
			
			String sql="Select * from produit where categorie='"+cate+"';";
			
			ResultSet rs=st.executeQuery(sql);
			return rs;
		}
		catch(Exception e) {
			System.out.print("erreur "+e.getMessage());
			return null;
		}
	}
	@Override
	public Produit getProduit(String id) {
		Produit p = new Produit();
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			String sql="Select * from produit where idProduit='"+id+"' ORDER BY idProduit DESC;";
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				p.setName(rs.getString("nomProduit"));
				p.setPrix(rs.getFloat("prix"));
				p.setDescription(rs.getString("description"));
				p.setCategorie(rs.getString("categorie"));
				p.setQuantite(rs.getInt("quantite"));
				p.setImagePath(rs.getString("imagePath"));
				p.setImageName(rs.getString("imageName"));
				p.setId(rs.getInt("idProduit"));
			}
			return p;
			
		}catch(Exception e) {
			System.out.print("erreur "+e.getMessage());
			return null;
		}
	}
	@Override
	public ArrayList<Produit> getAllProduits() {
		ArrayList<Produit> produits = new ArrayList<Produit>();
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			String sql="Select * from produit ORDER BY idProduit DESC;";
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Produit p = new Produit();
				p.setName(rs.getString("nomProduit"));
				p.setPrix(rs.getFloat("prix"));
				p.setDescription(rs.getString("description"));
				p.setCategorie(rs.getString("categorie"));
				p.setQuantite(rs.getInt("quantite"));
				p.setImagePath(rs.getString("imagePath"));
				p.setImageName(rs.getString("imageName"));
				p.setId(rs.getInt("idProduit"));
				produits.add(p);
			}
			return produits;
			
		}catch(Exception e) {
			System.out.print("erreur "+e.getMessage());
			return null;
		}
	}
	
	public Produit getProduitForCart(String id) {
		Produit p = new Produit();
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			String sql="Select p.*,c.qte from produit p inner join commandeProduits c where p.idProduit='"+id+"' and p.idProduit=c.idProduit;";
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				p.setName(rs.getString("nomProduit"));
				p.setPrix(rs.getFloat("prix"));
				p.setDescription(rs.getString("description"));
				p.setCategorie(rs.getString("categorie"));
				p.setQuantite(rs.getInt("qte"));
				p.setImagePath(rs.getString("imagePath"));
				p.setImageName(rs.getString("imageName"));
				p.setId(rs.getInt("idProduit"));
			}
			return p;
			
		}catch(Exception e) {
			System.out.print("erreur "+e.getMessage());
			return null;
		}
	}
	
	public void updateProduit(String id, Produit p) {
		// TODO Auto-generated method stub
		
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			st.executeUpdate("UPDATE produit set "+
					"nomProduit='"+p.getName()+
					"', categorie='"+p.getCategorie()+
					"',  prix='"+p.getPrix()+
					"',  description='"+p.getDescription()+
					"',  quantite='"+p.getQuantite()+
					"',  imageName='"+p.getImageName()+
					"',  imagePath='"+p.getImagePath()+
					"' WHERE idProduit="+id+";");
			
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}
		
	}
	
	public String getProduitCategory(String id) {
		ResultSet rs;
		String cat = null;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			rs=st.executeQuery("Select categorie from produit where idProduit='"+id+"';");
			while(rs.next()) {
				cat=rs.getString("categorie");
			}
			return cat;
	
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
			return null;
		}
	}
	
	public int deleteProduit(String id) {
		int row=0;
		int j=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			Statement st1 = con.getConnect().createStatement();
			ResultSet rs=st.executeQuery("SELECT * from commandeproduits where idProduit='"+id+"'");
			while(rs.next()) {
				int idCommande=rs.getInt("idCommande");
				ResultSet rs1=st1.executeQuery("Select count(*) from commande where idCommande='"+idCommande+"' and annulée=0 and livrée=0");
				while(rs1.next()) {
					j++;
				}
			}
			if(j!=0) {
				row=-1;
			}
			else {
				row=st.executeUpdate("Delete from produit where idProduit='"+id+"';");	
			}		
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
			row=0;
		}
		return row;
	}
	
}
