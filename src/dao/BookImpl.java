package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

import util.Db;
import util.Query;

public class BookImpl implements IBook {
	PreparedStatement statement;
	String result;

	@Override
	public String addBook(Book book) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.ADD_BOOK);
			statement.setInt(1, book.getBookid());
			statement.setString(2, book.getBookname());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getPublisher());
			statement.setInt(5, book.getPublishedyear());
			statement.setString(6, book.getLanguage());
			statement.executeUpdate();
			result = "Inserted Sucessfully";
		} catch (SQLException ex) {
			result = "Duplicate Exists";
			// ex.printStackTrace();

		}
		return result;
	}

	@Override
	public List<Book> viewBook() {
		List<Book> list = new ArrayList<Book>();
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_ALL_BOOK);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Book book = new Book(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5),
						set.getString(6));
				list.add(book);
			}
		}

		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public String updateBook(Book book) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_BOOK);
			statement.setInt(6, book.getBookid());
			statement.setString(5, book.getLanguage());
			statement.setInt(4, book.getPublishedyear());
			statement.setString(3, book.getPublisher());
			statement.setString(2, book.getAuthor());
			statement.setString(1, book.getBookname());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Updated Sucessfully";
			} else {
				result = "Record Not Found";
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}

	@Override
	public String deleteBook(Book book) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.DELETE_BOOK);
			statement.setInt(1, book.getBookid());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Deleted Sucessfully";
			} else {
				result = "Record Not Found";
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}

}
