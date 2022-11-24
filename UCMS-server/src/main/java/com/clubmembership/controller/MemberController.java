package com.clubmembership.controller;


import com.clubmembership.entity.converter.MemberConverter;
import com.clubmembership.entity.dto.CreateMemberRequest;
import com.clubmembership.entity.dto.MemberResponse;
import com.clubmembership.entity.dto.UpdateMemberRequest;
import com.clubmembership.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MemberConverter memberConverter;

    @GetMapping
    public ResponseEntity<MemberResponse> getById(@PathVariable int memberId){
        return new ResponseEntity<>(memberConverter.convert(memberService.getById(memberId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MemberResponse> create(CreateMemberRequest request){
        return new ResponseEntity<>(memberConverter.convert(memberService.create(request)),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MemberResponse> update(UpdateMemberRequest request){
        return new ResponseEntity<>(memberConverter.convert(memberService.update(request)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int memberId){
        memberService.deleteById(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
