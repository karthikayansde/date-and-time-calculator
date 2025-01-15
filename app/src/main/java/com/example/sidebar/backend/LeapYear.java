package com.example.sidebar.backend;

public class LeapYear {
    public static BulkLeap bulkLeap(int year1){
        int year = year1;
        year -= 20;
        BulkLeap bl = new BulkLeap();
        for(int i = 0; i < 40; i++){
            if(Mother.isLeap(year)){
                if(year == year1){
                    year++;
                    i--;
                    continue;
                }
                bl.add(i,year,true);
            }
            else{
                if(year == year1){
                    year++;
                    i--;
                    continue;
                }
                bl.add(i,year,false);
            }
            year++;
        }
        return bl;
    }
    public static boolean checkLeap(int year){
        if(Mother.isLeap(year)){return true;}
        else{return false;}
    }
}
