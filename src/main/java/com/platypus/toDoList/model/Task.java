package com.platypus.toDoList.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Task {

    @Id
    private String name;
    private String description;
    private String colour;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTask> subTasks = new ArrayList<>();

    private boolean completed;

    public Task() {
    }

    public Task(String name, String description, boolean completed, String colour) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.colour = colour;
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    public void deleteSubTask(long id) {subTasks.remove(id);}

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
    // getters and setters
}