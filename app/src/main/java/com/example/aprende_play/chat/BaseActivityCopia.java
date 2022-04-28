package com.example.aprende_play.chat;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.DatosTutores;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BaseActivityCopia  extends AppCompatActivity {
    private DocumentReference documenteRefrence;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        documenteRefrence = database.collection(DatosTutores.KEY_COLLECTION_ESPE)
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
