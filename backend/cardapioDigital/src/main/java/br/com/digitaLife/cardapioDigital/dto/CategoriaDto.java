package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.HorarioFuncionamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriaDto {

    private Long id;

    @NotNull(message = "{categoria.empresa.campoObrigatorio}")
    private Long empresaId;

    @NotBlank(message = "{categoria.descricao.campoObrigatorio}")
    private String descricao;

    @NotBlank(message = "{categoria.descricaoDetalhada.campoObrigatorio}")
    private String descricaoDetalhada;

    public Categoria convertDTOToEntity() {
        return new ModelMapper().map(this, Categoria.class);
    }
}
