package com.devpro.msconta.request;

import com.devpro.msconta.enums.Cartao;
import com.devpro.msconta.model.Endereco;
import lombok.Data;

@Data
public class SolicitaCartaoRequest {

    private Endereco endereco;
    private Cartao cartao;
}
