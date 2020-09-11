package com.example.hw10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class TasksActivity extends AppCompatActivity {

    String mTaskName;
    int mNumOfTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.tasks_container);

        mTaskName = getIntent().getStringExtra("task_name");
        mNumOfTask = (getIntent().getIntExtra("number_of_tasks",0));

        if (fragment == null) {
            fragmentManager.beginTransaction().add(R.id.tasks_container, TasksFragment.newInstance(mTaskName,mNumOfTask)).commit();
        }
    }
}