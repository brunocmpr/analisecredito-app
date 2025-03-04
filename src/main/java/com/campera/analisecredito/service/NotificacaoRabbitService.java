package com.campera.analisecredito.service;

import com.campera.analisecredito.domain.Proposta;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificacaoRabbitService {
    private RabbitTemplate rabbitTemplate;

    public void notificar(String exchange, Proposta proposta){
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
