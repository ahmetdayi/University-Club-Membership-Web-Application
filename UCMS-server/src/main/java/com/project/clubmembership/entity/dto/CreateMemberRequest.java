package com.project.clubmembership.entity.dto;

import com.project.clubmembership.core.validator.PasswordMatches;
import com.project.clubmembership.core.validator.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@PasswordMatches
public class CreateMemberRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;

    @NotBlank
    @Email(regexp = ".+@.+\\..+")
    private String email;

    @NotBlank
    private String department;

    @NotBlank
    @ValidPassword
    private String password;

    @NotBlank
    private String passwordMatch;



}
