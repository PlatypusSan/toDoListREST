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
import java.util.Date;

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
            Task task1 = new Task("Курсовой", "курсовой проект пгу, 5 семестр", false, "#33ee55");
            Task task2 = new Task("Интервью", "", false, "#ee9944");
            Task task3 = new Task("Ремонт", "", false, "#34ebde");

            taskService.addTask(task1);
            taskService.addTask(task2);
            taskService.addTask(task3);


            //subtasks
            SubTask subTask1 = new SubTask("Клинет", "sub1 des", false);
            subTask1.setId(1);
            SubTask subTask2 = new SubTask("Сервер", "sub2 des", false);
            subTask2.setId(2);
            SubTask subTask3 = new SubTask("Записка", "sub3 des", false);
            subTask2.setId(20);
            SubTask subTask4 = new SubTask("Защита", "sub4 des", false);
            subTask2.setId(21);


            subTaskService.addSubTask(subTask1, "Курсовой");
            subTaskService.addSubTask(subTask2, "Курсовой");
            subTaskService.addSubTask(subTask3, "Курсовой");
            subTaskService.addSubTask(subTask4, "Курсовой");

            Event event1;
            Event event2;
            Event event3;
            Event event4;
            Event event5;
            //events
            Date todayDate = new Date();
            Date tomorrowDate = new Date();
            tomorrowDate.setDate(todayDate.getDate() + 1);

            String today = (todayDate.getYear() + 1900) + "-" + todayDate.getMonth() + "-" + todayDate.getDate();
            String tomorrow = (tomorrowDate.getYear() + 1900) + "-" + tomorrowDate.getMonth() + "-" + tomorrowDate.getDate();
            System.out.println(today);

            try {
                event1 = new Event(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(today + " 03:00 GMT+00:00"),
                        "Написать записку", "описание", 10);
                event2 = new Event(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(today + " 05:05 GMT+00:00"),
                        "Покушать", "Чай с печеньем", 30);
                event3 = new Event(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(today + " 07:30 GMT+00:00"),
                        "Погладить кота", "", 50);
                event4 = new Event(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(tomorrow + " 11:35 GMT+00:00"),
                        "Зарядка", "", 110);
                event5 = new Event(new SimpleDateFormat("yyyy-MM-dd HH:mm z").parse(tomorrow + " 14:30 GMT+00:00"),
                        "Покушать", "", 200);
                eventService.addEventWithTask("Курсовой", event1);
                eventService.addEvent(event2);
                eventService.addEvent(event3);
                eventService.addEvent(event4);
                eventService.addEvent(event5);

            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
    }
}
