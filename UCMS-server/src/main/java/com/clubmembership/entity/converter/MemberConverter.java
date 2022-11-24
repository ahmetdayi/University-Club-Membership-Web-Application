package com.clubmembership.entity.converter;

import com.clubmembership.entity.Member;
import com.clubmembership.entity.dto.MemberResponse;
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
