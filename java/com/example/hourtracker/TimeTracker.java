package com.example.hourtracker;

import java.sql.Timestamp;

public class TimeTracker {
    private long dailyTotalInMillies = 0;
    private long startTimeInMillies = 0;


    public TimeTracker() {
    }

    public void start() {
        startTimeInMillies = System.currentTimeMillis();
    }

    public void stop() {
        dailyTotalInMillies += startTimeInMillies - System.currentTimeMillis();
    }

    public void reset() {
        dailyTotalInMillies = 0;
        startTimeInMillies = 0;
    }

    public int getDailyHours() {
        return (int) dailyTotalInMillies / 3600000;
    }

    public int getDailyMinutes() {
        return (int) dailyTotalInMillies / 60000;
    }
}
