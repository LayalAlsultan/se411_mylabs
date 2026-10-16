package edu.psu.se411.lab07;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;
import edu.psu.se411.lab07.model.Booking;
import edu.psu.se411.lab07.model.CarRentalBooking;
import edu.psu.se411.lab07.model.FlightBooking;
import edu.psu.se411.lab07.model.TrainBooking;
import edu.psu.se411.lab07.util.SeatClass;

public class MainApp {

	static Logger logger = LoggerFactory.getLogger(MainApp.class);

	public static double computeTotalPrice(Booking booking) {
		return booking.calculateTotalPrice();
	}

	private static void run(Booking booking) {
		try {
			System.out.println(booking + " -> Total Price: " + String.format("%.2f", computeTotalPrice(booking)));
		} catch (MissingInformationException | InvalidArgumentException e) {
			logger.error("Problem with " + booking + ": " + e.getMessage(), e);
			System.out.println(booking + " -> ERROR: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		logger.info("Application is starting...");

		Booking fbooking = new FlightBooking("B001", "John Doe", new Date(), "New York", 200.0, 30.0, 20.0);
		Booking cbooking = new CarRentalBooking("B002", "Jane Smith", new Date(), "Los Angeles", 50.0, 10);
		Booking tbooking = new TrainBooking("B003", "Alice Johnson", new Date(), "Chicago", SeatClass.STANDARD_CLASS, 100.0);
		run(fbooking);
		run(cbooking);
		run(tbooking);

		run(new FlightBooking("B004", "Sara Ali", new Date(), "Paris", 200.0, 30.0, 35.0));

		run(new FlightBooking("B005", "Omar Khan", new Date(), "Dubai", 200.0, 30.0, null));
		run(new TrainBooking("B006", "Lina Nasser", new Date(), "Dammam", SeatClass.FIRST_CLASS, null));
		run(new CarRentalBooking("B007", "Huda Saad", new Date(), "Jeddah", 50.0, null));

		run(new FlightBooking("B008", "Adam Noor", new Date(), "Rome", 200.0, 30.0, 45.0));
		run(new TrainBooking("B009", "Maha Fahad", new Date(), "Abha", SeatClass.FIRST_CLASS, 2500.0));
		run(new CarRentalBooking("B010", "Yara Sami", new Date(), "Tabuk", 50.0, 31));

		logger.info("Application is stopping...");
	}
}