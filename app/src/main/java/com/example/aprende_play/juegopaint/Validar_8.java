package com.example.aprende_play.juegopaint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.R;

public class Validar_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar8);
    }

    public void va2(View view) {
        Intent ob = new Intent(Validar_8.this, Teachgame.class);
        startActivity(ob);
    }

    public void va(View view) {
        finish();
    }

    public void next(View view) {
        Intent ob = new Intent(Validar_8.this, A_9_Teach.class);
        startActivity(ob);
    }
}