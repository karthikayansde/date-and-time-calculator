package com.example.sidebar.backend;

public class TimeAdd {
    public static long timeAdd (int[] startTime, int[] endTime){
        int minutes = 0;
        int hours = 0;
        int days = 0;
        long total = 0;
        int seconds = startTime[2] + endTime[2];
        if(seconds > 59){
            minutes = seconds/60;
            seconds = seconds%60;
        }

        minutes += startTime[1] + endTime[1];
        if(minutes > 59){
            hours = minutes/60;
            minutes = minutes%60;
        }

        hours += startTime[0] + endTime[0];
        if(hours > 24){
            days = hours/24;
            hours = hours%24;
        }

        return total = seconds + (minutes*60) + (hours*60*60) + (days*24*60*60);
    }
}
