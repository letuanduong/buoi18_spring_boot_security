package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Iterable<Task> findAllByUser(User user);

}
