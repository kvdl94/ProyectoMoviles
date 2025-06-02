package com.kevi.velasco.comunio;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class FragmentVideo extends Fragment {




    public FragmentVideo() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_video, container, false);
        VideoView videoView = view.findViewById(R.id.videoViewEquipo);

        EquipoViewModel equipoViewModel = new ViewModelProvider(requireActivity()).get(EquipoViewModel.class);

        equipoViewModel.getEquipoSeleccionado().observe(getViewLifecycleOwner(), equipo -> {
            if (equipo != null) {
                Uri uri = Uri.parse(equipo.getVideoUrl());
                videoView.setVideoURI(uri);


                MediaController mediaController = new MediaController(requireContext());
                mediaController.setAnchorView(videoView);
                videoView.setMediaController(mediaController);


                videoView.start();
            }
        });

        return view;
    }
}