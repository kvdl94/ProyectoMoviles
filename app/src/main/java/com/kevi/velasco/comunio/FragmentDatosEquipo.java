package com.kevi.velasco.comunio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentDatosEquipo extends Fragment {

    public FragmentDatosEquipo() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datos_equipo, container, false);

        ImageView imageViewEscudo = view.findViewById(R.id.imageViewEscudoDatosEquipo);
        TextView textViewNombre = view.findViewById(R.id.textViewNombreDatos);
        TextView textViewLocalizacion = view.findViewById(R.id.textViewLocalizacionDatos);
        TextView textViewEstadio = view.findViewById(R.id.textViewEstadioDatosEquipo);
        TextView textViewDivision = view.findViewById(R.id.textViewDivisionDatosEquipo);

        EscudoViewModel escudoViewModel = new ViewModelProvider(requireActivity()).get(EscudoViewModel.class);
        EquipoViewModel equipoViewModel = new ViewModelProvider(requireActivity()).get(EquipoViewModel.class);
        LetraViewModel letraViewModel = new ViewModelProvider(requireActivity()).get(LetraViewModel.class);


        letraViewModel.getTamanioLetra().observe(getViewLifecycleOwner(), nuevoTam -> {

                textViewNombre.setTextSize(nuevoTam);
                textViewLocalizacion.setTextSize(nuevoTam);
                textViewEstadio.setTextSize(nuevoTam);
                textViewDivision.setTextSize(nuevoTam);

        });

        escudoViewModel.getEscudoSeleccionado().observe(getViewLifecycleOwner(), escudo -> {
            ArrayList<Equipo> equipos = DAO.obtenerEquipos();
            for (Equipo equipo : equipos) {
                if (equipo.getImagenEscudo() == escudo) {
                    imageViewEscudo.setImageResource(equipo.getImagenEscudo());
                    textViewNombre.setText("Nombre: " + equipo.getNombre());
                    textViewLocalizacion.setText("Localización: " + equipo.getLocalizacion());
                    textViewEstadio.setText("Estadio: " + equipo.getNombreEstadio());
                    textViewDivision.setText("División: " + equipo.getDivision());

                    equipoViewModel.setEquipoSeleccionado(equipo);
                    break;
                }
            }
        });

        return view;
    }
}