package dcc.ufla.br.radarufla.responsehttp;


public class UploadResponse {

    String path;

    public UploadResponse(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
