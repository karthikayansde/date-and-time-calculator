package com.example.sidebar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import com.example.sidebar.backend.TimeAdd;
import com.example.sidebar.backend.TimeDifference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeAddSubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeAddSubFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TimeAddSubFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeAddSubFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeAddSubFragment newInstance(String param1, String param2) {
        TimeAddSubFragment fragment = new TimeAddSubFragment();
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
    Integer minutes=CurrentDateTime.minutes(),hours=CurrentDateTime.hour(),seconds = 0;
    Integer h = 0,m = 0,s = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_time_add_sub, container, false);

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

            Button btnAdd = view.findViewById(R.id.btnadd);
            Button btnSub = view.findViewById(R.id.btnsub);

            RelativeLayout ansArea1 = view.findViewById(R.id.ansArea);
            EditText eth,etm,ets;
            eth = view.findViewById(R.id.houri);
            etm = view.findViewById(R.id.minutei);
            ets = view.findViewById(R.id.secondi);
            eth.setHint("0");
            etm.setHint("0");
            ets.setHint("0");

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seconds = Integer.parseInt(spinner.getSelectedItem().toString());

                    if(!eth.getText().toString().trim().equals("")){
                        h = Integer.parseInt(eth.getText().toString());
                    }
                    if(!etm.getText().toString().trim().equals("")){
                        m = Integer.parseInt(etm.getText().toString());
                    }
                    if(!ets.getText().toString().trim().equals("")){
                        s = Integer.parseInt(ets.getText().toString());
                    }
                    int[] current = {hours,minutes,seconds};
                    int[] input = {h,m,s};

                    long ans = TimeAdd.timeAdd(current, input);
                    long we = 0, da = 0, ho = 0, mi = 0, se = 0;
                    we = ans/60/60/24/7;
                    da = ans/60/60/24;
                    ho = ans/60/60%24;
                    mi = ans/60%60;
                    se = ans%60;
                    TextView w1 = view.findViewById(R.id.w1);
                    TextView d1 = view.findViewById(R.id.d1);
                    TextView h1 = view.findViewById(R.id.h1);
                    TextView m1 = view.findViewById(R.id.m1);
                    TextView s1 = view.findViewById(R.id.s1);
                    w1.setText(": "+String.valueOf(we));
                    d1.setText(": "+String.valueOf(da));
                    h1.setText(": "+String.valueOf(ho));
                    m1.setText(": "+String.valueOf(mi));
                    s1.setText(": "+String.valueOf(se));
                    we = ans/60/60/24/7;
                    da = ans/60/60/24;
                    ho = ans/60/60;
                    mi = ans/60;
                    se = ans;
                    TextView w2 = view.findViewById(R.id.w2);
                    TextView d2 = view.findViewById(R.id.d2);
                    TextView h2 = view.findViewById(R.id.h2);
                    TextView m2 = view.findViewById(R.id.m2);
                    TextView s2 = view.findViewById(R.id.s2);
                    w2.setText(": "+String.valueOf(we));
                    d2.setText(": "+String.valueOf(da));
                    h2.setText(": "+String.valueOf(ho));
                    m2.setText(": "+String.valueOf(mi));
                    s2.setText(": "+String.valueOf(se));
                    ansArea1.setVisibility(View.VISIBLE);

                    Activity activity = getActivity();
                    InputMethodManager keyBoardCloser = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    keyBoardCloser.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
            });
            btnSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seconds = Integer.parseInt(spinner.getSelectedItem().toString());

                    if(!eth.getText().toString().trim().equals("")){
                        h = Integer.parseInt(eth.getText().toString());
                    }
                    if(!etm.getText().toString().trim().equals("")){
                        m = Integer.parseInt(etm.getText().toString());
                    }
                    if(!ets.getText().toString().trim().equals("")){
                        s = Integer.parseInt(ets.getText().toString());
                    }
                    int[] current = {hours,minutes,seconds};
                    int[] input = {h,m,s};
                    long ans = TimeDifference.timeDifference(current,input);
                    long we = 0, da = 0, ho = 0, mi = 0, se = 0;
                    we = ans/60/60/24/7;
                    da = ans/60/60/24;
                    ho = ans/60/60%24;
                    mi = ans/60%60;
                    se = ans%60;
                    TextView w1 = view.findViewById(R.id.w1);
                    TextView d1 = view.findViewById(R.id.d1);
                    TextView h1 = view.findViewById(R.id.h1);
                    TextView m1 = view.findViewById(R.id.m1);
                    TextView s1 = view.findViewById(R.id.s1);
                    w1.setText(": "+String.valueOf(we*-1));
                    d1.setText(": "+String.valueOf(da*-1));
                    h1.setText(": "+String.valueOf(ho*-1));
                    m1.setText(": "+String.valueOf(mi*-1));
                    s1.setText(": "+String.valueOf(se*-1));
                    we = ans/60/60/24/7;
                    da = ans/60/60/24;
                    ho = ans/60/60;
                    mi = ans/60;
                    se = ans;
                    TextView w2 = view.findViewById(R.id.w2);
                    TextView d2 = view.findViewById(R.id.d2);
                    TextView h2 = view.findViewById(R.id.h2);
                    TextView m2 = view.findViewById(R.id.m2);
                    TextView s2 = view.findViewById(R.id.s2);
                    w2.setText(": "+String.valueOf(we*-1));
                    d2.setText(": "+String.valueOf(da*-1));
                    h2.setText(": "+String.valueOf(ho*-1));
                    m2.setText(": "+String.valueOf(mi*-1));
                    s2.setText(": "+String.valueOf(se*-1));
                    ansArea1.setVisibility(View.VISIBLE);

                    Activity activity = getActivity();
                    InputMethodManager keyBoardCloser = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    keyBoardCloser.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
            });
        return view;
    }
}