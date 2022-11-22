package com.clubmembership.service;

import com.clubmembership.core.exception.ClubDoesntExistException;
import com.clubmembership.core.exception.ClubIsAlreadyExistException;
import com.clubmembership.core.exception.MemberAlreadyCreateClub;
import com.clubmembership.core.exception.constant.Constant;
import com.clubmembership.entity.Budget;
import com.clubmembership.entity.Club;
import com.clubmembership.entity.Member;
import com.clubmembership.entity.dto.ClubCreateRequest;
import com.clubmembership.repository.ClubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepo clubRepo;
    private final BudgetService budgetService;
    private final MemberService memberService;


    public List<Club> getAll(){
        return clubRepo.findAll();
    }
    protected Club findById(int id){
        return clubRepo.findById(id).orElseThrow(()-> new ClubDoesntExistException(Constant.CLUB_DOESNT_EXIST));
    }

    public Club getById(int id){
        return findById(id);
    }

    public Club create(ClubCreateRequest clubCreateRequest){
        Budget budget = budgetService.create();
        clubIsAlreadyExist(clubCreateRequest.getName());
        clubAdminAlreadyCreateClub(clubCreateRequest.getClubAdminId());
        Member clubAdmin = memberService.getById(clubCreateRequest.getClubAdminId());
        Club club = new Club(clubCreateRequest.getName(),budget,clubAdmin);
        return clubRepo.save(club);
    }
    public void deleteById(int id){
        clubRepo.deleteById(findById(id).getId());
    }

    private void clubIsAlreadyExist(String name) {
        if (clubRepo.findByNameIgnoreCase(name).isPresent()){
            throw new ClubIsAlreadyExistException(Constant.CLUB_IS_ALREADY_EXIST);
        }
    }

    private void clubAdminAlreadyCreateClub(int clubAdminId) {
        if(clubRepo.findByMember_Id(clubAdminId).isPresent()){
            throw new MemberAlreadyCreateClub(Constant.MEMBER_ALREADY_CREATE_CLUB);
        }
    }





}
