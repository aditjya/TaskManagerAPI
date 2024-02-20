package com.taskManager.repository;

import com.taskManager.model.User;
import com.taskManager.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;


    Optional<User> findByusername(String username);
}