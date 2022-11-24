package com.clubmembership.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private String department;
}
