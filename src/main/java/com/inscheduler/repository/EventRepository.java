package com.inscheduler.repository;

import com.inscheduler.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventById(Integer id) throws Exception;
    List<Event> findEventsByUserId(Integer userId);
    List<Event> findEventsByOrganization(String organization);
}
