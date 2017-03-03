package dcc.ufla.br.radarufla;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifestacao);

        getSupportActionBar().setTitle("Criar manifestação");

        instanciaObjetosView();

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
        
        //subir a imagem para o servidor

        //pegar o retorno do servidor com o path dela

        //subir o json com os dados da manifestação em si

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
                imgManifestacao.setImageBitmap(imageManifestacao);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
