package instantiation.logging;

public abstract class Logger {

	public static ILogger getLogger(String type) {
		switch(type) {
		case "console": return ConsoleLogger.create();
		case "file": return FileLogger.create();
		default: throw new IllegalArgumentException("type has to be either file or console");
		}
	}
	
}
