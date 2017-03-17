package dcc.ufla.br.radarufla;

/*
* "tipo": “consulta” | “denuncia” | “elogio” | “reclamacao” | “sugestao” | “solicitacao”,
“assunto”: “este e o assunto”,
“descricao”: “esta e a descricao da manifestacao”,
“anexo”: “caminho do arquivo”,
"id_usuario": "aslkjdf09f0sa" | null
"likes" : 0,
"dislikes" : 0

* */

import android.content.Context;

public class ManifestacaoModel {


    private String tipo;
    private String assunto;
    private String descricao;
    private String anexo;
    private String id_usuario;
    private int likes = 0;
    private int dislikes = 0;

    public ManifestacaoModel(String tipo, String assunto, String descricao, String anexo, String id_usuario, int likes, int dislikes) {
        this.tipo = tipo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.anexo = anexo;
        this.id_usuario = id_usuario;
        this.likes = likes;
        this.dislikes = dislikes;
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
}