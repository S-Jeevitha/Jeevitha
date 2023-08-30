package model;

public class User {
	private String name;
	private String email;
	private long mobilenumber;
	private String password;

	public User() {

	}

	public User(String name, String email, long mobilenumber, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-20s%-20s%-20s\n", name, email, mobilenumber, password);
	}
}
