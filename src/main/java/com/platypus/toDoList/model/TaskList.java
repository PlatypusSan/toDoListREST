package com.platypus.toDoList.model;

import java.util.ArrayList;


public class TaskList {
    ArrayList<Task> listOfTasks = new ArrayList<>();

    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(ArrayList<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public Task get(int i) {
        return listOfTasks.get(i);
    }

    public void add(Task task) {
        listOfTasks.add(task);
    }

    public int getSize() {
        return listOfTasks.size();
    }


}
