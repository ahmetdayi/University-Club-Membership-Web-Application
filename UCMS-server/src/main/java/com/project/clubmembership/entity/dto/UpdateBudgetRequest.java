package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateBudgetRequest {

    @NotNull
    private int budgetId;

    private double balance;
}
