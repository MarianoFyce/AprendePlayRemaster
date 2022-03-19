package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video2 extends AppCompatActivity {

  private  VideoView vw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video2);


        vw1=findViewById(R.id.video);

        vw1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.demo2));


        MediaController mc = new MediaController(this);
        vw1.setMediaController(mc);
        vw1.setVisibility(View.VISIBLE);
        mc.setAnchorView(vw1);

        vw1.start();

    }


    public void premio(View view) {
        Intent p = new Intent(Video2.this,Premios.class);
        startActivity(p);

    }
}