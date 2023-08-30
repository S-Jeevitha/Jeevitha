package dao;

import java.util.List;


import model.Book;

public interface IBook {
	public String addBook(Book book);
	public List<Book> viewBook();
	public String updateBook(Book book);
	public String deleteBook(Book book);
	
	

}
