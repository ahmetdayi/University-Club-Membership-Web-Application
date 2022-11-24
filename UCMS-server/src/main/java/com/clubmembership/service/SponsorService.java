package com.clubmembership.service;

import com.clubmembership.core.constant.Constant;
import com.clubmembership.core.exception.SponsorDoesntExistException;
import com.clubmembership.entity.Club;
import com.clubmembership.entity.Sponsor;
import com.clubmembership.entity.dto.CreateSponsorRequest;
import com.clubmembership.repository.SponsorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorService {

    private final ClubService clubService;

    private final SponsorRepo sponsorRepo;

    public List<Sponsor> getAll(List<Integer> clubId){
      return sponsorRepo.findByClubs_IdIn(clubId);
    }

    public Sponsor create(CreateSponsorRequest request){
        List<Club> byIdIn = clubService.getByIdIn(request.getClubId());
        Sponsor sponsor = new Sponsor(request.getName(), byIdIn);
        return sponsorRepo.save(sponsor);
    }

    private Sponsor findById(int id){
        return sponsorRepo.findById(id).orElseThrow(()-> new SponsorDoesntExistException(Constant.SPONSOR_DOESNT_EXIST));
    }

    public void delete(int id){
        sponsorRepo.deleteById(findById(id).getId());
    }

}
