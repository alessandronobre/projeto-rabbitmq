package com.devpro.msconta.controller;

import com.devpro.msconta.service.ClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/solicitar")
    public String solicitaCartao(@PathParam("clienteId") Long clienteId) {
        return clienteService.solicitaCartao(clienteId);

    }
}
