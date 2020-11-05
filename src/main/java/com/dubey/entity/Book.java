package com.dubey.entity;

public class Book  {
	private Long id;
	private Long  isbn;
	private String name;
	private String title;
	private Author   Author;
	private int publishYear;
	private String publisher;
	private double cost;
	public Book()
	{
		
	}
	
	public Book(Long id, Long isbn, String name, String title, Author author, int publishYear,
			String publisher, double cost) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.title = title;
		Author = author;
		this.publishYear = publishYear;
		this.publisher = publisher;
		this.cost = cost;
	}

	public Book(Long id,Long isbn, String name, String title, Author author) {
		super();
		this.id=id;
		this.isbn = isbn;
		this.name = name;
		this.title = title;
		Author = author;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Author getAuthor() {
		return Author;
	}
	public void setAuthor(Author author) {
		Author = author;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", name=" + name + ", title=" + title + ", Author=" + Author
				 + "]";
	}
	
	
	
}
