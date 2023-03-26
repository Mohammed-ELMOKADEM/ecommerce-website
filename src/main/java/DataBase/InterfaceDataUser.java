package DataBase;


import java.util.ArrayList;

import Models.User;

public interface InterfaceDataUser {
	public boolean saveUser(User u);
	int existUser(String email, String pwd);
	ArrayList<User> getAllUsers();
	Integer getUserByEmail(String email);
	Integer deleteUser(String id);
}
