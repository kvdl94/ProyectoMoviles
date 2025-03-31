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


public class FragmentEquipo extends Fragment {
    EquipoViewModdel equipoViewModdel;
    ImageView iPortero, iDefensa1, iDefensa2, iCentroCampista, iDelantero;
    int valorTotal = 0;
    TextView tValor, tMedia;
    int mediaEquipo;


    public FragmentEquipo() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_equipo, container, false);
        equipoViewModdel = new ViewModelProvider(requireActivity()).get(EquipoViewModdel.class);
        iPortero = view.findViewById(R.id.imageViewPortero);
        iDefensa1 = view.findViewById(R.id.imageViewDefensa1);
        iDefensa2 = view.findViewById(R.id.imageViewDefensa2);
        iCentroCampista = view.findViewById(R.id.imageViewCentroCampista);
        iDelantero = view.findViewById(R.id.imageViewDelantero);
        tValor = view.findViewById(R.id.textView2);
        tMedia = view.findViewById(R.id.textViewMediaEquipo);


        equipoViewModdel.getEquipoUsuario().observe(getViewLifecycleOwner(), jugadoresFichados -> {
            for (Jugador j : jugadoresFichados) {
                if (j.getPosicion().equals("portero")) {
                    iPortero.setImageResource(j.getFoto());

                } else if ((j.getPosicion().equals("centrocampista"))) {
                    iDelantero.setImageResource(jugadoresFichados.get(4).getFoto());
                } else if ((j.getPosicion().equals("centrocampista"))) {

                    iCentroCampista.setImageResource(j.getFoto());

                } else if ((j.getPosicion().equals("delantero"))) {

                    iCentroCampista.setImageResource(j.getFoto());

                } else {

                    iDefensa1.setImageResource(jugadoresFichados.get(1).getFoto());
                    iDefensa2.setImageResource(jugadoresFichados.get(2).getFoto());


                }

                valorTotal += j.getValorMercado();
                mediaEquipo += j.getMedia();
                mediaEquipo = mediaEquipo / jugadoresFichados.size();

            }

            tValor.setText(String.valueOf(valorTotal));
            tMedia.setText(String.valueOf(mediaEquipo));

        });


        return view;
    }
}