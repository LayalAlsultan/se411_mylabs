package edu.psu.se411.lab08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensorLogger implements Observer {

    private static final Logger log = LoggerFactory.getLogger(SensorLogger.class);

    @Override
    public void update(Subject subject) {
        if (subject instanceof Sensor s) {
            log.info("Data Received: {}", s);
            System.out.printf("Logger    | Data Received: %s%n", s);
        }
    }
}