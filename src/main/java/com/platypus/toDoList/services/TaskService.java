package com.platypus.toDoList.services;


import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.model.TaskList;
import com.platypus.toDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public TaskList getAllTasks() {
        TaskList tasks = new TaskList();
        for (Task task : repository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    public Task getTask(int id) {
        TaskList tasks = new TaskList();
        for (Task task : repository.findAll()) {
            tasks.add(task);
        }
        return tasks.get(id);
    }

    public void addTask(Task task) {
        repository.save(task);
    }
}
