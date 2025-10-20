package clonable;

import clonable.model.House;

public class App {

	public static void main(String[] args) {
		House h1 = new House(12, 400);
		House h2 = (House) h1.clone();
		
		System.out.printf("H2 == H1 : %s%n", h2 == h1);
		System.out.printf("H2 equals H1 : %s%n", h2.equals(h1));
		System.out.printf("H2 compareTo H1 : %s%n", h2.compareTo(h1));
	}

}
