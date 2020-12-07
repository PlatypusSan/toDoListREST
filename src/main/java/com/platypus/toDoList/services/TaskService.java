package com.platypus.toDoList.services;


import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.model.TaskList;
import com.platypus.toDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task : repository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    public Task getTask(String name) {
        return repository.getOne(name);
    }

    public void addTask(Task task) {
        repository.save(task);
    }


}
