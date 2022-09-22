package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoDto {

    private Long id;

    @NotNull(message = "{formaPagamento.empresa.campoObrigatorio}")
    private Long empresaId;

    private boolean dinheiro;
    private boolean cartaoCredito;
    private boolean cartaoDebito;
    private boolean valeRefeicao;

    @NotNull(message = "{formaPagamento.visivel.campoObrigatorio}")
    private boolean visivel;

    public FormaPagamento convertDTOToEntity() {
        return new ModelMapper().map(this, FormaPagamento.class);
    }
}
