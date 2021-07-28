package com.inscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inscheduler.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id) throws Exception;
    User findUserByEmail(String email) throws Exception;
    List<User> findUsersByEventId(Integer eventId) throws Exception;
}
