package com.clubmembership.repository;

import com.clubmembership.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member,Integer> {

    Optional<List<Member>> getByClub_Id(int clubId);

   Optional<Member> getByEmail(String email);
}
