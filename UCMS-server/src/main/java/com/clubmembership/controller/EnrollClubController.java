package com.clubmembership.controller;


import com.clubmembership.entity.converter.EnrollClubConverter;
import com.clubmembership.entity.dto.CreateEnrollClubRequest;
import com.clubmembership.entity.dto.DeleteEnrollClubRequest;
import com.clubmembership.entity.dto.EnrollClubResponse;
import com.clubmembership.service.EnrollClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollClub")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EnrollClubController {

    private final EnrollClubService enrollClubService;

    private final EnrollClubConverter enrollClubConverter;

    @GetMapping("/{clubId}/clubMember")
    public ResponseEntity<EnrollClubResponse> getAll(@PathVariable int clubId){
        return new ResponseEntity<>(enrollClubConverter.convert(enrollClubService.getAll(clubId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollClubResponse> enroll(CreateEnrollClubRequest request){
        return new ResponseEntity<>(enrollClubConverter.convert(enrollClubService.enroll(request)),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody DeleteEnrollClubRequest request){
        enrollClubService.deleteMemberInClub(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
