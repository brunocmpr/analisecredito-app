package com.campera.analisecredito.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposta {

    private Long id;

    private Double valorSolicitado;

    private Integer prazoPagamento;

    private Boolean aprovada;

    private boolean integrada;

    private String observacao;

    private Usuario usuario;
}