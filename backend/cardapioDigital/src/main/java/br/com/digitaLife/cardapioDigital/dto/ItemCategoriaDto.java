package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemCategoriaDto {

    private static ModelMapper modelMapper = new ModelMapper();

    private Long id;

    @NotNull(message = "{itemCategoria.empresa.campoObrigatorio}")
    private Long empresaId;

    @NotNull(message = "{itemCategoria.categoria.campoObrigatorio}")
    private Long categoriaId;

    @NotBlank(message = "{itemCategoria.descricaoDetalhada.campoObrigatorio}")
    private String descricaoDetalhada;

    @Schema(description = "Descrição detalhada do prato")
    @NotBlank(message = "{itemCategoria.descricaoSimples.campoObrigatorio}")
    private String descricaoSimples;

    @Schema(description ="Descrição Simples do prato")
    @NotNull(message = "{itemCategoria.preco.campoObrigatorio}")
    private BigDecimal preco;

    public ItemCategoria convertDTOToEntity() {
        return modelMapper.map(this, ItemCategoria.class);
    }
}


