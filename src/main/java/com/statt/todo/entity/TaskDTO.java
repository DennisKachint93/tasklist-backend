package com.statt.todo.entity;

public class TaskDTO {
    Long id;
    String task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    public TaskDTO(Long id, String task) {
        this.id = id;
        this.task = task;
    }
}
