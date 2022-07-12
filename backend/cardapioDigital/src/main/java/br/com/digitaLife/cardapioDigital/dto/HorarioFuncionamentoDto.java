package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.HorarioFuncionamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HorarioFuncionamentoDto {

    private Long id;

    @NotNull(message = "{horariofuncionamento.empresa.campoObrigatorio}")
    private Long empresaId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime segundaInicial;

    public HorarioFuncionamento convertDTOToEntity() {
        return new ModelMapper().map(this, HorarioFuncionamento.class);
    }
}
