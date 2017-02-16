package dcc.ufla.br.radarufla;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import dcc.ufla.br.radarufla.httpclients.LoginClient;
import dcc.ufla.br.radarufla.responsehttp.LoginResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    EditText emailUfla;
    EditText senhaUfla;
    Button botaoLogin;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login Radar UFLA");

        instaciarObjetosView();

        final LoginModel user = new LoginModel();
        this.progressDialog = new ProgressDialog(getBaseContext());
        this.botaoLogin.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setEmail(emailUfla.getText().toString());

                user.setPassword(senhaUfla.getText().toString());

                TaskParametros taskParametros = new TaskParametros("https://radar-ufla.herokuapp.com/login",user);
                LoginTask task = new LoginTask();
                task.execute(taskParametros);
                try{
                    System.out.println(CriptografarSenha.criptograr(emailUfla.getText().toString()));

                }
                catch ( NoSuchAlgorithmException err)
                {

                }

            }
        });

  }

    public void instaciarObjetosView(){

        this.emailUfla = (EditText)findViewById(R.id.emailUfla);
        this.senhaUfla = (EditText)findViewById(R.id.senhaUfla);
        this.botaoLogin = (Button)findViewById(R.id.botaoLogin);
    }

    /*classe privada da classe activity que é responsável por criar uma thread para trabalhar com a requisição post no caso*/
    private class LoginTask extends AsyncTask<TaskParametros,Integer,LoginResponse>{
        /*Nesse métódo que acontece o trabalho pesado, é onde se cria uma nova thread diferente da UI thread
        * Após o termíno do processo o mesmo retorna para o parametro do método onPostExecute
        * No nosso caso o doInBackground irá realizar a requisição post para o servidor
        * */
        protected LoginResponse doInBackground(TaskParametros... params) {

            LoginClient loginClient = new LoginClient();
            LoginResponse response = null;
            try {
                response = loginClient.runPost(params[0].getUrl(),params[0].getUser());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }
        /*Aqui podemos implementar uma interface para o usuário acompanhar o progresso da requisição*/
        protected void onProgressUpdate(Integer... progress) {
           progressDialog.setMessage("Logando");
           progressDialog.show();
        }
        /*Aqui é onde iremos tratar o nosso resultado (JSON) e tiver que fazer o necessário*/
        protected void onPostExecute(LoginResponse response) {
            progressDialog.dismiss();
            if(response != null){
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
            else{
                Toast.makeText(getBaseContext(),"Crendenciais erradas",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
