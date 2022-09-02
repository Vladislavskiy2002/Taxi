package com.vladislavskiy.spring.Taxi.exception_handling;

public class NotCorrectComfortLevelException extends RuntimeException{
    public NotCorrectComfortLevelException(String message) {
        super(message);
    }
}
