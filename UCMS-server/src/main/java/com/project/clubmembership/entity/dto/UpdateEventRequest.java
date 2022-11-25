package com.project.clubmembership.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class UpdateEventRequest {

    @NotNull
    private int id;

    private String name;

    private String eventPlace;

    private LocalDateTime dateTime;
}
