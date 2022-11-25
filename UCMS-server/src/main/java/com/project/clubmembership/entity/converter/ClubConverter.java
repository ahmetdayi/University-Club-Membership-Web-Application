package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.Club;
import com.project.clubmembership.entity.dto.ClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ClubConverter {

    private final MemberConverter memberConverter;

    private final BudgetConverter budgetConverter;

    public ClubResponse convert(Club club){
        return new ClubResponse(
                club.getId(),
                club.getName(),
                budgetConverter.convert(club.getBudget()),
                memberConverter.convert( club.getMember()));
    }

    public List<ClubResponse> convert(List<Club> fromList){
       return fromList.stream().
               map(club -> new ClubResponse(
                       club.getId(),
                       club.getName(),
                       budgetConverter.convert(club.getBudget()),
                       memberConverter.convert( club.getMember())
               )).collect(Collectors.toList());
    }
}
