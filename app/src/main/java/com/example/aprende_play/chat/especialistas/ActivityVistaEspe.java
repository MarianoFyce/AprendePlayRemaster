package com.example.aprende_play.chat.especialistas;

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
import com.example.aprende_play.chat.BaseActivity;
import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.chat.listeners.ConversionListener;
import com.example.aprende_play.chat.models.ChatMensaje;
import com.example.aprende_play.databinding.ActivityVistaEspeBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.List;

public class ActivityVistaEspe extends BaseActivity implements ConversionListener {
    private ActivityVistaEspeBinding binding;
    private PreferenceManager preferenceManager;
    private List<ChatMensaje> conversations;
    private RecentConversationAdapter recentConversationAdapter;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVistaEspeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        //init();
        loadUserDet();
        getToken();
        setListeners();
        //listenConversations();
    }
    //private void init(){
    //  conversations = new ArrayList<>();
    //recentConversationAdapter = new RecentConversationAdapter(conversations,this);
    //binding.conversationRecyclerView.setAdapter(recentConversationAdapter);
    //database = FirebaseFirestore.getInstance();
    //}

    private void setListeners(){
        binding.imagessignOut.setOnClickListener(v -> signOut());
        binding.fabnewchat.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), VistaClientes.class)));
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
    /*
    private void listenConversations(){
        database.collection(DatosTutores.KEY_COLLECTIONS_CONVERSATIONS)
                .whereEqualTo(DatosTutores.KEY_SENDER_ID,preferenceManager.getString(DatosTutores.KEY_USER_ID))
                .addSnapshotListener(eventListener);
        database.collection(DatosTutores.KEY_COLLECTIONS_CONVERSATIONS)
                .whereEqualTo(DatosTutores.KEY_RECEIVER_ID,preferenceManager.getString(DatosTutores.KEY_USER_ID))
                .addSnapshotListener(eventListener);
    }

    private final EventListener<QuerySnapshot> eventListener = (value, error) -> {
        if (error != null){
            return ;
        }
        if (value != null){
            for (DocumentChange documentChange : value.getDocumentChanges()){
                if (documentChange.getType()==DocumentChange.Type.ADDED){
                    String senderId = documentChange.getDocument().getString(DatosTutores.KEY_SENDER_ID);
                    String receiverId = documentChange.getDocument().getString(DatosTutores.KEY_RECEIVER_ID);

                    ChatMensaje chatMensaje = new ChatMensaje();
                    chatMensaje.senderId = senderId;
                    chatMensaje.receiverId = receiverId;
                    if (preferenceManager.getString(DatosTutores.KEY_USER_ID).equals(senderId)){
                        chatMensaje.conversionImage = documentChange.getDocument().getString(DatosTutores.KEY_RECEIVER_IMAGE);
                        chatMensaje.conversionName = documentChange.getDocument().getString(DatosTutores.KEY_RECEIVER_NAME);
                        chatMensaje.conversionId = documentChange.getDocument().getString(DatosTutores.KEY_RECEIVER_ID);

                    }else {
                        chatMensaje.conversionImage = documentChange.getDocument().getString(DatosTutores.KEY_SENDER_IMAGE);
                        chatMensaje.conversionName = documentChange.getDocument().getString(DatosTutores.KEY_SENDER_NAME);
                        chatMensaje.conversionId = documentChange.getDocument().getString(DatosTutores.KEY_SENDER_ID);

                    }
                    chatMensaje.mensaje = documentChange.getDocument().getString(DatosTutores.KEY_LAST_MENSAJE);
                    chatMensaje.dataObjet = documentChange.getDocument().getDate(DatosTutores.KEY_TIMESTAMP);
                    conversations.add(chatMensaje);
                }else if(documentChange.getType()== DocumentChange.Type.MODIFIED){
                    for (int i = 0;i < conversations.size(); i++){
                        String senderId = documentChange.getDocument().getString(DatosTutores.KEY_SENDER_ID);
                        String receiverId = documentChange.getDocument().getString(DatosTutores.KEY_RECEIVER_ID);
                        if (conversations.get(i) .senderId.equals(senderId) && conversations.get(i).receiverId.equals(receiverId)){
                            conversations.get(i).mensaje = documentChange.getDocument().getString(DatosTutores.KEY_LAST_MENSAJE);
                            conversations.get(i).dataObjet = documentChange.getDocument().getDate(DatosTutores.KEY_TIMESTAMP);
                            break;
                        }

                    }
                }
            }
            Collections.sort(conversations, (obj1,obj2) -> obj2.dataObjet.compareTo(obj1.dataObjet));
            recentConversationAdapter.notifyDataSetChanged();
            binding.conversationRecyclerView.smoothScrollToPosition(0);
            binding.conversationRecyclerView.setVisibility(View.VISIBLE);
            binding.progresbar2.setVisibility(View.GONE);
        }
    }; */


    private void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
//
    }
    private  void updateToken(String token){
        preferenceManager.putString(DatosTutores.KEY_FCM_TOKEN,token);

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(DatosTutores.KEY_COLLECTION_ESPE).document(
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
                database.collection(DatosTutores.KEY_COLLECTION_ESPE).document(
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
        Intent intent = new Intent(getApplicationContext(),ChatActivityEspe.class);
        intent.putExtra(DatosTutores.KEY_USER_ID,userr);
        startActivity(intent);
    }
}