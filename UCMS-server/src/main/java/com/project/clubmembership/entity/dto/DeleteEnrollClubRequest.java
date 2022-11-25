package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteEnrollClubRequest {

    @NotNull
    private int clubId;

    @NotNull
    private int memberId;
}
