package com.project.clubmembership.core.exception;

public class ClubIsAlreadyExistException extends RuntimeException {
    public ClubIsAlreadyExistException(String message) {
        super(message);
    }
}
