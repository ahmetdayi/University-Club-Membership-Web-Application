package com.clubmembership.service;


import com.clubmembership.core.exception.CLubAlreadyArrangeEventAtTimeException;
import com.clubmembership.core.exception.ClubDoesntArrangeEventYetException;
import com.clubmembership.core.exception.EventDoesntExistException;
import com.clubmembership.core.exception.EventPlaceDoesntEmpty;
import com.clubmembership.core.constant.Constant;
import com.clubmembership.entity.Event;
import com.clubmembership.entity.dto.CreateEventRequest;
import com.clubmembership.entity.dto.UpdateEventRequest;
import com.clubmembership.repository.EventRepo;
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
                request.getName(),request.getDate(),request.getEventPlace(),clubService.findById(request.getClubId()));
        dateControl(request.getDate());
        eventPlaceControl(request.getDate(),request.getEventPlace());
        return eventRepo.save(event);
    }

    public void deleteById(int id){
        eventRepo.deleteById(findById(id).getId());
    }

    public Event update(UpdateEventRequest request){
        Event event = findById(request.getId());
        event.setName(request.getName());
        event.setDatetime(request.getDate());
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
