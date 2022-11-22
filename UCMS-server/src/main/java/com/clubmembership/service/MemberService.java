package com.clubmembership.service;

import com.clubmembership.core.exception.ClubHasntMemberYetException;
import com.clubmembership.core.exception.MemberAlreadyExistException;
import com.clubmembership.core.exception.MemberDoesntExistException;
import com.clubmembership.core.exception.constant.Constant;
import com.clubmembership.entity.Member;
import com.clubmembership.entity.dto.CreateMemberRequest;
import com.clubmembership.entity.dto.UpdateMemberRequest;
import com.clubmembership.repository.MemberRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;

    protected Member findById(int id){
        return memberRepo.findById(id).orElseThrow(()->new MemberDoesntExistException(Constant.MEMBER_DOESNT_EXIST));
    }

    public Member getById(int id){
        return findById(id);
    }



    public Member create(CreateMemberRequest request){

        emailControl(request.getEmail());

        Member member = new Member
                (
                        request.getFirstName(),
                        request.getLastName(),
                        request.getGender(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getPasswordMatch(),
                        request.getDepartment()
                );
        return memberRepo.save(member);

    }

    public void deleteById(int id){
        memberRepo.deleteById(findById(id).getId());
    }

    public Member update(UpdateMemberRequest request){
        Member member = findById(request.getId());
        member.setFirstName(request.getFirstName());
        member.setLastName(request.getLastName());
        member.setDepartment(request.getDepartment());
        member.setGender(request.getGender());
        member.setPassword(request.getPassword());

        return memberRepo.save(member);

    }

    private void emailControl(String email) {
        if(memberRepo.getByEmail(email).isPresent()){
            throw new MemberAlreadyExistException(Constant.MEMBER_ALREADY_EXİST);
        }

    }


}
