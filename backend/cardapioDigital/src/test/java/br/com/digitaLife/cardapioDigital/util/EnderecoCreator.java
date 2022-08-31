package br.com.digitaLife.cardapioDigital.util;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.dto.EnderecoDto;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.Endereco;

import java.io.IOException;

public class EnderecoCreator {

    public static EnderecoDto createEnderecoDtoForSave() {
        return EnderecoDto.builder()
                .cep(950100000)
                .logradouro("Avenida das Carmelias")
                .numero(738)
                .bairro("Maua")
                .complemento("comp")
                .cidade("New York")
                .estado("RS")
                .pais("Brasil")
                .build();
    }

    public static Endereco validEndereco() {
        return Endereco.builder()
                .id(1L)
                .logradouro("Avenida das Carmelias")
                .bairro("Maua")
                .complemento("comp")
                .numero(738)
                .cep(950100000)
                .cidade("New York")
                .estado("RS")
                .pais("Brasil")
                .build();
    }

    public static EnderecoDto createEnderecoDtoToUpdate() {
        return EnderecoDto.builder()
                .logradouro("Avenida das Carmelias UP")
                .bairro("Maua UP")
                .complemento("comp UP")
                .numero(999)
                .cep(950100999)
                .cidade("New York UP")
                .estado("UP")
                .pais("Brasil-UP")
                .build();
    }

    public static Endereco enderecoUpdateValid() {
        return Endereco.builder()
                .logradouro("Avenida das Carmelias UP")
                .bairro("Maua UP")
                .complemento("comp UP")
                .numero(999)
                .cep(950100999)
                .cidade("New York UP")
                .estado("UP")
                .pais("Brasil-UP")
                .build();
    }

}
