package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.abel.Res1;
import com.example.aprende_play.abel.Resp;
import com.example.aprende_play.clases.Auxiliar;
import com.example.aprende_play.clases.Content;

public class info_covid extends AppCompatActivity {

    Intent i=null;
    Bundle info = new Bundle();//pasar datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_covid);
    }

    public void selected(View view) {

            switch (view.getId()) {
                case R.id.c1:

                    info.putString("Pregunta", Content.Pregunta(1));
                    break;
                case R.id.c2:
                    info.putString("Pregunta", Content.Pregunta(2));
                    break;

            }
            i = new Intent(this, Resp.class);
            if (i != null) {
                i.putExtras(info);
                startActivity(i);
            }

    }


}