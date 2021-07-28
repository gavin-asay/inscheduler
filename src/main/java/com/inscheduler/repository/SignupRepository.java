package com.inscheduler.repository;

import com.inscheduler.models.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Integer> {
    Signup findSignupById(Integer id);
    List<Signup> findSignupsByEventId(Integer eventId);
    List<Signup> findSignupsByClientId(Integer clientId);
}
