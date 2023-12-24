package com.devpro.mscartoes.request;

import com.devpro.mscartoes.dto.EnderecoDto;
import com.devpro.mscartoes.enums.Cartao;
import lombok.Data;

@Data
public class SolicitaCartaoRequest {

    private EnderecoDto endereco;
    private Cartao cartao;
}
