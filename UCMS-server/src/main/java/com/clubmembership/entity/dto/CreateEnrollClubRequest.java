package com.clubmembership.entity.dto;

import lombok.Data;

@Data
public class CreateEnrollClubRequest {

    private int memberId;

    private int clubId;
}
