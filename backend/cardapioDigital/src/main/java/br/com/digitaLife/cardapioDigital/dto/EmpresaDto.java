package br.com.digitaLife.cardapioDigital.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmpresaDto {

    @NotBlank
    private String razaoSocial;

    private String cnpj;

    private byte[] logo;

    private byte[] imagemCapa;

    private String descricao;

    private String site;

    private String instagram;

    private String facebook;

    private String whatsapp;

    @NotBlank
    private String telefoneContato;

    @NotBlank
    @NotNull
    @Email
    private String email;

}
