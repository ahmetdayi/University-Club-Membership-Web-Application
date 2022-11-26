package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
            joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn
    )
    private List<Club> clubs;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Image image;

    public Sponsor(String companyName, List<Club> clubs) {
        this.companyName = companyName;
        this.clubs = clubs;
    }
}
