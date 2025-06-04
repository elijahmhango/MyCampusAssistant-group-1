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

    private void showAddTaskDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Task");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        EditText etTaskName = new EditText(this);
        etTaskName.setHint("Task Name");
        layout.addView(etTaskName);

        EditText etDueDate = new EditText(this);
        etDueDate.setHint("Due Date");
        layout.addView(etDueDate);

        builder.setView(layout);
        builder.setPositiveButton("Add", (dialog, which) -> {
            String name = etTaskName.getText().toString();
            String dueDate = etDueDate.getText().toString();
            if (!name.isEmpty() && !dueDate.isEmpty()) {
                taskList.add(new Task(name, dueDate));
                adapter.notifyDataSetChanged();
                setTaskNotification(name, dueDate);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }









