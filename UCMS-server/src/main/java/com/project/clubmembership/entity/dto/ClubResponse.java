package com.project.clubmembership.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClubResponse {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    private BudgetResponse budget;

    private MemberResponse member;
}
