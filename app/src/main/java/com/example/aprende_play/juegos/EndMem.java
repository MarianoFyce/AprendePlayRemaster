package com.example.aprende_play.juegos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.Juegos;
import com.example.aprende_play.R;
import com.example.aprende_play.juegopaint.ModeloProgreso;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class EndMem extends AppCompatActivity {
    String nomP = " Memorama ";
    String appP = "2";
    String correoP = "Observaciones: Juego terminado";
    String passwordP = "24 puntos";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_mem);

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void guardaprogreso(View view) {
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
        Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();

        Intent i = new  Intent(EndMem.this, Juegos.class);
        startActivity(i);
    }
}