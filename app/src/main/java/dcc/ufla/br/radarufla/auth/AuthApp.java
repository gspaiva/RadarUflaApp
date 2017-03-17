package dcc.ufla.br.radarufla.auth;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthApp {

    private static String token;
    private static String id;
    private static final String PREF_NAME = "TOKEN";
    private static final String PREF_NAMEID = "ID_USUARIO";

    public static String getToken(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        token = settings.getString("token",null);
        return token;
    }
    public static void salvaToken(Context context, String tokenUser){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE).edit();
        editor.putString("token",tokenUser);
        editor.commit();
    }
    public static void salvaId(Context context, String idUser){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAMEID,context.MODE_PRIVATE).edit();
        editor.putString("id_usuario",idUser);
        editor.commit();
    }
    public static String getId(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAMEID, context.MODE_PRIVATE);
        id = settings.getString("id_usuario",null);
        return id;
    }




}
