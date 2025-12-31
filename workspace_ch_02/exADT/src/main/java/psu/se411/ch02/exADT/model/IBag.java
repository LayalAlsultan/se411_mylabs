package psu.se411.ch02.exADT.model;

import java.util.Iterator;

import psu.se411.ch02.exADT.exceptions.IllegalUseOfBagException;

/**
 * An interface for the Bag abstract data type.
 * @param <T>
 */
public interface IBag<T> extends Iterable<T> {
	
	/**
	 * Adds an element to the bag. Does not return anything if it succeeds.
	 * @param element
	 */
	public void add(T element) throws IllegalArgumentException, IllegalUseOfBagException;
	
	/**
	 * Removes the exact element from the Bag if it exists. 
	 * Uses ( == ) comparison semantics to find the element.
	 * @param element
	 */
	public void remove(T element) throws IllegalArgumentException;
	
	/**
	 * Removes all the occurences of element from the Bag if it exists. 
	 * Uses ( .equals ) comparison semantics to find the equal elements.
	 * @param element
	 */
	public void removeAll(T element) throws IllegalArgumentException;
	
	public boolean isEmpty();
	
	public int size();
	
	public boolean exists(T element) throws IllegalArgumentException;
	

	
}
