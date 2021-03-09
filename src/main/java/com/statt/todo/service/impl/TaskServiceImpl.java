package com.statt.todo.service.impl;

import com.statt.todo.entity.Task;
import com.statt.todo.entity.TaskDTO;
import com.statt.todo.entity.TaskRequest;
import com.statt.todo.service.TaskRepo;
import com.statt.todo.service.TaskService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepo repo;

    @Override
    public Optional<TaskDTO> get(Long id) {
        Optional<Task> task =  repo.findById(id);
        Optional<TaskDTO> dto = task.stream().map(Task::toDto).findAny();
        return dto;
    }

    @Override
    public Collection<TaskDTO> getAll() {
        return repo.findAll().stream().map(Task::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void create(TaskRequest request) {
        repo.save(new Task(request.getTask()));
    }

    @Override
    public void delete(Long id) {
        Task taskToDelete = repo.getOne(id);
        repo.delete(taskToDelete);
    }
}
