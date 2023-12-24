package com.devpro.msconta.enums;

public enum Reputacao {

    RUIM(1, "Ruim"),
    BOA(2, "Boa"),
    EXCELENTE(3, "Excelente");

    private int id;
    private String nome;

    Reputacao(int id, String nome) {
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
