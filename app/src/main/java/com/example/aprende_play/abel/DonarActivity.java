package com.example.aprende_play.abel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.R;

public class DonarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);


    }

    public void URL(View view) {

        Intent w=  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.clima.org.mx/quiero-ayudar"));
        startActivity(w);

    }


    public void Onclick(View view) {
        switch (view.getId()){

        }
    }


}