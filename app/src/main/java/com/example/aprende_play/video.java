package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {
private VideoView zt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);




        zt1=findViewById(R.id.video);

        zt1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.demo));


        MediaController mc = new MediaController(this);
        zt1.setMediaController(mc);
        zt1.setVisibility(View.VISIBLE);
        mc.setAnchorView(zt1);

        zt1.start();

    }

    public void si(View view) {
        Intent h= new Intent(video.this, Video2.class);
        startActivity(h);
    }

    public void Onclick(View view) {
        switch (view.getId()){

        }
    }

    public void e(View view) {
        Intent e= new Intent(video.this, Reintento.class);
        startActivity(e);
    }
}