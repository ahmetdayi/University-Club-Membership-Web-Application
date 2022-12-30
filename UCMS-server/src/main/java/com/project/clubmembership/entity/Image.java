package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Image {

    public static final String SEQUENCE_NAME="image_sequence";

    @Id
    private int imageId;

    private String url;

    @DocumentReference(collection = "club",lazy = true)
    private Club club;

    @DocumentReference(collection = "sponsor",lazy = true)
    private Sponsor sponsor;

    @DocumentReference(collection = "member",lazy = true)
    private Member member;

    public Image(int id,String url) {
        this.url = url;
        this.imageId=id;
    }
}