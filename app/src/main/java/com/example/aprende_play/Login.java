package com.example.aprende_play;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aprende_play.abel.Pantalla_Opciones;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button button2,button;

    EditText correo,contraseña;
    public String corre= "";
    public String contra = "";

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //declarar variables
        correo=(EditText)findViewById(R.id.correo);
        contraseña=(EditText)findViewById(R.id.contraseña);

        button2= (Button) findViewById(R.id.button2);
        button= (Button) findViewById(R.id.button);

        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.button:

                corre = correo.getText().toString();
                contra = contraseña.getText().toString();

                if (!corre.isEmpty()&& !contra.isEmpty()){
                    loginUser();

                }else{
                    Toast.makeText(this,"Error campos vacios",Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.button2:
                Intent ob = new Intent(Login.this, RegistroLogin.class);
                startActivity(ob);
                break;
        }
    }

    private void loginUser() {

        auth.signInWithEmailAndPassword(corre,contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i3 = new Intent(Login.this, Pantalla_Opciones.class);
                    startActivity(i3);
                    Toast.makeText(Login.this,"¡Bienvenido!",Toast.LENGTH_SHORT).show();
                    limpiar();


                }else{
                    Toast.makeText(Login.this,"Datos incorrectos",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void limpiar(){
        correo.setText("");
        contraseña.setText("");

    }
}