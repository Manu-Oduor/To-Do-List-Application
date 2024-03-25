package com.example.todolistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList; // Data source for the adapter

    // Constructor to initialize the adapter with a list of tasks
    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;// Set the provided list of tasks to the adapter's data source
    }

    // This method inflates the layout for an individual task item
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_individual_task, parent, false);
        return new TaskViewHolder(view);
    }

    // This method binds data to the views within the view holder
    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskTitleTextView.setText(task.getTaskName());

    }

    // Returns the number of tasks in the data source
    @Override
    public int getItemCount() {
        return taskList.size();
    }

    // Inner class representing the view holder for each task item
    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView taskTitleTextView;// TextView to display task title

        // Constructor to initialize the view holder
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitleTextView = itemView.findViewById(R.id.taskTitleTextView);
        }
    }
}
