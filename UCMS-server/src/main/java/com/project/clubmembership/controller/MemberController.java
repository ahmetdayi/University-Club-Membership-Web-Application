package com.project.clubmembership.controller;


import com.project.clubmembership.entity.converter.MemberConverter;
import com.project.clubmembership.entity.dto.CreateMemberRequest;
import com.project.clubmembership.entity.dto.ImageResponse;
import com.project.clubmembership.entity.dto.MemberResponse;
import com.project.clubmembership.entity.dto.UpdateMemberRequest;
import com.project.clubmembership.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MemberConverter memberConverter;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getById(@PathVariable int memberId){
        return new ResponseEntity<>(memberConverter.convert(memberService.getById(memberId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MemberResponse> create(CreateMemberRequest request){
        return new ResponseEntity<>(memberConverter.convert(memberService.create(request)),HttpStatus.CREATED);
    }

    @PostMapping("/addImage")
    public ResponseEntity<ImageResponse> addImage(@Valid @RequestParam("file") MultipartFile multipartFile,
                                                 @Valid @RequestParam("id") int id){
        return new ResponseEntity<>(memberConverter.convertImage
                (memberService.addProfilPhoto(multipartFile, id)),HttpStatus.CREATED);
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
