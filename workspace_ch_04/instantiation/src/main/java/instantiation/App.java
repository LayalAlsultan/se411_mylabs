package instantiation;

import instantiation.logging.ILogger;
import instantiation.logging.Logger;

public class App {

	public static void main(String[] args) {

		ILogger logA = Logger.getLogger("file");
		logA.log("some message");
		
		ILogger logB = Logger.getLogger("console");
		logB.log("some message");
	}

}
