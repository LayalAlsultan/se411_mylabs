package instantiation.logging;

public class FileLogger implements ILogger {

	private FileLogger() {
		// no instantiation
	}
	
	@Override
	public void log(String message) {
		System.out.printf("[file] %s%n", message);
	}

	public static ILogger create() {
		return new FileLogger();
	}
	
}
