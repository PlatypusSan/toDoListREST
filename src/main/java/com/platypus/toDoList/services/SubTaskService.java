package com.platypus.toDoList.services;


import com.platypus.toDoList.model.SubTask;
import com.platypus.toDoList.model.Task;
import com.platypus.toDoList.model.TaskList;
import com.platypus.toDoList.repository.SubTaskRepository;
import com.platypus.toDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTaskService {

    @Autowired
    SubTaskRepository subTaskRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<SubTask> getAllSubTasks(String taskName) {
        List<SubTask> subTasks = new ArrayList<>();
        subTaskRepository.findByTaskName(taskName).forEach(subTasks::add);
        return subTasks;
    }

    public SubTask getSubTask(int id) {
        return subTaskRepository.getOne(id);
    }

    public void addSubTask(SubTask subTask, String name) {
        taskRepository.getOne(name).addSubTask(subTask);
        //subTask.setTask(taskRepository.getOne(name));
        subTaskRepository.save(subTask);
    }
}
