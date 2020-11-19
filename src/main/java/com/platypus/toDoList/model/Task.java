package com.platypus.toDoList.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Task {

    @Id
    private String name;
    private String description;



    private boolean completed;

    public Task() {
    }

    public Task(String name, String description, boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
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
    // getters and setters
}