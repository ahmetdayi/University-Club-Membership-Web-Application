package com.ahmetpoyraz.databaseproject.business.abstracts;

import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import com.ahmetpoyraz.databaseproject.entities.dtos.ClubsWithMembersDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.MemberDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MembersService {
    DataResult<List<Members>> getAll();

    Result add(MemberDto memberDto);
    Result update(Members members);
    Result delete(Members members);

    DataResult<Members> getByMemberId(int memberId);
    DataResult<Members> getByMemberName(String memberName);



    DataResult<List<Members>> getByClubIdIn(List<Integer> clubs);

    DataResult<List<Members>> getByMemberNameContains(String memberName);

    DataResult<List<Members>> getByMemberNameStartsWith(String memberName);


}
