package com.kevi.velasco.comunio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


    public class Adapatador extends BaseAdapter {
        ArrayList<Jugador> jugadores;
        Context context;
        int tamanioLetra;

        public Adapatador(ArrayList<Jugador> jugadores, Context context, int tamanioLetra) {
            this.jugadores = jugadores;
            this.context = context;
            this.tamanioLetra = tamanioLetra;
        }


        public void setTamanioLetra(int tamanioLetra) {
            this.tamanioLetra = tamanioLetra;
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
        Picasso.get()
                .load(jugadores.get(i).getImagenUrl())
                .into(fotoJugador);

        ImageView corazon= view.findViewById(R.id.imageViewCorazon);
        corazon = view.findViewById(R.id.imageViewCorazon);


        nombre.setTextSize(tamanioLetra);
        posicion.setTextSize(tamanioLetra);
        media.setTextSize(tamanioLetra);
        valor.setTextSize(tamanioLetra);




        Jugador jugador = jugadores.get(i);






        if (jugador.isFavorito()) {
            corazon.setImageResource(R.drawable.ic_corazon_lleno);
        } else {
            corazon.setImageResource(R.drawable.ic_corazon_vacio);
        }

        corazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean nuevoEstado = !jugador.isFavorito();
                jugador.setFavorito(nuevoEstado);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
