package com.example.desafiob2w.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resposta {

    @JsonProperty
    private String mensagem;

    public Resposta(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
