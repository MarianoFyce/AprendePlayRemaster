package com.example.aprende_play.chat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.Login;
import com.example.aprende_play.chat.adapter.RecentConversationAdapter;
import com.example.aprende_play.chat.adapter.Userr;
import com.example.aprende_play.chat.adapter.UsersActivity;
import com.example.aprende_play.chat.listeners.ConversionListener;
import com.example.aprende_play.chat.models.ChatMensaje;
import com.example.aprende_play.databinding.ActivityVistaBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.List;

public class ActivityVista extends BaseActivity implements ConversionListener {
    private ActivityVistaBinding binding;
    private PreferenceManager preferenceManager;
    private List<ChatMensaje> conversations;
    private RecentConversationAdapter recentConversationAdapter;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVistaBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        //init();
        loadUserDet();
        getToken();
        setListeners();
        //listenConversations();
    }
    private void setListeners(){
        binding.imagessignOut.setOnClickListener(v -> signOut());
        binding.fabnewchat.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), UsersActivity.class)));
    }
    private void loadUserDet(){
        binding.textname.setText(preferenceManager.getString(DatosTutores.KEY_NAME));
        byte[] bytes = Base64.decode(preferenceManager.getString(DatosTutores.KEY_IMAGE),Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        binding.imagenPerfil.setImageBitmap(bitmap);
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
                database.collection(DatosTutores.KEY_COLLECTION_USERS).document(
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
                database.collection(DatosTutores.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(DatosTutores.KEY_USER_ID)
                );
        HashMap<String, Object>updates = new HashMap<>();
        updates.put(DatosTutores.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                })
                .addOnFailureListener(e -> showToast("No disponible"));
    }

    @Override
    public void onConversionClicked(Userr userr) {
        Intent intent = new Intent(getApplicationContext(),ChatActivity.class);
        intent.putExtra(DatosTutores.KEY_USER_ID,userr);
        startActivity(intent);
    }
}