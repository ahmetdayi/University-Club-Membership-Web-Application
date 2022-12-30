package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Member;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepo extends MongoRepository<Member, Integer> {

    Optional<List<Member>> getByClub_Id(int clubId);

   Optional<Member> getByEmail(String email);
}
