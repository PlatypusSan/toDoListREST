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


    @GetMapping(path = "/tasks/{name}/subtask/{id}")
    public SubTask getSubTask(@PathVariable String name, @PathVariable int id) {
        return subTaskService.getSubTask(id);
    }

    @GetMapping(path = "/tasks/{name}/subtasks")
    public List<SubTask> getSubAllTasks(@PathVariable String name){
        return subTaskService.getAllSubTasks(name);
    }

    @PostMapping(path = "/tasks/{name}/subtasks")
    public void addSubTask(@RequestBody SubTask subTask, @PathVariable String name){
        subTaskService.addSubTask(subTask, name);
    }
}
