package com.example.aprende_play.chat.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aprende_play.chat.listeners.Userlisteners;
import com.example.aprende_play.databinding.ItemContainerUsuariosBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private final List<Userr> userss;
    private  final Userlisteners userlisteners;

    public UserAdapter(List<Userr> users , Userlisteners userlisteners) {
        this.userss = users;
        this.userlisteners = userlisteners;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerUsuariosBinding itemContainerUsuariosBinding = ItemContainerUsuariosBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new UserViewHolder(itemContainerUsuariosBinding);
    }
//not
    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
holder.setUserData(userss.get(position));
    }

    @Override
    public int getItemCount() {
        return userss.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
ItemContainerUsuariosBinding binding;

UserViewHolder(ItemContainerUsuariosBinding itemContainerUsuariosBinding){
    super(itemContainerUsuariosBinding.getRoot());
    binding = itemContainerUsuariosBinding;
}
void setUserData(Userr userr){
    binding.textname.setText(userr.name);
    //por descrip
    binding.texemaildes.setText(userr.descrip);
    binding.imageProfile.setImageBitmap(getUserImage(userr.image));
    binding.getRoot().setOnClickListener(view ->  userlisteners.onUserClicked(userr));

}

    }
    private Bitmap getUserImage(String encodedImage){
        byte[] bytes = Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }
}
