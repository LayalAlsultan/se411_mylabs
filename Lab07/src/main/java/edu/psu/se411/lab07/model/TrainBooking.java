package edu.psu.se411.lab07.model;

import java.util.Date;

import edu.psu.se411.lab07.util.Config;
import edu.psu.se411.lab07.util.SeatClass;

public class TrainBooking extends Booking {

    private final SeatClass seatClass;
    private Double distanceKm;

    public TrainBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
                        SeatClass seatClass, Double distanceKm) {
        super(bookingId, customerName, travelDate, destinationCity);
        this.seatClass = seatClass;
        this.distanceKm = distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    @Override
    protected void validate() {
        requireInRange(distanceKm, "Distance", Config.MIN_TRAIN_DISTANCE, Config.MAX_TRAIN_DISTANCE);
    }

    @Override
    protected double computePrice() {
        double rate = (seatClass == SeatClass.FIRST_CLASS)
                ? Config.TRAIN_FIRST_CLASS_RATE
                : Config.TRAIN_STANDARD_RATE;
        return distanceKm * rate;
    }
}