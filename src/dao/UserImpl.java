package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Db;
import util.Query;

public class UserImpl implements IUser {
	PreparedStatement statement;
	String result;
	int i = 0;
	int status=0;

	@Override
	public String userloginvalidation(User user) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.USER_LOGIN);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				i++;
			}
			if (i > 0) {
				result = "Welcome To User Page!";
			} else {
				System.out.println("User or Password is Incorrect ");
				System.exit(0);
				
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}
		return result;
	}

	@Override
	public String addUser(User user) {
		try {

			statement = Db.getObject().getConnection().prepareStatement(Query.ADD_USER);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setLong(3, user.getMobilenumber());
			statement.setString(4, user.getPassword());
		    status=statement.executeUpdate();
			if (status > 0) {
				result = "Registered Sucessfully!";

			} else {
				result = "Please Try Again!";
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return result;
	}
	@Override
	public List<User> viewUser() {
		List<User> list = new ArrayList<User>();
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_USER);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
			User user = new User(set.getString(1),set.getString(2),set.getLong(3),set.getString(4));
				list.add(user);
			}
		}

		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public String updatedetail(User user) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_USER);
			statement.setString(1, user.getEmail());
			statement.setLong(2, user.getMobilenumber());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getName());
			statement.executeUpdate();
			if (i > 0) {
				result = "Updated Sucessfully!";
			} else {
				result = "Record Not Found";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	
}
