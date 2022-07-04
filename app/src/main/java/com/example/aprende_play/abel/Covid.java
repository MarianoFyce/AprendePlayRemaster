package com.example.aprende_play.abel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.aprende_play.R;
import com.example.aprende_play.chat.ChatActivity;
import com.example.aprende_play.clases.Content;

public class Covid extends AppCompatActivity {

    String retornar() {
        Bundle Obj = getIntent().getExtras();
        return (Obj != null) ? Obj.getString("Pregunta") : Content.Pregunta(0);


    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        TextView Txt = findViewById(R.id.TxtPregunta);
        Txt.setText(retornar());
    }



}