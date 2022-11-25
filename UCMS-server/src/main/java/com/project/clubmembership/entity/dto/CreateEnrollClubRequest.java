package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateEnrollClubRequest {

    @NotNull
    private int memberId;

    @NotNull
    private int clubId;
}
