package com.clubmembership.core.exception;

public class ClubDoesntExistException extends RuntimeException {
    public ClubDoesntExistException(String message) {
        super(message);
    }
}
