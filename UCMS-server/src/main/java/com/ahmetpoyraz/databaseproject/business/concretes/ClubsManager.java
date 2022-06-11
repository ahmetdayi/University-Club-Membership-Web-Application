package com.ahmetpoyraz.databaseproject.business.concretes;

import com.ahmetpoyraz.databaseproject.business.abstracts.ClubsService;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessDataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessResult;
import com.ahmetpoyraz.databaseproject.dataAccess.abstracts.ClubsDao;
import com.ahmetpoyraz.databaseproject.dataAccess.abstracts.MembersDao;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import com.ahmetpoyraz.databaseproject.entities.dtos.ClubsDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.MemberDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubsManager implements ClubsService {

    private ClubsDao clubsDao;
    private MembersDao membersDao;
    private ModelMapper modelMapper;


    @Autowired
    public ClubsManager(ClubsDao clubsDao,MembersDao membersDao,ModelMapper modelMapper) {
        this.clubsDao = clubsDao; this.membersDao = membersDao;this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<Clubs>> getAll() {
        return new SuccessDataResult<List<Clubs>>
                (this.clubsDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<Clubs> getByClubId(int clubId) {
        return new SuccessDataResult<Clubs>
                (this.clubsDao.getByClubId(clubId),"Data listelendi");
    }
    @Modifying
    @Override
    public Result enrolledMember(int memberId, int clubId) {
       Clubs clubs = clubsDao.getByClubId(clubId);
       Members members = membersDao.getByMemberId(memberId);
       clubs.enrollMembers(members);
       clubsDao.save(clubs);
        return new SuccessResult("Club guncellendı");
    }


    @Modifying
    @Override
    public Result add(ClubsDto clubsDto) {

        Clubs clubs = modelMapper.map(clubsDto, Clubs.class);

        modelMapper.map(this.clubsDao.save(clubs), ClubsDto.class);
        return new SuccessResult("JobSeeker added");
    }
    @Modifying
    @Override
    public Result update(Clubs clubs) {
        Clubs clubs1 = clubsDao.getByClubId(clubs.getClubId());
        clubs1.setClubName(clubs.getClubName());
        clubsDao.save(clubs1);
        return new SuccessResult("Club guncellendı");
    }
    @Modifying
    @Override
    public Result delete(int clubId) {
        clubsDao.deleteById(clubId);
        return new SuccessResult("Club silindi");
    }
}
