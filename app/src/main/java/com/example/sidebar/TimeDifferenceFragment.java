package com.example.sidebar;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.TimeDifference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeDifferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeDifferenceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TimeDifferenceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeDifferenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeDifferenceFragment newInstance(String param1, String param2) {
        TimeDifferenceFragment fragment = new TimeDifferenceFragment();
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
    Integer minutes1=0,hours1=0,seconds1 = 0;
    Integer h1 = 0,m1 = 0,s1 = 0;
    Integer minutes=0,hours=0,seconds = 0;
    Integer h = 0,m = 0,s = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time_difference, container, false);

        // time picker area
        TextView timedt1 = view.findViewById(R.id.edittime1);
        RelativeLayout timePicker1 = view.findViewById(R.id.timePicker1);
        timePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hours1 = hourOfDay;
                        minutes1 = minute;
                        timedt1.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                    }
                }, 0,0,false);
                timePickerDialog.updateTime(CurrentDateTime.hour(),CurrentDateTime.minutes());
                timePickerDialog.show();
                timePickerDialog.getButton(TimePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                timePickerDialog.getButton(TimePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
            }
        });

        //seconds area
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinnerss1);
//        TextView tvss1 = (TextView) view.findViewById(R.id.ss1);
        ArrayAdapter<CharSequence> array1 = ArrayAdapter.createFromResource(getContext(),R.array.array_of_seconds, R.layout.spinner_layout);
        array1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(array1);
        //------------------first input area over------------------------------------------
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
        //-------------------------input area over----------------------------------------------
        //button------------------------------------
        Button btn = view.findViewById(R.id.btn);
        RelativeLayout ansArea = view.findViewById(R.id.ansArea);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds1 = Integer.parseInt(spinner1.getSelectedItem().toString());
                seconds = Integer.parseInt(spinner.getSelectedItem().toString());
                int[] current = {hours1,minutes1,seconds1};
                int[] input = {hours,minutes,seconds};
                long ans = TimeDifference.timeDifference(current,input);
                long da = 0, ho = 0, mi = 0, se = 0;
                da = ans/60/60/24;
                ho = ans/60/60%24;
                mi = ans/60%60;
                se = ans%60;
                TextView d1 = view.findViewById(R.id.dans1);
                TextView h1 = view.findViewById(R.id.hans1);
                TextView m1 = view.findViewById(R.id.mans1);
                TextView s1 = view.findViewById(R.id.sans1);
                d1.setText(String.valueOf(da));
                h1.setText(String.valueOf(ho));
                m1.setText(String.valueOf(mi));
                s1.setText(String.valueOf(se));
                da = ans/60/60/24;
                ho = ans/60/60;
                mi = ans/60;
                se = ans;
                TextView d2 = view.findViewById(R.id.dans2);
                TextView h2 = view.findViewById(R.id.hans2);
                TextView m2 = view.findViewById(R.id.mans2);
                TextView s2 = view.findViewById(R.id.sans2);
                d2.setText(String.valueOf(da));
                h2.setText(String.valueOf(ho));
                m2.setText(String.valueOf(mi));
                s2.setText(String.valueOf(se));
                ansArea.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}