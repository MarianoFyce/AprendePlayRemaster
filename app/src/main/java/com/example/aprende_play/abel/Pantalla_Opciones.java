package com.example.aprende_play.abel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.R;
import com.example.aprende_play.info_covid;

public class Pantalla_Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opciones);

    }

    public void preg(View view) {
        Intent e = new Intent(this, Preguntas.class);
        startActivity(e);
    }

    public void chat(View view) {
        Intent i = new Intent(this, Chat_Activity.class);
        startActivity(i);
    }

    public void donacion(View view) {
        Intent c = new Intent(this, DonarActivity.class);
        startActivity(c);
    }



    public void notify(View view) {
        Intent d = new Intent(this, Notificaciones.class);
        startActivity(d);
    }

    public void covid(View view) {
        Intent s = new Intent(this, info_covid.class);
        startActivity(s);
    }



    public void Onclick(View view) {
        switch (view.getId()){
            case R.id.btnNotificacion:
            startActivity(new Intent(this, Notificaciones.class));
            break;
        }
    }
}