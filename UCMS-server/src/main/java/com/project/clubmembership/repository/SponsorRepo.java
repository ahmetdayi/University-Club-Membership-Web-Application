package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Sponsor;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface SponsorRepo extends MongoRepository<Sponsor,Integer> {

    List<Sponsor> findByClubs_IdIn(List<Integer> clubId);
}
