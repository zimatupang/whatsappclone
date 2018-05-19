package com.tech.roger.pembekalanh1.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Roger on 5/18/2018.
 */

public class Preferences {

    private static String TAG = "WA";
    public static void setStringPreferences(String prefName, String value, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG, context.MODE_PRIVATE).edit();
        editor.putString(prefName, value);
        editor.apply();
    }

    public static void setIntPreferences(String prefName, int value , Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG, context.MODE_PRIVATE).edit();
        editor.putInt(prefName, value);
        editor.apply();
    }

    public static String getStringPreferences(String prefNama, Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG,context.MODE_PRIVATE);
        String value = preferences.getString(prefNama, "");
        return value;
    }

    public static int getIntPreferences(String prefName, Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG, context.MODE_PRIVATE);
        int value = preferences.getInt(prefName, 0);
        return value;
    }
}
