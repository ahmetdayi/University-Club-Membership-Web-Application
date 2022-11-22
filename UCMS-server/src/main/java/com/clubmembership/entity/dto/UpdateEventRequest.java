package com.clubmembership.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateEventRequest {

    private int id;

    private String name;

    private String eventPlace;

    private LocalDateTime date;
}
