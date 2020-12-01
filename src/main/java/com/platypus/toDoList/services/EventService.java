package com.platypus.toDoList.services;

import com.platypus.toDoList.model.Event;
import com.platypus.toDoList.repository.EventRepository;
import com.platypus.toDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Event> getAllEventsByDate(int year, int month, int day){
        try {
            //return eventRepository.findByDate(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse("2015-01-01 03:00 GMT+00:00"));
            return eventRepository.findByDateBetween(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(
                            year + "-"+ month + "-" + day + " 00:00 GMT+00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(
                            year + "-"+ month + "-" + day + " 23:59 GMT+00:00"));

        } catch (ParseException e) {
            e.printStackTrace();
            return  eventRepository.findAll();
        }
        //return eventRepository.findAll();
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public void addEvent(Event event){
        System.out.println(event.getDate());
        eventRepository.save(event);
    }

    public void addEventWithTask(String taskName, Event event) {
        event.setTask(taskRepository.getOne(taskName));
        eventRepository.save(event);
    }
}
