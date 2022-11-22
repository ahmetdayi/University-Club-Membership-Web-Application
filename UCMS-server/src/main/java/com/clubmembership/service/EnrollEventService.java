package com.clubmembership.service;

import com.clubmembership.core.exception.MemberAlreadyEnrollEvent;
import com.clubmembership.core.exception.MemberDoesntEnrollEventYetException;
import com.clubmembership.core.exception.constant.Constant;
import com.clubmembership.entity.EnrollEvent;
import com.clubmembership.entity.dto.CreateEnrollEventRequest;
import com.clubmembership.entity.dto.DeleteEnrollEventRequest;
import com.clubmembership.repository.EnrollEventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollEventService {

    private final EnrollEventRepo enrollEventRepo;

    private final MemberService memberService;

    private final EventService eventService;

    public List<EnrollEvent> getAll(int memberId){

        return enrollEventRepo.
                getByMember_Id(memberService.getById(memberId).getId()).orElseThrow(
                        ()-> new MemberDoesntEnrollEventYetException(Constant.MEMBER_DOESNT_ENROLL_EVENT_YET));
    }

    public void enroll(CreateEnrollEventRequest request){

        eventMemberControl(request.getEventId(),request.getMemberId());
        EnrollEvent enrollEvent = new EnrollEvent(
                memberService.getById(request.getMemberId()),eventService.getById(request.getEventId()));

        enrollEventRepo.save(enrollEvent);

    }

    public void deleteMemberInEvent(DeleteEnrollEventRequest request){
        Optional<EnrollEvent> byMember_idAndEvent_id = enrollEventRepo.getByMember_IdAndEvent_Id(
                memberService.getById(request.getMemberId()).getId(),
                eventService.getById(request.getEventId()).getId());
        byMember_idAndEvent_id.ifPresent(enrollEvent-> enrollEventRepo.deleteById(enrollEvent.getId()));
    }

    private void eventMemberControl(int eventId, int memberId) {
        Optional<EnrollEvent> byMember_idAndEvent_id = enrollEventRepo.getByMember_IdAndEvent_Id(
                memberService.getById(memberId).getId(), eventService.getById(eventId).getId());

        if(byMember_idAndEvent_id.isPresent()){
            throw new MemberAlreadyEnrollEvent(Constant.MEMBER_ALREADY_ENROLL_Event);
        }
    }
}
