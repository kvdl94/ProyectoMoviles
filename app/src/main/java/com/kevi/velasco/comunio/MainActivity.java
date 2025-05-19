package com.kevi.velasco.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView fondo,escudo,next,atras;
    ArrayList<Equipo> equipos;
int posicion=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equipos = DAO.obtenerEquipos();


        next=findViewById(R.id.imageView2);
        next.setImageResource(R.drawable.siguiente);

        atras=findViewById(R.id.imageViewAtras);
        atras.setImageResource(R.drawable.anterior);


        fondo=findViewById(R.id.imageView);
        fondo.setImageResource(R.drawable.fondo);

        escudo=findViewById(R.id.imageViewEscudo);
        escudo.setImageResource(equipos.get(posicion).getImagenEscudo());


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posicion >= equipos.size() - 1) {
                    posicion = 0;
                } else {
                    posicion++;
                }
                escudo.setImageResource(equipos.get(posicion).getImagenEscudo());
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posicion == 0) {
                    posicion = equipos.size() - 1;
                } else {
                    posicion--;
                }
                escudo.setImageResource(equipos.get(posicion).getImagenEscudo());
            }
        });

        escudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int escudoSeleccionado = equipos.get(posicion).getImagenEscudo();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("escudoSeleccionado", escudoSeleccionado);
                startActivity(intent);
            }
        });
    }



}