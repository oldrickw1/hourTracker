package com.example.hourtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_startStop;
    Button btn_toGraph;
    TextView tv_goal;
    TextView tv_current;
    TextView tv_todo;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_startStop = findViewById(R.id.btn_startStop);
        btn_toGraph = findViewById(R.id.btn_toGraph);
        tv_goal = findViewById(R.id.tv_goal);
        tv_current = findViewById(R.id.tv_current);
        tv_todo = findViewById(R.id.tv_todo);



        btn_startStop.setOnClickListener(view -> {
            if (isRunning) {
                btn_startStop.setText("Start");
                btn_startStop.setBackgroundColor(getResources().getColor(R.color.green));
                isRunning = false;
                // stop the count;
            } else {
                btn_startStop.setText("Stop");
                btn_startStop.setBackgroundColor(getResources().getColor(R.color.red));
                isRunning = true;
                // start count
            }
        });
    }


}