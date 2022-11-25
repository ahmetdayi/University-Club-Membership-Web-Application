package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.EnrollClub;
import com.project.clubmembership.entity.dto.EnrollClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EnrollClubConverter {

    private final MemberConverter memberConverter;

    public EnrollClubResponse convert(EnrollClub from){
        return new EnrollClubResponse(from.getId(),memberConverter.convert(from.getMember()));
    }

    public List<EnrollClubResponse> convert(List<EnrollClub> fromList){
        return fromList.stream().map(enrollClub -> new EnrollClubResponse
                (
                        enrollClub.getId(),
                        memberConverter.convert(enrollClub.getMember())
                )).collect(Collectors.toList());
    }
}
