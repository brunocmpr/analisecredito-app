package com.campera.analisecredito.service.strategy;

import com.campera.analisecredito.domain.Proposta;

public interface CalculoPonto {
    int calcular(Proposta proposta);
}
