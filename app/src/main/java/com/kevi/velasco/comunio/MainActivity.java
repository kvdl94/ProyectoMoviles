package com.kevi.velasco.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView fondo,escudo,next,atras;
ArrayList<Integer> escudos;
int posicion=0;
int escudoSeleccionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        escudos = DAO.obtenerEscudos();


        next=findViewById(R.id.imageView2);
        next.setImageResource(R.drawable.siguiente);

        atras=findViewById(R.id.imageViewAtras);
        atras.setImageResource(R.drawable.anterior);


        fondo=findViewById(R.id.imageView);
        fondo.setImageResource(R.drawable.fondo);

        escudo=findViewById(R.id.imageViewEscudo);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posicion>=escudos.size()-1){
                    posicion = 0;

                }


                posicion++;
                escudo.setImageResource(escudos.get(posicion));



            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (posicion==0){
                         posicion=escudos.size();


                     }
                     posicion--;
                     escudo.setImageResource(escudos.get(posicion));


    }
});

escudo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         escudoSeleccionado = escudos.get(posicion);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("escudoSeleccionado", escudoSeleccionado);
        startActivity(intent);



    }
});





    }









}