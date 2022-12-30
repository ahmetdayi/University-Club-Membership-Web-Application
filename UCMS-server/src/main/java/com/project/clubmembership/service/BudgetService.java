package com.project.clubmembership.service;

import com.project.clubmembership.core.exception.BudgetDoesntExistException;
import com.project.clubmembership.core.constant.Constant;
import com.project.clubmembership.entity.Budget;
import com.project.clubmembership.entity.dto.UpdateBudgetRequest;
import com.project.clubmembership.repository.BudgetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepo budgetRepo;
    private final SequenceGeneratorService sequenceGeneratorService;


    public Budget create(){
        Budget budget = new Budget(sequenceGeneratorService.getSequenceNumber(Budget.SEQUENCE_NAME));
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
        return budgetRepo.findById(id).orElseThrow(()->new BudgetDoesntExistException(Constant.BUDGET_DOESNT_EXIST));
    }
}
