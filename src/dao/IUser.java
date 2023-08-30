package dao;

import java.util.List;

import model.User;

public interface IUser {
	public String userloginvalidation(User user);

	public String addUser(User user);

	public String updatedetail(User user);
	
	public List<User> viewUser();

}
