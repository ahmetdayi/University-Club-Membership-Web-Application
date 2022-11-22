package com.clubmembership.entity.dto;

import lombok.Data;

@Data
public class UpdateMemberRequest {

    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    private String department;

    private String password;


}
