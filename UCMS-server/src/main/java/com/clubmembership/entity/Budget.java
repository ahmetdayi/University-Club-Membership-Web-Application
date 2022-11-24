package com.clubmembership.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ida;

    private double amount;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Club club;




}
