package com.example.hourtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_startStop = findViewById(R.id.btn_startStop);
        btn_toGraph = findViewById(R.id.btn_toGraph);
        tv_goal = findViewById(R.id.tv_goal);
        tv_current = findViewById(R.id.tv_current);
        tv_todo = findViewById(R.id.tv_todo);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Seconds to do left: " + goalInSeconds--);

            }
        };

        Timer countDownTimer = new Timer();

        btn_startStop.setOnClickListener(view -> {
            if (isRunning) {
                // stop
                isRunning = false;
                btn_startStop.setText("Start");
                btn_startStop.setBackgroundColor(getResources().getColor(R.color.green));


            } else {
                countDownTimer.scheduleAtFixedRate(timerTask, 0, 1000);
                btn_startStop.setText("Stop");
                btn_startStop.setBackgroundColor(getResources().getColor(R.color.red));
                isRunning = true;
                // start count
            }
        });
    }


}