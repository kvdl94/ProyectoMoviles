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

public class MainActivity2 extends AppCompatActivity  {
ImageView imagenEscudoSele,imageMercado, imagenPlantilla, imagenInfoEquipo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int escudoSeleccionado = getIntent().getIntExtra("escudoSeleccionado", -5);
        imagenEscudoSele=findViewById(R.id.imageViewEscudoSelecc);
        imagenEscudoSele.setImageResource(escudoSeleccionado);
        imageMercado=findViewById(R.id.imageViewMercado);
        imagenPlantilla=findViewById(R.id.imageViewPlantilla);
        imagenInfoEquipo=findViewById(R.id.imageViewEquipo);

        imageMercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View fragmentContainer = findViewById(R.id.fragmentContainerView);
                fragmentContainer.setVisibility(View.VISIBLE);
                imagenEscudoSele.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, new FragmentMercado())
                        .addToBackStack(null)
                        .commit();
            }
        });


imagenPlantilla.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new FragmentEquipo())
                .addToBackStack(null)
                .commit();
    }
});


imagenInfoEquipo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new FragmentInfoEquipo())
                .addToBackStack(null)
                .commit();


    }
});


    }


}