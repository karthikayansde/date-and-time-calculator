package com.example.sidebar.backend;

public class BulkLeap
{
    public int[] year = new int[40];
    public boolean[] leap = new boolean[40];
    void add(int in1,int year1, boolean leap1){
        year[in1] = year1;
        leap[in1] = leap1;
    }
}
