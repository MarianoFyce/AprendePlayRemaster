package com.example.aprende_play.juegopaint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.R;

public class A_5_Valid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5_valid);
    }
    public void va2(View view) {
        Intent ob = new Intent(A_5_Valid.this, A_5_Teach.class);
        startActivity(ob);
    }

    public void va(View view) {
        finish();
    }

    public void next(View view) {
        Intent ob = new Intent(A_5_Valid.this, A_6_Teach.class);
        startActivity(ob);
    }
}