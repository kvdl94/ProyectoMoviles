package com.kevi.velasco.comunio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
    ArrayList<Jugador> jugadores= DAO.obtenerTodosLosJugadores();
    Adapatador adaptador;
    ArrayList<Jugador> equipoUsuario= new ArrayList<>();
    CheckBox cPt,cDef,cCc,cDel,cFav;
    int presupuesto=300;
    TextView tPresupuesto,tFichados;
    int fichados=5;


    public FragmentMercado() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mercado, container, false);
        cPt=view.findViewById(R.id.checkBoxPortero);
        cDef=view.findViewById(R.id.checkBoxDefensa);
        cCc=view.findViewById(R.id.checkBoxCentroCampista);
        cDel=view.findViewById(R.id.checkBoxDelantero);
        cFav=view.findViewById(R.id.checkBoxFavortios);
        tPresupuesto=view.findViewById(R.id.textViewPresupuesto);
        tPresupuesto.setText(String.valueOf(presupuesto));
        tFichados=view.findViewById(R.id.textViewFichados);
        tFichados.setText(String.valueOf(fichados));


        lv=view.findViewById(R.id.listView);
        adaptador = new Adapatador(jugadores, view.getContext());
        lv.setAdapter(adaptador);



lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Jugador jugadorSeleccionado= jugadores.get(i);
        new AlertDialog.Builder(view.getContext())
                .setTitle("¿QUIERES COMPRAR AL JUGADOR?")
                .setMessage(jugadorSeleccionado.getNombre()+
                "\n"+"POSICION: "+jugadorSeleccionado.getPosicion()+
                "\n"+"MEDIA: "+String.valueOf(jugadorSeleccionado.getMedia())+
                "\n"+"VALOR: "+String.valueOf(jugadorSeleccionado.getValorMercado())

                )
                .setPositiveButton("comprar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (equipoUsuario.contains(jugadorSeleccionado)) {
                            Toast.makeText(view.getContext(), "el jugador ya está en el equipo", Toast.LENGTH_SHORT).show();
                        } else if (equipoUsuario.size() >= 5) {
                            Toast.makeText(view.getContext(), "no puedes tener más de 5 jugadores", Toast.LENGTH_SHORT).show();
                        } else if (presupuesto <= jugadorSeleccionado.getValorMercado()) {
                            Toast.makeText(view.getContext(), "no tienes presupuesto suficiente", Toast.LENGTH_SHORT).show();
                        } else {
                            equipoUsuario.add(jugadorSeleccionado);
                            presupuesto -= jugadorSeleccionado.getValorMercado();
                            tPresupuesto.setText(String.valueOf(presupuesto));
                            Toast.makeText(view.getContext(), "jugador comprado", Toast.LENGTH_SHORT).show();
                            fichados-=1;
                            tFichados.setText(String.valueOf(fichados));
                        }






                    }
                })
                .setNegativeButton("cancelar",null)
                .show();




    }
});

cPt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ArrayList<Jugador> porteroFiltr = new ArrayList<>();
if (cPt.isChecked()){
    for (Jugador j: jugadores) {
        if (j.getPosicion().contains("Portero")){
            porteroFiltr.add(j);
            //donde se muestra?




        }

    }
    adaptador= new Adapatador(porteroFiltr,view.getContext());
    lv.setAdapter(adaptador);
 }else{
        adaptador= new Adapatador(jugadores,view.getContext());
        lv.setAdapter(adaptador);
    }

    }
});


        cDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Jugador> defensaFiltr = new ArrayList<>();
                if (cDef.isChecked()){
                    for (Jugador j: jugadores) {
                        if (j.getPosicion().contains("Defensa")){
                            defensaFiltr.add(j);
                            //donde se muestra?

                        }

                    }
                    adaptador= new Adapatador(defensaFiltr,view.getContext());
                    lv.setAdapter(adaptador);
                }else{
                    adaptador= new Adapatador(jugadores,view.getContext());
                    lv.setAdapter(adaptador);
                   }

            }
        });


        cCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Jugador> ccFiltr = new ArrayList<>();
                if (cCc.isChecked()){
                    for (Jugador j: jugadores) {
                        if (j.getPosicion().contains("Centrocampista")){
                            ccFiltr.add(j);
                            //donde se muestra?

                        }

                    }
                    adaptador= new Adapatador(ccFiltr,view.getContext());
                    lv.setAdapter(adaptador);
                }else{
                    adaptador= new Adapatador(jugadores,view.getContext());
                    lv.setAdapter(adaptador);
                }

            }
        });


        cDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Jugador> cDelFiltr = new ArrayList<>();
                if (cDel.isChecked()){
                    for (Jugador j: jugadores) {
                        if (j.getPosicion().contains("Delantero")){
                            cDelFiltr.add(j);
                            //donde se muestra?

                        }

                    }
                    adaptador= new Adapatador(cDelFiltr,view.getContext());
                    lv.setAdapter(adaptador);
                }else{
                    adaptador= new Adapatador(jugadores,view.getContext());
                    lv.setAdapter(adaptador);
                }

            }
        });










        return view;
    }


}