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
    //edit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);
        mp3 = MediaPlayer.create(this,R.raw.auwelcome);
        mp3.start();
        //new Handler().postDelayed(new Runnable() {
        //@Override
        //public void run() {
        //  Intent intent = new Intent(InicioJuego.this , A_0_Teach.class);
        //    startActivity(intent);
        //  }
        //},2000);
    }
    public void vamos(View view) {
        Intent intent = new Intent(InicioJuego.this , A_0_Teach.class);
        startActivity(intent);
    }

    public void t0(View view) {
        Intent intent = new Intent(InicioJuego.this , A_0_Teach.class);
        startActivity(intent);
    }
    public void t1(View view) {
        Intent intent = new Intent(InicioJuego.this , A_1_Teach.class);
        startActivity(intent);
    }
    public void t2(View view) {
        Intent intent = new Intent(InicioJuego.this , A_2_Teach.class);
        startActivity(intent);
    }

    public void t3(View view) {
        Intent intent = new Intent(InicioJuego.this , A_3_Teach.class);
        startActivity(intent);
    }
    public void t4(View view) {
        Intent intent = new Intent(InicioJuego.this , A_4_Teach.class);
        startActivity(intent);
    }
    public void t5(View view) {
        Intent intent = new Intent(InicioJuego.this , A_5_Teach.class);
        startActivity(intent);
    }
    public void t6(View view) {
        Intent intent = new Intent(InicioJuego.this , A_6_Teach.class);
        startActivity(intent);
    }
    public void t7(View view) {
        Intent intent = new Intent(InicioJuego.this , A_7_Teach.class);
        startActivity(intent);
    }
    public void t8(View view) {
        Intent intent = new Intent(InicioJuego.this , Teachgame.class);
        startActivity(intent);
    }
    public void t9(View view) {
        Intent intent = new Intent(InicioJuego.this , A_9_Teach.class);
        startActivity(intent);
    }
}