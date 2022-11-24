package com.clubmembership.entity.converter;

import com.clubmembership.entity.EnrollEvent;
import com.clubmembership.entity.dto.EnrollEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EnrollEventConverter {

    private final MemberConverter memberConverter;

    public EnrollEventResponse convert(EnrollEvent from){
        return new EnrollEventResponse
                (
                        from.getId(),
                        memberConverter.convert(from.getMember())
                );
    }

    public List<EnrollEventResponse> convert(List<EnrollEvent> fromList){
        return fromList.stream().map(enrollEvent -> new EnrollEventResponse
                (
                        enrollEvent.getId(),
                        memberConverter.convert(enrollEvent.getMember())
                )).collect(Collectors.toList());
    }
}
