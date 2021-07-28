package com.inscheduler.repository;

import com.inscheduler.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Guest findGuestById(Integer id) throws Exception;
    Guest findGuestByEmail(String email) throws Exception;
    List<Guest> findGuestsByEventId(Integer eventId) throws Exception;
}
