package com.project.clubmembership.core.exception;

public class EventDoesntExistException extends RuntimeException {
    public EventDoesntExistException(String message) {
        super(message);
    }
}
