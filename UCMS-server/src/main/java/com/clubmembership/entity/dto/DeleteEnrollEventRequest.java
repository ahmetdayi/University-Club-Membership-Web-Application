package com.clubmembership.entity.dto;

import lombok.Data;

@Data
public class DeleteEnrollEventRequest {
    private int memberId;

    private int eventId;
}
