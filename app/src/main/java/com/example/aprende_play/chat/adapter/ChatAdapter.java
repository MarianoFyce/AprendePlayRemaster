package com.example.aprende_play.chat.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aprende_play.chat.models.ChatMensaje;
import com.example.aprende_play.databinding.ItemContainerReceibedMensajeBinding;
import com.example.aprende_play.databinding.ItemContainerSentMensajeBinding;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ChatMensaje> ChatMensajes;
    private Bitmap receivedPerfilImagen;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;

    public void setReceivedPerfilImagen(Bitmap bitmap){
        receivedPerfilImagen = bitmap;
    }

    public ChatAdapter(List<ChatMensaje> ChatMensajes, Bitmap receivedPerfilImagen, String senderId) {
        this.ChatMensajes = ChatMensajes;
        this.receivedPerfilImagen = receivedPerfilImagen;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENT){
            return  new SentMensajeView(
                    ItemContainerSentMensajeBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }else {
            return  new ReceivedMensajeViewh(
                    ItemContainerReceibedMensajeBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
if (getItemViewType(position) == VIEW_TYPE_SENT){
    ((SentMensajeView)holder).setData(ChatMensajes.get(position));
}else{
    ((ReceivedMensajeViewh)holder).setData(ChatMensajes.get(position),receivedPerfilImagen );
}
    }

    @Override
    public int getItemCount() {
        return  ChatMensajes.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (ChatMensajes.get(position).senderId.equals(senderId)){
            return  VIEW_TYPE_SENT;
        }else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    static  class SentMensajeView extends RecyclerView.ViewHolder{
        private final ItemContainerSentMensajeBinding binding;

        SentMensajeView(ItemContainerSentMensajeBinding itemContainerSentMensajeBinding){
            super(itemContainerSentMensajeBinding.getRoot());
            binding = itemContainerSentMensajeBinding;
        }
        void setData(ChatMensaje chatMensaje){
            binding.texmensaje.setText(chatMensaje.mensaje);
            binding.textdateTime.setText(chatMensaje.dateTime);
        }


    }
    static class ReceivedMensajeViewh extends RecyclerView.ViewHolder{
        private  final ItemContainerReceibedMensajeBinding binding;

        ReceivedMensajeViewh (ItemContainerReceibedMensajeBinding itemContainerReceibedMensajeBinding){
            super(itemContainerReceibedMensajeBinding.getRoot());
            binding = itemContainerReceibedMensajeBinding;
        }
        void setData(ChatMensaje chatMensaje, Bitmap receiverPerfilImagen){
            binding.textMensaje.setText(chatMensaje.mensaje);
            binding.textDatetime.setText(chatMensaje.dateTime);

            //aña
            if (receiverPerfilImagen != null){
                binding.imagePerfil.setImageBitmap(receiverPerfilImagen);
            }

        }
    }
}
