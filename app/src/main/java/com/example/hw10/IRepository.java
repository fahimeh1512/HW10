package com.example.hw10;

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
