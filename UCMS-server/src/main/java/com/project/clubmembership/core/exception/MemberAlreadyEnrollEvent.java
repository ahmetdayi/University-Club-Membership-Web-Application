package com.project.clubmembership.core.exception;

public class MemberAlreadyEnrollEvent extends RuntimeException {
    public MemberAlreadyEnrollEvent(String message) {
        super(message);
    }
}
