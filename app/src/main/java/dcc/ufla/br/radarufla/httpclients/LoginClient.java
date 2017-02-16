package dcc.ufla.br.radarufla.httpclients;


import com.google.gson.Gson;

import java.io.IOException;

import dcc.ufla.br.radarufla.LoginModel;
import dcc.ufla.br.radarufla.responsehttp.LoginResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginClient {

    OkHttpClient client = new OkHttpClient();
    final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public LoginResponse runPost(String url, LoginModel user) throws IOException {

        Gson userJson = new Gson();

        System.out.println(userJson.toJson(user));

        RequestBody requestBody = RequestBody.create(JSON,userJson.toJson(user));

        Request request = new Request.Builder().url(url).post(requestBody).build();

        LoginResponse result = null;
        try{
            Response response = client.newCall(request).execute();
            Gson responseGson = new Gson();
            result = responseGson.fromJson(response.body().string(),LoginResponse.class);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return result;

            /* usuario valido{ email: 'neumar@dcc.ufla.br', password: '123456' }*/
    }
}
