package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
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
public class ItemCategoriaDto {

    private Long id;

    @NotNull(message = "{itemCategoria.empresa.campoObrigatorio}")
    private Long empresaId;

    @NotNull(message = "{itemCategoria.categoria.campoObrigatorio}")
    private Long categoriaId;

    @NotBlank(message = "{itemCategoria.descricaoDetalhada.campoObrigatorio}")
    private String descricaoDetalhada;

    @NotBlank(message = "{itemCategoria.descricaoSimples.campoObrigatorio}")
    private String descricaoSimples;

    @NotNull(message = "{itemCategoria.preco.campoObrigatorio}")
    private BigDecimal preco;

    public ItemCategoria convertDTOToEntity() {
        return new ModelMapper().map(this, ItemCategoria.class);
    }
}
