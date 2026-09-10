package se411.lab03;
import java.util.List;

public class App {
	
	public static void printList(List<?> list) {
		for (Object item : list) {
			System.out.println(item);
		}
	}

	public static double sumNumbers(List<? extends Number> list) {
		double sum = 0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		
		return sum;
	}


	public static void main(String[] args) {
		
		// Exercise 1
		String[] strArr = {"apple", "banana", "cherry"};
		PrintableList<String> stringList = new PrintableList<>(strArr);
		stringList.printList();

		Integer[] intArr = {1, 2, 3};
		PrintableList<Integer> intList = new PrintableList<>(intArr);
		intList.printList();

		// Exercise 2
		NumberBox<Integer> intBox = new NumberBox<>();
		intBox.setItem(10);
		System.out.println("Int box sum: " + intBox.sum(5));

		NumberBox<Double> doubleBox = new NumberBox<>();
		doubleBox.setItem(3.5);
		System.out.println("Double box sum: " + doubleBox.sum(2.5));

		
		// Exercise 3
		printList(stringList.getList());
		System.out.println("Sum: " + sumNumbers(intList.getList()));

		
		
	}

	
}
