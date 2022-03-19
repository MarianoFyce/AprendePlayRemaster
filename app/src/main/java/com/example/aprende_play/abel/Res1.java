package com.example.aprende_play.abel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.aprende_play.R;
import com.example.aprende_play.clases.Auxiliar;

public class Res1 extends AppCompatActivity {

    String retornar() {
        Bundle Obj = getIntent().getExtras();
        return (Obj != null) ? Obj.getString("Pregunta") : Auxiliar.Pregunta(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res1);

        TextView Txt = findViewById(R.id.TxtPregunta);
        Txt.setText(retornar());
//        Txt.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
    }

        public void Onclick(View view) {
            switch (view.getId()){
                case R.id.imgdudas:
                    startActivity(new Intent(this,Chat_Activity.class));
                    break;

            }
    }

}