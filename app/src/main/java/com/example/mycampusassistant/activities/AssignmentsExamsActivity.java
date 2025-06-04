package com.example.mycampusassistant.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycampusassistant.R;

public class AssignmentsExamsActivity extends AppCompatActivity {
    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments_exams);

        RecyclerView rvTasks = findViewById(R.id.rv_tasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskAdapter(taskList);
        rvTasks.setAdapter(adapter);

        Button btnAddTask = findViewById(R.id.btn_add_task);
        btnAddTask.setOnClickListener(v -> showAddTaskDialog());

        // Sample data
        taskList.add(new Task("Math HW", "5 June"));
        taskList.add(new Task("Exam CS", "10 June"));
        adapter.notifyDataSetChanged();
    }




