package com.clubmembership.core.exception;

public class ClubHasntMemberYetException extends RuntimeException {
    public ClubHasntMemberYetException(String message) {
        super(message);
    }
}
