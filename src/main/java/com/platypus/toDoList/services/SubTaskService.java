package com.platypus.toDoList.services;


import com.platypus.toDoList.model.SubTask;
import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.model.TaskList;
import com.platypus.toDoList.repository.SubTaskRepository;
import com.platypus.toDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTaskService {

    @Autowired
    SubTaskRepository subTaskRepository;

    @Autowired
    TaskRepository taskRepository;

    public TaskList getAllSubTasks(String taskId) {
        TaskList tasks = new TaskList();

        return tasks;
    }

    public SubTask getSubTask(int id) {
        return subTaskRepository.getOne(id);
    }

    public void addSubTask(SubTask subTask) {
        subTaskRepository.save(subTask);
    }
}
