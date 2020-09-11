package com.example.hw10.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hw10.R;
import com.example.hw10.controller.activity.TasksActivity;

public class MainFragment extends Fragment {
    private EditText mTaskName;
    private EditText mNumber;
    private Button mMakeButton;

    public static final String EXTRA_TASK_NAME = "com.example.hw10.controller.fragment.task_name";
    public static final String EXTRA_NUMBER_OF_TASKS = "com.example.hw10.controller.fragment.number_of_tasks";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        findViews(view);
        setListener();

        return view;
    }

    private void findViews(View view) {
        mTaskName = view.findViewById(R.id.task_name);
        mNumber = view.findViewById(R.id.number);
        mMakeButton = view.findViewById(R.id.button);
    }

    private void setListener() {
        mMakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Starts TasksActivity and send task name and number of tasks to it
                Intent intent = new Intent(getActivity(), TasksActivity.class);
                intent.putExtra(EXTRA_TASK_NAME, mTaskName.getText().toString());
                intent.putExtra(EXTRA_NUMBER_OF_TASKS, Integer.parseInt(mNumber.getText().toString()));
                getActivity().startActivity(intent);
            }
        });
    }
}