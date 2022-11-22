package com.clubmembership.repository;

import com.clubmembership.entity.Club;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club,Integer> {
   Optional<Club> findByNameIgnoreCase(String name);
   Optional<Club> findByMember_Id(int id);


}
