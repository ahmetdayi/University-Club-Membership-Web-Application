package com.clubmembership.entity.dto;

import lombok.Data;

@Data
public class UpdateBudgetRequest {

    private int budgetId;

    private double balance;
}
