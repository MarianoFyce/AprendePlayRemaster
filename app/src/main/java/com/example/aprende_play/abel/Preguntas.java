package com.example.aprende_play.abel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.R;
import com.example.aprende_play.clases.Auxiliar;

public class Preguntas extends AppCompatActivity {

    Intent intent=null;
    Bundle PasarDatos = new Bundle();//pasar datos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
    }

        public void Onclick(View view) {

                switch (view.getId()) {
                    case R.id.idP1:
                        PasarDatos.putString("Pregunta", Auxiliar.Pregunta(1));
                        break;
                    case R.id.idP2:
                        PasarDatos.putString("Pregunta", Auxiliar.Pregunta(2));
                        //break;
                    case R.id.idP3:
                        PasarDatos.putString("Pregunta", Auxiliar.Pregunta(3));
                        break;

                }
                intent = new Intent(this, Res1.class);
                if (intent != null) {
                    intent.putExtras(PasarDatos);
                    startActivity(intent);
                }

    }

}