package com.example.sidebar;

import static com.example.sidebar.backend.CurrentDateTime.year;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.SumOnDate;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dateFragment newInstance(String param1, String param2) {
        dateFragment fragment = new dateFragment();
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
    DatePickerDialog.OnDateSetListener dateSetListener;
    Integer days=CurrentDateTime.day(),months=CurrentDateTime.month(),years=CurrentDateTime.year(),minutes=CurrentDateTime.minutes(),hours=CurrentDateTime.hour(),seconds = 0;
    Integer y = 0,m = 0,w = 0,d = 0,h = 0,mm = 0,s = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_date, container, false);
        RelativeLayout dateInput = (RelativeLayout) view.findViewById(R.id.dateInput);
        TextView tv = (TextView) view.findViewById(R.id.editt);
        tv.setText(days+"-"+months+"-"+years);
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener,CurrentDateTime.year(), CurrentDateTime.month()-1,CurrentDateTime.day());
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
                years = year;
                months = month;
                days = dayOfMonth;
                tv.setText(date);
            }
        };


        // time picker area
        TextView timedt = view.findViewById(R.id.edittime);
        timedt.setText(hours+":"+minutes);
        RelativeLayout timePicker = view.findViewById(R.id.timePicker);
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hours = hourOfDay;
                        minutes = minute;
                        timedt.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                    }
                }, 0,0,false);
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

        //--------------------getting inputs over ----------------------------

        TextView dateans = view.findViewById(R.id.resultans1);
        TextView timeans = view.findViewById(R.id.resultans2);
        Button btnAdd = view.findViewById(R.id.btnadd);
        Button btnSub = view.findViewById(R.id.btnsub);
        RelativeLayout ansArea = view.findViewById(R.id.ansArea);

        EditText ety,etm,etw,etd,eth,etmm,ets;
        ety = view.findViewById(R.id.yeari);
        etm = view.findViewById(R.id.monthi);
        etw = view.findViewById(R.id.weeki);
        etd = view.findViewById(R.id.daysi);
        eth = view.findViewById(R.id.houri);
        etmm = view.findViewById(R.id.minutei);
        ets = view.findViewById(R.id.secondi);
        ety.setHint(String.valueOf(y));
        etm.setHint(String.valueOf(m));
        etw.setHint(String.valueOf(w));
        etd.setHint(String.valueOf(d));
        eth.setHint(String.valueOf(h));
        etmm.setHint(String.valueOf(mm));
        ets.setHint(String.valueOf(s));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds = Integer.parseInt(spinner.getSelectedItem().toString());

                if(!ety.getText().toString().trim().equals("")){
                    y = Integer.parseInt(ety.getText().toString());
                }
                if(!etm.getText().toString().trim().equals("")){
                    m = Integer.parseInt(etm.getText().toString());
                }
                if(!etw.getText().toString().trim().equals("")){
                    w = Integer.parseInt(etw.getText().toString());
                }
                if(!etd.getText().toString().trim().equals("")){
                    d = Integer.parseInt(etd.getText().toString());
                }
                if(!eth.getText().toString().trim().equals("")){
                    h = Integer.parseInt(eth.getText().toString());
                }
                if(!etmm.getText().toString().trim().equals("")){
                    mm = Integer.parseInt(etmm.getText().toString());
                }
                if(!ets.getText().toString().trim().equals("")){
                    s = Integer.parseInt(ets.getText().toString());
                }
                int[] current = {days,months,years,hours,minutes,seconds};
                int[] input = {y,m,w,d,h,mm,s};
                int[] ans = SumOnDate.dateTimeAdd(current,input);
                String date = ans[0]+"-"+ans[1]+"-"+ans[2];
                String time = ans[3]+":"+ans[4]+":"+ans[5];
                dateans.setText(date);
                timeans.setText(time);
                ansArea.setVisibility(View.VISIBLE);
                Activity activity = getActivity();
                InputMethodManager keyBoardCloser = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                keyBoardCloser.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds = Integer.parseInt(spinner.getSelectedItem().toString());

                if(!ety.getText().toString().trim().equals("")){
                    y = Integer.parseInt(ety.getText().toString());
                }
                if(!etm.getText().toString().trim().equals("")){
                    m = Integer.parseInt(etm.getText().toString());
                }
                if(!etw.getText().toString().trim().equals("")){
                    w = Integer.parseInt(etw.getText().toString());
                }
                if(!etd.getText().toString().trim().equals("")){
                    d = Integer.parseInt(etd.getText().toString());
                }
                if(!eth.getText().toString().trim().equals("")){
                    h = Integer.parseInt(eth.getText().toString());
                }
                if(!etmm.getText().toString().trim().equals("")){
                    mm = Integer.parseInt(etmm.getText().toString());
                }
                if(!ets.getText().toString().trim().equals("")){
                    s = Integer.parseInt(ets.getText().toString());
                }
                int[] current = {days,months,years,hours,minutes,seconds};
                int[] input = {y,m,w,d,h,mm,s};
                int[] ans = SumOnDate.dateTimeSub(current,input);
                String date = ans[0]+"-"+ans[1]+"-"+ans[2];
                String time = ans[3]+":"+ans[4]+":"+ans[5];
                dateans.setText(date);
                timeans.setText(time);
                ansArea.setVisibility(View.VISIBLE);
                Activity activity = getActivity();
                InputMethodManager keyBoardCloser = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                keyBoardCloser.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });

        return view;
    }

}