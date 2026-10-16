package edu.psu.se411.lab09_inventory;

public class Book extends Item {

	private String author;

	public Book(String id, String name, String author) {
		super(id, name);
		this.author = author;
	}

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	@Override
	public String toString() {
		return "Book [" + super.toString() + ", author=" + author + "]";
	}
}