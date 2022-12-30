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
public class EnrollClub {

    public static final String SEQUENCE_NAME="enrollClub_sequence";

    @Id
    private int id;

    @DocumentReference(collection = "member",lazy = true)
    private Member member;

    @DocumentReference(collection = "club",lazy = true)
    private Club club;

}
