package dcc.ufla.br.radarufla;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dcc.ufla.br.radarufla.auth.AuthApp;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "TOKEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bem vindo ao Radar UFLA");

        System.out.println(AuthApp.getToken(this));

    }
}
