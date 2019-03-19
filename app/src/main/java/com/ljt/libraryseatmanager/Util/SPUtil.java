package com.ljt.libraryseatmanager.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    private static  final String NAME="LbrSetMager";

    public static  void putString(Context context,String key,String content){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,content);
        edit.apply();

    }
    public static String getString(Context context,String key)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        String string = sharedPreferences.getString(key, " ");
        return string;

    }
    public static  void putInt(Context context,String key,int content){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key,content);
        edit.apply();


    }
    public static int getInt(Context context,String key)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        int string = sharedPreferences.getInt(key, 0);
        return string;

    }
}
