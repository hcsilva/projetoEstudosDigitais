package br.com.digitaLife.cardapioDigital.util;

import br.com.digitaLife.cardapioDigital.dto.ItemCategoriaDto;
import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import java.math.BigDecimal;

public class ItemCategoriaCreator {
    final static Empresa empresa = EmpresaCreator.validEmpresa();
    final static byte[] foto = EmpresaCreator.IMAGEM;
    final static Categoria categoriaForSave = CategoriaCreator.categoriaValid();

    public static ItemCategoriaDto createItemCategoriaDtoForSave(){
        return ItemCategoriaDto.builder()
                .categoriaId(1L)
                .empresaId(1L)
                .preco(new BigDecimal("12.5"))
                .descricaoDetalhada("Descrição detalhada teste")
                .descricaoSimples("Descrição simples teste")
                .foto(foto)
                .destaque(Boolean.TRUE)
                .precoMiniPrato(new BigDecimal("6.5"))
                .vegano(Boolean.TRUE)
                .semGluten(Boolean.TRUE)
                .semLactose(Boolean.TRUE)
                .build();
    }

    public static ItemCategoria itemCategoriaValid(){
        return ItemCategoria.builder()
                .categoria(categoriaForSave)
                .empresa(empresa)
                .id(1L)
                .preco(new BigDecimal("12.5"))
                .descricaoDetalhada("Descrição detalhada teste")
                .descricaoSimples("Descrição simples teste")
                .foto(foto)
                .destaque(Boolean.TRUE)
                .precoMiniPrato(new BigDecimal("6.5"))
                .vegano(Boolean.TRUE)
                .semGluten(Boolean.TRUE)
                .semLactose(Boolean.TRUE)
                .build();
    }

    public static ItemCategoriaDto createItemCategoriaToUpdate(){
        return ItemCategoriaDto.builder()
                .categoriaId(1L)
                .empresaId(1L)
                .preco(new BigDecimal("12"))
                .descricaoDetalhada("Descrição detalhada update")
                .descricaoSimples("Descrição simples update")
                .foto(foto)
                .destaque(Boolean.FALSE)
                .precoMiniPrato(new BigDecimal("6"))
                .vegano(Boolean.FALSE)
                .semGluten(Boolean.FALSE)
                .semLactose(Boolean.FALSE)
                .build();
    }

    public static ItemCategoria itemCategoriaUpdateValid(){
        return ItemCategoria.builder()
                .categoria(categoriaForSave)
                .empresa(empresa)
                .id(1L)
                .preco(new BigDecimal("12"))
                .descricaoDetalhada("Descrição detalhada update")
                .descricaoSimples("Descrição simples update")
                .foto(foto)
                .destaque(Boolean.FALSE)
                .precoMiniPrato(new BigDecimal("6"))
                .vegano(Boolean.FALSE)
                .semGluten(Boolean.FALSE)
                .semLactose(Boolean.FALSE)
                .build();
    }
}
