package com.clubmembership.repository;

import com.clubmembership.entity.Budget;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<Budget,Integer> {
}
