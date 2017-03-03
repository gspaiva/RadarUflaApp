package dcc.ufla.br.radarufla;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dcc.ufla.br.radarufla.auth.AuthApp;

public class MainActivity extends AppCompatActivity {

    private Button btnAddManifestacao;
    private static final String PREF_NAME = "TOKEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Bem vindo ao Radar UFLA");

        btnAddManifestacao = (Button)findViewById(R.id.btnAddManifestacao);

        btnAddManifestacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ManifestacaoActivity.class);
                startActivity(i);
            }
        });

    }
}
