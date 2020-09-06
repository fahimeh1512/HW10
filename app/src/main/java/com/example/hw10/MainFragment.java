package com.example.hw10;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainFragment extends Fragment {
    private EditText mTaskName;
    private EditText mNumber;
    private Button mMakeButton;

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

        initViews();

        return view;
    }

    private void findViews(View view) {
        mTaskName = view.findViewById(R.id.task_name);
        mNumber = view.findViewById(R.id.number);
        mMakeButton = view.findViewById(R.id.button);
    }

    private void initViews() {
        mTaskName.setText("Task Name");
        mNumber.setText("5");
        setListener();
    }
    private void setListener() {
        mMakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TasksActivity.class);
                intent.putExtra("task_name", mTaskName.getText());
                intent.putExtra("number_of_tasks", mNumber.getText());
                getActivity().startActivity(intent);
            }
        });
    }
}