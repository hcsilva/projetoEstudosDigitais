package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LinksDto {

    @NotEmpty(message = "{links.descricao.campoObrigatorio}")
    private String descricao;

    @URL(message = "{links.urlInvalida}")
    @NotEmpty(message = "{links.link.campoObrigatorio}")
    private String link;

    @NotNull(message = "{links.empresa.campoObrigatorio}")
    private Empresa empresa;

}
