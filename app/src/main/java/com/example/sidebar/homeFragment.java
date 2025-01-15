package com.example.sidebar;

import android.app.ActivityManager;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view  = inflater.inflate(R.layout.fragment_home, container, false);
        FragmentManager fm = getFragmentManager();
        CardView cv1 = (CardView) view.findViewById(R.id.card1);
        CardView cv2 = (CardView) view.findViewById(R.id.card2);
        CardView cv3 = (CardView) view.findViewById(R.id.card3);
        CardView cv4 = (CardView) view.findViewById(R.id.card4);
        CardView cv5 = (CardView) view.findViewById(R.id.card5);
        CardView cv6 = (CardView) view.findViewById(R.id.card6);
        CardView cv7 = (CardView) view.findViewById(R.id.card7);
        CardView cv8 = (CardView) view.findViewById(R.id.card8);
        CardView cv9 = (CardView) view.findViewById(R.id.card9);
        CardView cv10 = (CardView) view.findViewById(R.id.card10);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,dateFragment.class,null).addToBackStack("name").commit();
                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    bnv.setSelectedItemId(R.id.date);
                }
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,timeFragment.class,null).addToBackStack("name").commit();
                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    bnv.setSelectedItemId(R.id.time);
                }
            }
        });
//        cv3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fm.beginTransaction().replace(R.id.fragmentContainerView,travalFragment.class,null).addToBackStack("name").commit();
//                View viewofp = getActivity().findViewById(R.id.bnv);
//                if(viewofp instanceof BottomNavigationView){
//                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
//                    bnv.setSelectedItemId(R.id.traval);
//                }
//            }
//        });
//        cv4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fm.beginTransaction().replace(R.id.fragmentContainerView,AgeDiffFragment.class,null).addToBackStack("name").commit();
//
//                View viewofp = getActivity().findViewById(R.id.bnv);
//                if(viewofp instanceof BottomNavigationView){
//                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
//                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
//                }
//            }
//        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,TimeAddSubFragment.class,null).addToBackStack("name").commit();

                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
                }
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,TimeDifferenceFragment.class,null).addToBackStack("name").commit();

                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
                }
            }
        });
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,DateAddSubFragment.class,null).addToBackStack("name").commit();

                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    bnv.setSelectedItemId(R.id.traval);
                }
            }
        });
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,DateDifferenceFragment.class,null).addToBackStack("name").commit();

                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
                }
            }
        });
        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,dayFragment.class,null).addToBackStack("name").commit();

                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
                }
            }
        });
        cv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,DaysFragment.class,null).addToBackStack("name").commit();

                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
                }
            }
        });
        cv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,LeapYearFragment.class,null).addToBackStack("name").commit();
                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    ((MainActivity)getActivity()).bnv.setVisibility(View.GONE);
                }
            }
        });
        cv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView,ModeFragment.class,null).addToBackStack("name").commit();
                View viewofp = getActivity().findViewById(R.id.bnv);
                if(viewofp instanceof BottomNavigationView){
                    BottomNavigationView bnv = (BottomNavigationView) viewofp;
                    bnv.setSelectedItemId(R.id.settings);
                }
            }
        });
        return view;
    }
}