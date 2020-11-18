package com.platypus.toDoList.controllers;


import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.model.TaskList;
import com.platypus.toDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    public TaskController() {

    }

    @GetMapping(path = "/tasks/{id}")
    public Task getTask(@PathVariable int id) { return taskService.getTask(id - 1);
    }

    @GetMapping(path = "/tasks")
    public TaskList getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping(path = "/tasks")
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }
}