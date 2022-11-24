package com.clubmembership.entity.converter;

import com.clubmembership.entity.Budget;
import com.clubmembership.entity.dto.BudgetResponse;
import org.springframework.stereotype.Component;

@Component
public class BudgetConverter {

    public BudgetResponse convert(Budget from){
        return new BudgetResponse(from.getId(), from.getAmount());
    }
}
