package com.project.clubmembership.controller;


import com.project.clubmembership.entity.converter.EnrollEventConverter;
import com.project.clubmembership.entity.dto.CreateEnrollEventRequest;
import com.project.clubmembership.entity.dto.DeleteEnrollEventRequest;
import com.project.clubmembership.entity.dto.EnrollEventResponse;
import com.project.clubmembership.service.EnrollEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollEvent")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EnrollEventController {

    private final EnrollEventService enrollEventService;

    private final EnrollEventConverter enrollEventConverter;

    @GetMapping("/{eventId}/member")
    public ResponseEntity<List<EnrollEventResponse>> getAll(@PathVariable int eventId){
        return new ResponseEntity<>(enrollEventConverter.convert(enrollEventService.getAll(eventId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollEventResponse> enroll(CreateEnrollEventRequest request){
        return new ResponseEntity<>(enrollEventConverter.convert(enrollEventService.enroll(request)),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody DeleteEnrollEventRequest request){
        enrollEventService.deleteMemberInEvent(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
