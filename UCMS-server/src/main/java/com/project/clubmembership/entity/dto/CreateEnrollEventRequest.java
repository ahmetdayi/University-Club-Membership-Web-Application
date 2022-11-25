package com.project.clubmembership.entity.dto;

import lombok.Data;

@Data
public class CreateEnrollEventRequest {

    private int memberId;

    private int eventId;
}
