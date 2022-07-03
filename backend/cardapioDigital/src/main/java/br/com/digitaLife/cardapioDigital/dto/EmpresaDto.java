package br.com.digitaLife.cardapioDigital.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmpresaDto {

    @NotEmpty(message = "{empresa.razaoSocial.campoObrigatorio}")
    private String razaoSocial;

    @CNPJ(message =  "{empresa.cnpj.invalido}")
    private String cnpj;

    private byte[] logo;

    private byte[] imagemCapa;

    private String descricao;

    private String site;

    private String instagram;

    private String facebook;

    private String whatsapp;

    @NotBlank(message = "{empresa.telefoneContato.campoObrigatorio}")
    private String telefoneContato;

    @Email(message = "{empresa.email.invalido}")
    @NotBlank(message = "{empresa.email.campoObrigatorio}")
    private String email;

}
