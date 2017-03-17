package dcc.ufla.br.radarufla;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;

import dcc.ufla.br.radarufla.auth.AuthApp;
import dcc.ufla.br.radarufla.httpclients.LoginClient;
import dcc.ufla.br.radarufla.httpclients.ManifestacaoClient;
import dcc.ufla.br.radarufla.responsehttp.LoginResponse;
import dcc.ufla.br.radarufla.responsehttp.ManifestacaoResponse;
import dcc.ufla.br.radarufla.responsehttp.UploadResponse;
import okhttp3.MultipartBody;

public class ManifestacaoActivity extends AppCompatActivity {


    private Spinner spnTipoManifestacao;
    private EditText edtAssunto;
    private EditText edtDescricao;
    private Button btnAddAnexo;
    private Button btnEnviarManifestacao;
    private ImageView imgManifestacao;
    private int PICK_IMAGE_REQUEST = 1 ;
    private Uri caminhoImagem = null;
    private boolean botaoAtivar = false;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifestacao);

        getSupportActionBar().setTitle("Criar manifestação");

        instanciaObjetosView();


        //setar tipo manifestação

        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item,
                new String[]{
                        new TipoManifestacao("Consulta").getTipo(),
                        new TipoManifestacao("Elogio").getTipo(),
                        new TipoManifestacao("Denuncia").getTipo(),
                        new TipoManifestacao("Reclamação").getTipo(),
                        new TipoManifestacao("Sugestão").getTipo(),
                        new TipoManifestacao("Solicitação").getTipo()
                });


        spnTipoManifestacao.setAdapter(spinnerAdapter);


        //pegar a imagem da galeria

        btnAddAnexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE_REQUEST);
                //após o método startActivityForResult a atividade vai chamar o método onActiivityResult
                //nesse método iremos chamar um método responsável por fazer a parte de subir a imagem

            }
        });

        btnEnviarManifestacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sabemos que a imagem já foi pega
                if(botaoAtivar){

                    //sobe primero a imagem


//                    TaskManifestacao taskManifestacao = new TaskManifestacao("https://radar-ufla.herokuapp.com/login",ManifestacaoActivity.this);
//                    ManifestacaoActivity.ManifestacaoTask task = new ManifestacaoActivity.ManifestacaoTask();
//                    task.execute(taskManifestacao);

                }//imagem não foi pega ainda
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(ManifestacaoActivity.this);
                    builder.setMessage("Tem certeza que não deseja enviar uma imagem ?");
                    builder.setTitle("Confirmação");
                    builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();

                    dialog.show();

                }

            }
        });
        
        //subir a imagem para o servidor

        //pegar o retorno do servidor com o path dela

        //subir o json com os dados da manifestação em si

    }
    public void chamarRequisicao(ManifestacaoModel manifestacaoModel, TaskUpload taskUploadParametros){

        if(manifestacaoModel != null){

        }
        else
        {
            UploadTask uploadTask = new ManifestacaoActivity.UploadTask();

            uploadTask.execute(taskUploadParametros);
        }

    }

    public void instanciaObjetosView(){

        spnTipoManifestacao = (Spinner)findViewById(R.id.spnTipoManifestacao);
        edtAssunto = (EditText)findViewById(R.id.edtAssunto);
        edtDescricao = (EditText)findViewById(R.id.edtDescricao);
        btnAddAnexo = (Button)findViewById(R.id.btnAddAnexo);
        btnEnviarManifestacao = (Button)findViewById(R.id.btnEnviarManifestacao);
        imgManifestacao = (ImageView)findViewById(R.id.imgManifestacao);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {

                Bitmap imageManifestacao = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                System.out.println(data.getData().getPath());
                imgManifestacao.setImageBitmap(imageManifestacao);
                this.botaoAtivar = true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private class ManifestacaoTask extends AsyncTask<TaskManifestacao,Integer,List<ManifestacaoResponse>>{
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(ManifestacaoActivity.this);
            progressDialog.setMessage("Salvando manifestações");
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

                for(ManifestacaoResponse manifestacaoResponse : manifestacaoResponses ){
                    System.out.println(manifestacaoResponse.getDescricao());
                }

                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
            else{
                Toast.makeText(getBaseContext(),"Erro manifestação",Toast.LENGTH_SHORT).show();
            }
        }

    }
    private class UploadTask extends AsyncTask<TaskUpload,Integer,UploadResponse> {

        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected UploadResponse doInBackground(TaskUpload... params) {

            return null;
        }
        protected void onPostExecute(UploadResponse path) {



        }

    }





}
