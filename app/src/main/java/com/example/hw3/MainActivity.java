package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private Button saveButton;
    private Button btnSchedule;
    private Button btnReminder;
    private Button btnExpenses;
    private Button btnTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        saveButton = findViewById(R.id.saveButton);
        btnSchedule = findViewById(R.id.btnSchedule);
        btnReminder = findViewById(R.id.btnReminder);
        btnExpenses = findViewById(R.id.btnExpenses);
        btnTimer = findViewById(R.id.btnTimer);

        saveButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            if (!name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Вітаємо, " + name + "!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Будь ласка, введіть ім'я!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
            startActivity(intent);
        });

        btnReminder.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReminderActivity.class);
            startActivity(intent);
        });

        btnExpenses.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExpensesActivity.class);
            startActivity(intent);
        });

        btnTimer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimerActivity.class);
            startActivity(intent);
        });
    }
}