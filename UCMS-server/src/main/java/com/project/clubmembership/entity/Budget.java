package com.project.clubmembership.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

    public static final String SEQUENCE_NAME="budget_sequence";

    @Id
    private int id;

    private double amount;


    private Club club;

    public Budget(int id) {
        this.id = id;
    }
}
