package dcc.ufla.br.radarufla;

import android.content.Context;

import java.io.File;

//String url, File photo, Context ctx, String type

public class TaskUpload {

    private String url;
    private File photo;
    private Context ctx;
    private String tipo;

    public TaskUpload(String url, File photo, Context ctx, String tipo) {
        this.url = url;
        this.photo = photo;
        this.ctx = ctx;
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
