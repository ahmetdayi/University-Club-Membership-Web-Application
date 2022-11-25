package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateMemberRequest {

    @NotNull
    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    private String department;

    private String password;


}
