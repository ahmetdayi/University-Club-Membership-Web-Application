package com.project.clubmembership.repository;

import com.project.clubmembership.entity.Club;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface ClubRepo extends MongoRepository<Club,Integer> {
   Optional<Club> findByNameIgnoreCase(String name);
   Optional<Club> findByMember_Id(int memberId);

   List<Club> findByIdIn(List<Integer> clubId);


}
