package com.project.clubmembership.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SponsorResponse {

    @NotNull
    private int id;

    @NotBlank
    private String companyName;
}
