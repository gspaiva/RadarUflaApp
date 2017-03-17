package dcc.ufla.br.radarufla;

import android.content.Context;

/**
 * Created by gabriel on 16/03/17.
 */

public class TaskManifestacao {

    private String url;
    private Context ctx;

    public TaskManifestacao(String url, Context ctx) {
        this.url = url;
        this.ctx = ctx;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }
}
