package com.example.sidebar.backend;

public class SumOnDate {

    public static int[] dateAdd(int[] current, int[] input){ // input is year, month, week, days
        //changing current values
        current[2] += input[0];
        // month add
        current[1] += input[1];
        if(current[1] > 11){
            current[2] += current[1] / 12;
            current[1] = current[1] % 12;
        }
        // day area
        int dayCount = (7 * input[2]) + input[3];

        boolean loopState = true;
        loopBreaker:
        while (loopState) {
            while (loopState) {
                while(loopState){
                    if (dayCount > 0) {
                        int mDays = Mother.MONTHS[current[1]];
                        if(Mother.isLeap(current[2]) && (current[1] == 1)){
                            mDays++;
                        }
                        if(current[0] < mDays){
                            current[0]++;
                            dayCount--;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break loopBreaker;
                    }
                }
                if(current[1] == 11){
                    current[0] = 0;
                    current[1] = 0;
                    break;
                }
                else{
                    current[0] = 0;
                    current[1]++;
                }
            }
            current[2]++;
        }

        return current;
    }

    //-------------------------------------------------------------------------------------

    public static int[] dateSub(int[] current, int[] input){ // input is year, month, week, days
        //changing current values
        current[2] -= input[0];
        // month area
        current[1] -= input[1];
        if(current[1] < 0){
            current[2] = current[2] - (-current[1] / 12);
            if(current[1] % 12 != 0){
                current[2]--;
                current[1] = 12 - (-current[1]%12);
            }
            else{
                current[1] = 0;
            }
        }
        // day area
        int dayCount = (7 * input[2]) + input[3];

        boolean loopState = true;
        loopBreaker:
        while (loopState) {
            while (loopState) {
                while(loopState){
                    if (dayCount > 0) {
                        if(current[0] > 1){
                            current[0]--;
                            dayCount--;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break loopBreaker;
                    }
                }
                if(current[1] == 0){
                    current[0] = Mother.MONTHS[11];
                    current[1] = 11;
                    break;
                }
                else{
                    int mDays = Mother.MONTHS[current[1]-1];
                    if(Mother.isLeap(current[2]) && (current[1] == 1)){
                        mDays++;
                    }
                    current[0] = mDays;
                    current[1]--;
                }
            }
            current[2]--;
        }
        return current;
    }
    // with time------------------------------------------------------------------------------------------------------
    public static int[] dateTimeAdd(int[] current, int[] input){ // input is year, month, week, days || hour, minute, second
        //           0      1     2      3       4     5        6
        // current  day, month, year, hours, minute, second
        //changing current values

        int[] start = {current[3], current[4], current[5]};
        int[] end = {input[4], input[5], input[6]};
        long time = TimeAdd.timeAdd(start, end);

        current[2] += input[0];
        // month add
        current[1] += input[1];
        if(current[1] > 11){
            current[2] += current[1] / 12;
            current[1] = current[1] % 12;
        }
        // day area
        int dayCount = (7 * input[2]) + input[3] + (int)(time/60/60/24);

        boolean loopState = true;
        loopBreaker:
        while (loopState) {
            while (loopState) {
                while(loopState){
                    if (dayCount > 0) {
                        int mDays = Mother.MONTHS[current[1]];
                        if(Mother.isLeap(current[2]) && (current[1] == 1)){
                            mDays++;
                        }
                        if(current[0] < mDays){
                            current[0]++;
                            dayCount--;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break loopBreaker;
                    }
                }
                if(current[1] == 11){
                    current[0] = 0;
                    current[1] = 0;
                    break;
                }
                else{
                    current[0] = 0;
                    current[1]++;
                }
            }
            current[2]++;
        }
        current[3] = (int)(time/60/60%24);
        current[4] = (int)(time/60%60);
        current[5] = (int)(time%60);
        return current;
    }


    //----------------------------------------------------------------------------------------------------------


    public static int[] dateTimeSub(int[] current, int[] input){  // input is year, month, week, days || hour, minute, second
        //           0      1     2      3       4     5        6
        //          days, month, year, hours, minute, second
        //changing current values

        int[] start = {current[3], current[4], current[5]};
        int[] end = {input[4], input[5], input[6]};
        int totalStart = start[0]*60*60 + start[1]*60 + start[2];
        int totalEnd = end[0]*60*60 + end[1]*60 + end[2];

        boolean ownTime = false;

        long time = 0;
        if((end[0]==0) && (end[1] == 0) && (end[2] == 0)){
            ownTime = true;
        }
        else{
            time = TimeDifference.timeDifference(start, end);
        }

        current[2] -= input[0];
        // month area
        current[1] -= input[1];
        if(current[1] < 0){
            current[2] = current[2] - (-current[1] / 12);
            if(current[1] % 12 != 0){
                current[2]--;
                current[1] = 12 - (-current[1]%12);
            }
            else{
                current[1] = 0;
            }
        }
        // day area
        boolean change = false;
        int h=0,m=0,s=0;
        int dayCount = (7 * input[2]) + input[3] + (int)(time/60/60/24);
        if(ownTime == false){
            h = (int)time/60/60%24;
            m = (int)time/60%60;
            s = (int)time%60;

            if(totalStart < totalEnd){
                int cur[] = {current[0], current[1], current[2]};
                int inp[] = {0,0,0,1};
                int ar[] = SumOnDate.dateSub(cur, inp);
                current[0] = ar[0];
                current[1] = ar[1];
                current[2] = ar[2];
            }
            change = true;
        }

        boolean loopState = true;
        loopBreaker:
        while (loopState) {
            while (loopState) {
                while(loopState){
                    if (dayCount > 0) {
                        if(current[0] > 0){
                            current[0]--;
                            dayCount--;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break loopBreaker;
                    }
                }
                if(current[1] == 0){
                    current[0] = Mother.MONTHS[11];
                    current[1] = 11;
                    break;
                }
                else{
                    int mDays = Mother.MONTHS[current[1]-1];
                    if(Mother.isLeap(current[2]) && (current[1]-1 == 1)){
                        mDays++;
                    }
                    current[0] = mDays;
                    current[1]--;
                }
            }
            current[2]--;
        }

        int timeFinal = 0;
        if(change){
            timeFinal = 86400 - (h*60*60) - (m*60) - s;
        }

        if(ownTime){
            return current;
        }
        current[3] = timeFinal/60/60%24;
        current[4] = timeFinal/60%60;
        current[5] = timeFinal%60;
        return current;
    }
}
