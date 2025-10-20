package generics.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import generics.util.SomeBean;
import generics.util.SomeClass;

public class App {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		
		s1.addAll(Arrays.asList("zbc", "acb", "mdf", "cfg"));
		
		Collections.sort(s1); // not applicable
		
	}

}
