package dcc.ufla.br.radarufla;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    EditText emailUfla;
    EditText senhaUfla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login Radar UFLA");

        instaciarObjetosView();

        LoginTask task = new LoginTask();
        task.execute("http://echo.jsontest.com/key/value/one/two");


  }

    public void instaciarObjetosView(){

        this.emailUfla = (EditText)findViewById(R.id.emailUfla);
        this.senhaUfla = (EditText)findViewById(R.id.senhaUfla);
    }


    private class LoginTask extends AsyncTask<String,Integer,String>{
        /*Nesse métódo que acontece o trabalho pesado, é onde se cria uma nova thread diferente da UI thread
        * Após o termíno do processo o mesmo retorna para o parametro do método onPostExecute
        * No nosso caso o doInBackground irá realizar a requisição post para o servidor
        * */
        protected String doInBackground(String... urls) {

            PostLogin postLogin = new PostLogin();
            String response = null;
            try {
                response = postLogin.run(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }
        /*Aqui podemos implementar uma interface para o usuário acompanhar o progresso da requisição*/
        protected void onProgressUpdate(Integer... progress) {

        }
        /*Aqui é onde iremos tratar o nosso resultado (JSON) e tiver que fazer o necessário*/
        protected void onPostExecute(String result) {
            System.out.println(result);
        }
    }
    public class PostLogin{
        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException{
            Request request = new Request.Builder().url(url).build();
            String result = null;
            try{
                Response response = client.newCall(request).execute();
                result = response.body().string();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return result;
        }
    }
}
