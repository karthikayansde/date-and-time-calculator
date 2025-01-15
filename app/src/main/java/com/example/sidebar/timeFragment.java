package com.example.sidebar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.DateAndTimeDiff;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link timeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class timeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public timeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment timeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static timeFragment newInstance(String param1, String param2) {
        timeFragment fragment = new timeFragment();
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
    DatePickerDialog.OnDateSetListener dateSetListener, dateSetListener2;
    Integer year1 = 0, month1 = 0, date1 = 0, hour1 = 0, minute1 = 0, second1 = 0;
    Integer year2 = 0, month2 = 0, date2 = 0, hour2 = 0, minute2 = 0, second2 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_time, container, false);
        RelativeLayout dateInput = (RelativeLayout) view.findViewById(R.id.dateInput);
        TextView tv = (TextView) view.findViewById(R.id.editt);
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener,CurrentDateTime.year(),CurrentDateTime.month()-1,CurrentDateTime.day());
                dialog.show();
                dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                String date = dayOfMonth+"/"+month+"/"+year;
                year1 = year;
                month1 = month;
                date1 = dayOfMonth;
                tv.setText(date);
            }
        };


        // time picker area
        TextView timedt = view.findViewById(R.id.edittime);
        RelativeLayout timePicker = view.findViewById(R.id.timePicker);
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hour1 = hourOfDay;
                        minute1 = minute;
                        timedt.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                    }
                },0,0,false);
                timePickerDialog.updateTime(CurrentDateTime.hour(),CurrentDateTime.minutes());
                timePickerDialog.show();
                timePickerDialog.getButton(TimePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                timePickerDialog.getButton(TimePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
            }
        });

        //seconds area
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerss);
//        TextView tvss = (TextView) view.findViewById(R.id.ss);
        ArrayAdapter<CharSequence> array = ArrayAdapter.createFromResource(getContext(),R.array.array_of_seconds, R.layout.spinner_layout);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(array);

        //-----------------------------------------------------------------------------------------------------------------------
        RelativeLayout dateInput2 = (RelativeLayout) view.findViewById(R.id.dateInput2);
        TextView tv2 = (TextView) view.findViewById(R.id.editt2);
        dateInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog2 = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener2,CurrentDateTime.year(),CurrentDateTime.month()-1,CurrentDateTime.day());
                dialog2.show();
                dialog2.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                dialog2.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
            }
        });
        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                String date = dayOfMonth+"/"+month+"/"+year;
                year2 = year;
                month2 = month;
                date2 = dayOfMonth;
                tv2.setText(date);
            }
        };


        // time picker area
        TextView timedt2 = view.findViewById(R.id.edittime2);
        RelativeLayout timePicker2 = view.findViewById(R.id.timePicker2);
        timePicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] hour = new int[1];
                final int[] minutes = new int[1];
                TimePickerDialog timePickerDialog2 = new TimePickerDialog(
                        getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hour2 = hourOfDay;
                        minute2 = minute;
                        timedt2.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                    }
                },0,0,false);
                timePickerDialog2.updateTime(CurrentDateTime.hour(), CurrentDateTime.minutes());
                timePickerDialog2.show();
                timePickerDialog2.getButton(TimePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                timePickerDialog2.getButton(TimePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
            }
        });

        //seconds area
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinnerss2);
//        TextView tvss = (TextView) view.findViewById(R.id.ss2);
        ArrayAdapter<CharSequence> array2 = ArrayAdapter.createFromResource(getContext(),R.array.array_of_seconds, R.layout.spinner_layout);
        array2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(array2);

        //button area-----------------------------------------------------------
        Button btn = view.findViewById(R.id.btn);
        RelativeLayout ansArea = view.findViewById(R.id.ansArea);
        TextView d1,d2,h1,h2,m1,m2,s1,s2;
        d1 = view.findViewById(R.id.dans1);
        d2 = view.findViewById(R.id.dans2);
        h1 = view.findViewById(R.id.hans1);
        h2 = view.findViewById(R.id.hans2);
        m1 = view.findViewById(R.id.mans1);
        m2 = view.findViewById(R.id.mans2);
        s1 = view.findViewById(R.id.sans1);
        s2 = view.findViewById(R.id.sans2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second1 = Integer.parseInt(spinner.getSelectedItem().toString());
                second2 = Integer.parseInt(spinner2.getSelectedItem().toString());
                if(month1 != 0){
                    month1--;
                }
                if(month2 != 0){
                    month2--;
                }
                int[] start = {date1,month1,year1,hour1,minute1,second1};
                int[] end = {date2,month2,year2,hour2,minute2,second2};
                int[] ans = DateAndTimeDiff.dateAndTime(start,end);
                d1.setText(String.valueOf(ans[0]));
                h1.setText(String.valueOf(ans[1]));
                m1.setText(String.valueOf(ans[2]));
                s1.setText(String.valueOf(ans[3]));

                d2.setText(String.valueOf(ans[0]));
                h2.setText(String.valueOf(ans[0]*24+ans[1]));
                m2.setText(String.valueOf(ans[0]*24*60+ans[1]*60+ans[2]));
                s2.setText(String.valueOf(ans[0]*24*60*60+ans[1]*60+ans[2]*60+ans[3]));
                ansArea.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}