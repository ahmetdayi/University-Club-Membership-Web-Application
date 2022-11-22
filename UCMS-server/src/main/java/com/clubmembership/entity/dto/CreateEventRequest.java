package com.clubmembership.entity.dto;

import com.clubmembership.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    private String name;

    private LocalDateTime date;

    private String eventPlace;

    private int clubId;


}
