package com.example.aprende_play.juegos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.Juegos;
import com.example.aprende_play.R;

public class EndMem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_mem);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EndMem.this , Juegos.class);
                startActivity(intent);
            }
        },4000);
    }
}