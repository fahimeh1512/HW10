package com.example.hw10;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksFragment extends Fragment {

    private static final String ARG_TASK_NAME = "task_name";
    private static final String ARG_NUMBER = "number";

    private RecyclerView mRecyclerView;

    private String mTaskName;
    private int mNumber;

    public TasksFragment() {
        // Required empty public constructor
    }


    public static TasksFragment newInstance(String name,int numOfTask) {
        TasksFragment fragment = new TasksFragment();
        Bundle args = new Bundle();
        args.putString("Args_Name",name);
        args.putInt("Args_number",numOfTask);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){

            mTaskName = getArguments().getString("task_name");
            mNumber = getArguments().getInt("number_of_tasks");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        findViews(view);
        initViews();

        return view;
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_tasks_list);
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TaskAdapter taskAdapter = new TaskAdapter(getContext());
        mRecyclerView.setAdapter(taskAdapter);
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;
        private Context mContext;

        public TaskAdapter(Context context, List<Task> tasks) {
            mContext = context;
            mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.task_item, parent, false);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            holder.bindTask();
        }

        @Override
        public int getItemCount() {
            return mNumber;
        }
    }


    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mHolderName;
        private TextView mHolderState;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            findViews(itemView);
        }

        private void findViews(View view) {
            mHolderName = view.findViewById(R.id.name);
            mHolderState = view.findViewById(R.id.state);
        }

        private void bindTask() {
            mHolderName.setText(mTaskName);
            //mHolderState.setText(mStates.getRandomState().toString());
        }
    }
}