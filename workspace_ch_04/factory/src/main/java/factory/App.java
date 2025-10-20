package factory;

import factory.logger.Logger;

public class App {

	public static void main(String[] args) {
		Logger lc = Logger.getLogger("console");
		lc.log("selem");

		Logger lf = Logger.getLogger("file");
		lf.log("ciao");
	}

}
