package dcc.ufla.br.radarufla.auth;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthApp {

    private static String token;
    private static final String PREF_NAME = "TOKEN";

    public static String getToken(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        token = settings.getString("token",null);
        return token;
    }
    public static void salvaToken(Context context, String token){
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE).edit();
        editor.putString("token",token);
        editor.commit();
    }
    


}
