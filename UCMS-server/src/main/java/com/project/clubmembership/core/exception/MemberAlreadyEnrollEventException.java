package com.project.clubmembership.core.exception;

public class MemberAlreadyEnrollEventException extends RuntimeException {
    public MemberAlreadyEnrollEventException(String message) {
        super(message);
    }
}
