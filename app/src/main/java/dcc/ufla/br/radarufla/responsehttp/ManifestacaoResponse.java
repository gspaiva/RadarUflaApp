package dcc.ufla.br.radarufla.responsehttp;

/**
 * Created by gabriel on 16/03/17.
 */

public class ManifestacaoResponse {

    private String _id;
    private String tipo;
    private String assunto;
    private String descricao;
    private String anexo;
    private String id_usuario;
    private int likes;
    private int dislikes;
    private int _v;

    public ManifestacaoResponse(String _id, String tipo, String assunto, String descricao, String anexo, String id_usuario, int likes, int dislikes, int _v) {
        this._id = _id;
        this.tipo = tipo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.anexo = anexo;
        this.id_usuario = id_usuario;
        this.likes = likes;
        this.dislikes = dislikes;
        this._v = _v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int get_v() {
        return _v;
    }

    public void set_v(int _v) {
        this._v = _v;
    }
}
