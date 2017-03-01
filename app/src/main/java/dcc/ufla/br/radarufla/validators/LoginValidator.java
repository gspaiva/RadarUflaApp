package dcc.ufla.br.radarufla.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {



    public static boolean verificaCamposVazios(String email, String senha){

        if(email.equals("") |  senha.equals("")){
            return false;
        }
        return true;
    }
    public static boolean verificaEmail(String email){
        Pattern regEx = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher matcher = regEx.matcher(email);

        if(!matcher.matches()){
            return false;
        }

        return true;
    }
    public static boolean verificaSenha(String senha){
        if(senha.length() < 6)
            return false;

        return true;
    }





}
