package edu.psu.se411.lab07.exceptions;

public class MissingInformationException extends RuntimeException {

    public MissingInformationException(String message) {
        super(message);
    }
}