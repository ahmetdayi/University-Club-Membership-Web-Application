package com.ahmetpoyraz.databaseproject.api.controller;


import com.ahmetpoyraz.databaseproject.business.abstracts.MembersService;
import com.ahmetpoyraz.databaseproject.core.entities.User;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessDataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessResult;
import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import com.ahmetpoyraz.databaseproject.entities.dtos.ClubsWithMembersDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MembersController {

    private MembersService membersService;

    @Autowired
    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping("/getall")
    public DataResult<List<Members>> getAll() {
        return this.membersService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody MemberDto members) {
        Result res = this.membersService.add(members);
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.badRequest().body(res);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Members members) {
        return this.membersService.delete(members);

    }

    @PostMapping("/update")
    public Result update(@RequestBody Members members) {
        return this.membersService.update(members);

    }

    @GetMapping("/getByMemberName")
    public DataResult<Members> getByMemberName(@RequestParam String memberName) {
        return this.membersService.getByMemberName(memberName);
    }
    @GetMapping("/getByMemberId")
    public DataResult<Members> getByMemberId(@RequestParam int memberId) {
        return this.membersService.getByMemberId(memberId);
    }


    @GetMapping("/getByClubIdIn")
    public DataResult<List<Members>> getByClubIdIn(List<Integer> clubs) {
        return this.membersService.getByClubIdIn(clubs);
    }

    @GetMapping("/getByMemberNameContains")
    public DataResult<List<Members>> getByMemberNameContains(@RequestParam String memberName) {
        return this.membersService.getByMemberNameContains(memberName);
    }

    @GetMapping("/getByMemberNameStartsWith")
    public DataResult<List<Members>> getByMemberNameStartsWith(@RequestParam String memberName) {
        return this.membersService.getByMemberNameStartsWith(memberName);
    }



}
