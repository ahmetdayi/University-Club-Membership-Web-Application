package com.clubmembership.repository;

import com.clubmembership.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SponsorRepo extends JpaRepository<Sponsor,Integer> {

    List<Sponsor> findByClubs_IdIn(List<Integer> clubId);
}
