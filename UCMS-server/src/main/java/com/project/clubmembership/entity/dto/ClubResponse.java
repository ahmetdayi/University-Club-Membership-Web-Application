package com.project.clubmembership.entity.dto;

import com.project.clubmembership.entity.Budget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClubResponse {

    private int id;

    private String name;

    private BudgetResponse budget;

    private MemberResponse member;
}