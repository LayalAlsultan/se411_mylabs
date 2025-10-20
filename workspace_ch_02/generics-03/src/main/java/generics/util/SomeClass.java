package generics.util;

public class SomeClass {

	public SomeClass() {
		
	}
	
	public <T> T SomeGenericMethod(T param) {
		System.out.println(param);
		return param;
	}
	
}
