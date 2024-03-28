package com.nagarro.java_mini_assignment_2.Service;

import com.nagarro.java_mini_assignment_2.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {
}
