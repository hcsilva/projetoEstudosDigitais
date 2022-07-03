package br.com.digitaLife.cardapioDigital.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepDto {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
