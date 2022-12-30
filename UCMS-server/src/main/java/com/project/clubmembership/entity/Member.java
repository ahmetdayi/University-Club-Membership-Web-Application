package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    public static final String SEQUENCE_NAME="member_sequence";

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private String password;

    private String passwordMatch;

    private String department;


    private Role role;

    @DocumentReference(collection = "enrollClub",lazy = true)
    private List<EnrollClub> enrollClubs;


    private List<EnrollEvent> enrollEvents;


    private Club club;


    private Image image;

    public Member(int id,String firstName, String lastName, String gender, String email, String password, String passwordMatch, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.passwordMatch = passwordMatch;
        this.department = department;
        this.id=id;
    }
}
