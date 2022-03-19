package com.example.aprende_play.abel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aprende_play.R;
import com.example.aprende_play.Seleccion;

public class Notificaciones extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }
    public void Onclick(View view) {

            switch (view.getId()) {
                case R.id.idMensajes:
                    Intent i = new Intent(this, Chat_Activity.class);
                    startActivity(i);
                    break;
                case R.id.idLogros:
                    Intent z = new Intent(this, Avances.class);
                    startActivity(z);
                    break;
                case R.id.idPremiun:
                    Toast.makeText(this, "Esperalo proximamente", Toast.LENGTH_SHORT).show();
                    break;

            }

    }



}