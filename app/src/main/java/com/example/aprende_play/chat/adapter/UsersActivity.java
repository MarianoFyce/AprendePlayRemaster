package com.example.aprende_play.chat.adapter;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.databinding.ActivityUsersBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {
private ActivityUsersBinding binding;
private PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        setListeners();
        getUsers();
    }
private void setListeners(){
        binding.imageback.setOnClickListener(v -> onBackPressed());
}
    private  void getUsers(){
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(DatosTutores.KEY_COLLECTION_USERS)
                .get()
                .addOnCompleteListener(task -> {
                    loading(false);
                    String currentUserId = preferenceManager.getString(DatosTutores.KEY_USER_ID);
                    if (task.isSuccessful() && task.getResult() != null){
                        List<User> users = new ArrayList<>();
                        for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                            if (currentUserId.equals(queryDocumentSnapshot.getId())){
                                continue;
                            }
                            Userr userr1 = new Userr();
                            userr1.name= queryDocumentSnapshot.getString(DatosTutores.KEY_NAME);
                            userr1.email= queryDocumentSnapshot.getString(DatosTutores.KEY_EMAIL);
                            userr1.image= queryDocumentSnapshot.getString(DatosTutores.KEY_IMAGE);

                            userr1.token= queryDocumentSnapshot.getString(DatosTutores.KEY_FCM_TOKEN);
           //posiblerror
//users.add(userr1);
                        }
                        if (users.size() > 0){
                         //   UserAdapter userAdapter = new UserAdapter(users);
                           // binding.usersRecycler.setAdapter(userAdapter);
                            binding.usersRecycler.setVisibility(View.VISIBLE);

                        }else {
                            showErrormensaje();
                        }
                    }else {
                        showErrormensaje();
                    }
                });
    }

    private  void showErrormensaje(){
        binding.texterror.setText(String.format("%s","Usuario no disponible"));
        binding.texterror.setVisibility(View.VISIBLE);
    }
    private void loading(Boolean isloading){
        if (isloading){
            binding.progresbar.setVisibility(View.VISIBLE);
        }else {
            binding.progresbar.setVisibility(View.INVISIBLE);
        }
    }
}