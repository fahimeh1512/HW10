package com.example.hw10.repository;

import com.example.hw10.model.Task;

import java.util.List;
import java.util.UUID;

public interface IRepository {
    List<Task> getTasks();
    void addTask(Task task);
    void deleteTask(Task task);
    void updateTask(Task task);
    Task getTask(UUID taskId);
    int getPosition(UUID taskId);

}
