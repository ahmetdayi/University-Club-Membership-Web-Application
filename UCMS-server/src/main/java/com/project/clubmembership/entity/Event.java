package com.project.clubmembership.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {


    public static final String SEQUENCE_NAME="event_sequence";
    @Id
    private int id;

    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd@HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;

    private String eventPlace;

    @DocumentReference(collection = "club",lazy = true)
    private Club club;

    @DocumentReference(collection = "enrollEvent",lazy = true)
    private List<EnrollEvent> enrollEvents;

    public Event(int id,String name, LocalDateTime datetime,String eventPlace,Club club) {
        this.name = name;
        this.datetime = datetime;
        this.club=club;
        this.eventPlace=eventPlace;
        this.id=id;
    }
}
