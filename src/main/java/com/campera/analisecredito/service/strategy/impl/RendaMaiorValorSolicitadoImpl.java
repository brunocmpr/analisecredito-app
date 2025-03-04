package com.campera.analisecredito.service.strategy.impl;

import com.campera.analisecredito.domain.Proposta;
import com.campera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorValorSolicitadoImpl implements CalculoPonto {
    @Override
    public int calcular(Proposta proposta) {
        if(rendaMaiorValorSolicitado(proposta)){
            return 100;
        }
        return 0;
    }

    private boolean rendaMaiorValorSolicitado(Proposta proposta){
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }

}
