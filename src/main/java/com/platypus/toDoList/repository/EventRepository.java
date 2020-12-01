package com.platypus.toDoList.repository;

import com.platypus.toDoList.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, LocalDateTime> {
    //@Query("select a from Event a where a.date = :date")
    List<Event> findByDate( Date date);
    List<Event> findByDateBetween(Date date1, Date date2);
}
