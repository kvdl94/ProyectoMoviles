package com.kevi.velasco.comunio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentInfoEquipo extends Fragment {



    private String mParam1;
    private String mParam2;

    public FragmentInfoEquipo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_info_equipo, container, false);





        return view;
    }
}