package dcc.ufla.br.radarufla.responsehttp;

public class LoginResponse {

    private String _id;
    private String email;
    private String password;
    private String nome;
    private String categoria;
    private String setor;
    private int _v;
    private String token;
    private boolean auth;


    public LoginResponse(String _id, String email, String password, String nome, String categoria, String setor, int _v, String token, boolean auth) {
        this._id = _id;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.categoria = categoria;
        this.setor = setor;
        this._v = _v;
        this.token = token;
        this.auth = auth;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int get_v() {
        return _v;
    }

    public void set_v(int _v) {
        this._v = _v;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }
}
