package se411.lab03;
import java.util.Arrays;
import java.util.List;

public class PrintableList<T> {

	private List<T> items;
	
	public PrintableList(T[] array) {
		this.items = Arrays.asList(array);
	}
	
	public List<T> getList(){
		return items;
	}
	
	public void printList() {
		for(T item : items) {
			System.out.println(item);
		}
	}
}
