package com.ahmetpoyraz.databaseproject.dataAccess.abstracts;

import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Event;

import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubsDao extends JpaRepository<Clubs,Integer> {
    Clubs getByClubId(int clubId);
    Clubs getByClubName(String clubName);


}
