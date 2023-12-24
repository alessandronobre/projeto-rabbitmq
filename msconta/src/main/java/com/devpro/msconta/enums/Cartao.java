package com.devpro.msconta.enums;

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

    public static Cartao verificaCartaoDisponivel(Reputacao reputacao) {
        if (Reputacao.EXCELENTE.equals(reputacao)) {
            return BLACK;
        }
        return PLATINUM;
    }
}
