package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private String url;
	private String username;
	private String password;
	private Connection connect;
	
	public ConnectionDB(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection(this.url,this.username,this.password);
		} catch (Exception e) {
			System.out.print("erreur "+e.getMessage());
		}
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	
	
	
	
}
