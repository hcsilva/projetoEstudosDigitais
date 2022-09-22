package br.com.digitaLife.cardapioDigital.util;

import br.com.digitaLife.cardapioDigital.dto.CategoriaDto;
import br.com.digitaLife.cardapioDigital.model.Categoria;

public class CategoriaCreator {

    public static CategoriaDto createCategoriaDtoForSave(){
        return CategoriaDto.builder()
                .descricaoDetalhada("Descrição Detalhada Teste")
                .empresaId(1L)
                .descricaoSimples("Descrição Simples Teste")
                .labelMiniPrato("Label mini prato teste")
                .status(Boolean.TRUE)
                .build();
    }

    public static Categoria categoriaValid(){
        return Categoria.builder()
                .id(1L)
                .descricaoDetalhada("Descrição Detalhada Teste")
                .descricaoSimples("Descrição Simples Teste")
                .status(Boolean.TRUE)
                .labelMiniPrato("Label mini prato teste")
                .build();
    }

    public static CategoriaDto createCategoriaToUpdate(){
        return CategoriaDto.builder()
                .descricaoSimples("Descrição Simples update")
                .descricaoDetalhada("Descrição detalhada update")
                .status(Boolean.FALSE)
                .labelMiniPrato("Label mini prato update")
                .build();
    }

    public static Categoria categoriaUpdateValid(){
        return Categoria.builder()
                .id(1L)
                .descricaoSimples("Descrição Simples update")
                .descricaoDetalhada("Descrição detalhada update")
                .status(Boolean.FALSE)
                .labelMiniPrato("Label mini prato update")
                .build();
    }
}
