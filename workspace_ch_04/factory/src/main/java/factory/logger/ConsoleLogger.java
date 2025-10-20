package factory.logger;

public class ConsoleLogger extends Logger {

	private ConsoleLogger() {
		
	}
	
	public static ConsoleLogger create() {
		return new ConsoleLogger();
	}

	@Override
	public void log(String message) {
		System.out.println("[Console] " + message);
		
	}
}
