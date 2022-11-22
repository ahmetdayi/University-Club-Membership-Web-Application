package com.clubmembership.entity.dto;

import lombok.Data;

@Data
public class CreateEnrollRequest {

    private int memberId;

    private int clubId;
}
