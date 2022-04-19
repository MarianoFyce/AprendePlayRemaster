package com.example.aprende_play.chat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.aprende_play.DatosTutores;
import com.example.aprende_play.R;
import com.example.aprende_play.chat.adapter.Userr;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class MensajeServicio extends FirebaseMessagingService {


    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        //Log.d("FCM","Tokenj"+token);
    }
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // Log.d("FCM",",Mensaje" + message.getNotification().getBody());
        Userr userr = new Userr();

        userr.id = remoteMessage.getData().get(DatosTutores.KEY_USER_ID);
        userr.name = remoteMessage.getData().get(DatosTutores.KEY_NAME);
        userr.token = remoteMessage.getData().get(DatosTutores.KEY_FCM_TOKEN);

        int notificationId = new Random().nextInt();
        String channelId = "Mensaje a tú chat";

        Intent intent = new Intent(this,ChatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(DatosTutores.KEY_USER,userr);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channelId);
        builder.setSmallIcon(R.drawable.ic_not);
        builder.setContentTitle(userr.name);
        builder.setContentText(remoteMessage.getData().get(DatosTutores.KEY_MENSAJE));
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(
                remoteMessage.getData().get(DatosTutores.KEY_MENSAJE)
        ));
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence channelName = "Mensajes del Chat";
            String channelDescription = "Notificacion de AprendePlay";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName,importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(notificationId, builder.build());
    }
}
