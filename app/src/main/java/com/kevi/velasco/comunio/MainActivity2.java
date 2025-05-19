package com.kevi.velasco.comunio;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity2 extends AppCompatActivity {
    ImageView imagenEscudoSele, imageMercado, imagenPlantilla, imagenInfoEquipo;
    int tamanio = 14;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int escudoSeleccionado = getIntent().getIntExtra("escudoSeleccionado", -5);
        imagenEscudoSele = findViewById(R.id.imageViewEscudoSelecc);
        imagenEscudoSele.setImageResource(escudoSeleccionado);
        imageMercado = findViewById(R.id.imageViewMercado);
        imagenPlantilla = findViewById(R.id.imageViewPlantilla);
        imagenInfoEquipo = findViewById(R.id.imageViewEquipo);


        imageMercado.setOnClickListener(view -> {
            View fragmentContainer = findViewById(R.id.fragmentContainerView);
            fragmentContainer.setVisibility(View.VISIBLE);
            imagenEscudoSele.setVisibility(View.INVISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new FragmentMercado())
                    .addToBackStack(null)
                    .commit();
        });

        imagenPlantilla.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new FragmentEquipo())
                    .addToBackStack(null)
                    .commit();
        });

        imagenInfoEquipo.setOnClickListener(view -> {
            EscudoViewModel escudoViewModel = new ViewModelProvider(MainActivity2.this).get(EscudoViewModel.class);
            escudoViewModel.setEscudoSeleccionado(escudoSeleccionado);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new FragmentInfoEquipo())
                    .addToBackStack(null)
                    .commit();
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.idCerrar) {
            finishAffinity();
            return true;
        }

        if (item.getItemId() == R.id.idLetra) {
            new AlertDialog.Builder(this)
                    .setTitle("Tamaño de Letra")
                    .setMessage("¿Quieres aumentar o disminuir el tamaño?")
                    .setPositiveButton("Aumentar", (dialog, which) -> {
                        tamanio += 2;
                        LetraViewModel letraViewModel = new ViewModelProvider(this).get(LetraViewModel.class);
                        letraViewModel.setTamanioLetra(tamanio);

                        SharedPreferences sp = getSharedPreferences("letra", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("letra", tamanio);
                        editor.apply();
                    })
                    .setNegativeButton("Disminuir", (dialog, which) -> {
                        tamanio -= 2;
                        LetraViewModel letraViewModel = new ViewModelProvider(this).get(LetraViewModel.class);
                        letraViewModel.setTamanioLetra(tamanio);

                        SharedPreferences sp = getSharedPreferences("letra", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("letra", tamanio);
                        editor.apply();
                    })
                    .show();





            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
