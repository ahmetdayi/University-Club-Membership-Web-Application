package com.ahmetpoyraz.databaseproject.api.controller;


import com.ahmetpoyraz.databaseproject.business.abstracts.EventService;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import com.ahmetpoyraz.databaseproject.entities.concretes.Event;
import com.ahmetpoyraz.databaseproject.entities.dtos.EventDto;
import com.ahmetpoyraz.databaseproject.entities.dtos.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/event")
@CrossOrigin(origins = "*")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getall")
    public DataResult<List<Event>> getAll() {
        return this.eventService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody EventDto eventDto) {
        Result res = this.eventService.add(eventDto);
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.badRequest().body(res);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Event event) {
        return this.eventService.delete(event);

    }

    @PostMapping("/update")
    public Result update(@RequestBody Event event) {
        return this.eventService.update(event);

    }
    @PostMapping("/{eventId}/clubs/{clubId}")
    public ResponseEntity<?> enrolledClub(@PathVariable int eventId,@PathVariable int clubId){
         Result res = this.eventService.enrolledClub(eventId,clubId);
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.badRequest().body(res);
    }

}
