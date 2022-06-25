package br.com.digitaLife.cardapioDigital.enums;

import lombok.Getter;

@Getter
public enum IdiomaEnum {
    PT("pt", "BR", "português Brasil");

    private final String idioma;
    private final String pais;

    IdiomaEnum(String idioma, String pais, String descricao) {
        this.idioma = idioma;
        this.pais = pais;
    }
}
