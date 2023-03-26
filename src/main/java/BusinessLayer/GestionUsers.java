package BusinessLayer;

import java.util.ArrayList;


import DataBase.DataUser;
import Models.User;

public class GestionUsers implements GestionUsersInterface {
	
	DataUser DU = new DataUser();
	
	@Override
	public int existUser(String email, String pwd) {
		return DU.existUser(email, pwd);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return DU.getAllUsers();
	}

	@Override
	public Integer getUserByEmail(String email) {
		return DU.getUserByEmail(email);
	}

	@Override
	public Integer deleteUser(String id) {
		return DU.deleteUser(id);
	}

}
