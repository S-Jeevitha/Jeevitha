package model;

public class Book {
	private Integer bookid;
	private String bookname;
	private String author;
	private String publisher;
	private Integer publishedyear;
	private String language;

	public Book() {

	}

	public Book(Integer bookid, String bookname, String author, String publisher, Integer publishedyear,
			String language) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.publisher = publisher;
		this.publishedyear = publishedyear;
		this.language = language;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getPublishedyear() {
		return publishedyear;
	}

	public void setPublishedyear(Integer publishedyear) {
		this.publishedyear = publishedyear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-30s%-20s%-30s%-20s%s\n", bookid, bookname, author, publisher, publishedyear,
				language);
	}

}
