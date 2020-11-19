package com.platypus.toDoList.repository;

import com.platypus.toDoList.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Integer> {
    public List<SubTask> findByTaskName(String name);
}
