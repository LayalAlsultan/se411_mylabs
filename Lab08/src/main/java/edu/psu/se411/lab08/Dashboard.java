package edu.psu.se411.lab08;

public class Dashboard implements Observer {

    @Override
    public void update(Subject subject) {
        if (subject instanceof Sensor s) {
            System.out.printf("Dashboard | Data Received: %s = %.2f%n", s.getName(), s.getReading());
        }
    }
}