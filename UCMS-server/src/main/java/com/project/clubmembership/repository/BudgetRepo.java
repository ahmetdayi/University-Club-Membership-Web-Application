package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Budget;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BudgetRepo extends MongoRepository<Budget,Integer> {

    Optional<Budget> findById(int id);
}
