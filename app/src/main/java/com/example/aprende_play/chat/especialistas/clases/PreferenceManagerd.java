package com.example.aprende_play.chat.especialistas.clases;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aprende_play.DatosTutores;

public class PreferenceManagerd {
    private final SharedPreferences sharedPreferences;
    public PreferenceManagerd(Context context){
        sharedPreferences= context.getSharedPreferences(DatosTutores.KEY_PREFERENCE_NAME,Context.MODE_PRIVATE);

    }
    public void putBoolean (String key,Boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public Boolean getBoABoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }
    public void putString(String key,String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getString(String key){
        return sharedPreferences.getString(key,null);
    }
    public void clear(){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
