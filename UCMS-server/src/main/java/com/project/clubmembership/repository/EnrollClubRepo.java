package com.project.clubmembership.repository;

import com.project.clubmembership.entity.EnrollClub;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EnrollClubRepo extends MongoRepository<EnrollClub,Integer> {

    Optional<EnrollClub> getByClub_Id(int clubId);

    Optional<EnrollClub> getByClub_IdAndMember_Id(int clubId,int memberId);
}
