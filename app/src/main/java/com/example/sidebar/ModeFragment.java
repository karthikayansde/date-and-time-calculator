package com.example.sidebar;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sidebar.mode.ModeChange;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ModeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ModeFragment newInstance(String param1, String param2) {
        ModeFragment fragment = new ModeFragment();
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
    RadioGroup rg;
    RadioButton rb1,rb2,rb3;
    ModeChange mc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mode, container, false);

        rg = view.findViewById(R.id.rg);
        rb1 = view.findViewById(R.id.system);
        rb2 = view.findViewById(R.id.light);
        rb3 = view.findViewById(R.id.dark);
        mc = new ModeChange(view.getContext());
        if(mc.getMode() == -1){
            rb1.setChecked(true);
        }
        else if(mc.getMode() == 1){
            rb2.setChecked(true);
        }
        else{
            rb3.setChecked(true);
        }
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc.setMode(-1);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc.setMode(1);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc.setMode(2);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });
        return view;
    }
}