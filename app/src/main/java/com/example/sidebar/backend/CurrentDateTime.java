package com.example.sidebar.backend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime {
    public static int day(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date date = new Date();
        return Integer.parseInt(sdf.format(date));
    }
    public static int month(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        Date date = new Date();
        return Integer.parseInt(sdf.format(date));
    }
    public static int year(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return Integer.parseInt(sdf.format(date));
    }
    public static int hour(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        Date date = new Date();
        return Integer.parseInt(sdf.format(date));
    }
    public static int minutes(){
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        Date date = new Date();
        return Integer.parseInt(sdf.format(date));
    }
    public static int seconds(){
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        Date date = new Date();
        return Integer.parseInt(sdf.format(date));
    }
}
