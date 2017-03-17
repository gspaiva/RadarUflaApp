package dcc.ufla.br.radarufla.httpclients;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import dcc.ufla.br.radarufla.ManifestacaoActivity;
import dcc.ufla.br.radarufla.ManifestacaoModel;
import dcc.ufla.br.radarufla.auth.AuthApp;
import dcc.ufla.br.radarufla.responsehttp.ManifestacaoResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ManifestacaoClient {

    private OkHttpClient client = new OkHttpClient();
    final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");



    public ManifestacaoResponse runPost(String url, ManifestacaoModel manifestacao) throws IOException {

//        Gson userJson = new Gson();
//
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//
//        ManifestacaoResponse result = null;
//        try{
//            Response response = client.newCall(request).execute();
//
//            if(response.code() == 200){
//                Gson responseGson = new Gson();
//                result = responseGson.fromJson(response.body().string(),ManifestacaoResponse.class);
//            }
//
//        }
//
//        catch (IOException e){
//            e.printStackTrace();
//        }
//
//        return result;
        return null;
    }
    public List<ManifestacaoResponse> runGet(String url, Context ctx) throws IOException {

        Type listType = new TypeToken<ArrayList<ManifestacaoResponse>>(){}.getType();

        Request request = new Request.Builder().url(url).get().addHeader("x-access-token", AuthApp.getToken(ctx)).build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());

        List<ManifestacaoResponse> manifestacoes = new Gson().fromJson(response.body().string(),listType);

        return manifestacoes;


    }



}
