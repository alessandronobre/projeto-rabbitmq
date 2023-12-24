package com.devpro.mscartoes.consumer;

import com.devpro.mscartoes.request.SolicitaCartaoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmissaoCartaoConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void emitirCartao(@Payload String payload){
        try {
            SolicitaCartaoRequest request = objectMapper.readValue(payload, SolicitaCartaoRequest.class);
            log.error("Enviando cartão " + request .getCartao() + " para o endereço : "+ request.getEndereco().toString());

        }catch (Exception e){
            log.error("Erro ao receber solicitacao de emissao de cartao: {} ", e.getMessage());
        }
    }
}
