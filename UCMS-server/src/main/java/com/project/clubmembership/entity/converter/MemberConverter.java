package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.Member;
import com.project.clubmembership.entity.dto.ImageResponse;
import com.project.clubmembership.entity.dto.MemberResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public ImageResponse convertImage(Member from){
        return new ImageResponse(from.getImage().getImageId(), from.getImage().getUrl());
    }

    public List<ImageResponse> convertImage(List<Member> fromList){
        if (fromList == null){
            return null;
        }
        return fromList.stream().map(from->new ImageResponse(from.getImage().getImageId(), from.getImage().getUrl()))
                .collect(Collectors.toList());
    }
}
