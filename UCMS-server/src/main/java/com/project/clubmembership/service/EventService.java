package com.project.clubmembership.service;


import com.project.clubmembership.core.exception.CLubAlreadyArrangeEventAtTimeException;
import com.project.clubmembership.core.exception.ClubDoesntArrangeEventYetException;
import com.project.clubmembership.core.exception.EventDoesntExistException;
import com.project.clubmembership.core.exception.EventPlaceDoesntEmpty;
import com.project.clubmembership.core.constant.Constant;
import com.project.clubmembership.entity.Event;
import com.project.clubmembership.entity.dto.CreateEventRequest;
import com.project.clubmembership.entity.dto.UpdateEventRequest;
import com.project.clubmembership.repository.EventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepo eventRepo;

    private final ClubService clubService;


    public List<Event> getAll(int clubId){
       return eventRepo.getByClub_Id(clubId).orElseThrow(
                ()->new ClubDoesntArrangeEventYetException(Constant.CLUB_DOESNT_ARRANGE_EVENT_YET));
    }
    public Event create(CreateEventRequest request){
        Event event = new Event(
                request.getName(),request.getDatetime(),request.getEventPlace(),clubService.findById(request.getClubId()));
        dateControl(request.getDatetime());
        eventPlaceControl(request.getDatetime(),request.getEventPlace());
        return eventRepo.save(event);
    }

    public void deleteById(int id){
        eventRepo.deleteById(findById(id).getId());
    }

    public Event update(UpdateEventRequest request){
        Event event = findById(request.getId());
        event.setName(request.getName());
        event.setDatetime(request.getDateTime());
        event.setEventPlace(request.getEventPlace());
        return eventRepo.save(event);

    }
    public Event getById(int id){
        return findById(id);
    }
    private Event findById(int id){
        return eventRepo.findById(id).orElseThrow(()->new EventDoesntExistException(Constant.EVENT_DOESNT_EXIST));
    }

    private void eventPlaceControl(LocalDateTime dateTime,String eventPlace) {
        if(eventRepo.getByDatetimeAndEventPlace(dateTime,eventPlace).isPresent()){
            throw new EventPlaceDoesntEmpty(Constant.EVENT_PLACE_DOESNT_EMPTY);
        }

    }

    private void dateControl(LocalDateTime date) {
        if (eventRepo.getByDatetime(date).isPresent()){
            throw new CLubAlreadyArrangeEventAtTimeException(Constant.CLUB_ALREADY_ARRANGE_EVENT_AT_TIME);
        }
    }




}
