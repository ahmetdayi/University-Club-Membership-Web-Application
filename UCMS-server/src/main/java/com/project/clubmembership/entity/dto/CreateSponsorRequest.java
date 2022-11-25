package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateSponsorRequest {

    @NotBlank
    private String name;

    @NotNull
    private List<Integer> clubId;
}
