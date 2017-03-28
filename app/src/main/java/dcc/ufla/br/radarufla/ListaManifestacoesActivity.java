package dcc.ufla.br.radarufla;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.IOException;
import java.util.List;

import dcc.ufla.br.radarufla.adapters.ManifestacaoAdapter;
import dcc.ufla.br.radarufla.httpclients.ManifestacaoClient;
import dcc.ufla.br.radarufla.responsehttp.ManifestacaoResponse;

public class ListaManifestacoesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_manifestacoes);
        Fresco.initialize(this);

        instaciarObjetosView();
        ManifestacaoTask task = new ManifestacaoTask();
        task.execute(new TaskManifestacao(" https://radar-ufla.herokuapp.com/manifestacao",this));

    }


    public void instaciarObjetosView(){
        this.recyclerView = (RecyclerView)findViewById(R.id.listManifestacoes);
        this.progressDialog = new ProgressDialog(this);
    }

    public void setupRecyclerView(List<ManifestacaoResponse> manifestacaoResponseList){
        layoutManager = new LinearLayoutManager(this);
        adapter = new ManifestacaoAdapter(manifestacaoResponseList,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private class ManifestacaoTask extends AsyncTask<TaskManifestacao,Integer,List<ManifestacaoResponse>> {

        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(ListaManifestacoesActivity.this);
            progressDialog.setMessage("Recuperando manifestações");
            progressDialog.show();
        }


        protected List<ManifestacaoResponse> doInBackground(TaskManifestacao... params) {

            ManifestacaoClient manifestacaoClient = new ManifestacaoClient();
            List<ManifestacaoResponse> response = null;
            try {
                response = manifestacaoClient.runGet(params[0].getUrl(), params[0].getCtx());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }
        protected void onPostExecute(List<ManifestacaoResponse> manifestacaoResponses) {
            progressDialog.dismiss();
            if(manifestacaoResponses != null){
                setupRecyclerView(manifestacaoResponses);
            }

        }

    }
}
