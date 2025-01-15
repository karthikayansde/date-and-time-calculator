package com.example.sidebar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.SumOnDate;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DateAddSubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DateAddSubFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DateAddSubFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DateAddSubFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DateAddSubFragment newInstance(String param1, String param2) {
        DateAddSubFragment fragment = new DateAddSubFragment();
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
    Integer days=CurrentDateTime.day(),months=CurrentDateTime.month(),years=CurrentDateTime.year();
    Integer y = 0,m = 0,w = 0,d = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_date_add_sub, container, false);
        RelativeLayout dateInput = view.findViewById(R.id.dateInput);
        TextView tv = view.findViewById(R.id.editt);
        tv.setText(days+"/"+months+"/"+years);
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener, CurrentDateTime.year(), CurrentDateTime.month()-1,CurrentDateTime.day());
                dialog.show();
                dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(0xFFFFFFFF);
                dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(0xFFFFFFFF);
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth+"/"+(month+1)+"/"+year;
                years = year;
                months = month;
                days = dayOfMonth;
                tv.setText(date);
            }
        };
        //--------------------------------------------------------------------------------------------------------------
        TextView dateans = view.findViewById(R.id.resultans1);
        RelativeLayout ansArea = view.findViewById(R.id.ansArea);
        Button btnAdd = view.findViewById(R.id.btnadd);
        Button btnSub = view.findViewById(R.id.btnsub);

        EditText ety,etm,etw,etd;
        ety = view.findViewById(R.id.yeari);
        etm = view.findViewById(R.id.monthi);
        etw = view.findViewById(R.id.weeki);
        etd = view.findViewById(R.id.daysi);
        ety.setHint(String.valueOf(y));
        etm.setHint(String.valueOf(m));
        etw.setHint(String.valueOf(w));
        etd.setHint(String.valueOf(d));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                int[] current = {days,months,years};
                int[] input = {y,m,w,d};
                int[] ans = SumOnDate.dateAdd(current,input);
                ans[1]++;
                String date = ans[0]+"-"+ans[1]+"-"+ans[2];
                dateans.setText(date);
                ansArea.setVisibility(View.VISIBLE);
                Activity activity = getActivity();
                InputMethodManager keyBoardCloser = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                keyBoardCloser.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                int[] current = {days,months,years};
                int[] input = {y,m,w,d};
                int[] ans = SumOnDate.dateSub(current,input);
                ans[1]++;
                String date = ans[0]+"-"+ans[1]+"-"+ans[2];
                dateans.setText(date);
                ansArea.setVisibility(View.VISIBLE);
                Activity activity = getActivity();
                InputMethodManager keyBoardCloser = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                keyBoardCloser.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });


        return view;
    }
}