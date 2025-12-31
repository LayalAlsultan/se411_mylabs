package psu.se411.ch02.exADT.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import psu.se411.ch02.exADT.exceptions.IllegalUseOfBagException;

public class ListBag<T> implements IBag<T>{

	private ArrayList<T> elements;
	
	public ListBag() {
		elements = new ArrayList<T>();
	}
	
	public ListBag(T... content) {
		elements = new ArrayList<T>(Arrays.asList(content));
	}
	
	@Override
	public void add(T element) throws IllegalUseOfBagException {
		if(exists(element)) {
			throw new IllegalUseOfBagException("Cannot add an element more than once");
		}
		if(element != null) {
			elements.add(element);
		} 
		throw new IllegalArgumentException("Cannot add a null element");
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			Iterator<T> it = elements.iterator();
			while(it.hasNext()) {
				T current = it.next();
				if(current == element) {
					it.remove();
					break;
				}
			}
		}
		throw new IllegalArgumentException("Cannot remove a null element");
	}

	@Override
	public void removeAll(T element) {
		if(element != null) {
			Iterator<T> it = elements.iterator();
			while(it.hasNext()) {
				T current = it.next();
				if(current.equals(element)) {
					it.remove();
				}
			}
		}
		throw new IllegalArgumentException("Cannot remove a null element");
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public int size() {
		return elements.size();
	}

	public boolean exists(T element) {
		if(element != null) {
			Iterator<T> it = elements.iterator();
			while(it.hasNext()) {
				T current = it.next();
				if(current == element) {
					return true;
				}
			}
			return false;
		}
		throw new IllegalArgumentException("Argument element cannot be null");
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private final int[] shuffledIndices;
			private int currentPosition = 0;
			private final int expectedSize = elements.size();

			// Instance initializer - shuffles indices at creation
			{
				int size = elements.size();
				shuffledIndices = new int[size];

				// Initialize indices: 0, 1, 2, ..., size-1
				for (int i = 0; i < size; i++) {
					shuffledIndices[i] = i;
				}

				// Make n random permutations
				Random random = new Random();
				for (int i = size - 1; i > 0; i--) {
					int j = random.nextInt(i + 1);
					int temp = shuffledIndices[i];
					shuffledIndices[i] = shuffledIndices[j];
					shuffledIndices[j] = temp;
				}
			}

			@Override
			public boolean hasNext() {
				return currentPosition < shuffledIndices.length;
			}

			@Override
			public T next() {
				// Not thread safe
				if (!hasNext()) {
					throw new NoSuchElementException("No more elements in bag");
				}
				return elements.get(shuffledIndices[currentPosition++]);
			}
		};
	}

}
