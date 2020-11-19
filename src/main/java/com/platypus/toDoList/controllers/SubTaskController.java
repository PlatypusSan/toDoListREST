package com.platypus.toDoList.controllers;

import com.platypus.toDoList.model.SubTask;
import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.model.TaskList;
import com.platypus.toDoList.services.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubTaskController {

    @Autowired
    SubTaskService subTaskService;

    public SubTaskController() {
    }


    @GetMapping(path = "/task/{name}/subtask/{id}")
    public SubTask getTask(@PathVariable String name, @PathVariable int id) {
        return subTaskService.getSubTask(id);
    }

    @GetMapping(path = "/task/{name}/subtasks")
    public List<SubTask> getAllTasks(@PathVariable String name){
        return subTaskService.getAllSubTasks(name);
    }

    @PostMapping(path = "/task/{name}/subtasks")
    public void addTask(@RequestBody SubTask subTask, @PathVariable String name){
        subTaskService.addSubTask(subTask, name);
    }
}
