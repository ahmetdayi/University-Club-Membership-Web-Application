package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.Member;
import com.project.clubmembership.entity.dto.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter {

    public MemberResponse convert(Member member){
        return new MemberResponse
                (
                        member.getId(),
                        member.getFirstName(),
                        member.getLastName(),
                        member.getGender(),
                        member.getEmail(),
                        member.getDepartment()

                );
    }
}
