package com.project.clubmembership.controller;

import com.project.clubmembership.entity.converter.ClubConverter;
import com.project.clubmembership.entity.dto.CreateClubRequest;
import com.project.clubmembership.entity.dto.ClubResponse;
import com.project.clubmembership.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    private final ClubConverter clubConverter;

    @GetMapping
    public ResponseEntity<List<ClubResponse>> getAll(){
        return new ResponseEntity<>(clubConverter.convert(clubService.getAll()), HttpStatus.OK);

    }

    @GetMapping("/{clubId}")
    public ResponseEntity<ClubResponse> getById(@PathVariable int clubId){
        return new ResponseEntity<>(clubConverter.convert(clubService.getById(clubId)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClubResponse> create(@RequestBody CreateClubRequest request){
        return new ResponseEntity<>(clubConverter.convert(clubService.create(request)),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("clubId") int clubId){
        clubService.deleteById(clubId);
       return new ResponseEntity<>(HttpStatus.OK);
    }





}
