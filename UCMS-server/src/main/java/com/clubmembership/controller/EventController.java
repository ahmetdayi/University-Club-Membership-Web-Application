package com.clubmembership.controller;


import com.clubmembership.entity.converter.EventConverter;
import com.clubmembership.entity.dto.CreateEventRequest;
import com.clubmembership.entity.dto.EventResponse;
import com.clubmembership.entity.dto.UpdateEventRequest;
import com.clubmembership.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    private final EventConverter eventConverter;

    @GetMapping("/{clubId}/events")
    public ResponseEntity<List<EventResponse>> getAll(@PathVariable int clubId){
        return new ResponseEntity<>(eventConverter.convert(eventService.getAll(clubId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventResponse> create(CreateEventRequest request){
        return new ResponseEntity<>(eventConverter.convert(eventService.create(request)),HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponse> getById(@PathVariable int eventId){
        return new ResponseEntity<>(eventConverter.convert(eventService.getById(eventId)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EventResponse> update(UpdateEventRequest request){
        return new ResponseEntity<>(eventConverter.convert(eventService.update(request)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int eventId){
        eventService.deleteById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
