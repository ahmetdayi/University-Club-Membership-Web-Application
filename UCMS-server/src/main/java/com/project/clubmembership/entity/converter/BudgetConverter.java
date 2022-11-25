package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.Budget;
import com.project.clubmembership.entity.dto.BudgetResponse;
import org.springframework.stereotype.Component;

@Component
public class BudgetConverter {

    public BudgetResponse convert(Budget from){
        return new BudgetResponse(from.getId(), from.getAmount());
    }
}
