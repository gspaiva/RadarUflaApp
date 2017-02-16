package dcc.ufla.br.radarufla.responsehttp;

public class LoginResponse {

    private String _id;
    private String email;
    private String password;
    private String nome;
    private String categoria;
    private String setor;



    public LoginResponse(String _id, String email, String password, int __v) {
        this._id = _id;
        this.email = email;
        this.password = password;

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
}
