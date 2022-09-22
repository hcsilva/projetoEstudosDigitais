package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
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
public class CategoriaDto {

    private Long id;

    @NotNull(message = "{categoria.empresa.campoObrigatorio}")
    private Long empresaId;

    @NotBlank(message = "{categoria.descricao.campoObrigatorio}")
    private String descricaoSimples;

    @NotBlank(message = "{categoria.descricaoDetalhada.campoObrigatorio}")
    private String descricaoDetalhada;

    @Schema(description = "Categoria Ativa ou não")
    @NotNull(message = "{categoria.status.campoObrigatorio}")
    private boolean status;

    private String labelMiniPrato;

    public Categoria convertDTOToEntity() {
        return new ModelMapper().map(this, Categoria.class);
    }
}
