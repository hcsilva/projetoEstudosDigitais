package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.enums.PaisEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Getter
@Setter
public class EnderecoDto {

    @NotBlank(message = "{endereco.cep.campoObrigatorio}")
    @Size(max = 8, message = "{endereco.cep.tamanhoMaximoExcedido}")
    private String cep;

    @NotBlank(message = "{endereco.logradouro.campoObrigatorio}")
    private String logradouro;

    @NotNull(message = "{endereco.numero.campoObrigatorio}")
    private int numero;

    @NotBlank(message = "{endereco.bairro.campoObrigatorio}")
    private String bairro;

    private String complemento;

    @NotBlank(message = "{endereco.cidade.campoObrigatorio}")
    private String cidade;

    @NotBlank(message = "{endereco.estado.campoObrigatorio}")
    private String estado;

    private String pais;

    public EnderecoDto() {
        this.pais = PaisEnum.BRA.getTwoDigitsCode();
    }
}
