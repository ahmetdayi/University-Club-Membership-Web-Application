package com.project.clubmembership.core.exception;

public class SponsorDoesntExistException extends RuntimeException {
    public SponsorDoesntExistException(String message) {
        super(message);
    }
}
