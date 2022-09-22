package br.com.digitaLife.cardapioDigital.util;

import br.com.digitaLife.cardapioDigital.dto.FormaPagamentoDto;
import br.com.digitaLife.cardapioDigital.model.FormaPagamento;

public class FormaPagamentoCreator {

    public static FormaPagamentoDto createFormaPagamentoDtoForSave() {
        return FormaPagamentoDto.builder()
                .cartaoCredito(Boolean.TRUE)
                .cartaoDebito(Boolean.TRUE)
                .dinheiro(Boolean.TRUE)
                .valeRefeicao(Boolean.FALSE)
                .visivel(Boolean.TRUE)
                .empresaId(1l)
                .build();
    }

    public static FormaPagamento formaPagamentoValid() {
        return FormaPagamento.builder()
                .cartaoCredito(Boolean.TRUE)
                .cartaoDebito(Boolean.TRUE)
                .dinheiro(Boolean.TRUE)
                .valeRefeicao(Boolean.FALSE)
                .visivel(Boolean.TRUE)
                .build();
    }

    public static FormaPagamentoDto createFormaPagamentoToUpdate() {
        return FormaPagamentoDto.builder()
                .cartaoCredito(Boolean.FALSE)
                .cartaoDebito(Boolean.FALSE)
                .dinheiro(Boolean.FALSE)
                .valeRefeicao(Boolean.TRUE)
                .visivel(Boolean.TRUE)
                .empresaId(1l)
                .build();
    }

    public static FormaPagamento formaPagamentoUpdateValid() {
        return FormaPagamento.builder()
                .cartaoCredito(Boolean.FALSE)
                .cartaoDebito(Boolean.FALSE)
                .dinheiro(Boolean.FALSE)
                .valeRefeicao(Boolean.TRUE)
                .visivel(Boolean.TRUE)
                .build();
    }
}
