package dcc.ufla.br.radarufla;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    EditText emailUfla;
    EditText senhaUfla;
    Button botaoLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login Radar UFLA");

        instaciarObjetosView();

        final LoginModel user = new LoginModel();

        this.botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setEmail(emailUfla.getText().toString());
                user.setPassword(senhaUfla.getText().toString());

                TaskParametros taskParametros = new TaskParametros("https://radar-ufla.herokuapp.com/login",user);
                LoginTask task = new LoginTask();
                task.execute(taskParametros);
            }
        });





  }

    public void instaciarObjetosView(){

        this.emailUfla = (EditText)findViewById(R.id.emailUfla);
        this.senhaUfla = (EditText)findViewById(R.id.senhaUfla);
        this.botaoLogin = (Button)findViewById(R.id.botaoLogin);
    }


    private class LoginTask extends AsyncTask<TaskParametros,Integer,String>{
        /*Nesse métódo que acontece o trabalho pesado, é onde se cria uma nova thread diferente da UI thread
        * Após o termíno do processo o mesmo retorna para o parametro do método onPostExecute
        * No nosso caso o doInBackground irá realizar a requisição post para o servidor
        * */
        protected String doInBackground(TaskParametros... params) {

            PostLogin postLogin = new PostLogin();
            String response = null;
            try {
                response = postLogin.run(params[0].getUrl(),params[0].getUser());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }
        /*Aqui podemos implementar uma interface para o usuário acompanhar o progresso da requisição*/
        protected void onProgressUpdate(Integer... progress) {

        }
        /*Aqui é onde iremos tratar o nosso resultado (JSON) e tiver que fazer o necessário*/
        protected void onPostExecute(String response) {
            System.out.println(response);
        }
    }
    public class PostLogin{
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        String run(String url, LoginModel user) throws IOException{

            Gson userJson = new Gson();

            System.out.println(userJson.toJson(user));

            RequestBody requestBody = RequestBody.create(JSON,userJson.toJson(user));

            Request request = new Request.Builder().url(url).post(requestBody).build();
            String result = null;
            try{
                Response response = client.newCall(request).execute();
                result = response.body().string();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return result;

            /* usuario valido{ email: 'neumar@dcc.ufla.br', password: '123456' }*/
        }
    }
}
