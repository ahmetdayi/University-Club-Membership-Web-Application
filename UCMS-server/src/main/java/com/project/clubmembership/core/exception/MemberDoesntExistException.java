package com.project.clubmembership.core.exception;

public class MemberDoesntExistException extends RuntimeException {
    public MemberDoesntExistException(String message) {
        super(message);
    }
}
