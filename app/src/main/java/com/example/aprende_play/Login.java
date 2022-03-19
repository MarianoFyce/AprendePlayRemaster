package com.example.aprende_play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aprende_play.abel.Pantalla_Opciones;



public class Login extends AppCompatActivity{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button= (Button) findViewById(R.id.button);

    }
        public void loginuser(View view) {


            Intent i3 = new Intent(Login.this, Pantalla_Opciones.class);
            startActivity(i3);
            Toast.makeText(Login.this,"¡Bienvenido!",Toast.LENGTH_SHORT).show();


    }

}