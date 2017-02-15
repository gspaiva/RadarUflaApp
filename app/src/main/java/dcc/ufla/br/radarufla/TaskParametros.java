package dcc.ufla.br.radarufla;



public class TaskParametros {

    private String url;
    private LoginModel user;

    public TaskParametros(String url, LoginModel user) {
        this.url = url;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LoginModel getUser() {
        return user;
    }

    public void setUser(LoginModel user) {
        this.user = user;
    }
}
