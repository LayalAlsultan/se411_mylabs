package edu.psu.se411.lab09_inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Application is starting...");

		Inventory<Item> inventory = new Inventory<Item>();
		inventory.add(new Book("B001", "Concurrency in Java", "Salah Obeid"));
		inventory.add(new Book("B002", "Clean Code", "Robert Martin"));
		inventory.add(new ElectronicDevice("M001", "USB drive 256Gb", "Toshiba"));
		inventory.add(new ElectronicDevice("M002", "Headphones WH-1000XM5", "Sony"));

		System.out.println("Search by name 'Concurrency in Java':");
		print(inventory.findItems(new SearchByName("Concurrency in Java")));

		System.out.println("Search book by author 'Salah Obeid':");
		print(inventory.findItems(new SearchBookByAuthor("Salah Obeid")));

		System.out.println("Search device by category 'Sony':");
		print(inventory.findItems(new SearchByCategory("Sony")));

		System.out.println("Search by id 'M001':");
		print(inventory.findItems(new SearchById("M001")));

		System.out.println("Lambda: names that contain 'USB':");
		print(inventory.findItems(item -> item.getName().contains("USB")));

		System.out.println("Display whole inventory:");
		displayInventory(inventory);

		try {
			inventory.add(null);
		} catch (IllegalArgumentException e) {
			logger.error("Could not add item: {}", e.getMessage());
		}

		logger.info("Application is closing...");
	}

	public static void displayInventory(Inventory<?> inventory) {
		for (Object element : inventory.getElements()) {
			System.out.println("  " + element);
		}
	}

	private static void print(List<Item> items) {
		if (items.isEmpty()) {
			System.out.println("  (no match)");
		}
		for (Item item : items) {
			System.out.println("  " + item);
		}
	}
}