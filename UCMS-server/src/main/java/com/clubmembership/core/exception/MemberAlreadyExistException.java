package com.clubmembership.core.exception;

public class MemberAlreadyExistException extends RuntimeException {
    public MemberAlreadyExistException(String message) {
        super(message);
    }
}
