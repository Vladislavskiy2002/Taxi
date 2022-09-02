package com.vladislavskiy.spring.Taxi.exception_handling;

public class NotFoundUserByIdException extends RuntimeException{
    public NotFoundUserByIdException(String message) {
        super(message);
    }
}
