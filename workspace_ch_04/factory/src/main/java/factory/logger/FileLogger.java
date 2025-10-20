package factory.logger;

public class FileLogger extends Logger {

	private FileLogger() {
		
	}
	
	public static FileLogger create() {
		return new FileLogger();
	}

	@Override
	public void log(String message) {
		// log into file, but this is just for testing
		System.out.println("[File] " + message);
	}
}
