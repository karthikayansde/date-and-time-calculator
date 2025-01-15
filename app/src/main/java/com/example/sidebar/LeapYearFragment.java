package com.example.sidebar;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.sidebar.backend.BulkLeap;
import com.example.sidebar.backend.CurrentDateTime;
import com.example.sidebar.backend.LeapYear;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeapYearFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeapYearFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LeapYearFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeapYearFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeapYearFragment newInstance(String param1, String param2) {
        LeapYearFragment fragment = new LeapYearFragment();
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_leap_year, container, false);

        TextView tv = view.findViewById(R.id.yearcus);

        RelativeLayout pop = view.findViewById(R.id.yearrl);
        NumberPicker yearPicker = view.findViewById(R.id.noPicker);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            yearPicker.setTextColor(0x00000000);
//        }
        yearPicker.setMinValue(101);
        yearPicker.setMaxValue(10000);
        yearPicker.setValue(yearVal);
        tv.setText(String.valueOf(yearVal));
        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv.setText(String.valueOf(newVal));
                yearVal = newVal;
            }
        });

        RelativeLayout year = view.findViewById(R.id.input);
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
//----------------------input area over-------------------------------------
        //calculation area------------------------------------------
        Button btn = view.findViewById(R.id.btn);
        TextView ansTv = view.findViewById(R.id.anstv);
        TableLayout anstbl = view.findViewById(R.id.ans2);
//--------------------table----------------------------
        ArrayList<TextView> a = new ArrayList<>();
        ArrayList<TextView> b = new ArrayList<>();
        ArrayList<TextView> c = new ArrayList<>();
        ArrayList<TextView> d = new ArrayList<>();

        a.add(view.findViewById(R.id.a1));
        b.add(view.findViewById(R.id.b1));
        c.add(view.findViewById(R.id.c1));
        d.add(view.findViewById(R.id.d1));

        a.add(view.findViewById(R.id.a2));
        b.add(view.findViewById(R.id.b2));
        c.add(view.findViewById(R.id.c2));
        d.add(view.findViewById(R.id.d2));

        a.add(view.findViewById(R.id.a3));
        b.add(view.findViewById(R.id.b3));
        c.add(view.findViewById(R.id.c3));
        d.add(view.findViewById(R.id.d3));

        a.add(view.findViewById(R.id.a4));
        b.add(view.findViewById(R.id.b4));
        c.add(view.findViewById(R.id.c4));
        d.add(view.findViewById(R.id.d4));

        a.add(view.findViewById(R.id.a5));
        b.add(view.findViewById(R.id.b5));
        c.add(view.findViewById(R.id.c5));
        d.add(view.findViewById(R.id.d5));

        a.add(view.findViewById(R.id.a6));
        b.add(view.findViewById(R.id.b6));
        c.add(view.findViewById(R.id.c6));
        d.add(view.findViewById(R.id.d6));

        a.add(view.findViewById(R.id.a7));
        b.add(view.findViewById(R.id.b7));
        c.add(view.findViewById(R.id.c7));
        d.add(view.findViewById(R.id.d7));

        a.add(view.findViewById(R.id.a8));
        b.add(view.findViewById(R.id.b8));
        c.add(view.findViewById(R.id.c8));
        d.add(view.findViewById(R.id.d8));

        a.add(view.findViewById(R.id.a9));
        b.add(view.findViewById(R.id.b9));
        c.add(view.findViewById(R.id.c9));
        d.add(view.findViewById(R.id.d9));

        a.add(view.findViewById(R.id.a10));
        b.add(view.findViewById(R.id.b10));
        c.add(view.findViewById(R.id.c10));
        d.add(view.findViewById(R.id.d10));

        a.add(view.findViewById(R.id.a11));
        b.add(view.findViewById(R.id.b11));
        c.add(view.findViewById(R.id.c11));
        d.add(view.findViewById(R.id.d11));

        a.add(view.findViewById(R.id.a12));
        b.add(view.findViewById(R.id.b12));
        c.add(view.findViewById(R.id.c12));
        d.add(view.findViewById(R.id.d12));

        a.add(view.findViewById(R.id.a13));
        b.add(view.findViewById(R.id.b13));
        c.add(view.findViewById(R.id.c13));
        d.add(view.findViewById(R.id.d13));

        a.add(view.findViewById(R.id.a14));
        b.add(view.findViewById(R.id.b14));
        c.add(view.findViewById(R.id.c14));
        d.add(view.findViewById(R.id.d14));

        a.add(view.findViewById(R.id.a15));
        b.add(view.findViewById(R.id.b15));
        c.add(view.findViewById(R.id.c15));
        d.add(view.findViewById(R.id.d15));

        a.add(view.findViewById(R.id.a16));
        b.add(view.findViewById(R.id.b16));
        c.add(view.findViewById(R.id.c16));
        d.add(view.findViewById(R.id.d16));

        a.add(view.findViewById(R.id.a17));
        b.add(view.findViewById(R.id.b17));
        c.add(view.findViewById(R.id.c17));
        d.add(view.findViewById(R.id.d17));

        a.add(view.findViewById(R.id.a18));
        b.add(view.findViewById(R.id.b18));
        c.add(view.findViewById(R.id.c18));
        d.add(view.findViewById(R.id.d18));

        a.add(view.findViewById(R.id.a19));
        b.add(view.findViewById(R.id.b19));
        c.add(view.findViewById(R.id.c19));
        d.add(view.findViewById(R.id.d19));

        a.add(view.findViewById(R.id.a20));
        b.add(view.findViewById(R.id.b20));
        c.add(view.findViewById(R.id.c20));
        d.add(view.findViewById(R.id.d20));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LeapYear.checkLeap(yearVal)){
                    ansTv.setText(yearVal+" is a leap year");
                }
                else{
                    ansTv.setText(yearVal+" is not a leap year");
                }
                anstbl.setVisibility(View.VISIBLE);
                BulkLeap bl = LeapYear.bulkLeap(yearVal);
                for (int i = 0; i < 20; i++) {
                    a.get(i).setText(bl.leap[19-i]?"leap year":"not leap year");
                    b.get(i).setText(" : "+String.valueOf(bl.year[19-i]));
                    c.get(i).setText(String.valueOf(bl.year[20+i]));
                    d.get(i).setText(bl.leap[20+i]?" : leap year":" : not leap year");
                }
            }
        });
        return view;
    }
}