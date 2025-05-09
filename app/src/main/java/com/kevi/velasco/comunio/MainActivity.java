package com.kevi.velasco.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_toolbar,menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.idCerrar){
            finishAffinity();
        }
        if (item.getItemId() == R.id.idLetra) {

        }


        return super.onOptionsItemSelected(item);
    }





}