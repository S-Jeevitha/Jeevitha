package controller;

import java.util.List;

import dao.BookImpl;
import dao.IBook;
import model.Book;

public class BookController {
	Book book;
	IBook impl = new BookImpl();

	public String addBook(Integer bookid, String bookname, String author, String publisher, Integer publishedyear,
			String language) {
		book = new Book(bookid, bookname, author, publisher, publishedyear, language);
		return impl.addBook(book);
	}
	public List<Book> viewBook(){
		return impl.viewBook();
	}
	
	public String updateBook(Integer bookid, String bookname, String author, String publisher, Integer publishedyear,
			String language) {
		book = new Book(bookid, bookname, author, publisher, publishedyear, language);
		return impl.updateBook(book);
	}
	public String deleteBook(Integer bookid)  {
		book = new Book();
		book.setBookid(bookid);
		return impl.deleteBook(book);
	}

}
