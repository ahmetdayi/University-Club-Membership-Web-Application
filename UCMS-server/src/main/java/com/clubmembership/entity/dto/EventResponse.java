package com.clubmembership.entity.dto;

import com.clubmembership.entity.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

    private int id;

    private String name;

    private LocalDateTime datetime;

    private String eventPlace;

}
