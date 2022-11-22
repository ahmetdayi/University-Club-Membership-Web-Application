package com.clubmembership.repository;

import com.clubmembership.entity.EnrollEvent;
import com.clubmembership.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollEventRepo extends JpaRepository<EnrollEvent,Integer> {

    Optional<List<EnrollEvent>> getByMember_Id(int id);

    Optional<EnrollEvent> getByMember_IdAndEvent_Id(int memberId,int eventId);
}
