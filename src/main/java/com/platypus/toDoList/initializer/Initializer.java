package com.platypus.toDoList.initializer;

import com.platypus.toDoList.model.Event;
import com.platypus.toDoList.model.SubTask;
import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.repository.EventRepository;
import com.platypus.toDoList.repository.SubTaskRepository;
import com.platypus.toDoList.repository.TaskRepository;
import com.platypus.toDoList.services.EventService;
import com.platypus.toDoList.services.SubTaskService;
import com.platypus.toDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

//@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    SubTaskRepository subTaskRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    TaskService taskService;

    @Autowired
    SubTaskService subTaskService;

    @Autowired
    EventService eventService;

    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        if (taskRepository.findAll().size() < 1 && eventRepository.findAll().size() < 1) {
            System.out.println("\n______________INITIALIZATION______________");


            //tasks
            Task task1 = new Task("task1", "task1 des", false , "ffff00");
            Task task2 = new Task("task2", "task2 des", false , "ff9900");
            taskService.addTask(task1);
            taskService.addTask(task2);

            //subtasks
            SubTask subTask1 = new SubTask("sub1", "sub1 des", false);
            subTask1.setId(1);
            SubTask subTask2 = new SubTask("sub2", "sub2 des", true);
            subTask2.setId(2);

            subTaskService.addSubTask(subTask1, "task1");
            subTaskService.addSubTask(subTask2, "task1");
            Event event1;
            //events
            try {
                event1 = new Event(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse("2015-01-01 03:00 GMT+00:00"),
                        "event1","event1 des", 10);
                eventService.addEventWithTask("task1", event1);
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
    }
}
