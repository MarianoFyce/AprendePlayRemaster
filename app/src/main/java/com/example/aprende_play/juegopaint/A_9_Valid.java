package com.example.aprende_play.juegopaint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.Juegos;
import com.example.aprende_play.R;

public class A_9_Valid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a9_valid);
    }

    public void va2(View view) {
        Intent ob = new Intent(A_9_Valid.this,RegistroProgreso.class);
        startActivity(ob);
    }

    public void va(View view){

    finish();

}
    public void next(View view) {
        Intent ob = new Intent(A_9_Valid.this, Juegos.class);
        startActivity(ob);
    }
    }
