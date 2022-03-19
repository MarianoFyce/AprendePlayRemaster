package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.aprende_play.juegos.Juego;

public class Giff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giff);

        new Handler().postDelayed(new Runnable() {
            @Override
        public void run() {
            Intent intent = new Intent(Giff.this, Juego.class);
            startActivity(intent);
            finish();
        }
    },4000);
    }
}