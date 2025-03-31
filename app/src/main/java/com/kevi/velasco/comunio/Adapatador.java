package com.kevi.velasco.comunio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapatador extends BaseAdapter {
   ArrayList<Jugador> jugadores= DAO.obtenerTodosLosJugadores();
   Context context;

    public Adapatador(ArrayList<Jugador> jugadores, Context context) {
        this.jugadores = jugadores;
        this.context = context;
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Object getItem(int i) {
        return jugadores.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view=layoutInflater.inflate(R.layout.jugador_item,null);


        }

        TextView nombre = view.findViewById(R.id.textViewNombreJuagador);
        nombre.setText(jugadores.get(i).getNombre());

        TextView posicion = view.findViewById(R.id.textViewPosicion);
        posicion.setText(jugadores.get(i).getPosicion());

        TextView media = view.findViewById(R.id.textViewMedia);
        media.setText(String.valueOf(jugadores.get(i).getMedia()));

        TextView valor = view.findViewById(R.id.textViewValor);
        valor.setText(String.valueOf(jugadores.get(i).getValorMercado()));

        ImageView fotoJugador= view.findViewById(R.id.imageViewJuagorListView);
        fotoJugador.setImageResource(jugadores.get(i).getFoto());




        return view;
    }
}
