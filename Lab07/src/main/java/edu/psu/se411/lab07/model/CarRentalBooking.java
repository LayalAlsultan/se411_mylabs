package edu.psu.se411.lab07.model;

import java.util.Date;

import edu.psu.se411.lab07.util.Config;

public class CarRentalBooking extends Booking {

    private final double dailyRate;
    private Integer rentalDays;

    public CarRentalBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
                            double dailyRate, Integer rentalDays) {
        super(bookingId, customerName, travelDate, destinationCity);
        this.dailyRate = dailyRate;
        this.rentalDays = rentalDays;
    }

    public void setRentalDays(Integer rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    protected void validate() {
        requireInRange(rentalDays, "Rental days", Config.MIN_RENTAL_DAYS, Config.MAX_RENTAL_DAYS);
    }

    @Override
    protected double computePrice() {
        return dailyRate * rentalDays;
    }
}