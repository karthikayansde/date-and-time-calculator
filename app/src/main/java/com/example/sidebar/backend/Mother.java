package com.example.sidebar.backend;

public class Mother {
    static final int LEAP_YEAR = 2, NON_LEAP_YEAR = 1;
    static final int YEAR_DAYS = 365;
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static final int[] DAYS_NO = {0, 1, 2, 3, 4, 5, 6};
    static final int[] MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};
    static final int[] HOUR = {00,23};
    static final int[] MINUTE = {00, 59};
    static final int[] SECOND = {00, 59};
    static final int[] TIME_START = {0,0,0};
    static final int[] TIME_END = {24,0,0};
    static boolean isLeap(int year){
        if(year % 400 == 0){
            return true;
        }
        else if(year % 100 == 0){
            return false;
        }
        else if(year % 4 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    static boolean timeMaxFinder(int first[], int last[]){
        long t1 = first[2] + (first[1]*60) + (first[0]*60*60);
        long t2 = last[2] + (last[1]*60) + (last[0]*60*60);
        if(t1 > t2){
            return true;
        }
        return false;
    }
}
