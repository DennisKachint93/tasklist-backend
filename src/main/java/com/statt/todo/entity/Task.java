package com.statt.todo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String taskDescription;

    public Task(){ }

    public Task(String taskDescription){
        this.taskDescription = taskDescription;
    }

    public Task(Long id, String taskDescription){
        this.id = id;
        this.taskDescription = taskDescription;
    }

    public TaskDTO toDto(){
        return new TaskDTO(this.id, this.taskDescription);
    }
}
