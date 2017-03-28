package dcc.ufla.br.radarufla;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import dcc.ufla.br.radarufla.auth.AuthApp;

public class MainActivity extends AppCompatActivity {

    private Button btnAddManifestacao;
    private Button btnAtualizarMeusDados;
    private Button btnVerManifestacao;

    //private static final String PREF_NAME = "TOKEN";

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bem vindo ao Radar UFLA");

        instanciarObjetosView();

        btnAddManifestacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ManifestacaoActivity.class);
                startActivity(i);
            }
        });

        btnVerManifestacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ListaManifestacoesActivity.class);
                startActivity(i);
            }
        });


    }
    public void instanciarObjetosView(){

        btnAddManifestacao = (Button)findViewById(R.id.btnAddManifestacao);
        btnVerManifestacao = (Button)findViewById(R.id.btnVerManifestacoes);
        btnAtualizarMeusDados = (Button)findViewById(R.id.btnAtualizarMeusDados);

    }

}
