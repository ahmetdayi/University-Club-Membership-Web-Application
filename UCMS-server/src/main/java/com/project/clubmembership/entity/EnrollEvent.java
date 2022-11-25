package com.project.clubmembership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class EnrollEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Event event;

    public EnrollEvent(Member member, Event event) {
        this.member = member;
        this.event = event;
    }
}
