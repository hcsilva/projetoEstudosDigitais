package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.enums.PaisEnum;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.Endereco;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "{endereco.empresa.campoObrigatorio}")
    private Empresa empresa;

    private String pais;

    public EnderecoDto() {
        this.pais = PaisEnum.BRA.getTwoDigitsCode();
    }
}
