package com.ahmetpoyraz.databaseproject.business.abstracts;

import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.dtos.ClubsDto;


import java.util.List;

public interface ClubsService {
    DataResult<List<Clubs>> getAll();
    DataResult<Clubs> getByClubId(int clubId);
    Result enrolledMember(int memberId,int clubId);
//    Result UnenrolledMember(int memberId,int clubId);



//    Result add(int memberId,int clubId);
    Result add(ClubsDto clubsAddDto);
    Result update(Clubs clubs);
    Result delete(int clubId);
}
