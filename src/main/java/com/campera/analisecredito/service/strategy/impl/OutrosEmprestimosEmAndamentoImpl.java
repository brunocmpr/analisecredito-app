package com.campera.analisecredito.service.strategy.impl;

import com.campera.analisecredito.domain.Proposta;
import com.campera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoImpl implements CalculoPonto {
    @Override
    public int calcular(Proposta proposta) {
        if(outroEmprestimoEmAndamento()){
            return 0;
        }
        return 100;
    }

    private boolean outroEmprestimoEmAndamento(){
        return new Random().nextBoolean();
    }

}
