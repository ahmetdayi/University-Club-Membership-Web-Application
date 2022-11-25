package com.project.clubmembership.repository;

import com.project.clubmembership.entity.EnrollClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollClubRepo extends JpaRepository<EnrollClub,Integer> {

    Optional<EnrollClub> getByClub_Id(int clubId);

    Optional<EnrollClub> getByClub_IdAndMember_Id(int clubId,int memberId);
}
