package com.project.clubmembership.entity.dto;

import lombok.Data;

@Data
public class DeleteEnrollClubRequest {

    private int clubId;

    private int memberId;
}
