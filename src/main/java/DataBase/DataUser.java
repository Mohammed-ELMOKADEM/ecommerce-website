package DataBase;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Models.User;

public class DataUser implements InterfaceDataUser {
	
	@Override
	public boolean saveUser(User u) {
		// TODO Auto-generated method stub
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","root");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			st.execute("insert into user (nom,email,adresse,telephone,password) values('" +u.getNom() + "', '" + u.getEmail() + "', '"+u.getAdresse()+"', '" + u.getTelephone()+ "', '"+ u.getPwd()+"')");
			return true;
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
			return false;
		}
	}
	
	@Override
	public int existUser(String email, String pwd) {
		// TODO Auto-generated method stub
		int value=0;
		ResultSet rs;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			rs=st.executeQuery("Select count(*) from user where email ='"+email+"' and password='"+pwd+"'");
			while(rs.next()) {
				value=Integer.parseInt(rs.getString(1));
			}
			return value;
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
			return 0;
		}
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> users=new ArrayList<User>();
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			ResultSet rs=st.executeQuery("Select * from user where nom !='admin'");
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setNom(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAdresse(rs.getString(4));
				u.setTelephone(rs.getString(5));
				u.setPwd(rs.getString(6));
				users.add(u);
			}
			return users;
		}
		catch(Exception e) {
			System.out.print("erreur "+e.getMessage());
			return null;
		}
	}

	@Override
	public Integer getUserByEmail(String email) {
		int id=0;
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			ResultSet rs=st.executeQuery("Select * from user where email ='"+email+"'");
			while(rs.next()) {
				id=rs.getInt("id");
			}
			System.out.println(id);
			return id;
		}
		catch(Exception e) {
			System.out.print("erreur "+e.getMessage());
			return 0;
		}
	}
	

	@Override
	public Integer deleteUser(String id) {
		int row=0;		
		try {
			ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/project","root","");
			con.connectToDB();
			Statement st = con.getConnect().createStatement();
			row = st.executeUpdate("DELETE FROM user where id='"+id+"'");
		}
		catch(Exception e) {
			return 0;
		}
		return row;
	}


}
