package com.devpro.mscartoes.enums;

public enum Cartao {

    PLATINUM(1, "Platinum"),
    BLACK(2, "Black");

    private int id;
    private String nome;

    Cartao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
