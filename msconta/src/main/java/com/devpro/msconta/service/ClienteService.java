package com.devpro.msconta.service;

import com.devpro.msconta.enums.Cartao;
import com.devpro.msconta.enums.Reputacao;
import com.devpro.msconta.model.Cliente;
import com.devpro.msconta.producer.SolicitaEmissaoCartaoProducer;
import com.devpro.msconta.repository.ClienteRepository;
import com.devpro.msconta.request.SolicitaCartaoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SolicitaEmissaoCartaoProducer solicitaEmissaoCartaoProducer;

    public String solicitaCartao(Long clienteId) {
        Optional<Cliente> cliente =  clienteRepository.findById(clienteId);
        if (!cliente.isPresent()) {
            return "Cliente não encontrado";
        }

        Cartao cartao = verificaCartaoDisponivel(cliente.get().getReputacao());
        if (cartao != null) {
            SolicitaCartaoRequest request = new SolicitaCartaoRequest();
            request.setEndereco(cliente.get().getEndereco());
            request.setCartao(cartao);

            try {
                solicitaEmissaoCartaoProducer.solicitarCartao(request);
                return "Obá, com base no seu perfil enviaremos um cartão " + cartao + " para voce, agora só aguardar !";

            } catch (JsonProcessingException e) {
                log.error("Houve um erro ao tentar enviar msg para a fila : " + e.getMessage());
                return "Erro ao tentar solicitar o cartão, entre em contato com a central";
            }

        } else {
            return "Infelismente não temos cartões disponivel para seu perfil no momento";
        }

    }

    private Cartao verificaCartaoDisponivel(Reputacao reputacao) {
        if (!Reputacao.RUIM.equals(reputacao)) {
            return Cartao.verificaCartaoDisponivel(reputacao);
        } else {
            return null;
        }
    }
}
