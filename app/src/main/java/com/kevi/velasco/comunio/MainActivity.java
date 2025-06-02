package com.kevi.velasco.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView fondo, escudo, next, atras;
    ArrayList<Equipo> equipos = new ArrayList<>();
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.imageView2);
        next.setImageResource(R.drawable.siguiente);

        atras = findViewById(R.id.imageViewAtras);
        atras.setImageResource(R.drawable.anterior);

        fondo = findViewById(R.id.imageView);
        fondo.setImageResource(R.drawable.fondo);

        escudo = findViewById(R.id.imageViewEscudo);


        DAO.cargarDatosDesdeInternet(this, new DAO.Callback() {
            @Override
            public void onSuccess() {
                equipos = DAO.obtenerEquipos();
                if (!equipos.isEmpty()) {
                    mostrarEscudoActual();
                }
            }

            @Override
            public void onError(Exception e) {
            System.out.println("sdnjsdns");
            }
        });

        next.setOnClickListener(view -> {
            if (!equipos.isEmpty()) {
                if (posicion >= equipos.size() - 1) {
                    posicion = 0;
                } else {
                    posicion++;
                }
                mostrarEscudoActual();
            }
        });

        atras.setOnClickListener(view -> {
            if (!equipos.isEmpty()) {
                if (posicion == 0) {
                    posicion = equipos.size() - 1;
                } else {
                    posicion--;
                }
                mostrarEscudoActual();
            }
        });

        escudo.setOnClickListener(view -> {
            if (!equipos.isEmpty()) {
                Equipo equipoSeleccionado = equipos.get(posicion);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("equipo", equipoSeleccionado);
                startActivity(intent);
            }
        });
    }

    private void mostrarEscudoActual() {
        if (equipos.isEmpty()) return;

        Equipo equipo = equipos.get(posicion);
        Picasso.get()
                .load(equipo.getEscudoUrl())
                .into(escudo);
    }
}
