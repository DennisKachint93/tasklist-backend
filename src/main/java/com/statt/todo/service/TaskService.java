package com.statt.todo.service;

import com.statt.todo.entity.TaskDTO;
import com.statt.todo.entity.TaskRequest;

import java.util.Collection;
import java.util.Optional;

public interface TaskService {
    public Optional<TaskDTO> get(Long id);
    public Collection<TaskDTO> getAll();
    public void create(TaskRequest task);
    public void delete(Long id);
}
