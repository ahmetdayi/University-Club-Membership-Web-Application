package com.project.clubmembership.core.exception;

public class MemberDoesntEnrollEventYetException extends RuntimeException {
    public MemberDoesntEnrollEventYetException(String message) {
        super(message);
    }
}
