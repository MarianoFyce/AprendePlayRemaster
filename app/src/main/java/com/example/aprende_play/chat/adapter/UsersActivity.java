package com.example.aprende_play.chat.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.Login;
import com.example.aprende_play.chat.BaseActivity;
import com.example.aprende_play.chat.ChatActivity;
import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.chat.listeners.Userlisteners;
import com.example.aprende_play.databinding.ActivityUsersBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
//TODO
public class UsersActivity extends BaseActivity implements Userlisteners {
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
     //   binding.imageback.setOnClickListener(v -> onBackPressed());
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
                        List<Userr> users = new ArrayList<>();
                        for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                            if (currentUserId.equals(queryDocumentSnapshot.getId())){
                                continue;
                            }
                            Userr userr1 = new Userr();
                            userr1.name= queryDocumentSnapshot.getString(DatosTutores.KEY_NAME);
                            //cambie
                            userr1.descrip= queryDocumentSnapshot.getString(DatosTutores.KEY_SEXO);
                            userr1.image= queryDocumentSnapshot.getString(DatosTutores.KEY_IMAGE);

                            userr1.token= queryDocumentSnapshot.getString(DatosTutores.KEY_FCM_TOKEN);
                            userr1.id = queryDocumentSnapshot.getId();
           //posiblerror
users.add(userr1);
                        }
                        if (users.size() > 0){
                           UserAdapter userAdapter = new UserAdapter(users, this);
                            binding.usersRecycler.setAdapter(userAdapter);
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

    @Override
    public void onUserClicked(Userr userr) {
        Intent intent  = new Intent(getApplicationContext(), ChatActivity.class);
        intent.putExtra(DatosTutores.KEY_USER,userr);
        startActivity(intent);
        finish();
    }

    public void sig(View view) {
        Intent pasa = new Intent(UsersActivity.this, Login.class);
        startActivity(pasa);
    }
}