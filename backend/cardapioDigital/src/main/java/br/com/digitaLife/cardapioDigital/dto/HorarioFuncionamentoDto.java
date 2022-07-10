package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class HorarioFuncionamentoDto {

    @NotNull(message = "{horariofuncionamento.empresa.campoObrigatorio}")
    private Long empresa;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime segundaInicial;
}
