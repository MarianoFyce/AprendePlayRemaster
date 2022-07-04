package com.example.aprende_play.abel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.Verprogreso;
import com.example.aprende_play.chat.ActivityVista;
import com.example.aprende_play.chat.BaseActivity;
import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.chat.adapter.RecentConversationAdapter;
import com.example.aprende_play.chat.adapter.Userr;
import com.example.aprende_play.chat.listeners.ConversionListener;
import com.example.aprende_play.databinding.ActivityInicioPadreBinding;
import com.example.aprende_play.info_covid;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

public class Inicio_padre extends BaseActivity implements ConversionListener {
    private ActivityInicioPadreBinding binding;
    private PreferenceManager preferenceManager;
    private RecentConversationAdapter recentConversationAdapter;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding =  ActivityInicioPadreBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        //init();
        loadUserDet();
        getToken();
        setListeners();
        //listenConversations();
    }


    private void setListeners(){
        binding.btnNotificacion.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Verprogreso.class)));
    }
    private void loadUserDet(){
        byte[] bytes = Base64.decode(preferenceManager.getString(DatosTutores.KEY_IMAGE),Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

    }
    private void  showToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
    private void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);

    }
    private  void updateToken(String token){
        preferenceManager.putString(DatosTutores.KEY_FCM_TOKEN,token);

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(DatosTutores.KEY_COLLECTION_NINOS2).document(
                        preferenceManager.getString(DatosTutores.KEY_USER_ID)
                );
        documentReference.update(DatosTutores.KEY_FCM_TOKEN,token)
                //.addOnSuccessListener(unused -> showToast("Token actualizado"))
                .addOnFailureListener(e -> showToast(""));

    }
    @Override
    public void onConversionClicked(Userr userr) {
        Intent intent = new Intent(getApplicationContext(),Verprogreso.class);
        intent.putExtra(DatosTutores.KEY_USER_ID,userr);
        startActivity(intent);
    }


    public void preg(View view) {
        Intent e = new Intent(this, Preguntas.class);
        startActivity(e);
    }

    public void chat(View view) {
        Intent i = new Intent(this, ActivityVista.class);
        startActivity(i);
    }

    public void donacion(View view) {
        Intent c = new Intent(this, DonarActivity.class);
        startActivity(c);
    }





    public void covid(View view) {
        Intent s = new Intent(this, info_covid.class);
        startActivity(s);
    }

}