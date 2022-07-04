package com.example.aprende_play;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.abel.Terminos_condiciones;
import com.example.aprende_play.databinding.ActivityInicioBinding;


//esta linea de codigo, deberia quedar asi
//public class Inicio extends BaseActivity implements ConversionListener
//esta clase se llamaba Seleccion

public class Inicio extends AppCompatActivity{
    private ActivityInicioBinding  binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInicioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

        private void setListeners(){
            binding.gifImageView.setOnClickListener(v ->
                    startActivity(new Intent(getApplicationContext(), Verninoss.class)));


            binding.tvPad.setOnClickListener(v ->
                    startActivity(new Intent(getApplicationContext(), Login.class)));


                binding.tvTer.setOnClickListener(v->
                     startActivity(new Intent(getApplicationContext(), Terminos_condiciones.class)));
            }



        }


