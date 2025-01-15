package com.example.sidebar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.MonthAndDays;
import com.example.sidebar.backend.Mother;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dayFragment newInstance(String param1, String param2) {
        dayFragment fragment = new dayFragment();
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
    Integer year1 = CurrentDateTime.year(), month1 = CurrentDateTime.month(), date1 = CurrentDateTime.day();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day, container, false);
        //------date input area
        RelativeLayout dateInput =(RelativeLayout) view.findViewById(R.id.dateInput);
        TextView tv = (TextView) view.findViewById(R.id.editt);

        tv.setText(date1+"-"+month1+"-"+year1);
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
                year1 = year;
                month1 = month;
                date1 = dayOfMonth;
                String datein = dayOfMonth+"/"+(month+1)+"/"+year;
                tv.setText(datein);
            }
        };
        //--------date area over-----------------

        //--------button area--------------------

        Button btn = view.findViewById(R.id.btn);
        TextView ans = view.findViewById(R.id.ans);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(Mother.DAYS[MonthAndDays.dayFinder(date1, month1, year1)]);
            }
        });

        return view;
    }
}