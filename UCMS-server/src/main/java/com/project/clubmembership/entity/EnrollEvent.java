package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document
public class EnrollEvent {

    public static final String SEQUENCE_NAME="enrollEvent_sequence";

    @Id
    private int id;

    @DocumentReference(collection = "member",lazy = true)
    private Member member;

    @DocumentReference(collection = "event",lazy = true)
    private Event event;

}
