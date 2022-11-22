package com.clubmembership.controller;


import com.clubmembership.service.MemberService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}
