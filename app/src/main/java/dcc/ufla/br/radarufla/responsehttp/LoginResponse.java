package dcc.ufla.br.radarufla.responsehttp;

public class LoginResponse {

    private String _id;
    private String email;
    private String password;
    private int __v;

    public LoginResponse(String _id, String email, String password, int __v) {
        this._id = _id;
        this.email = email;
        this.password = password;
        this.__v = __v;
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

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
