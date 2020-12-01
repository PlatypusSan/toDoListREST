package com.platypus.toDoList.controllers;

import com.platypus.toDoList.model.Event;
import com.platypus.toDoList.repository.EventRepository;
import com.platypus.toDoList.services.EventService;
import com.platypus.toDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(path = "/events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping(path = "/events/{year}-{month}-{day}")
    public List<Event> getAllEventsByDate(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        return eventService.getAllEventsByDate(year, month, day);
    }

    @PostMapping(path = "/events")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @PostMapping(path = "/events/{taskName}")
    public void addEventWithTask(@RequestBody Event event, @PathVariable String taskName){
        eventService.addEventWithTask(taskName, event);
    }

}
