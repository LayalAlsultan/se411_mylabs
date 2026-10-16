package edu.psu.se411.lab08;

import java.util.HashSet;

public class Sensor extends AbstractSubject implements Cloneable {

    private String name;
    private SensorType type;
    private Double reading;

    public Sensor(String name, SensorType type) {
        this.name = name;
        this.type = type;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public SensorType getType() {
        return type;
    }

    @Override
    public Sensor clone() {
        try {
            Sensor copy = (Sensor) super.clone();
            copy.setObservers(new HashSet<>());
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return name + " [" + type + "]: " + reading;
    }
}