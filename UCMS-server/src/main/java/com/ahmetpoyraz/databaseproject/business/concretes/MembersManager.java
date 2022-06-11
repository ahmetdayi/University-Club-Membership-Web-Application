package com.ahmetpoyraz.databaseproject.business.concretes;

import com.ahmetpoyraz.databaseproject.business.abstracts.MembersService;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessDataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessResult;
import com.ahmetpoyraz.databaseproject.dataAccess.abstracts.MembersDao;

import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Event;
import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import com.ahmetpoyraz.databaseproject.entities.dtos.ClubsWithMembersDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.MemberDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MembersManager implements MembersService {

    private MembersDao membersDao;
    private ModelMapper modelMapper;

    @Autowired
    public MembersManager(MembersDao membersDao,ModelMapper modelMapper) {
        this.membersDao = membersDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<Members>> getAll() {
        return new SuccessDataResult<List<Members>>
                (this.membersDao.findAll(),"Data listelendi");
    }

    @Modifying
    @Override
    public Result add(MemberDto memberDto) {

        Members member = modelMapper.map(memberDto, Members.class);

        modelMapper.map(this.membersDao.save(member), MemberDto.class);
        return new SuccessResult("JobSeeker added");
    }

    @Modifying
    @Override
    public Result update(Members members) {
        Members members1 = membersDao.getByMemberId(members.getMemberId());
        members1.setMemberName(members.getMemberName());
        members1.setPosition(members.getPosition());
        members1.setGender(members.getGender());
        members1.setDepartment(members.getDepartment());
        members1.setEmail(members.getEmail());
        membersDao.save(members1);
        return new SuccessResult("Member guncellendı");

    }
    @Modifying

    @Override
    public Result delete(Members members) {
        membersDao.deleteById(members.getMemberId());
        return new SuccessResult("Member silindi");
    }

    @Override
    public DataResult<Members> getByMemberId(int memberId) {
        return new SuccessDataResult<Members>
                (this.membersDao.getByMemberId(memberId),"Data listelendi");
    }

    @Override
    public DataResult<Members> getByMemberName(String memberName) {
        return new SuccessDataResult<Members>
                (this.membersDao.getByMemberName(memberName),"Data listelendi");
    }



    @Override
    public DataResult<List<Members>> getByClubIdIn(List<Integer> clubs) {
        return new SuccessDataResult<List<Members>>
                (this.membersDao.getByClubsIn(clubs),"Data listelendi");
    }

    @Override
    public DataResult<List<Members>> getByMemberNameContains(String memberName) {
        return new SuccessDataResult<List<Members>>
                (this.membersDao.getByMemberNameContains(memberName),"Data listelendi");
    }

    @Override
    public DataResult<List<Members>> getByMemberNameStartsWith(String memberName) {
        return new SuccessDataResult<List<Members>>
                (this.membersDao.getByMemberNameStartsWith(memberName),"Data listelendi");
    }
}
