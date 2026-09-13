package edu.psu.se411;

import edu.psu.se411.exceptions.InvalidAgeException;

public class EX1 {

	public static void main(String[] args) {
		try {
	        validateAge(20);
	        validateAge(15);
	    } catch (InvalidAgeException e) {
	        System.out.println("Caught exception: " + e.getMessage());
	    }

	}
	
	public static void validateAge(int age) throws InvalidAgeException {
	    if (age < 18) {
	        throw new InvalidAgeException("Age " + age + " is invalid must be 18 or older.");
	    }
	    System.out.println("Age: " + age + " is valid.");
	}

}
