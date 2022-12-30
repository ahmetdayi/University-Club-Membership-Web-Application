package com.project.clubmembership.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Club {

    public static final String SEQUENCE_NAME="club_sequence";

    @Id
    private int id;

    private String name;

    @DocumentReference(collection = "budget",lazy = true)
    private Budget budget;
    @DocumentReference(collection = "member",lazy = true)
    private Member member;



    private List<Event> events;



    private List<EnrollClub> enrollClubs;

    @DocumentReference(collection = "image",lazy = true)
    private Image image;

    public Club(int id,String name, Budget budget, Member member) {
        this.name = name;
        this.budget = budget;
        this.member = member;
        this.id=id;
    }
}