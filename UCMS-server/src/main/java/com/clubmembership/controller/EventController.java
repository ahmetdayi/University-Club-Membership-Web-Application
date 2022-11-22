package com.clubmembership.controller;


import com.clubmembership.service.EventService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


}
