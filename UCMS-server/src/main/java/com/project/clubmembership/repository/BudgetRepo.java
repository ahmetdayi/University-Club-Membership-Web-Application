package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Budget;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<Budget,Integer> {
}
