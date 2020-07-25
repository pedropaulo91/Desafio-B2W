package com.example.desafiob2w.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "planetas")
public class Planeta {

    private ObjectId _id;
    @NotNull
    private String nome;
    @NotNull
    private String clima;
    @NotNull
    private String terreno;
    private int aparicoes;


    public String get_id() {
        return _id.toString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getAparicoes() {
        return aparicoes;
    }

    public void setAparicoes(int aparicoes) {
        this.aparicoes = aparicoes;
    }

}
