package com.project.clubmembership.service;

import com.project.clubmembership.core.constant.Constant;
import com.project.clubmembership.core.exception.SponsorDoesntExistException;
import com.project.clubmembership.entity.Club;
import com.project.clubmembership.entity.Sponsor;
import com.project.clubmembership.entity.dto.CreateSponsorRequest;
import com.project.clubmembership.repository.SponsorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorService {

    private final ClubService clubService;

    private final SponsorRepo sponsorRepo;

    private final ImageService imageService;

    public List<Sponsor> getAll(List<Integer> clubId){
      return sponsorRepo.findByClubs_IdIn(clubId);
    }

    public Sponsor create(CreateSponsorRequest request){
        List<Club> byIdIn = clubService.getByIdIn(request.getClubId());
        Sponsor sponsor = new Sponsor(request.getName(), byIdIn);
        return sponsorRepo.save(sponsor);
    }

    public Sponsor addSponsorPhoto(MultipartFile multipartFile,int id){
        Sponsor sponsor = findById(id);
        sponsor.setImage(imageService.addImage(multipartFile));
        return sponsorRepo.save(sponsor);
    }

    public void delete(int id){
        sponsorRepo.deleteById(findById(id).getId());
    }

    private Sponsor findById(int id){
        return sponsorRepo.findById(id).orElseThrow(()-> new SponsorDoesntExistException(Constant.SPONSOR_DOESNT_EXIST));
    }

}
