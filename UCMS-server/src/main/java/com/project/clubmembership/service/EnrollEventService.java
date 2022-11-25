package com.project.clubmembership.service;

import com.project.clubmembership.core.exception.MemberAlreadyEnrollEvent;
import com.project.clubmembership.core.exception.MemberDoesntEnrollEventYetException;
import com.project.clubmembership.core.constant.Constant;
import com.project.clubmembership.entity.EnrollEvent;
import com.project.clubmembership.entity.dto.CreateEnrollEventRequest;
import com.project.clubmembership.entity.dto.DeleteEnrollEventRequest;
import com.project.clubmembership.repository.EnrollEventRepo;
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

    public List<EnrollEvent> getAll(int eventId){

        return enrollEventRepo.
                getByEvent_Id(eventService.getById(eventId).getId()).orElseThrow(
                        ()-> new MemberDoesntEnrollEventYetException(Constant.MEMBER_DOESNT_ENROLL_EVENT_YET));
    }

    public EnrollEvent enroll(CreateEnrollEventRequest request){

        eventMemberControl(request.getEventId(),request.getMemberId());

        EnrollEvent enrollEvent = new EnrollEvent(
                memberService.getById(request.getMemberId()),eventService.getById(request.getEventId()));

        return enrollEventRepo.save(enrollEvent);

    }

    public void deleteMemberInEvent(DeleteEnrollEventRequest request){
        Optional<EnrollEvent> byMember_idAndEvent_id = enrollEventRepo.getByMember_IdAndEvent_Id(
                memberService.getById(request.getMemberId()).getId(),
                eventService.getById(request.getEventId()).getId());
        byMember_idAndEvent_id.ifPresent(enrolledEvent-> enrollEventRepo.deleteById(enrolledEvent.getId()));
    }

    private void eventMemberControl(int eventId, int memberId) {
        Optional<EnrollEvent> byMember_idAndEvent_id = enrollEventRepo.getByMember_IdAndEvent_Id(
                memberService.getById(memberId).getId(), eventService.getById(eventId).getId());

        if(byMember_idAndEvent_id.isPresent()){
            throw new MemberAlreadyEnrollEvent(Constant.MEMBER_ALREADY_ENROLL_Event);
        }
    }
}
