package instantiation.logging;

public class ConsoleLogger implements ILogger {

	private ConsoleLogger() {
		// no instantiation
	}
	
	
	@Override
	public void log(String message) {
		System.out.printf("[console] %s%n", message);
	}
	
	public static ILogger create() {
		return new ConsoleLogger();
	}

}
