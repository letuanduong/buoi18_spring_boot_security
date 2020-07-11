package com.example.demo.service.taskService;

import com.example.demo.model.User;
import com.example.demo.model.Task;

import java.util.Optional;

public interface ITaskService {

    Iterable<Task> findAllByUser(User user);

    Iterable<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task t);

    void remove(Long id);

}
