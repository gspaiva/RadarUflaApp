package dcc.ufla.br.radarufla;


import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografarSenha {


    public static String criptograr(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        String passwordCriptografado = Base64.encodeToString(digest,1);

        return passwordCriptografado;
    }


}
