package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateEnrollEventRequest {

    @NotNull
    private int memberId;

    @NotNull
    private int eventId;
}
