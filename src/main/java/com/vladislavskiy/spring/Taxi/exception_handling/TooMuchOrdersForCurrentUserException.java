package com.vladislavskiy.spring.Taxi.exception_handling;

public class TooMuchOrdersForCurrentUserException extends RuntimeException{
    public TooMuchOrdersForCurrentUserException(String message) {
        super(message);
    }
}
