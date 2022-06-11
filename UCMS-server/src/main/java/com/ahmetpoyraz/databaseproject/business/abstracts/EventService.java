package com.ahmetpoyraz.databaseproject.business.abstracts;

import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Event;
import com.ahmetpoyraz.databaseproject.entities.dtos.EventDto;

import java.util.List;

public interface EventService {

    DataResult<List<Event>> getAll();
    Result eventEnrolledMember(int memberId,int eventId);

    Result enrolledClub(int eventId,int clubId);


    Result add(EventDto eventDto);
    Result update(Event event);
    Result delete(Event event);
}
