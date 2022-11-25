package com.project.clubmembership.entity.dto;

import lombok.Data;

@Data
public class CreateMemberRequest {

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private String department;

    private String password;

    private String passwordMatch;



}
