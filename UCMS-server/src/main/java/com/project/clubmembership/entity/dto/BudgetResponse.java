package com.project.clubmembership.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetResponse {

    @NotNull
    private int id;

    @NotNull
    private double amount;
}
