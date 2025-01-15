package com.example.sidebar.backend;

import java.util.ArrayList;

public class MonthAndDays {

//    MonthAndDays(){
//        Scanner in = new Scanner(System.in);
//        System.out.println("enter 1 to find day of date : ");
//        System.out.println("enter 2 for dates of day : ");
//        int val = in.nextInt();
//        switch (val) {
//            case 1:
//                int[] arr = Input.inputDate();
//                System.out.println("day is : "+Mother.DAYS[dayFinder(arr[0], arr[1], arr[2])]);
//                break;
//            case 2:
//                int[] arr1 = Input.inputForDate();
//                ArrayList<Integer> al = daysFinder(arr1[0], arr1[1], arr1[2]);
//                System.out.println("dates are : ");
//                for (Integer integer : al) {
//                    System.out.println(integer);
//                }
//                break;
//        }
//    }

    int oddDaysForDAY(int days){
        return days%7;
    }

    static int oddDaysForYear(int year){
        int total_odd = 0;
        for(int start = 1; start <= year; start++){
            if(Mother.isLeap(start)){
                total_odd += Mother.LEAP_YEAR;
            }
            else{
                total_odd += Mother.NON_LEAP_YEAR;
            }
        }
        return total_odd%7;
    }

    public static int dayFinder(int date, int month, int year){
        boolean feb_plus1 = Mother.isLeap(year);
        int oddDay = oddDaysForYear(year-1);
        for (int i = 0; i < month; i++) {
            oddDay += Mother.MONTHS[i];
            if(i == 1){
                if(feb_plus1){
                    oddDay += 1;
                }
            }
        }
        oddDay += date;
        return oddDay%7;
    }

    static int dateFinder(int day, int month, int year){
        for (int i = 1; i <= 7; i++) {
            if(dayFinder(i, month, year) == day){
                return i;
            }
        }
        return -1;
    }
    public static ArrayList<Integer> daysFinder(int day, int month, int year){
        int i = dateFinder(day, month, year);
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(i);
        boolean leap = Mother.isLeap(year);
        if(month == 1 && leap){
            month = 1+Mother.MONTHS[1];
        }
        else{
            month = Mother.MONTHS[month];
        }
        while (i <= month) {
            i+=7;
            if(i <= month){
                al.add(i);
            }
        }
        return al;
    }
}
