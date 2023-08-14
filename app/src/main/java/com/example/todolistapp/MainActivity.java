package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;
    private EditText taskEditText;
    private EditText descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.task_recyclerview);
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);

        taskEditText = findViewById(R.id.TaskName);
        descriptionEditText = findViewById(R.id.taskDescriptionEditText);

        Button addTaskButton = findViewById(R.id.AddTaskBtn);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskTitle = taskEditText.getText().toString();


                if (!taskTitle.isEmpty()) {
                    Task newTask = new Task(taskTitle);
                    taskList.add(newTask);
                    taskAdapter.notifyDataSetChanged();

                    // Clear input fields
                    taskEditText.setText("");

                }
            }
        });
    }
}