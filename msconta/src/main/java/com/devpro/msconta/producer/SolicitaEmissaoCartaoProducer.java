package com.devpro.msconta.producer;

import com.devpro.msconta.request.SolicitaCartaoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitaEmissaoCartaoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queueEmissaoCartoes;

    @Autowired
    private ObjectMapper objectMapper;

    public void solicitarCartao(SolicitaCartaoRequest request) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(request);
        rabbitTemplate.convertAndSend(queueEmissaoCartoes.getName(), json);
    }
}
