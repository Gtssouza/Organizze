package com.example.organizze.activity.model;

import com.example.organizze.activity.config.ConfiguracaoFireBase;
import com.example.organizze.activity.helper.Base64Custom;
import com.example.organizze.activity.helper.DataUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Movimentacao {

    private String data;
    private String categoria;
    private String descricao;
    private String tipo;
    private double valor;

    public Movimentacao() {
    }

    public void salvar(String dataEscolhida){
        FirebaseAuth autenticacao = ConfiguracaoFireBase.getFireBaseAuth();
        String mesAno = DataUtil.mesAnoDataEscolhida(dataEscolhida);
        String idUsuario = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());
        DatabaseReference fireBaseref = ConfiguracaoFireBase.getFireBase();
        fireBaseref.child("movimentacao").child(idUsuario).child(mesAno).push().setValue(this);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
