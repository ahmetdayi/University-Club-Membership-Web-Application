package com.clubmembership.core.exception;

public class BudgetDoesntExist extends RuntimeException {
    public BudgetDoesntExist(String message) {
        super(message);
    }
}
