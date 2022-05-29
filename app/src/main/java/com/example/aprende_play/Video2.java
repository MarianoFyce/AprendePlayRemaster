package com.example.aprende_play;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.juegopaint.ModeloProgreso;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Video2 extends AppCompatActivity {

    //para el progreso
    String nomP = " Lava tus manos ";
    String appP = "2";
    String correoP = "Observaciones: Juego terminado";
    String passwordP = "10 puntos";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }



    public void premio(View view) {
        Intent pAS = new Intent(Video2.this,Premios.class);
        startActivity(pAS);

        //agregala info a BD
        inicializarFirebase();
        String nombre = nomP.toString();
        String correo = correoP.toString();
        String password = passwordP.toString();
        String app = appP.toString();
        ModeloProgreso p = new ModeloProgreso();
        p.setUid(UUID.randomUUID().toString());
        p.setNombre(nombre);
        p.setApellido(app);
        p.setCorreo(correo);
        p.setPassword(password);
        databaseReference.child("PROGRESO_NIÑO").child(p.getUid()).setValue(p);
        Toast.makeText(this, "Reclamado", Toast.LENGTH_LONG).show();

    }
}