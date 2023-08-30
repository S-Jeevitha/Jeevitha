package controller;

import java.util.List;

import dao.IUser;
import dao.UserImpl;
import model.User;

public class UserController {
	User user;
	IUser impl = new UserImpl();

	public String userloginvalidation(String name, String password) {
		user = new User();
		user.setName(name);
		user.setPassword(password);
		return impl.userloginvalidation(user);
	}
	public List<User> viewUser(){
		return impl.viewUser();
	}
	

	public String addUser(String name, String email, long mobilenumber, String password) {
		user = new User(name, email, mobilenumber, password);
		return impl.addUser(user);
	}

	public String updatedetail(String name, String email, long mobilenumber, String password) {
		user = new User(name, email, mobilenumber, password);
		return impl.updatedetail(user);
	}

}
