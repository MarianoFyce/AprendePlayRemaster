package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Error_lava_manos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_lava_manos);
    }

    public void ba(View view) {
        Intent e= new Intent(Error_lava_manos.this, video.class);
        startActivity(e);
        finish();
    }
}