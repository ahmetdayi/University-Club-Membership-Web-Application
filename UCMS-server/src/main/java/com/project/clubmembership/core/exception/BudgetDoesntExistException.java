package com.project.clubmembership.core.exception;

public class BudgetDoesntExistException extends RuntimeException {
    public BudgetDoesntExistException(String message) {
        super(message);
    }
}
