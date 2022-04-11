package com.example.aprende_play;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
    }
        public void pasa(View view) {
            Intent pasa = new Intent(Seleccion.this, Login.class);
            startActivity(pasa);
        }

        public void pasajuego(View view) {
            Intent pasajuego = new Intent(Seleccion.this, Juegos.class);
            startActivity(pasajuego);

    }
}