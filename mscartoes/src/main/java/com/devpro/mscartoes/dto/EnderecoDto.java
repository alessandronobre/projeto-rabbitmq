package com.devpro.mscartoes.dto;

import com.devpro.mscartoes.enums.Cidade;
import lombok.Data;

@Data
public class EnderecoDto {

    private Long id;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
    private String cep;

    @Override
    public String toString() {
        return  "Rua " + rua +
                ", " + numero +
                " - " + bairro +
                " - " + cidade +
                ", " + cep +
                " - Complemento = " + complemento ;
    }
}
