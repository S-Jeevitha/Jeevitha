package util;

public class Query {
	public static final String ADMIN_LOGIN="select * from admin where username = ? and password = ? ";
	public static final String UPDATE_ADMIN="update admin set password=? where username =?";
	public static final String USER_LOGIN="select * from user where username = ? and password = ? ";
	public static final String ADD_USER="insert into user values(?,?,?,?)";
	public static final String UPDATE_USER="update user set email=?,mobile_number=?,password=? where username =?";
	public static final String VIEW_USER="select * from user";
	public static final String ADD_BOOK="insert into book values(?,?,?,?,?,?)";
	public static final String VIEW_ALL_BOOK="select * from Book";
	public static final String UPDATE_BOOK="update book set book_name=?,author=?,publisher=?,published_year=?,language=? where book_id=?";
	public static final String DELETE_BOOK="delete from book where book_id=?";
	
	
	
	

}
