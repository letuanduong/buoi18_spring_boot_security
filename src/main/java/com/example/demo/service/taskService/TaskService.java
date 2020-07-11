package com.example.demo.service.taskService;


import com.example.demo.model.User;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository TaskRepository;

    @Override
    public Iterable<Task> findAll() {
        return TaskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return TaskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return TaskRepository.save(task);
    }

    @Override
    public void remove(Long id) {
        TaskRepository.deleteById(id);
    }

    @Override
    public Iterable<Task> findAllByUser(User user) {
        return TaskRepository.findAllByUser(user);
    }

}
