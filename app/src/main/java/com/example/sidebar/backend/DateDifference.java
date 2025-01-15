package com.example.sidebar.backend;

public class DateDifference {
//    DateDifference(){
//        int[] sDate = Input.inputDate();
//        int[] eDate = Input.inputDate();
//        Scanner in = new Scanner(System.in);
//        System.out.print("enter a starting date can include or not (false or true) : ");
//        boolean firstd = in.nextBoolean();
//        System.out.print("enter a ending date can include or not (false or true) : ");
//        boolean lastd = in.nextBoolean();
//        System.out.println("days between dates is : "+DateDifferenceFinder(firstd, lastd, sDate, eDate));
//    }
    public static int DateDifferenceFinder(boolean start, boolean end, int[] startDate, int[] endDate){

        int yearCount = 0;
        int totalDays = 0;
        for (int i = startDate[2]+1; i < endDate[2]; i++) {
            yearCount+=1;
            if(Mother.isLeap(i)){
                totalDays = Mother.YEAR_DAYS + 1 + totalDays;
                continue;
        }
            totalDays += Mother.YEAR_DAYS;
        }
        //---------------------------------month area----------------------
        int monthCount = 0;
        if(startDate[2] == endDate[2]){
            for (int i = startDate[1]+1; i < endDate[1]; i++) {
                if(i == 1 && Mother.isLeap(startDate[2])){
                    totalDays += Mother.MONTHS[i]+1;
                    monthCount++;
                    continue;
                }
                totalDays += Mother.MONTHS[i];
                monthCount++;
            }
        }
        else{
            //-----------starting month

            for (int i = startDate[1]+1; i < 12; i++) {
                if(i == 1 && Mother.isLeap(startDate[2])){
                    totalDays += Mother.MONTHS[i]+1;
                    monthCount++;
                    continue;
                }
                totalDays += Mother.MONTHS[i];
                monthCount++;
            }
            //-----------ending month
            for (int i = 0; i < endDate[1]; i++) {
                if(i == 1 && Mother.isLeap(endDate[2])){
                    totalDays += Mother.MONTHS[1]+1;
                    monthCount++;
                    continue;
                }
                totalDays += Mother.MONTHS[i];
                monthCount++;
            }
        }
        //---------------------------------day area----------------------

        int daysCount = 0;
        if(monthCount == 0 && startDate[1] == endDate[1]){
            for (int i = startDate[0]; i <= Mother.MONTHS[startDate[1]]; i++) {
                if(i <= endDate[0]){
                    totalDays += 1;
                    daysCount += 1;
                }
            }
        }
        else{
            if(startDate[1] == 1 && Mother.isLeap(startDate[2])){
                totalDays += 29-startDate[0]+1;
                daysCount += 29-startDate[0]+1;
            }
            else{
                totalDays += Mother.MONTHS[startDate[1]] - startDate[0];
                daysCount += Mother.MONTHS[startDate[1]] - startDate[0];
            }
            //
            if(startDate[1] == 1 && Mother.isLeap(startDate[2])){
                totalDays += endDate[0];
                daysCount += endDate[0];
            }
            else{
                totalDays += endDate[0];
                daysCount += endDate[0];
            }
        }
        if(!start){
            totalDays--;
        }
        if(!end){
            totalDays--;
        }
        return totalDays;
    }
}
