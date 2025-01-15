package com.example.sidebar.backend;
import com.example.sidebar.*;
import android.view.View;

import com.example.sidebar.MainActivity;
import com.example.sidebar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TimeDifference {
    public static long timeDifference (int[] startTime, int[] endTime){
        // hours----------------
        int hours = endTime[0] - 1 - startTime[0];

        // minutes--------------
        // start minute-----
        int minutes = 60 - 1 - startTime[1];
        // end minute-------
        minutes += endTime[1];
        // seconds--------------
        // start second-----
        int seconds = 60 - startTime[2];
        // end second-------
        seconds += endTime[2];
        long total = (long)(hours * 60 * 60);
        total += (long)(minutes * 60);
        total += seconds;
        return total;
    }
}
