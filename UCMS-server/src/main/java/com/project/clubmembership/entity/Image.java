package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    private String url;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "image")
    private Club club;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "image")
    private Sponsor sponsor;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "image")
    private Member member;

    public Image(String url) {
        this.url = url;
    }
}