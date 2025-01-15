package com.example.sidebar.backend;

public class DateAndTimeDiff {
//    DateAndTimeDiff(){
//        int[] start = new int[6];
//        int[] end = new int[6];
//        int[] sd = Input.inputDate(), st = Input.inputTime();
//        int[] ed = Input.inputDate(), et = Input.inputTime();
//        for (int i = 0; i < 3; i++) {
//            start[i] = sd[i];
//            end[i] = ed[i];
//        }
//        for (int i = 0; i < 3; i++) {
//            start[i+3] = st[i];
//            end[i+3] = et[i];
//        }
//        int[] ans = dateAndTime(start, end);
//        System.out.println("days : "+ans[0]+" hours : "+ans[1]+" minutes : "+ans[2]+" seconds : "+ans[3]);
//    }
    public static int[] dateAndTime(int[] start, int[] end){
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
        int days = 0;

        int[] dStart = {start[0],start[1],start[2]};
        int[] dEnd =  {end[0],end[1],end[2]};
        int[] tStart = {start[3],start[4],start[5]};
        int[] tEnd = {end[3],end[4],end[5]};

        days = DateDifference.DateDifferenceFinder(false, false, dStart, dEnd);

        long startTime = TimeDifference.timeDifference(tStart, Mother.TIME_END);
        long endTime = TimeDifference.timeDifference(Mother.TIME_START,tEnd);

        seconds = (int)(startTime % 60 + endTime % 60);
        if(seconds >= 60){
            minutes += seconds/60;
            seconds %= 60;
        }

        minutes += startTime / 60 % 60 + endTime / 60 % 60;
        if(minutes >= 60){
            hours += minutes/60;
            minutes %= 60;
        }

        hours += startTime / 60 / 60 + endTime / 60 / 60;
        if(hours >= 24){
            days += hours/24;
            hours %= 24;
        }

        int[] ans = {days,hours,minutes,seconds};
        return ans;
    }
}
