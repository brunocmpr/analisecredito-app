package com.campera.analisecredito.service.strategy.impl;

import com.campera.analisecredito.domain.Proposta;
import com.campera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoImpl implements CalculoPonto {
    @Override
    public int calcular(Proposta proposta) {
       return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }



}
