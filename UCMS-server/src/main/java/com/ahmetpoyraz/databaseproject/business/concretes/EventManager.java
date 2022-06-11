package com.ahmetpoyraz.databaseproject.business.concretes;

import com.ahmetpoyraz.databaseproject.business.abstracts.EventService;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessDataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessResult;
import com.ahmetpoyraz.databaseproject.dataAccess.abstracts.ClubsDao;
import com.ahmetpoyraz.databaseproject.dataAccess.abstracts.EventDao;
import com.ahmetpoyraz.databaseproject.dataAccess.abstracts.MembersDao;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Event;
import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import com.ahmetpoyraz.databaseproject.entities.dtos.ClubsDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.EventDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.MemberDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventManager implements EventService {

    private EventDao eventDao;
    private MembersDao membersDao;
    private ClubsDao clubsDao;
    private ModelMapper modelMapper;

    @Autowired
    public EventManager(EventDao eventDao,MembersDao membersDao,ClubsDao clubsDao,ModelMapper modelMapper) {
        this.eventDao = eventDao; this.membersDao= membersDao;this.modelMapper=modelMapper;this.clubsDao=clubsDao;
    }

    @Override
    public DataResult<List<Event>> getAll() {
        return new SuccessDataResult<List<Event>>
                (this.eventDao.findAll(),"Data listelendi");
    }

    @Modifying
    @Override
    public Result add(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);

        modelMapper.map(this.eventDao.save(event), EventDto.class);
        return new SuccessResult("JobSeeker added");
    }
    @Modifying
    @Override
    public Result update(Event event) {
        Event event1 = eventDao.getByEventId(event.getEventId());
        event1.setEventName(event.getEventName());
        return new SuccessResult("Event guncellendı");
    }
    @Modifying
    @Override
    public Result delete(Event event) {
        eventDao.deleteById(event.getEventId());
        return new SuccessResult("Event silindi");
    }

    @Modifying
    @Override
    public Result eventEnrolledMember(int memberId, int eventId) {
        Event event = eventDao.getByEventId(eventId);
        Members members = membersDao.getByMemberId(memberId);
        event.eventEnrollMembers(members);
        eventDao.save(event);
        return new SuccessResult("Event guncellendı");
    }

    @Override
    public Result enrolledClub(int eventId, int clubId) {
        Event event = eventDao.getByEventId(eventId);
        Clubs clubs = clubsDao.getByClubId(clubId);
        event.setClubs(clubs);
        clubsDao.save(clubs);
        return new SuccessResult("Club guncellendı");
    }


}
