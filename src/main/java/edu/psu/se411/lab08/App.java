package edu.psu.se411.lab08;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application is starting...");
        Random random = new Random();

        Sensor temp = new Sensor("TempA", SensorType.TEMPERATURE);
        Sensor humidity = new Sensor("HumidA", SensorType.HUMIDITY);

        Observer dashboard = new Dashboard();
        Observer sensorLogger = new SensorLogger();

        temp.register(dashboard);
        temp.register(sensorLogger);
        humidity.register(dashboard);
        humidity.register(sensorLogger);

        for (int i = 0; i < 10; i++) {
            temp.setReading(20 + random.nextDouble() * 15);
            humidity.setReading(40 + random.nextDouble() * 20);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Sensor tempCopy = temp.clone();
        System.out.println("--- Clone test ---");
        System.out.println("Original observers: " + temp.getObservers().size());
        System.out.println("Clone observers:    " + tempCopy.getObservers().size());

        tempCopy.setReading(99.0);            
        tempCopy.register(new Dashboard());   
        tempCopy.setReading(50.0);            

        logger.info("Application finished.");
    }
}