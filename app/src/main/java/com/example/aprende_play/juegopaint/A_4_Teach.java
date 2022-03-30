package com.example.aprende_play.juegopaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aprende_play.R;


public class A_4_Teach extends AppCompatActivity {
    Button ochoo;
    MediaPlayer mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4_teach);
        ochoo = (Button) findViewById(R.id.button3);
        mp3 = MediaPlayer.create(this,R.raw.aucuatro);
        mp3.start();
        ochoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp3.isPlaying()){
                    mp3.pause();
                    ochoo.setBackgroundResource(R.drawable.play);
                    Toast.makeText(A_4_Teach.this,"Pausa",Toast.LENGTH_SHORT).show();
                }else{
                    mp3.start();
                    ochoo.setBackgroundResource(R.drawable.play);
                    Toast.makeText(A_4_Teach.this,"Play",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void draw(View view) {
        Intent ob = new Intent(A_4_Teach.this, A_4_Paint.class);
        startActivity(ob);
    }
}