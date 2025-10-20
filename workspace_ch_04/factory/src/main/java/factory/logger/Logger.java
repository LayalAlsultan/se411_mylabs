package factory.logger;

public abstract class Logger {
	
	public abstract void log(String message);

	public static Logger getLogger(String type ) {
		switch(type) {
			case "console":
				return ConsoleLogger.create();
			case "file":
				return FileLogger.create();
			default:
				throw new IllegalArgumentException("Type must be either console or file");
		}

	}
	
}
