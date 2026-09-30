package edu.psu.se411.lab07.model;

import java.util.Date;

import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;

public abstract class Booking {

    private final String bookingId;
    private final String customerName;
    private final Date travelDate;
    private final String destinationCity;

    protected Booking(String bookingId, String customerName, Date travelDate, String destinationCity) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.travelDate = travelDate;
        this.destinationCity = destinationCity;
    }

    public final double calculateTotalPrice() {
        validate();
        return computePrice();
    }

    protected abstract void validate();

    protected abstract double computePrice();

    protected static void requireInRange(Number value, String fieldName, double min, double max) {
        if (value == null) {
            throw new MissingInformationException(fieldName + " was not provided.");
        }
        double v = value.doubleValue();
        if (v < min || v > max) {
            throw new InvalidArgumentException(
                    fieldName + " must be between " + min + " and " + max + " but was " + v);
        }
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public Date getTravelDate() { return travelDate; }
    public String getDestinationCity() { return destinationCity; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + bookingId + ", customer=" + customerName
                + ", destination=" + destinationCity + "]";
    }
}