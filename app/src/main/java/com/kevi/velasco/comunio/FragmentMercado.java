package com.kevi.velasco.comunio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentMercado extends Fragment {
    ListView lv;
    ArrayList<Jugador> jugadores = DAO.obtenerTodosLosJugadores();
    ArrayList<Jugador> jugadoresFiltrados = new ArrayList<>();
    Adapatador adaptador;
    ArrayList<Jugador> equipoUsuario = new ArrayList<>();
    CheckBox cPt, cDef, cCc, cDel, cFav;
    int presupuesto = 300;
    TextView tPresupuesto, tFichados;
    int fichados = 0;
    EquipoViewModdel equipoViewModdel;
    int porteroFichado=0;
    int defensasFichados=0;
    int centroCampistaFichado=0;
    int delanteroFichado=0;

    public FragmentMercado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mercado, container, false);
        cPt = view.findViewById(R.id.checkBoxPortero);
        cDef = view.findViewById(R.id.checkBoxDefensa);
        cCc = view.findViewById(R.id.checkBoxCentroCampista);
        cDel = view.findViewById(R.id.checkBoxDelantero);
        cFav = view.findViewById(R.id.checkBoxFavortios);
        tPresupuesto = view.findViewById(R.id.textViewPresupuesto);
        tPresupuesto.setText(String.valueOf(presupuesto));
        tFichados = view.findViewById(R.id.textViewFichados);
        tFichados.setText(String.valueOf(fichados));
        equipoViewModdel = new ViewModelProvider(requireActivity()).get(EquipoViewModdel.class);


        lv = view.findViewById(R.id.listView);
        adaptador = new Adapatador(jugadores, view.getContext());
        lv.setAdapter(adaptador);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Jugador jugadorSeleccionado = jugadoresFiltrados.get(i);
                new AlertDialog.Builder(view.getContext())
                        .setTitle("¿QUIERES COMPRAR AL JUGADOR?")
                        .setMessage(jugadorSeleccionado.getNombre() +
                                "\n" + "POSICION: " + jugadorSeleccionado.getPosicion() +
                                "\n" + "MEDIA: " + String.valueOf(jugadorSeleccionado.getMedia()) +
                                "\n" + "VALOR: " + String.valueOf(jugadorSeleccionado.getValorMercado())

                        )
                        .setPositiveButton("comprar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (equipoUsuario.contains(jugadorSeleccionado)) {
                                    Toast.makeText(view.getContext(), "El jugador ya está en el equipo", Toast.LENGTH_SHORT).show();
                                } else if (equipoUsuario.size() >= 5) {
                                    Toast.makeText(view.getContext(), "No puedes tener más de 5 jugadores", Toast.LENGTH_SHORT).show();
                                } else if (presupuesto < jugadorSeleccionado.getValorMercado()) {
                                    Toast.makeText(view.getContext(), "No tienes presupuesto suficiente", Toast.LENGTH_SHORT).show();
                                } else {

                                    if(jugadorSeleccionado.getPosicion().equalsIgnoreCase("Portero")) {
                                        if(porteroFichado >= 1){
                                            Toast.makeText(view.getContext(), "Ya tienes un portero", Toast.LENGTH_SHORT).show();
                                            return;
                                        } else {
                                            porteroFichado++;
                                        }
                                    }
                                    else if(jugadorSeleccionado.getPosicion().equalsIgnoreCase("Defensa")) {
                                        if(defensasFichados >= 2){
                                            Toast.makeText(view.getContext(), "Ya tienes dos defensas", Toast.LENGTH_SHORT).show();
                                            return;
                                        } else {
                                            defensasFichados++;
                                        }
                                    }
                                    else if(jugadorSeleccionado.getPosicion().equalsIgnoreCase("Centrocampista")) {
                                        if(centroCampistaFichado >= 1){
                                            Toast.makeText(view.getContext(), "Ya tienes un centrocampista", Toast.LENGTH_SHORT).show();
                                            return;
                                        } else {
                                            centroCampistaFichado++;
                                        }
                                    }
                                    else if(jugadorSeleccionado.getPosicion().equalsIgnoreCase("Delantero")) {
                                        if(delanteroFichado >= 1){
                                            Toast.makeText(view.getContext(), "Ya tienes un delantero", Toast.LENGTH_SHORT).show();
                                            return;
                                        } else {
                                            delanteroFichado++;
                                        }
                                    }

                                    equipoUsuario.add(jugadorSeleccionado);
                                    presupuesto -= jugadorSeleccionado.getValorMercado();
                                    tPresupuesto.setText(String.valueOf(presupuesto));
                                    Toast.makeText(view.getContext(), "Jugador comprado", Toast.LENGTH_SHORT).show();
                                    fichados++;
                                    tFichados.setText(String.valueOf(fichados));
                                    equipoViewModdel.setEquipoUsuario(equipoUsuario);
                                }
                            }
                        })
                        .setNegativeButton("cancelar", null)
                        .show();


            }
        });

        cPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadoresFiltrados.clear();

                if (cPt.isChecked()) {
                    for (Jugador j : jugadores) {
                        if (j.getPosicion().equalsIgnoreCase("Portero")) {
                            jugadoresFiltrados.add(j);
                        }
                    }
                } else {
                    jugadoresFiltrados.addAll(jugadores);
                }

                adaptador = new Adapatador(jugadoresFiltrados, view.getContext());
                lv.setAdapter(adaptador);
            }
        });

        cDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadoresFiltrados.clear();

                if (cDef.isChecked()) {
                    for (Jugador j : jugadores) {
                        if (j.getPosicion().equalsIgnoreCase("Defensa")) {
                            jugadoresFiltrados.add(j);
                        }
                    }
                } else {
                    jugadoresFiltrados.addAll(jugadores);
                }

                adaptador = new Adapatador(jugadoresFiltrados, view.getContext());
                lv.setAdapter(adaptador);
            }
        });

        cCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadoresFiltrados.clear();

                if (cCc.isChecked()) {
                    for (Jugador j : jugadores) {
                        if (j.getPosicion().equalsIgnoreCase("Centrocampista")) {
                            jugadoresFiltrados.add(j);
                        }
                    }
                } else {
                    jugadoresFiltrados.addAll(jugadores);
                }

                adaptador = new Adapatador(jugadoresFiltrados, view.getContext());
                lv.setAdapter(adaptador);
            }
        });

        cDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadoresFiltrados.clear();

                if (cDel.isChecked()) {
                    for (Jugador j : jugadores) {
                        if (j.getPosicion().equalsIgnoreCase("Delantero")) {
                            jugadoresFiltrados.add(j);
                        }
                    }
                } else {
                    jugadoresFiltrados.addAll(jugadores);
                }

                adaptador = new Adapatador(jugadoresFiltrados, view.getContext());
                lv.setAdapter(adaptador);
            }
        });



        return view;
    }


}