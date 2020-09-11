package com.example.hw10.controller.fragment;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hw10.R;
import com.example.hw10.model.Task;
import com.example.hw10.repository.IRepository;
import com.example.hw10.repository.TaskRepository;

import java.util.List;

public class TasksFragment extends Fragment {

    private static final String ARG_TASK_NAME = "task_name";
    private static final String ARG_NUMBER = "number";

    private RecyclerView mRecyclerView;
    private IRepository mRepository;

    private String mTaskName;
    private int mNumber;

    public TasksFragment() {
        // Required empty public constructor
    }

    public static TasksFragment newInstance(String name,int numOfTask) {
        Bundle args = new Bundle();
        args.putString("ARG_TASK_NAME",name);
        args.putInt("ARG_NUMBER",numOfTask);

        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){

            mTaskName = getArguments().getString("ARG_TASK_NAME");
            mNumber = getArguments().getInt("ARG_NUMBER");

            // Gets instance of repository
            mRepository = TaskRepository.getInstance(mTaskName, mNumber);
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

        // Sets adapter
        TaskAdapter taskAdapter = new TaskAdapter(getContext(), mRepository.getTasks());
        mRecyclerView.setAdapter(taskAdapter);
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;
        private Context mContext;

        public TaskAdapter(Context context, List<Task> tasks) {
            mContext = context;
            mTasks = tasks;
        }

        // Creates view holder
        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.task_item, parent, false);
            return new TaskHolder(view);
        }

        // Binds each task to view holder
        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bindTask(task);
        }

        // Gets number of tasks
        @Override
        public int getItemCount() {
            return mNumber;
        }
    }


    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mHolderName;
        private TextView mHolderState;
        // Root layout for each task
        private RelativeLayout mTaskLayout;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            findViews(itemView);
        }

        private void findViews(View view) {
            mHolderName = view.findViewById(R.id.name);
            mHolderState = view.findViewById(R.id.state);
            mTaskLayout = view.findViewById(R.id.task_item);
        }

        private void bindTask(Task task) {
            mHolderName.setText(task.getName());
            mHolderState.setText(task.getState().toString());
            mTaskLayout.setBackgroundColor(task.getBackgroundColor());
        }
    }
}