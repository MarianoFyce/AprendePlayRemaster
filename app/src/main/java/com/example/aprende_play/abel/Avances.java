package com.example.aprende_play.abel;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.R;
import com.example.aprende_play.juegopaint.ModeloProgreso;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Avances extends AppCompatActivity {



    private List<ModeloProgreso> listPerson = new ArrayList<ModeloProgreso>();
    ArrayAdapter<ModeloProgreso> arrayAdapterPersona;

    EditText nomP, appP,correoP,passwordP;
    ListView listV_personas;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ModeloProgreso personaSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avances);
        nomP = findViewById(R.id.txt_nombrePersona);
        appP = findViewById(R.id.txt_appPersona);
        correoP = findViewById(R.id.txt_correoPersona);
        passwordP = findViewById(R.id.txt_passwordPersona);

        listV_personas = findViewById(R.id.lv_datosPersonas);
        inicializarFirebase();
        listarDatos();

        listV_personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personaSelected = (ModeloProgreso) parent.getItemAtPosition(position);
                nomP.setText(personaSelected.getNombre());
                appP.setText(personaSelected.getApellido());
                correoP.setText(personaSelected.getCorreo());
                passwordP.setText(personaSelected.getPassword());
            }
        });

        //Activar el icono de la app en la barra de notificacion
    }
    private void listarDatos() {
        databaseReference.child("PROGRESO_NIÑO").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPerson.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    ModeloProgreso p = objSnaptshot.getValue(ModeloProgreso.class);
                    listPerson.add(p);

                    arrayAdapterPersona = new ArrayAdapter<ModeloProgreso>(Avances.this, android.R.layout.simple_list_item_1, listPerson);
                    listV_personas.setAdapter(arrayAdapterPersona);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}