package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Sponsor {


    public static final String SEQUENCE_NAME="sponsor_sequence";
    @Id
    private int id;

    private String companyName;

    @DocumentReference(collection = "club",lazy = true)
    private List<Club> clubs;

    @DocumentReference(collection = "image",lazy = true)
    private Image image;

    public Sponsor(int id,String companyName, List<Club> clubs) {
        this.companyName = companyName;
        this.clubs = clubs;
        this.id=id;
    }
}
