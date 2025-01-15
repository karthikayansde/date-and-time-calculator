package com.example.sidebar.mode;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sidebar.MainActivity;

public class ModeChange {
    Context con;
    SharedPreferences sp;
    public ModeChange(Context context){
        con = context;
        sp = context.getSharedPreferences("mode",Context.MODE_PRIVATE);
    }
    public int getMode(){
        return sp.getInt("Mode",-1);
    }
    public void setMode(int val){
        SharedPreferences.Editor edt = sp.edit();
        edt.putInt("Mode",val);
        edt.commit();
    }
}
