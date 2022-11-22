package com.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    private String name;

    private LocalDateTime datetime;

    private String eventPlace;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn
    private Club club;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "event")
    private List<EnrollEvent> enrollEvents;

    public Event(String name, LocalDateTime datetime,String eventPlace,Club club) {
        this.name = name;
        this.datetime = datetime;
        this.club=club;
        this.eventPlace=eventPlace;
    }
}
