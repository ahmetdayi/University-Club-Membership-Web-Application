package com.clubmembership.controller;


import com.clubmembership.entity.converter.SponsorConverter;
import com.clubmembership.entity.dto.CreateSponsorRequest;
import com.clubmembership.entity.dto.SponsorResponse;
import com.clubmembership.service.SponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sponsor")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SponsorController {

    private final SponsorService sponsorService;

    private final SponsorConverter sponsorConverter;


    @GetMapping("/{clubId}/sponsor")
    public ResponseEntity<List<SponsorResponse>> getAll(@PathVariable List<Integer> clubId){
        return new ResponseEntity<>(sponsorConverter.convert(sponsorService.getAll(clubId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SponsorResponse> create(CreateSponsorRequest request){
        return new ResponseEntity<>(sponsorConverter.convert(sponsorService.create(request)),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int sponsorId){
        sponsorService.delete(sponsorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
