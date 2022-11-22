package com.clubmembership.service;

import com.clubmembership.core.exception.ClubHasntMemberYetException;
import com.clubmembership.core.exception.MemberAlreadyEnrollClubException;
import com.clubmembership.core.exception.constant.Constant;
import com.clubmembership.entity.EnrollClub;
import com.clubmembership.entity.dto.CreateEnrollRequest;
import com.clubmembership.entity.dto.DeleteEnrollClubRequest;
import com.clubmembership.repository.EnrollClubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EnrollClubService {

    private final EnrollClubRepo enrollClubRepo;
    private final ClubService clubService;

    private final MemberService memberService;

    //sadece ıd ve memberı donmek yeterlı olacak
    public EnrollClub getAll(int clubId){
        return enrollClubRepo.getByClub_Id(clubService.getById(clubId).getId()).orElseThrow(
                ()-> new ClubHasntMemberYetException(Constant.CLUB_HAS_NOT_MEMBER_YET));
    }

    public void enroll(CreateEnrollRequest request){
        clubMemberControl(request.getMemberId(),request.getClubId());
        EnrollClub enrollClub = new EnrollClub(
                memberService.getById(request.getMemberId()),clubService.getById(request.getClubId()));
        enrollClubRepo.save(enrollClub);
    }

    public void deleteMemberInClub(DeleteEnrollClubRequest request){
        Optional<EnrollClub> byClub_idAndMember_id =
                enrollClubRepo.getByClub_IdAndMember_Id(request.getClubId(), request.getMemberId());
        byClub_idAndMember_id.ifPresent(enrollClub -> enrollClubRepo.deleteById(enrollClub.getId()));
    }

    private void clubMemberControl(int memberId, int clubId) {
        Optional<EnrollClub> byClub_idAndMember_id = enrollClubRepo.getByClub_IdAndMember_Id
                (clubService.getById(clubId).getId(), memberService.getById(memberId).getId());

        if(byClub_idAndMember_id.isPresent()){
            throw new MemberAlreadyEnrollClubException(Constant.MEMBER_ALREADY_ENROLL_CLUB);
        }
    }


}
