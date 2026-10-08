package edu.psu.se411.lab07.model;

import java.util.Date;

import edu.psu.se411.lab07.util.Config;

public class FlightBooking extends Booking {

    private final double basePrice;
    private final double includedLuggageWeight;
    private Double luggageWeight;  

    public FlightBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
                         double basePrice, double includedLuggageWeight, Double luggageWeight) {
        super(bookingId, customerName, travelDate, destinationCity);
        this.basePrice = basePrice;
        this.includedLuggageWeight = includedLuggageWeight;
        this.luggageWeight = luggageWeight;
    }

    public void setLuggageWeight(Double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    @Override
    protected void validate() {
        requireInRange(luggageWeight, "Luggage weight", Config.MIN_LUGGAGE_WEIGHT, Config.MAX_LUGGAGE_WEIGHT);
    }

    @Override
    protected double computePrice() {
        double extraKg = Math.max(0, luggageWeight - includedLuggageWeight);
        double subtotal = basePrice + extraKg * Config.EXTRA_LUGGAGE_RATE;
        return subtotal * (1 + Config.TAX_RATE);
    }
}