package com.example.aprende_play.juegopaint;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aprende_play.R;

public class InicioJuego extends AppCompatActivity {
    MediaPlayer mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);
        mp3 = MediaPlayer.create(this,R.raw.musicaf);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(InicioJuego.this , A_0_Teach.class);
                startActivity(intent);
            }
        },2000);
    }
    public void vamos(View view) {

    }
}