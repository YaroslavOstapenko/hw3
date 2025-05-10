package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReminderActivity extends AppCompatActivity {

    private EditText taskInput;
    private TimePicker timePicker;
    private Button addReminderButton;
    private Button btnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        taskInput = findViewById(R.id.taskInput);
        timePicker = findViewById(R.id.timePicker);
        addReminderButton = findViewById(R.id.addReminder);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        addReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = taskInput.getText().toString().trim();
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                if (taskName.isEmpty()) {
                    Toast.makeText(ReminderActivity.this, "Будь ласка, введіть назву завдання", Toast.LENGTH_SHORT).show();
                } else {
                    String reminderDetails = "Завдання: " + taskName + "\nЧас: " + hour + ":" + minute;
                    Toast.makeText(ReminderActivity.this, "Нагадування додано: " + reminderDetails, Toast.LENGTH_LONG).show();

                }
            }
        });

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReminderActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
