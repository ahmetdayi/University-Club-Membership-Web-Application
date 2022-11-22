package com.clubmembership.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(mappedBy = "club", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Budget budget;

    @OneToOne(mappedBy = "club", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnrollClub> enrollClubs;

    public Club(String name, Budget budget, Member member) {
        this.name = name;
        this.budget = budget;
        this.member = member;
    }
}