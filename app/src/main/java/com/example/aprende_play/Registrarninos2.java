package com.example.aprende_play;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aprende_play.chat.PreferenceManager;
import com.example.aprende_play.databinding.ActivityRegistrarninos2Binding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class Registrarninos2 extends AppCompatActivity {
    private ActivityRegistrarninos2Binding binding;
    private  String encodedImage;
    private PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrarninos2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());

        setListeners();

    }

    private void setListeners() {
        binding.volver.setOnClickListener(v -> onBackPressed());
        binding.registrar.setOnClickListener(v ->{
            if (isValidSignDetail()){
                signUp();
            }
        });
        binding.frameimage.setOnClickListener(v ->{
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pickImage.launch(intent);
        });

    }


    private void showToast(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_SHORT).show();
    }
    private void signUp(){
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String,Object> user = new HashMap<>();
        user.put(DatosTutores.KEY_IMAGE,encodedImage);
        user.put(DatosTutores.KEY_NAME,binding.nombre.getText().toString());
        user.put(DatosTutores.KEY_EMAIL,binding.correo.getText().toString());
        user.put(DatosTutores.KEY_EDAD,binding.edad.getText().toString());
        user.put(DatosTutores.KEY_SEXO,binding.sexo.getText().toString());
        database.collection(DatosTutores.KEY_COLLECTION_NINOS2)
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    preferenceManager.putBoolean(DatosTutores.KEY_IS_SIGNED_IN, true);
                    preferenceManager.putString(DatosTutores.KEY_USER_ID, documentReference.getId());
                    preferenceManager.putString(DatosTutores.KEY_IMAGE, encodedImage);
                    preferenceManager.putString(DatosTutores.KEY_NAME, binding.nombre.getText().toString());


                    Intent intent = new Intent(getApplicationContext(), Verninoss.class);


                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                })
                .addOnFailureListener(exception ->{
                    loading(false);
                    showToast(exception.getMessage());

                });
    }
    private String encodedImage(Bitmap bitmap){
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight() * previewWidth / bitmap.getWidth();
        Bitmap prevewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth,previewHeight,false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        prevewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);

    }
    private final ActivityResultLauncher<Intent> pickImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode()== RESULT_OK){
                    if(result.getData() != null){
                        Uri imageUri = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.imperfil.setImageBitmap(bitmap);
                            binding.addImage.setVisibility(View.GONE);
                            encodedImage= encodedImage(bitmap);

                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
    );


    private Boolean isValidSignDetail(){
        if (encodedImage == null){
            showToast("Seleciona foto de perfil");
            return false;
        }else if(binding.correo.getText().toString().trim().isEmpty()){
            showToast("Agrega tú correo");
            return false;
        }
        else if (binding.nombre.getText().toString().trim().isEmpty()){
            showToast("Agrega un nombre");
            return false;

        }else if (binding.edad.getText().toString().trim().isEmpty()){
            showToast("Agrega tú edad");
            return false;

        }else if (binding.sexo.getText().toString().trim().isEmpty()){
            showToast("H/M");
            return false;
        }else {
            return true;
        }
    }
    private  void loading(Boolean isloading){
        if (isloading){
            binding.registrar.setVisibility(View.INVISIBLE);
            binding.progresbar.setVisibility(View.VISIBLE);

        }else{
            binding.progresbar.setVisibility(View.INVISIBLE);
            binding.registrar.setVisibility(View.VISIBLE);

        }

    }

}