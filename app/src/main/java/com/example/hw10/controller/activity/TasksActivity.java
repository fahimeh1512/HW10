package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.hw10.R;
import com.example.hw10.controller.fragment.MainFragment;
import com.example.hw10.controller.fragment.TasksFragment;

public class TasksActivity extends AppCompatActivity {

    private String mTaskName;
    private int mNumOfTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.tasks_container);

        mTaskName = getIntent().getStringExtra(MainFragment.EXTRA_TASK_NAME);
        mNumOfTask = getIntent().getIntExtra(MainFragment.EXTRA_NUMBER_OF_TASKS,0);

        if (fragment == null) {
            fragmentManager.beginTransaction().add(R.id.tasks_container, TasksFragment.newInstance(mTaskName,mNumOfTask)).commit();
        }
    }
}