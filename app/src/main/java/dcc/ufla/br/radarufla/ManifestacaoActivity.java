package dcc.ufla.br.radarufla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ManifestacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifestacao);

        getSupportActionBar().setTitle("Criar manifestação");




    }
}
