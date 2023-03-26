package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Commande;
import Models.Produit;

public class DataCommande implements InterfaceCommande {

	private static final String sql = "INSERT INTO commande (idClient, total, annulée, payée) values (?, ?, 0, 0)";
	private static final String sql1= "INSERT INTO commandeproduits (idCommande,idProduit,qte) values (?,?,?)";
	DataProduit DP = new DataProduit();
	@Override
	public void ajouterAuPanier(Commande c,Integer idProd) {
		ResultSet rs;
		int row=0;
		int idCom=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","root");
			con.connectToDB();
			Statement st=con.getConnect().createStatement();
			rs=st.executeQuery("SELECT *,count(*) as nbr FROM commande where idClient='"+c.getIdClient()+"' and annulée=0 and payée=0");
			while(rs.next()) {
				row=rs.getInt("nbr");
				idCom=rs.getInt("idCommande");
			}
			if(row!=0) {
				Produit p = DP.getProduit(idProd.toString());
				st.executeUpdate("UPDATE commande SET total=total+"+p.getPrix()+" where idCommande='"+idCom+"'");
				PreparedStatement preparedStatement = con.getConnect().prepareStatement(sql1);
				preparedStatement.setInt(1, idCom);
				preparedStatement.setInt(2,idProd);
				preparedStatement.setInt(3, 1);
				preparedStatement.executeUpdate();
				
			}
			else {
				Produit p = DP.getProduit(idProd.toString());
				PreparedStatement preparedStatement = con.getConnect().prepareStatement(sql);
		        preparedStatement.setString(1, c.getIdClient());
		        preparedStatement.setFloat(2, p.getPrix());
		        preparedStatement.executeUpdate();
		        idCom=getCommandeId(Integer.parseInt(c.getIdClient()));
		        
		        
				PreparedStatement preparedStatement1 = con.getConnect().prepareStatement(sql1);
				preparedStatement1.setInt(1, idCom);
				preparedStatement1.setInt(2,idProd);
				preparedStatement1.setInt(3, 1);
				preparedStatement1.executeUpdate();
			}
			  
	        Statement st1=con.getConnect().createStatement();
	        st1.executeUpdate("Update produit set quantite = quantite-1 where idProduit='"+idProd+"'");
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}

	}
	@Override
	public Integer getCommandeId(int id) {
		int idCom=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        ResultSet rs=st.executeQuery("SELECT idCommande from Commande where idClient='"+id+"' and annulée=0 and payée=0");
	        
	        while(rs.next()) {
	        	idCom=rs.getInt("idCommande");
	        }
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}
		
		return idCom;
	}
	@Override
	public void updateQte(String id,String idClient) {
		int idCom=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        ResultSet rs=st.executeQuery("SELECT idCommande from Commande where idClient='"+idClient+"' and annulée=0 and payée=0");
	        while(rs.next()) {
	        	idCom=rs.getInt("idCommande");
	        }
	        if(idCom!=0) {
	        	Produit p = DP.getProduit(id);
	        	st.executeUpdate("UPDATE commande set total=total+"+p.getPrix()+" Where idCommande='"+idCom+"'");
	        	st.executeUpdate("UPDATE Commandeproduits Set qte=qte+1	where idProduit='"+id+"' and idCommande='"+idCom+"'");
	 	        st.executeUpdate("Update produit set quantite = quantite-1 where idProduit='"+id+"'");
	        }
	        
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}	
	}
	@Override
	public ArrayList<Integer> topSelling() {
		String sql1="SELECT idProduit,count(*) as nbrCom from commandeProduits GROUP BY idProduit ORDER BY nbrCom DESC LIMIT 8;";
		ArrayList<Integer> produits = new ArrayList<Integer>();
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        ResultSet rs=st.executeQuery(sql1);
	        while(rs.next()) {
	        	int id;
	        	id=rs.getInt("idProduit");
	        	produits.add(id);
	        }
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}	
		return produits;
		
	}
	@Override
	public void removeFromCart(String id,String client) {
		// TODO Auto-generated method stub
		int idCom=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        ResultSet rs=st.executeQuery("SELECT idCommande from commande where idClient='"+client+"' and payée=0 and annulée=0");
	        while(rs.next()) {
	        	idCom=rs.getInt("idCommande");
	        }
	        if(idCom!=0) {
	        	int qte=0;
	        	rs=st.executeQuery("SELECT qte from commandeProduits where idProduit='"+id+"' and idCommande='"+idCom+"'");
	        	while(rs.next()) {
	        		qte=rs.getInt("qte");
	        	}
	        	
	        	st.executeUpdate("DELETE FROM Commandeproduits where idProduit='"+id+"' and idCommande='"+idCom+"'");
	        	st.executeUpdate("UPDATE produit set quantite=quantite+"+qte+" WHERE idProduit='"+id+"'");
	        }
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}	
		
	}
	
	@Override
	public void ConfirmerCommande(String id, String add) {
		// TODO Auto-generated method stub
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        st.executeUpdate("UPDATE Commande SET payée = 1,adresse='"+add+"' where idCommande='"+id+"'");
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}
	}
	
	@Override
	public ArrayList<Commande> getAllCommandes() {
		ArrayList<Commande> Commandes = new ArrayList<Commande>();
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        ResultSet rs = st.executeQuery("SELECT *,u.nom from Commande c inner join user u where c.idClient=u.id");
	        while(rs.next()) {
	        	Commande c = new Commande();
	        	c.setIdClient(rs.getString("u.nom"));
	        	c.setIdCommande(rs.getInt("idCommande"));
	        	c.setAnnulée(rs.getInt("annulée"));
	        	c.setPayée(rs.getInt("payée"));
	        	c.setAdresse(rs.getString("adresse"));
	        	c.setTotal(rs.getFloat("total"));
	        	c.setLivrée(rs.getInt("livrée"));
	        	Commandes.add(c);
	        	
	        }
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}
		
		return Commandes;
		
	}
	@Override
	public int annuleCommandes(String id) {
		int row=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
	        Statement st=con.getConnect().createStatement();
	        row=st.executeUpdate("UPDATE Commande SET annulée = 1 , payée=0 where idCommande='"+id+"'");
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
			row=0;
		}
		return row;
		
	}
	@Override
	public ArrayList<Integer> getCart(String id) {
		ArrayList<Integer> Commandes=new ArrayList<Integer>();
		int idCom=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st=con.getConnect().createStatement();
			ResultSet rs=st.executeQuery("Select idCommande FROM Commande where idClient='"+id+"' and payée=0 and annulée=0");
			while(rs.next()) {
				idCom=rs.getInt("idCommande");
			}
			if(idCom!=0) {
				rs=st.executeQuery("SELECT idProduit FROM commandeproduits where idCommande='"+idCom+"'");
				while(rs.next()) {
					Commandes.add(rs.getInt("idProduit"));
				}
			}
		}catch(Exception e) {
			return null;
		}
		return Commandes;
	}
	@Override
	public Integer getIdCommande(String id) {
		int idCom=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st=con.getConnect().createStatement();
			ResultSet rs=st.executeQuery("Select idCommande FROM Commande where idClient='"+id+"' and payée=0 and annulée=0");
			while(rs.next()) {
				idCom=rs.getInt("idCommande");
			}
		}catch(Exception e) {
			return 0;
		}
		return idCom;
		
	}
	@Override
	public int livrerCommande(String id) {
		int row=0;
		int pay=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st=con.getConnect().createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM commande where idCommande='"+id+"'");
			while(rs.next()) {
				pay=rs.getInt("payée");
			}
			if(pay!=0) {
				row=st.executeUpdate("UPDATE commande SET livrée=1 where idCommande='"+id+"'");
			}
			else {
				row=-1;
			}
		}catch(Exception e) {
			row= 0;
		}
		return row;	
	}
	
}
