package dcc.ufla.br.radarufla.httpclients;

import android.content.Context;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;

import dcc.ufla.br.radarufla.auth.AuthApp;
import dcc.ufla.br.radarufla.responsehttp.LoginResponse;
import dcc.ufla.br.radarufla.responsehttp.UploadResponse;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadClient {

    OkHttpClient client = new OkHttpClient();

    public UploadResponse runMultipartUpload(String url, File photo, Context ctx, String type) throws IOException {

        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("fotoManifestacao", AuthApp.getId(ctx).toString() + timestamp.toString() + type ,
                        RequestBody.create(MultipartBody.FORM, photo))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();


        Response response = client.newCall(request).execute();
        UploadResponse uploadResponse = null;

        if(response.code() == 200){
            Gson gson = new Gson();
            uploadResponse = gson.fromJson(response.body().string(),UploadResponse.class);
        }

        return uploadResponse;

    }

}
