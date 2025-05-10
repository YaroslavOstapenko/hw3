package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScheduleActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private ListView pairsList;
    private Button btnBackToMain;

    private final Map<String, List<String>> pairsByDate = new HashMap<String, List<String>>() {{
        put("2025-05-10", Arrays.asList("Математика 10:00", "Фізика 12:00"));
        put("2025-05-12", Arrays.asList("Хімія 09:00", "Історія 11:00"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        calendarView = findViewById(R.id.calendarView);
        pairsList = findViewById(R.id.pairsList);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = String.format(Locale.getDefault(), "%04d-%02d-%02d", year, month + 1, dayOfMonth);
            List<String> pairs = pairsByDate.getOrDefault(selectedDate, Collections.singletonList("Пар немає"));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pairs);
            pairsList.setAdapter(adapter);
        });
    }
}

