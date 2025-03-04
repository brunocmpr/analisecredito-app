package com.campera.analisecredito.service.strategy.impl;

import com.campera.analisecredito.constante.MensagemConstante;
import com.campera.analisecredito.domain.Proposta;
import com.campera.analisecredito.exception.StrategyException;
import com.campera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalculoPonto {
    @Override
    public int calcular(Proposta proposta) {
        int score = score();
        if(score < 200){
            throw new StrategyException(String.format(
                    MensagemConstante.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));
        }else if(score > 200 && score <= 400) {
            return 150;
        }else if(score > 400 && score <= 600) {
            return 180;
        }
        return 220;
    }

    private int score(){
        return new Random().nextInt(0, 1000);
    }
}
