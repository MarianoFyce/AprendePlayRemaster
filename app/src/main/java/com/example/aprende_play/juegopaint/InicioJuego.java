package com.example.aprende_play.juegopaint;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.R;

public class InicioJuego extends AppCompatActivity {
    MediaPlayer mp3;
    Button rp;
    //edit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_juego);

        rp = (Button) findViewById(R.id.imageButton5);
        mp3 = MediaPlayer.create(this,R.raw.auwelcome);
        rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp3.isPlaying()){
                    mp3.pause();
                    rp.setBackgroundResource(R.drawable.paisee);
                    Toast.makeText(InicioJuego.this,"Pausa",Toast.LENGTH_SHORT).show();
                }else{
                    mp3.start();
                    rp.setBackgroundResource(R.drawable.sonidos);
                    Toast.makeText(InicioJuego.this,"Reproduciendo",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //new Handler().postDelayed(new Runnable() {
        //@Override
        //public void run() {
        //  Intent intent = new Intent(InicioJuego.this , A_0_Teach.class);
        //    startActivity(intent);
        //  }
        //},2000);
    }
    public void destruir() {
        if (mp3 != null)
            mp3.release();
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