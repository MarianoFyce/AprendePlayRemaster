package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Reintento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reintento);
    }

    public void ba(View view) {
        Intent e= new Intent(Reintento.this, video.class);
        startActivity(e);
    }
}