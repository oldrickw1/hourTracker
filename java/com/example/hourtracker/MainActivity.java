package com.example.hourtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity{

    Button btn_startStop;
    Button btn_toGraph;
    TextView tv_goal;
    TextView tv_current;
    TextView tv_todo;
    boolean isRunning = false;
    int goalInHours = 8;
    int goalInSeconds = goalInHours * 60 * 60;


    public MainActivity() throws IOException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_startStop = findViewById(R.id.btn_startStop);
        btn_toGraph = findViewById(R.id.btn_toGraph);
        tv_goal = findViewById(R.id.tv_goal);
        tv_current = findViewById(R.id.tv_current);
        tv_todo = findViewById(R.id.tv_todo);


        btn_startStop.setOnClickListener(this::startOrStop);
    }

    private void startOrStop(View v){
        if (isRunning) {
            stop();
        } else {
            start();
        }
    }

    private void start() {
        isRunning = true;
        btn_startStop.setText("Stop");
        btn_startStop.setBackgroundColor(getResources().getColor(R.color.red));
        System.out.println("Stopped at: " + System.currentTimeMillis());
    }

    private void stop() {
        isRunning = false;
        btn_startStop.setText("Start");
        btn_startStop.setBackgroundColor(getResources().getColor(R.color.green));
        System.out.println("Started at: " + System.currentTimeMillis());
    }


}