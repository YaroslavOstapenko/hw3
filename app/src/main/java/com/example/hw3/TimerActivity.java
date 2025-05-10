package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private ToggleButton toggleTimer;
    private TextView timeDisplay;
    private Button btnBackToMain;

    private boolean isTimerRunning = false;
    private int seconds = 0;
    private Handler handler = new Handler();

    private Runnable updateTimeRunnable = new Runnable() {
        @Override
        public void run() {
            if (isTimerRunning) {
                seconds++;
                int minutes = seconds / 60;
                int remainingSeconds = seconds % 60;
                timeDisplay.setText(String.format("%02d:%02d", minutes, remainingSeconds));

                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        toggleTimer = findViewById(R.id.toggleTimer);
        timeDisplay = findViewById(R.id.timeDisplay);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        toggleTimer.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                isTimerRunning = true;
                handler.post(updateTimeRunnable);
            } else {
                isTimerRunning = false;
            }
        });

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        isTimerRunning = false;
    }
}