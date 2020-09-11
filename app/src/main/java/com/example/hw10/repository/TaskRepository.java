package com.example.hw10.repository;

import android.graphics.Color;

import com.example.hw10.model.State;
import com.example.hw10.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository implements IRepository {
    // This class uses singleton method
    private static TaskRepository sInstance;
    private static List<Task> mTasks;

    // This method gets task name and number of tasks as input
    public static TaskRepository getInstance(String taskName, int numberOfTasks) {
        if (sInstance == null)
            sInstance = new TaskRepository(taskName, numberOfTasks);

        return sInstance;
    }

    // Constructor produces tasks list as number of input and the name of input
    private TaskRepository(String taskName, int numberOfTasks) {
        mTasks = new ArrayList<>();

        for (int i = 0; i < numberOfTasks; i++) {
            Task task = new Task();
            task.setName(taskName);
            task.setState(State.getRandomState());
            // Defines different colors for even and odd indexes
            if (i % 2 == 0)
                task.setBackgroundColor(Color.rgb(181, 214, 182));
            else
                task.setBackgroundColor(Color.rgb(207, 161, 161));

            mTasks.add(task);
        }
    }

    @Override
    public List<Task> getTasks() {
        return mTasks;
    }

    @Override
    public void addTask(Task task) {
        mTasks.add(task);
    }

    @Override
    public void deleteTask(Task task) {
        for (int i = 0; i < mTasks.size(); i++) {
            if (mTasks.get(i).getId().equals(task.getId())) {
                mTasks.remove(i);
                return;
            }
        }
    }

    @Override
    public void updateTask(Task task) {
        Task foundTask = getTask(task.getId());
        foundTask.setName(task.getName());
        foundTask.setState(task.getState());
    }

    @Override
    public Task getTask(UUID taskId) {
        for (Task task: mTasks)
            if (task.getId().equals(taskId))
                return task;

        return null;
    }

    @Override
    public int getPosition(UUID taskId) {
        for (int i = 0; i < mTasks.size(); i++) {
            if (mTasks.get(i).getId().equals(taskId))
                return i;
        }

        return 0;
    }
}
