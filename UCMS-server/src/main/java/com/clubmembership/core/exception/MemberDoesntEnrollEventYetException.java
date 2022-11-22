package com.clubmembership.core.exception;

public class MemberDoesntEnrollEventYetException extends RuntimeException {
    public MemberDoesntEnrollEventYetException(String message) {
        super(message);
    }
}
