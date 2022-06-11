package com.ahmetpoyraz.databaseproject.entities.dtos;

import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubsWithMembersDto {



    private int memberId;

    private String memberName;

    private String gender;


    private String email;


    private String department;


    private String position;

    private int clubId;

    private int eventId;



}
