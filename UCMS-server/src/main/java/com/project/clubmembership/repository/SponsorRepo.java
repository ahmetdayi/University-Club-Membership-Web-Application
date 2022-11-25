package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SponsorRepo extends JpaRepository<Sponsor,Integer> {

    List<Sponsor> findByClubs_IdIn(List<Integer> clubId);
}
