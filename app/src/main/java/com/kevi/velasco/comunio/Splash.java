package com.kevi.velasco.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
TextView tReglas;
StringBuilder sb = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
    tReglas=findViewById(R.id.textViewReglas);
        sb.append("* Puedes fichar 5 jugadores\n");
        sb.append("* Tienes un presupuesto asignado que no puedes sobrepasar\n");
        sb.append("* Cada jugador tiene su media y su valor asignado\n");
        tReglas.setText(sb);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);



            }
        },4000);

    }
}