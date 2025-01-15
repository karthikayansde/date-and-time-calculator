package com.example.sidebar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.MonthAndDays;
import com.example.sidebar.backend.Mother;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DaysFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DaysFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DaysFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DaysFragment newInstance(String param1, String param2) {
        DaysFragment fragment = new DaysFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }





    View view;
    Integer yearVal = CurrentDateTime.year();
    Integer day1 = 0, month1 = 0, year1 = yearVal;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_days, container, false);

        //------year picker----------
        TextView tv = view.findViewById(R.id.edittime);

        RelativeLayout pop = view.findViewById(R.id.yearrl);
        NumberPicker yearPicker = view.findViewById(R.id.noPicker);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            yearPicker.setTextColor(0x000000);
//        }
        yearPicker.setMinValue(101);
        yearPicker.setMaxValue(10000);
        yearPicker.setValue(yearVal);
        tv.setText(String.valueOf(yearVal));
        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv.setText(String.valueOf(newVal));
                year1 = newVal;
            }
        });

        RelativeLayout year = view.findViewById(R.id.yearPicker);
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.setVisibility(View.VISIBLE);
            }
        });
        TextView txBtn = view.findViewById(R.id.tvBtn);
        txBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.setVisibility(View.GONE);
            }
        });
        //-------------------------------------------------------
        //--------month------------------------------------------
        TextView tvM = view.findViewById(R.id.editmonth);

        month1 = (CurrentDateTime.month()-1);
        String[] months = {"1-January","2-Fibruary","3-March","4-April","5-May","6-June","7-July","8-August","9-September","10-October","11-November","12-December"};
        RelativeLayout popM = view.findViewById(R.id.monthrl);
        NumberPicker monthPicker = view.findViewById(R.id.noPickerm);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            monthPicker.setTextColor(0x000000);
//        }
        monthPicker.setMinValue(0);
        monthPicker.setMaxValue(11);
        monthPicker.setValue((CurrentDateTime.month()-1));
        monthPicker.setDisplayedValues(months);
        tvM.setText(months[(CurrentDateTime.month()-1)]);
        monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tvM.setText(months[newVal]);
                month1 = newVal;
            }
        });

        RelativeLayout month = view.findViewById(R.id.monthPicker);
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popM.setVisibility(View.VISIBLE);
            }
        });
        TextView txBtnM = view.findViewById(R.id.tvBtnM);
        txBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popM.setVisibility(View.GONE);
            }
        });
        //-------------------------------------------------------------------------
        //--------day------------------------------------------
        TextView tvD = view.findViewById(R.id.editday);

//        int currday = 0;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            LocalDate ld = LocalDate.now();
//            DayOfWeek dof = ld.getDayOfWeek();
//            currday = dof.getValue();
//            if(currday == 7){
//                currday = 0;
//            }
//        }


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        day1 = (cal.get(Calendar.DAY_OF_WEEK)-1);
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        tvD.setText(days[day1]);
        RelativeLayout popD = view.findViewById(R.id.dayrl);
        NumberPicker dayPicker = view.findViewById(R.id.noPickerD);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            dayPicker.setTextColor(0x00000000);
//        }
        dayPicker.setMinValue(0);
        dayPicker.setMaxValue(6);
        dayPicker.setValue(day1);
        dayPicker.setDisplayedValues(days);
        dayPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tvD.setText(days[newVal]);
                day1 = newVal;
            }
        });

        RelativeLayout day = view.findViewById(R.id.dayPicker);
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popD.setVisibility(View.VISIBLE);
            }
        });
        TextView txBtnD = view.findViewById(R.id.tvBtnD);
        txBtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popD.setVisibility(View.GONE);
            }
        });
        //---------------------------------------------------------------------
        //---------calculation and button area---------------------------------
        TextView anstv = view.findViewById(R.id.ans);
        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> ansAL = MonthAndDays.daysFinder(day1,month1,year1);
                String ans = String.valueOf(ansAL.get(0));
                for (int i = 1; i < ansAL.size(); i++) {
                    ans = ans.concat(" - "+String.valueOf(ansAL.get(i)));
                }
                anstv.setText(ans);
            }
        });
        return view;
    }
}