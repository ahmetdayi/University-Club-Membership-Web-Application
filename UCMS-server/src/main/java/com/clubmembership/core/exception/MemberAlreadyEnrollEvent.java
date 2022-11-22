package com.clubmembership.core.exception;

public class MemberAlreadyEnrollEvent extends RuntimeException {
    public MemberAlreadyEnrollEvent(String message) {
        super(message);
    }
}
