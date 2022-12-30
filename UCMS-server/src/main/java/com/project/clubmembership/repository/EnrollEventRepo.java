package com.project.clubmembership.repository;

import com.project.clubmembership.entity.EnrollEvent;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollEventRepo extends MongoRepository<EnrollEvent,Integer> {

    Optional<List<EnrollEvent>> getByEvent_Id(int id);

    Optional<EnrollEvent> getByMember_IdAndEvent_Id(int memberId,int eventId);
}
