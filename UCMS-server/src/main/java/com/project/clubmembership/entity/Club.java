package com.project.clubmembership.entity;


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

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Budget budget;

    @OneToOne( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;


    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    //delete yaptıgımda enroll clubın ıcınde ılıskılendırdıgım her sey sılınıyor.
    @OneToMany(mappedBy = "club", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<EnrollClub> enrollClubs;

    public Club(String name, Budget budget, Member member) {
        this.name = name;
        this.budget = budget;
        this.member = member;
    }
}