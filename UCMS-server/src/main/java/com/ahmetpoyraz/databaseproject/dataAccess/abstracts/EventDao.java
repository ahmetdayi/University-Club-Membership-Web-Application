package com.ahmetpoyraz.databaseproject.dataAccess.abstracts;

import com.ahmetpoyraz.databaseproject.entities.concretes.Event;
import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventDao extends JpaRepository<Event,Integer> {
    Event getByEventId(int eventId);

    Event getByEventName(String eventName);


}
