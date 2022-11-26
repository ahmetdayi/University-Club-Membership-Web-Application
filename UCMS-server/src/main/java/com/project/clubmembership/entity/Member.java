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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private String password;

    private String passwordMatch;

    private String department;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "member")
    private List<EnrollClub> enrollClubs;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "member")
    private List<EnrollEvent> enrollEvents;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "member")
    private Club club;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Image image;

    public Member(String firstName, String lastName, String gender, String email, String password, String passwordMatch, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.passwordMatch = passwordMatch;
        this.department = department;
    }
}
