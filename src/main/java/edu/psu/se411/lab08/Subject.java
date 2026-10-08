package edu.psu.se411.lab08;

public interface Subject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyObservers();
}