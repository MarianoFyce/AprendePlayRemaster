package com.example.aprende_play.abel.Generador_citas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aprende_play.R;

public class Nueva_cita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita2);
    }

    public void maps(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.com.mx/maps/place/CENTRO+MEDICO+LA+FRAGUA+408/@19.1852063,-96.1341402,18.98z/data=!4m5!3m4!1s0x85c346b5b792c85b:0xb2dd2baa7f7977a8!8m2!3d19.1851023!4d-96.1335469"));
        startActivity(intent);
    }

    public void clickConf(View view) {
        Toast toast = Toast.makeText(this, "La cita ha sido agendada", Toast.LENGTH_SHORT);
        toast.show();
    }
}