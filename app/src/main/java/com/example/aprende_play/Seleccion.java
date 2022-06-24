package com.example.aprende_play;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.example.aprende_play.chat.BaseActivity;
import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.chat.adapter.RecentConversationAdapter;
import com.example.aprende_play.chat.adapter.Userr;
import com.example.aprende_play.chat.listeners.ConversionListener;
import com.example.aprende_play.chat.models.ChatMensaje;
import com.example.aprende_play.databinding.ActivitySeleccionBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.List;

public class Seleccion extends BaseActivity implements ConversionListener {
    private  ActivitySeleccionBinding binding;
    private PreferenceManager preferenceManager;
    private List<ChatMensaje> conversations;
    private RecentConversationAdapter recentConversationAdapter;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeleccionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        //init();
        loadUserDet();
        getToken();
        setListeners();
        //listenConversations();
    }
    private void setListeners(){
        binding.fabnewchat.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Verninos.class)));
    }
    private void loadUserDet(){
        byte[] bytes = Base64.decode(preferenceManager.getString(DatosTutores.KEY_IMAGE),Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

    }
    private void  showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    private void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);

    }
    private  void updateToken(String token){
        preferenceManager.putString(DatosTutores.KEY_FCM_TOKEN,token);

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(DatosTutores.KEY_COLLECTION_NINOSS).document(
                        preferenceManager.getString(DatosTutores.KEY_USER_ID)
                );
        documentReference.update(DatosTutores.KEY_FCM_TOKEN,token)
                //.addOnSuccessListener(unused -> showToast("Token actualizado"))
                .addOnFailureListener(e -> showToast("No disponible actualización"));

    }
    private void  signOut(){
        showToast("Espere...");
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(DatosTutores.KEY_COLLECTION_NINOSS).document(
                        preferenceManager.getString(DatosTutores.KEY_USER_ID)
                );
        HashMap<String, Object>updates = new HashMap<>();
        updates.put(DatosTutores.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getApplicationContext(), Verninos.class));
                    finish();
                })
                .addOnFailureListener(e -> showToast("No disponible"));
    }

    @Override
    public void onConversionClicked(Userr userr) {
        Intent intent = new Intent(getApplicationContext(),Verninos.class);
        intent.putExtra(DatosTutores.KEY_USER_ID,userr);
        startActivity(intent);
    }

    public void pasa(View view) {
        Intent i = new Intent(Seleccion.this, Login.class);
        startActivity(i);
    }
}