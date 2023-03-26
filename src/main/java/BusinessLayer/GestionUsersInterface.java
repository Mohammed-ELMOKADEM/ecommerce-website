package BusinessLayer;

import java.util.ArrayList;

import Models.User;

public interface GestionUsersInterface {
	int existUser(String email, String pwd);
	ArrayList<User> getAllUsers();
	Integer getUserByEmail(String email);
	Integer deleteUser(String id);
}
