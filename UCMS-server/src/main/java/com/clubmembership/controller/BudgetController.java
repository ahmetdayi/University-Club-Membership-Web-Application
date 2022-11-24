package com.clubmembership.controller;

import com.clubmembership.entity.converter.BudgetConverter;
import com.clubmembership.entity.dto.BudgetResponse;
import com.clubmembership.entity.dto.UpdateBudgetRequest;
import com.clubmembership.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    private final BudgetConverter budgetConverter;

    @PutMapping
    public ResponseEntity<BudgetResponse> addBalance(UpdateBudgetRequest request){
        return new ResponseEntity<>(budgetConverter.convert(budgetService.update(request)), HttpStatus.OK);
    }

    @GetMapping("/{budgetId}")
    public ResponseEntity<BudgetResponse> getById(@PathVariable int budgetId){
        return new ResponseEntity<>(budgetConverter.convert(budgetService.getById(budgetId)),HttpStatus.OK);
    }
}
