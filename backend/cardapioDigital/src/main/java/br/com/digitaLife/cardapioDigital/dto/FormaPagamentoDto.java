package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoDto {

    private Long id;

    @NotNull(message = "{formaPagamento.empresa.campoObrigatorio}")
    private Long empresaId;

    public FormaPagamento convertDTOToEntity() {
        return new ModelMapper().map(this, FormaPagamento.class);
    }
}
