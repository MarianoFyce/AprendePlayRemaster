package com.example.aprende_play.chat.especialistas;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.databinding.ActivityLogespecialBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Logespecial extends AppCompatActivity {
    private ActivityLogespecialBinding binding;
    private PreferenceManager preferenceManager;
    private FirebaseAuth mAuth;
    private Button btnlink;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = "https://docs.google.com/forms/u/0/";
        preferenceManager = new PreferenceManager(getApplicationContext());
        binding = ActivityLogespecialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();

    }

    private void setListeners() {
        // binding.button2.setOnClickListener(v ->
        //       startActivity(new Intent(getApplicationContext(), RegistroLogin.class)));
        binding.button.setOnClickListener(v ->{
            if (isValidSigninDetail()){
                signIn();
            }
        });
    }
    private void signIn(){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(DatosTutores.KEY_COLLECTION_ESPE)
                .whereEqualTo(DatosTutores.KEY_EMAIL,binding.correo.getText().toString())
                .whereEqualTo(DatosTutores.KEY_PASSWORD,binding.contraseA.getText().toString())
                .get()
                .addOnCompleteListener(task ->{
                    if (task.isSuccessful() && task.getResult() != null
                            && task.getResult().getDocuments().size() > 0){
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        preferenceManager.putBoolean(DatosTutores.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(DatosTutores.KEY_USER_ID, documentSnapshot.getId());
                        preferenceManager.putString(DatosTutores.KEY_IMAGE, documentSnapshot.getString(DatosTutores.KEY_IMAGE));
                        preferenceManager.putString(DatosTutores.KEY_NAME, documentSnapshot.getString(DatosTutores.KEY_NAME));

                        Intent intent = new Intent(getApplicationContext(),ActivityVistaEspe.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else {
                        showToast("Datos no encontrados");
                    }
                });
    }
    private void showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }
    private Boolean isValidSigninDetail(){
        if(binding.correo.getText().toString().trim().isEmpty()){
            showToast("Agrega Email");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.correo.getText().toString()).matches()){
            showToast("Agrega un correo valido");
            return false;

        }else if(binding.contraseA.getText().toString().trim().isEmpty()) {
            showToast("Agrega una contraseña");
            return false;

        }
        else {
            return true;
        }
    }


    public void link(View view) {
        //  Uri uri = Uri.parse(url);
        //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        //startActivity(intent);

        Intent d = new Intent(this, ValidaCedula.class);
        startActivity(d);

    }



}