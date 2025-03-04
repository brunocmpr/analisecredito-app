package com.campera.analisecredito.service;

import com.campera.analisecredito.domain.Proposta;
import com.campera.analisecredito.exception.StrategyException;
import com.campera.analisecredito.service.strategy.CalculoPonto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    private List<CalculoPonto> calculoPontoList;
    private NotificacaoRabbitService notificacaoRabbitService;
    private final String exchangePropostaConcluida;

    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList
            , NotificacaoRabbitService notificacaoRabbitService
            , @Value("${rabbitmq.propostaconcluida.exchange}") String exchangePropostaConcluida) {
        this.calculoPontoList = calculoPontoList;
        this.notificacaoRabbitService = notificacaoRabbitService;
        this.exchangePropostaConcluida = exchangePropostaConcluida;
    }

    public void analisar(Proposta proposta){
        try {
            int pontuacaoFinal = calculoPontoList.stream()
                    .mapToInt(strategy -> strategy.calcular(proposta))
                    .sum();
            boolean aprovada = pontuacaoFinal > 350;
            proposta.setAprovada(aprovada);
        } catch (StrategyException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificacaoRabbitService.notificar(exchangePropostaConcluida, proposta);
    }
}
