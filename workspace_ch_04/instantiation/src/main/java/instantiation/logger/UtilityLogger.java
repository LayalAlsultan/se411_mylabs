package instantiation.logger;

public class UtilityLogger {

	private UtilityLogger() {
		// no instantiation
	}
	
	public static void logInfo(String message) {
		System.out.printf("[INFO] %s%n", message);
	}
	
	public static void logError(String message) {
		System.out.printf("[ERROR] %s%n", message);
	}
}
