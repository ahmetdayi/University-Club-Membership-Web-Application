package com.clubmembership.service;

import com.clubmembership.core.exception.BudgetDoesntExist;
import com.clubmembership.core.constant.Constant;
import com.clubmembership.entity.Budget;
import com.clubmembership.entity.dto.UpdateBudgetRequest;
import com.clubmembership.repository.BudgetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepo budgetRepo;


    public Budget create(){
        Budget budget = new Budget();
        return budgetRepo.save(budget);
    }

    public Budget update(UpdateBudgetRequest request){
        Budget budget = findById(request.getBudgetId());
        double amount = budget.getAmount()+ request.getBalance();
        budget.setAmount(amount);
       return budgetRepo.save(budget);
    }

    public Budget getById(int id){
        return findById(id);
    }

    private Budget findById(int id){
        return budgetRepo.findById(id).orElseThrow(()->new BudgetDoesntExist(Constant.BUDGET_DOESNT_EXIST));
    }
}
