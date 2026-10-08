import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import edu.psu.se411.model.Stack;

import java.util.NoSuchElementException;
	
public class StackTest {
	
	private Stack stacktest = new Stack();
	@Test
	@DisplayName("Push pop should work")
	void testPush() {
	stacktest.push("Z");
	stacktest.push("A");
	assertEquals("Z", stacktest.pop());
	//The popped element has to be equal to A
	//otherwise there is a problem in our Stack.
	}
	
	@Test
	public void pop_empty_stack() {
	NoSuchElementException thrown = assertThrows(NoSuchElementException.class,() -> stacktest.pop(),"Expected pop from empty Stack to throw, but it didn't");
	assertTrue(thrown.getMessage().equals("Stack is empty, cannot pop"));
	}
	
	void test_pop() {
	stacktest.push("A");
	stacktest.push("B");
	stacktest.push("C");
	
	assertEquals("C", stacktest.pop());
	assertEquals("B", stacktest.pop());
	assertEquals("A", stacktest.pop());
	
	}
}
