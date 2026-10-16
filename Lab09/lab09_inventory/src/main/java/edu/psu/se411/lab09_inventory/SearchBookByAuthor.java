package edu.psu.se411.lab09_inventory;

public class SearchBookByAuthor implements SearchStrategy<Item> {
	private final String author;

	public SearchBookByAuthor(String author) { this.author = author; }

	@Override
	public boolean matches(Item item) {
		return item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author);
	}
}