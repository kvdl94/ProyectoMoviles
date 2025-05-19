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
    TextView tValor, tMedia ,tvalorEquipo, tMediaEquipo;
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
        tvalorEquipo=view.findViewById(R.id.textViewValorEquipo);
        tMediaEquipo=view.findViewById(R.id.textView7);
        LetraViewModel letraViewModel = new ViewModelProvider(requireActivity()).get(LetraViewModel.class);
        letraViewModel.getTamanioLetra().observe(getViewLifecycleOwner(), nuevoTam -> {

                tValor.setTextSize(nuevoTam);
                tMedia.setTextSize(nuevoTam);
                tvalorEquipo.setTextSize(nuevoTam);
                tMediaEquipo.setTextSize(nuevoTam);

        });

        equipoViewModdel.getEquipoUsuario().observe(getViewLifecycleOwner(), jugadoresFichados -> {

            valorTotal = 0;
            mediaEquipo = 0;



            int contDefensas = 0;

            for (Jugador j : jugadoresFichados) {
                if (j.getPosicion().equalsIgnoreCase("portero")) {
                    iPortero.setImageResource(j.getFoto());
                } else if (j.getPosicion().equalsIgnoreCase("defensa")) {
                    if (contDefensas == 0) {
                        iDefensa1.setImageResource(j.getFoto());
                        contDefensas++;
                    } else {
                        iDefensa2.setImageResource(j.getFoto());
                    }
                } else if (j.getPosicion().equalsIgnoreCase("centrocampista")) {
                    iCentroCampista.setImageResource(j.getFoto());
                } else if (j.getPosicion().equalsIgnoreCase("delantero")) {
                    iDelantero.setImageResource(j.getFoto());
                }

                valorTotal += j.getValorMercado();
                mediaEquipo += j.getMedia();
            }

            if (jugadoresFichados.size() > 0) {
                mediaEquipo = mediaEquipo / jugadoresFichados.size();
            }

            tValor.setText(String.valueOf(valorTotal));
            tMedia.setText(String.valueOf(mediaEquipo));
        });



        return view;
    }





}