package com.project.clubmembership.service;

import com.project.clubmembership.core.exception.ClubHasntMemberYetException;
import com.project.clubmembership.core.exception.MemberAlreadyEnrollClubException;
import com.project.clubmembership.core.constant.Constant;
import com.project.clubmembership.entity.Club;
import com.project.clubmembership.entity.EnrollClub;
import com.project.clubmembership.entity.Member;
import com.project.clubmembership.entity.dto.CreateEnrollClubRequest;
import com.project.clubmembership.entity.dto.DeleteEnrollClubRequest;
import com.project.clubmembership.repository.EnrollClubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EnrollClubService {

    private final EnrollClubRepo enrollClubRepo;
    private final ClubService clubService;

    private final MemberService memberService;
    private final SequenceGeneratorService sequenceGeneratorService;

    //sadece ıd ve memberı donmek yeterlı olacak
    public EnrollClub getAll(int clubId) {
        return enrollClubRepo.getByClub_Id(clubService.getById(clubId).getId()).orElseThrow(
                () -> new ClubHasntMemberYetException(Constant.CLUB_HAS_NOT_MEMBER_YET));
    }

    public EnrollClub enroll(CreateEnrollClubRequest request) {
        clubMemberControl(request.getMemberId(), request.getClubId());
        Member member = memberService.getById(request.getMemberId());
        Club club = clubService.getById(request.getClubId());

        EnrollClub enrollClub = new EnrollClub
                (
                        sequenceGeneratorService.getSequenceNumber(EnrollClub.SEQUENCE_NAME),
                        member,
                        club
                );
        member.setEnrollClubs(List.of(enrollClub));

        return enrollClubRepo.save(enrollClub);
    }

    public void deleteMemberInClub(DeleteEnrollClubRequest request) {
        Optional<EnrollClub> byClub_idAndMember_id =
                enrollClubRepo.getByClub_IdAndMember_Id(request.getClubId(), request.getMemberId());
        byClub_idAndMember_id.ifPresent(enrolledClub -> enrollClubRepo.deleteById(enrolledClub.getId()));
    }

    private void clubMemberControl(int memberId, int clubId) {
        Optional<EnrollClub> byClub_idAndMember_id = enrollClubRepo.getByClub_IdAndMember_Id
                (clubService.getById(clubId).getId(), memberService.getById(memberId).getId());

        if (byClub_idAndMember_id.isPresent()) {
            throw new MemberAlreadyEnrollClubException(Constant.MEMBER_ALREADY_ENROLL_CLUB);
        }
    }


}
