package com.example.aprende_play;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;

public class RegistroLogin extends AppCompatActivity implements View.OnClickListener {
    public EditText correo1,contraseña1,nombre1,edad1,sexo1;//

    Button registrar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_login);

        correo1 = (EditText) findViewById(R.id.correo);
        contraseña1 = (EditText) findViewById(R.id.contraseña);
        nombre1 = (EditText) findViewById(R.id.nombre);
        edad1 = (EditText) findViewById(R.id.edad);
        sexo1 = (EditText) findViewById(R.id.sexo);

        registrar = (Button) findViewById(R.id.registrar);

        registrar.setOnClickListener(this);

        iniciarFirebase();

        auth = FirebaseAuth.getInstance();
    }
    //se inicia firebase
    private void iniciarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    //limpia cajas
    private void limpiar() {
        correo1.setText("");
        contraseña1.setText("");
        nombre1.setText("");
        edad1.setText("");
        sexo1.setText("");



    }
    // De aquí
    @Override
    public void onClick(View v) {
        String correo = correo1.getText().toString();
        String contraseña = contraseña1.getText().toString();
        String nombre = nombre1.getText().toString();
        String edad = edad1.getText().toString();
        String sexo = sexo1.getText().toString();

        switch (v.getId()){
            case R.id.registrar:{

                if (correo.equals("")||contraseña.equals("")||nombre.equals("")||edad.equals("")||sexo.equals("") ) {
                    validacion();
                    Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();

                } else {

                    if (contraseña.length() >= 6){
                        registraUsuario();
                    }else {                    Toast.makeText(this, "El password debe tener minimo 6 carácteres", Toast.LENGTH_SHORT).show();
                    }

                }
                break;}

            default: break;
        }
        return;
    }

    private void registraUsuario() {
        String correo = correo1.getText().toString();
        String contraseña = contraseña1.getText().toString();
        auth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    String correo = correo1.getText().toString();
                    String contraseña = contraseña1.getText().toString();
                    String nombre = nombre1.getText().toString();
                    String edad = edad1.getText().toString();
                    String sexo = sexo1.getText().toString();

                    DatosTutores p = new DatosTutores();
                    p.setId(UUID.randomUUID().toString());
                    p.setCorreoo(correo);
                    p.setContraseñaa(contraseña);
                    p.setNombree(nombre);
                    p.setEdadd(edad);
                    p.setSexoo(sexo);


                    databaseReference.child("AprendePlayBase").child(p.getId()).setValue(p);
                    Toast.makeText(RegistroLogin.this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                    limpiar();
                    Intent i1 = new Intent(RegistroLogin.this,Login.class);
                    startActivity(i1);
                }else{
                    Toast.makeText(RegistroLogin.this, "No se puede registrar", Toast.LENGTH_SHORT).show();
                    System.out.println("ERROR : "+ task.getException());
                }
            }
        });
    }

    private void validacion() {
        String correo = correo1.getText().toString();
        String contraseña = contraseña1.getText().toString();
        String nombre = nombre1.getText().toString();
        String edad = edad1.getText().toString();
        String sexo = sexo1.getText().toString();



        if (correo.equals("")) {
            correo1.setError("Campo Vacio");
        } else if (contraseña.equals("")) {
            contraseña1.setError("Campo Vacio");
        } else if (nombre.equals("")) {
            nombre1.setError("Campo Vacio");
        } else if (edad.equals("")) {
            edad1.setError("Campo Vacio");
        }else if (sexo.equals("")) {
            sexo1.setError("Campo Vacio");
        }

    }
}