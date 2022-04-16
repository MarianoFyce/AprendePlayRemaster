package com.example.aprende_play.chat.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aprende_play.chat.listeners.ConversionListener;
import com.example.aprende_play.chat.models.ChatMensaje;
import com.example.aprende_play.databinding.ItemContainerRecentConversationBinding;

import java.util.List;

public class RecentConversationAdapter extends RecyclerView.Adapter<RecentConversationAdapter.ConversionViewHolder>{

    private final List<ChatMensaje> chatMensajes;
   // private final ConversionListener conversionListener;

    public RecentConversationAdapter(List<ChatMensaje> chatMensajes,ConversionListener conversionListener) {
        this.chatMensajes = chatMensajes;
      //  this.conversionListener = conversionListener;
    }

    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversionViewHolder(
                ItemContainerRecentConversationBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionViewHolder holder, int position) {
holder.setData(chatMensajes.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMensajes.size();
    }

    class ConversionViewHolder extends RecyclerView.ViewHolder{

        ItemContainerRecentConversationBinding binding;

        ConversionViewHolder(ItemContainerRecentConversationBinding itemContainerRecentConversationBinding){
            super(itemContainerRecentConversationBinding.getRoot());
            binding = itemContainerRecentConversationBinding;
        }
    void setData(ChatMensaje chatMensaje){
            binding.imageProfile.setImageBitmap(getConversionImage(chatMensaje.conversionImage));
            binding.textname.setText(chatMensaje.conversionName);
            binding.texrecenmensaje.setText(chatMensaje.mensaje);
         //   binding.getRoot().setOnClickListener(v ->{
           ///     Userr userr = new Userr();
              //  userr.id =chatMensaje.conversionId;
                //userr.name = chatMensaje.conversionName;
                //userr.image = chatMensaje.conversionImage;
                //conversionListener.onConversionClicked(userr);
            //});
    }
    }


    private Bitmap getConversionImage(String encodesImage){

        byte[] bytes = Base64.decode(encodesImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }
}