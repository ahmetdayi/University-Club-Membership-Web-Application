package com.clubmembership.entity.converter;

import com.clubmembership.entity.Club;
import com.clubmembership.entity.dto.ClubResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClubConverter {

    public ClubResponse convert(Club club){
        return new ClubResponse(
                club.getId(),
                club.getName(),
                club.getBudget());
    }

    public List<ClubResponse> convert(List<Club> fromList){
       return fromList.stream().
               map(club -> new ClubResponse(
                       club.getId(),
                       club.getName(),
                       club.getBudget())).collect(Collectors.toList());
    }
}
