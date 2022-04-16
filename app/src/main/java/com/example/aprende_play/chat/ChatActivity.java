package com.example.aprende_play.chat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.chat.adapter.ChatAdapter;
import com.example.aprende_play.chat.adapter.Userr;
import com.example.aprende_play.chat.adapter.UsersActivity;
import com.example.aprende_play.chat.models.ChatMensaje;
import com.example.aprende_play.databinding.ActivityChat2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ChatActivity extends BaseActivity{

    private ActivityChat2Binding binding;
    private Userr receiverUser;
    private List<ChatMensaje> ChatMensajes;
    private ChatAdapter chatAdapter;
    private PreferenceManager preferenceManager;
    private FirebaseFirestore database;
    private String conversationId = null;
    private Boolean isReceiverAvailable = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChat2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
         loadReceivedDeatil();
        init();
        listenMensajes();
    }
    private void init(){
        preferenceManager = new PreferenceManager(getApplicationContext());
        ChatMensajes = new ArrayList<>();
        chatAdapter = new  ChatAdapter(
                ChatMensajes,
                getBitmapEncodedString(receiverUser.image),
                preferenceManager.getString(DatosTutores.KEY_USER_ID)
        );
        binding.chatRecycler.setAdapter(chatAdapter);
        database = FirebaseFirestore.getInstance();
    }
    private void sendMensaje(){
        HashMap<String,Object>mensaje = new HashMap<>();
        mensaje.put(DatosTutores.KEY_SENDER_ID,preferenceManager.getString(DatosTutores.KEY_USER_ID));
        mensaje.put(DatosTutores.KEY_RECEIVER_ID,receiverUser.id);
        mensaje.put(DatosTutores.KEY_MENSAJE,binding.inputMensaje.getText().toString());
        mensaje.put(DatosTutores.KEY_TIMESTAMP, new Date());

        database.collection(DatosTutores.KEY_COLLECTION_CHAT).add(mensaje);
      /*  if (conversationId !=null){
        //    updateConversion(binding.inputMensaje.getText().toString());
        }else {
            HashMap<String,Object> conversion = new HashMap<>();
            //conversion.put(DatosTutores.KEY_SENDER_ID,preferenceManager.getString(DatosTutores.KEY_USER_ID));
            //conversion.put(DatosTutores.KEY_SENDER_NAME,preferenceManager.getString(DatosTutores.KEY_NAME));
            //conversion.put(DatosTutores.KEY_SENDER_IMAGE,preferenceManager.getString(DatosTutores.KEY_IMAGE));

            conversion.put(DatosTutores.KEY_RECEIVER_ID,receiverUser.id);
           // conversion.put(DatosTutores.KEY_RECEIVER_NAME,receiverUser.name);
            //conversion.put(DatosTutores.KEY_RECEIVER_IMAGE,receiverUser.image);
            //conversion.put(DatosTutores.KEY_LAST_MENSAJE,binding.inputMensaje.getText().toString());
            //conversion.put(DatosTutores.KEY_TIMESTAMP,new Date());
            //addConversion(conversion);


        }*/
        binding.inputMensaje.setText(null);
    }

    private void listenAvailabilityOfReceiver(){
        database.collection(DatosTutores.KEY_COLLECTION_USERS).document(
                receiverUser.id
        ).addSnapshotListener(ChatActivity.this,(value,error) -> {
            if (error != null){
                return;
            }
            if (value !=null){
                if (value.getLong(DatosTutores.KEY_AVAILABILITY) != null){
                    int availability = Objects.requireNonNull(
                            value.getLong(DatosTutores.KEY_AVAILABILITY)
                    ).intValue();
                    isReceiverAvailable = availability ==1;
                }
                receiverUser.token = value.getString(DatosTutores.KEY_FCM_TOKEN);
            }
            if (isReceiverAvailable){
                binding.textAvailability.setVisibility(View.VISIBLE);
            }else{
                binding.textAvailability.setVisibility(View.GONE);
            }

            //pushN

        });

    }

    private void listenMensajes(){
        database.collection(DatosTutores.KEY_COLLECTION_CHAT)
                .whereEqualTo(DatosTutores.KEY_SENDER_ID,preferenceManager.getString(DatosTutores.KEY_USER_ID))
                .whereEqualTo(DatosTutores.KEY_RECEIVER_ID,receiverUser.id)
                .addSnapshotListener(eventListener);

        database.collection(DatosTutores.KEY_COLLECTION_CHAT)
                .whereEqualTo(DatosTutores.KEY_SENDER_ID,receiverUser.id)
                .whereEqualTo(DatosTutores.KEY_RECEIVER_ID,preferenceManager.getString(DatosTutores.KEY_USER_ID))
                .addSnapshotListener(eventListener);
    }

    private final EventListener<QuerySnapshot> eventListener = (value ,error) ->{
        if (error != null){
            return;
        }
        if (value != null){
            int count = ChatMensajes.size();
            for (DocumentChange documentChange : value.getDocumentChanges()){
                if (documentChange.getType() == DocumentChange.Type.ADDED){
                    ChatMensaje chatMensaje = new ChatMensaje();

                    chatMensaje.senderId = documentChange.getDocument().getString(DatosTutores.KEY_SENDER_ID);
                    chatMensaje.receiverId = documentChange.getDocument().getString(DatosTutores.KEY_RECEIVER_ID);
                    chatMensaje.mensaje = documentChange.getDocument().getString(DatosTutores.KEY_MENSAJE);
                    // ChatMensaje.dateTime = getReadableDataTime(documentChange.getDocument().getDate(DatosTutores.KEY_TIMESTAMP));

                    chatMensaje.dataObjet = documentChange.getDocument().getDate(DatosTutores.KEY_TIMESTAMP);
                    ChatMensajes.add(chatMensaje);
                }
            }
            // Collections.sort(ChatMensajes, (obj1, obj2) -> obj1.dataObjet.compareTo(obj2.dataObjet));
            if (count == 0){
                chatAdapter.notifyDataSetChanged();
            }else{
                chatAdapter.notifyItemRangeInserted(ChatMensajes.size(), ChatMensajes.size());
                binding.chatRecycler.smoothScrollToPosition(ChatMensajes.size() - 1);
            }
            binding.chatRecycler.setVisibility(View.VISIBLE);
        }
        binding.progresbar.setVisibility(View.GONE);
        //if (conversationId == null){
        //    checkForconversion();
        //}
    };

    private Bitmap getBitmapEncodedString(String encodesImage){
        byte [] bytes = Base64.decode(encodesImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);

    }
    private void loadReceivedDeatil(){
        receiverUser = (Userr) getIntent().getSerializableExtra(DatosTutores.KEY_USER);
        binding.textname.setText(receiverUser.name);
    }
    private void setListeners(){
        //binding.imageback.setOnClickListener(view -> onBackPressed());
        binding.layoutsend.setOnClickListener(view -> sendMensaje());

    }

    public void pasars(View view) {
        Intent pasa = new Intent(ChatActivity.this, UsersActivity.class);
        startActivity(pasa);
    }
    /*
    //pEROR
    //@RequiresApi(api = Build.VERSION_CODES.N)
    //private String getReadableDataTime(Date date){
    //  return new SimpleDateFormat("MMMM dd, yyyy - hh:mm a", Locale.getDefault()).format(date);
    //}
    private void addConversion(HashMap<String,Object>conversion){
        database.collection(DatosTutores.KEY_COLLECTIONS_CONVERSATIONS)
                .add(conversion)
                .addOnSuccessListener(documentReference -> conversationId= documentReference.getId());

    }
    private void updateConversion(String mensaje){
        DocumentReference documentReference =
                database.collection(DatosTutores.KEY_COLLECTIONS_CONVERSATIONS).document(conversationId);
        documentReference.update(
                DatosTutores.KEY_LAST_MENSAJE,mensaje,
                DatosTutores.KEY_TIMESTAMP,new Date()
        );

    }
    private void checkForconversion(){
        if (ChatMensajes.size() !=0){
            checkForConversationRemote(
                    preferenceManager.getString(DatosTutores.KEY_USER_ID),
                    receiverUser.id
            );
            checkForConversationRemote(
                    receiverUser.id,
                    preferenceManager.getString(DatosTutores.KEY_USER_ID)
            );
        }

    }
  //  private void checkForConversationRemote(String senderId,String receiverId){
    //    database.collection(DatosTutores.KEY_COLLECTIONS_CONVERSATIONS)
      //          .whereEqualTo(DatosTutores.KEY_SENDER_ID,senderId)
        //        .whereEqualTo(DatosTutores.KEY_RECEIVER_ID,receiverId)
          //      .get()
            //    .addOnCompleteListener(conversionOncompleteListen);
    //}

   */
    private final OnCompleteListener<QuerySnapshot> conversionOncompleteListen = task -> {
        if (task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0){
            DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
            conversationId = documentSnapshot.getId();
        }

    };

    @Override
    protected void onResume() {
        super.onResume();
        listenAvailabilityOfReceiver();
    }
}