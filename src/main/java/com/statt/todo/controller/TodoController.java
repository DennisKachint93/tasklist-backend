package com.statt.todo.controller;

import com.statt.todo.entity.Task;
import com.statt.todo.entity.TaskDTO;
import com.statt.todo.entity.TaskRequest;
import com.statt.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TodoController {
    @Autowired
    TaskService service;

    @GetMapping(value = "/{taskId}")
    public ResponseEntity<TaskDTO> get(@PathVariable("taskId") Long id) {
        return ResponseEntity.of(service.get(id));
    }

    @GetMapping()
    public ResponseEntity<Collection<TaskDTO>> getAll() {
        return ResponseEntity.of(Optional.of(service.getAll()));
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody TaskRequest task) {
        service.create(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}