package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<Event,Integer> {
    Optional<Event> getByDatetimeAndEventPlace(LocalDateTime dateTime,String eventPlace);


    Optional<Event> getByDatetime(LocalDateTime date);

    Optional<List<Event>> getByClub_Id(int clubId);
}
