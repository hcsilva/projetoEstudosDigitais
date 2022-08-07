package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.model.ItemExtras;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemExtrasDto {

    private Long id;

    @NotNull(message = "{itemExtras.empresa.campoObrigatorio}")
    private Long idEmpresa;

    @NotNull(message = "{itemExtras.categoria.campoObrigatorio}")
    private Long idCategoria;

    @NotBlank(message = "{itemExtras.descricao.campoObrigatorio}")
    private String descricao;

    public ItemExtras convertDTOToEntity() {
        return new ModelMapper().map(this, ItemExtras.class);
    }
}
