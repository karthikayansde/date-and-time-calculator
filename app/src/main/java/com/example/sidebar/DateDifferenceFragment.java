package com.example.sidebar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.DateDifference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DateDifferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DateDifferenceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DateDifferenceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DateDifferenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DateDifferenceFragment newInstance(String param1, String param2) {
        DateDifferenceFragment fragment = new DateDifferenceFragment();
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
    Integer year1 = 0, month1 = 0, date1 = 0;
    Integer year2 = 0, month2 = 0, date2 = 0;
    boolean start = false, end = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_date_difference, container, false);

        //------date input area
        RelativeLayout dateInput =(RelativeLayout) view.findViewById(R.id.dateInput);
        RelativeLayout dateInput2 =(RelativeLayout) view.findViewById(R.id.dateInput2);
        TextView tv = (TextView) view.findViewById(R.id.editt);
        TextView tv2 = (TextView) view.findViewById(R.id.editt2);

        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener, CurrentDateTime.year(),CurrentDateTime.month()-1,CurrentDateTime.day());
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
        //---------
        dateInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener2,CurrentDateTime.year(),CurrentDateTime.month()-1,CurrentDateTime.day());
                dialog.show();
                dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
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
        //-----------date input area over-------------

        //-----------calculation button area----------

        RelativeLayout ansArea = view.findViewById(R.id.rl);
        Button btn = view.findViewById(R.id.btn);
        CheckBox c1 = view.findViewById(R.id.sinclude);
        CheckBox c2 = view.findViewById(R.id.einclude);
        TextView anstv = view.findViewById(R.id.ans);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] startarr = {date1,month1,year1};
                int[] endarr = {date2,month2,year2};
                start = c1.isChecked();
                end = c2.isChecked();
                int ans = DateDifference.DateDifferenceFinder(start,end,startarr,endarr);
                anstv.setText(String.valueOf(ans));
                ansArea.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}