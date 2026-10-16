package edu.psu.se411.lab09_inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {

	private List<T> elements;

	public Inventory() {
		this.elements = new ArrayList<>();
	}

	public Inventory(List<T> elements) {
		this.elements = new ArrayList<>(elements);
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = new ArrayList<>(elements);
	}

	public void add(T element) {
		if (element == null) {
			throw new IllegalArgumentException("Cannot add a null item");
		}
		elements.add(element);
	}

	public boolean remove(T element) {
		return elements.remove(element);
	}

	public List<T> findItems(SearchStrategy<T> strategy) {
		List<T> result = new ArrayList<>();
		for (T element : elements) {
			if (strategy.matches(element)) {
				result.add(element);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Inventory " + elements;
	}
}