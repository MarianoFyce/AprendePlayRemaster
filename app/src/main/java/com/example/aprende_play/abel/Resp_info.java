package com.example.aprende_play.abel;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.R;
import com.example.aprende_play.chat.ActivityVista;
import com.example.aprende_play.clases.Auxiliar;

public class Resp_info extends AppCompatActivity {

    String retornar() {
        Bundle Obj = getIntent().getExtras();
        return (Obj != null) ? Obj.getString("Pregunta") : Auxiliar.Pregunta(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_info);

        TextView Txt = findViewById(R.id.TxtPregunta);
        Txt.setText(retornar());

    }

    public void pasa_chat(View view) {
        Intent c = new Intent(this, ActivityVista.class);
        startActivity(c);
        finish();
    }
    }

