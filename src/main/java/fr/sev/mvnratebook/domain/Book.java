package fr.sev.mvnratebook.domain;

public class Book {

	private int id;
	private String title;
	private Author author;
	private int year;
	private String genre;
	
	public Book() {
		super();
	}

	public Book(String title, Author author, int year, String genre) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	public Book(int id, String title, Author author, int year, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
}
