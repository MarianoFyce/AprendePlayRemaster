package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Instrucciones extends AppCompatActivity {
//Mariano y axol
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones);
    }

    public void lava(View v){
        Intent i = new  Intent(Instrucciones.this, video.class);
        startActivity(i);
    }

}
