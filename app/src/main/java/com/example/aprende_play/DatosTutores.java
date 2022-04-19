package com.example.aprende_play;


import java.util.HashMap;

public class DatosTutores {

    public static final String KEY_COLLECTION_USERS= "usuarios";
    public static final String KEY_NAME= "nombre";
    public static final String KEY_EMAIL= "correo";
    public static final String KEY_PASSWORD= "contraseña";
    public static final String KEY_SEXO= "sexo";
    public static final String KEY_EDAD= "edad";
    public static final String KEY_PREFERENCE_NAME= "chatAppPreference";
    public static final String KEY_IS_SIGNED_IN= "isSignedIn";
    public static final String KEY_USER_ID= "userId";
    public static final String KEY_IMAGE = "image";

    public static final String KEY_FCM_TOKEN = "fcmToken";

    public static final String KEY_USER ="usern";

    public static final String KEY_COLLECTION_CHAT = "chat";
    public static final String KEY_SENDER_ID = "senderId";
    public static final String KEY_RECEIVER_ID = "receiverId";
    public static final String KEY_MENSAJE ="mensaje;";
    public static final String KEY_TIMESTAMP = "timestamp";

    //public static final String KEY_COLLECTIONS_CONVERSATIONS = "conversations";
    //public static final String KEY_SENDER_NAME = "senderName";
    //public static final String KEY_RECEIVER_NAME = "receiverName";
    //public static final String KEY_SENDER_IMAGE = "senderImage";
    //public static final String KEY_RECEIVER_IMAGE = "receiverImage";
    //public static final String KEY_LAST_MENSAJE = "lastMensaje";
    public static final String KEY_AVAILABILITY = "availability";
    public static final String REMOTE_MSG_AUTHORIZATION = "Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE = "Content-Type";
    public static final String REMOTE_MSG_DATA = "data";
    public static final String REMOTE_MSG_REGISTRATION_IDS = "registration_ids";


    public static HashMap<String,String> remoteMsgHeaders = null;

    public static HashMap<String, String> getRemoteMsgHeaders(){
        if (remoteMsgHeaders == null){
            remoteMsgHeaders = new HashMap<>();
            remoteMsgHeaders.put(
                    REMOTE_MSG_AUTHORIZATION,
                    "KEY = AAAACkn8vys:APA91bFhNMqvJzn2aR7G4XkgNUvvdXzNzrrFMoD4n28lijPXoGB5bNzwJHSxqFMDPHCyUb5fQ7ms5ixiK-_irLHinFpuN6kKZtRgc3jY6W89mNXON-lnXL3MIvIAdTx18ebPStBaq2v0"
            );
            remoteMsgHeaders.put(
                    REMOTE_MSG_CONTENT_TYPE,
                    "application/json"
            );
        }
        return remoteMsgHeaders;
    }
}
