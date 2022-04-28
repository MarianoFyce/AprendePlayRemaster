package com.example.aprende_play.chat.especialistas.clases;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.DatosTutores;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BaseActivityd  extends AppCompatActivity {
    private DocumentReference documenteRefrence;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        PreferenceManagerd preferenceManager = new PreferenceManagerd(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        documenteRefrence = database.collection(DatosTutores.KEY_COLLECTION_USERS)
                .document(preferenceManager.getString(DatosTutores.KEY_USER_ID));


    }

    @Override
    protected void onPause() {
        super.onPause();
        documenteRefrence.update(DatosTutores.KEY_AVAILABILITY,0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        documenteRefrence.update(DatosTutores.KEY_AVAILABILITY,1);
    }
}
