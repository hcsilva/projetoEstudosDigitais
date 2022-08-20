package br.com.digitaLife.cardapioDigital.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@Builder
public class EmpresaDto {

    @NotEmpty(message = "{empresa.razaoSocial.campoObrigatorio}")
    private String razaoSocial;

    @CNPJ(message = "{empresa.cnpj.invalido}")
    private String cnpj;

    private byte[] logo;

    private byte[] imagemCapa;

    private String descricao;

    private String site;

    @URL(message = "{empresa.urlInstragramInvalida}")
    private String instagram;

    @URL(message = "{empresa.urlFacebookInvalida}")
    private String facebook;

    private String whatsapp;

    @NotBlank(message = "{empresa.telefoneContato.campoObrigatorio}")
    private String telefoneContato;

    @Email(message = "{empresa.email.invalido}")
    @NotBlank(message = "{empresa.email.campoObrigatorio}")
    private String email;

}
