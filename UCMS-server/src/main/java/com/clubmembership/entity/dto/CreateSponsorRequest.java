package com.clubmembership.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateSponsorRequest {

    private String name;

    private List<Integer> clubId;
}
